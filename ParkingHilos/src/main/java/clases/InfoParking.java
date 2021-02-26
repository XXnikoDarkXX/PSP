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
    
    //Esto solo si quitas el lock
   /* public synchronized boolean decidirSiEntras(int id,String nMatricula) throws InterruptedException {
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
		
    }*/
    
    
    public  boolean decidirSiEntras(int id,String nMatricula) throws InterruptedException {
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
}
