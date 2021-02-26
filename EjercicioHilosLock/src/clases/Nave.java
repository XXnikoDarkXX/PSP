
package clases;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Alejanddro Ríos Díaz
 *
 */
public class Nave implements Runnable {

	private String nombreNave;
	private GestionDeDesechos gestionDeDesechos;// variable compartida a traves de una clase
	private ReentrantLock cerrojo;// Como v.interna y tenerlo compartido con el padre a traves del constructor


	public Nave(String nombreNave, GestionDeDesechos gestionDeDesechos, ReentrantLock cerrojo) {
		this.nombreNave = nombreNave;
		this.gestionDeDesechos = gestionDeDesechos;
		this.cerrojo = cerrojo;
	}


	@Override
	public void run() {

		try {
			System.out.println("La nave " + nombreNave + " ha empezado a funcionar");// Informa
			Thread.sleep(100);// Simulo que cada cierto tiempo llega una nave
			long momentoInicial = System.currentTimeMillis();// Para que la nave funcione solo un tiempo

			//Tiempo del hilo
			while (System.currentTimeMillis() - momentoInicial < 1500) {
				
				cerrojo.lock();//Tiene q estar por encima del do while para q puedan entrar los hilos
				
				System.out.println("La nave " + nombreNave + " llega a Planet Express");

				boolean retirarResiduos = false;
				do {
					System.out.println("La nave " + nombreNave + " entra en el almacen para cargar residuos");
					retirarResiduos = gestionDeDesechos.comprobarExistencias(nombreNave);
					cerrojo.unlock();
				} while (!(retirarResiduos==true));//como te devuelve un true termina el do while
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	 

}
