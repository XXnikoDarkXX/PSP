/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mparamos
 */
public class Nave implements Runnable{
    private String nombre;
    private GestionDesechos gestor;
    private ReentrantLock cerrojo;
    
    public Nave(String n,GestionDesechos gestor,ReentrantLock c){
        this.nombre=n;
        this.gestor=gestor;
        this.cerrojo=c;
    }
    
    @Override
    public void run() {
        try {
                    
            System.out.println("La nave "+this.nombre+" empieza a funcionar.");
            Thread.sleep(100); //Simulo que cada cierto tiempo llega un coche
            
            long momentoInicial=System.currentTimeMillis(); //Para que la barrera funcione solo un tiempo
            //Pongo a funcionar la barrera un tiempo fijo. En el mundo real, sería un while(true)
            while(System.currentTimeMillis()-momentoInicial<1500){
             
               System.out.println("A la naves "+nombre+" llega a planet ");
                
                
                boolean haEntrado=false;
                
                do{
                    cerrojo.lock();
                    //Si hay plazas disponibles, lo deja pasar.
                    if(gestor.getDesechos()>1){
         
           
                        int kilos=restarKilos();
                    
                        System.out.println("La nave "+this.nombre+" se va a  desacer de " +kilos+"kg en total hay "+gestor.getDesechos()+" kg");
                      
                         
                        System.out.println("la nave  "+this.nombre+" ha escrito en el albaran y va a deshacerse de los desechos");
                        haEntrado=true;
                    }else{
                      
                    	Thread.sleep(100);
                    	haEntrado=false;
                    }
                   if (gestor.getDesechos()>0) {
                        haEntrado=true;
					}
                    cerrojo.unlock();
                }while(haEntrado==false);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int restarKilos() {
    	Random r=new Random();
    	int kilos=r.nextInt(gestor.getDesechos());
    	gestor.setDesechos(kilos);
    	return kilos;
    }
    
 
 
    
}
