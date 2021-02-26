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
public class Barrera implements Runnable {
	private int id;
	private InfoParking parking;
	private ReentrantLock cerrojo;

	public Barrera(int id, InfoParking parking, ReentrantLock c) {
		this.id = id;
		this.parking = parking;
		this.cerrojo=c;
	}

	@Override
	public void run() {
		try {

			System.out.println("La barrera " + this.id + " empieza a funcionar.");
			Thread.sleep(100); // Simulo que cada cierto tiempo llega un coche

			long momentoInicial = System.currentTimeMillis(); // Para que la barrera funcione solo un tiempo
			// Pongo a funcionar la barrera un tiempo fijo. En el mundo real, sería un
			// while(true)
			while (System.currentTimeMillis() - momentoInicial < 1500) {
				cerrojo.lock();
				String matriculaActual = this.generarMatricula();
				System.out.println("A la barrera " + id + " llega el vehículo " + matriculaActual
						+ ".Plazas restantes: " + parking.getnPlazas());

				boolean haEntrado = false;
				do {
					
					haEntrado=parking.decidirSiEntras(id, matriculaActual);
				
				} while (!haEntrado);
				cerrojo.unlock();
			}

		} catch (InterruptedException ex) {
			Logger.getLogger(Barrera.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String generarMatricula() {
		String res = "";
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			res += r.nextInt(10);
		}
		res += "-";
		for (int i = 0; i < 3; i++) {
			res += (char) (64 + r.nextInt(24));
		}
		return res;
	}

}
