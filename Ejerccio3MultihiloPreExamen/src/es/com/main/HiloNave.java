package es.com.main;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloNave implements Runnable {
	private PlanetExpress planet;// variable privada plenetExpress que la tendremos compartida
	private String nombre;
	private ReentrantLock cerrojo;

	public HiloNave(String nombre, PlanetExpress planet, ReentrantLock c) {
		this.nombre = nombre;
		this.planet = planet;
		this.cerrojo = c;
	}

	@Override
	public void run() {

		System.out.println("La nave  " + this.nombre + " empieza a funcionar.");
		try {
			Thread.sleep(100);

			long momentoInicial = System.currentTimeMillis(); // Para que la barrera funcione solo un tiempo

			while (System.currentTimeMillis() - momentoInicial < 1500) {
				cerrojo.lock();
				boolean haEntrado = false;
				do {
					
				System.out.println("la nave "+this.nombre+" entra en el almacen para cargar residuos");
				haEntrado=planet.comprobarDesechos(this.nombre);
				cerrojo.unlock();
				} while (!(haEntrado==true));
			
			}
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Simulo que cada cierto tiempo llega un coche
//
	}

	public PlanetExpress getPlanet() {
		return planet;
	}

	public void setPlanet(PlanetExpress planet) {
		this.planet = planet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	



}
