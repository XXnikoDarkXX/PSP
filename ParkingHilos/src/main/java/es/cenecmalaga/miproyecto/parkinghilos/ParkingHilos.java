/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cenecmalaga.miproyecto.parkinghilos;

import clases.Barrera;
import clases.InfoParking;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mparamos
 */
public class ParkingHilos {
    public static final int nPlazas=30;
    public static final byte nBarreras=3;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InfoParking parking=new InfoParking(nPlazas);
        
        ArrayList<Thread> barreras=new ArrayList<Thread>();
        ReentrantLock cerrojo=new ReentrantLock();
        
        for (int i = 0; i < nBarreras; i++) {
            //TODO Lanzar hijo
            barreras.add(new Thread(new Barrera(i,parking,cerrojo)));
            barreras.get(barreras.size()-1).start();
        }
        
        for (int i = 0; i < barreras.size(); i++) {
            do{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ParkingHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while(barreras.get(i).isAlive());
            System.out.println("La barrera "+i+" ha terminado.");
        }
        
        
    }
    
}
