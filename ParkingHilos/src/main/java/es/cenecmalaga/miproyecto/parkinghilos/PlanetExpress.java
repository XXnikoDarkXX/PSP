/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cenecmalaga.miproyecto.parkinghilos;

import clases.Nave;

import clases.GestionDesechos;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class PlanetExpress {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe los kilos totales de desechos");
        int desechos=Integer.parseInt(sc.nextLine());
        GestionDesechos gestor=new GestionDesechos(desechos);
        ReentrantLock cerrojo=new ReentrantLock();
        
        ArrayList<Thread> naves=new ArrayList<Thread>();
        String nombreNaves[]= {"Old Bessie","Electric Mucus","Zoidberg killer","Scruffy’s love song”","Hermes Budgets"};
        
        for (int i = 0; i < 5; i++) {
            //TODO Lanzar hijo
        	Nave nav=new Nave(nombreNaves[i],gestor,cerrojo);
        	naves.add(new Thread(new Nave(nombreNaves[i],gestor,cerrojo)));
        	naves.get(naves.size()-1).start();
        }
        
        for (int i = 0; i < naves.size(); i++) {
            do{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlanetExpress.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while(naves.get(i).isAlive());
         	System.out.println("La nave " + nombreNaves[i] + " ha terminado su dura jornada de trabajo");
            
    		
    	}
    		 System.out.println("\ntras la eliminación sutil, quedan "+gestor.getDesechos()+"  kilos de desechos por eliminar");
    			
        }
        
        
    }
    

