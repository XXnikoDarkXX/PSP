/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author mparamos
 */
public class InfoParking {
    private int nPlazas;

    public InfoParking(int nPlazas) {
        this.nPlazas = nPlazas;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    public void añadirPlaza(){
        nPlazas++;
    }
    
    public void restarPlaza(){
        nPlazas--;
    }
     public synchronized boolean decidirSiEntras(int id,String nMatricula) throws InterruptedException {
	// Si hay plazas disponibles, lo deja pasar.
	
		if (getnPlazas() > 0) {
			System.out.println("La barrera " + id + " deja pasar al vehiculo " + nMatricula);
			restarPlaza();
			return  true;
		} else {
			// Si no hay plazas libres, espera un tiempo. Simulando que en ese tiempo, otro
			// coche ha salido de ahí
			Thread.sleep(100);
			return false;
		}
     }
		
		 public synchronized boolean decidirSiSumar() throws InterruptedException {
			   //Si hay plazas disponibles, lo deja pasar.
            if(getnPlazas()<30){
                System.out.print("Antes habia: "+getnPlazas());
              añadirPlaza();
             System.out.println("un coche ha salido por lo cual sumamos y nos quedan"+getnPlazas());
                return true;
                
            }else{
                //Si no hay plazas libres, espera un tiempo. Simulando que en ese tiempo, otro coche ha salido de ahí
                Thread.sleep(100);
                return false;
            }
		}
	

    
    
}
