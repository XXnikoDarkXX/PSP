
package clases;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Alejanddro Ríos Díaz
 *
 */
public class PlanetExpress {

	public static final int nNaves = 5;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		// Variables
		ReentrantLock cerrojo = new ReentrantLock();// Metodo Cerrojo, lo declaro y se lo paso a los hijos en el
													// constructor
		ArrayList<Thread> naves = new ArrayList<Thread>();// Colleccion de hilos hijos
		String[] nombreNaves = { "Old Bessie", "Electric Mucus", "Zoidberg killer", "Scruffy’s love son",
				"Hermes Budgets" };

		// Inicio
		System.out.println("Introduce numero de Kilos de desechos a eliminar?");
		int desechos = sc.nextInt();

		GestionDeDesechos desechosTotales = new GestionDeDesechos(desechos);// Variable compartida
		System.out.println(
				"El total de kilos de desechos para eliminar es de: " + desechosTotales.getDesechosRestantes());

		

		// bucle para lanzar
		for (int i = 0; i < nNaves; i++) {
			naves.add(new Thread(new Nave(nombreNaves[i], desechosTotales, cerrojo)));
			naves.get(naves.size() - 1).start();// En paralelo todas las hebras con el start
		}

		// Espero a todos
		for (int i = 0; i < naves.size(); i++) {
			do {
				try {
					Thread.sleep(100);

				} catch (InterruptedException ex) {
					System.out.println("ERROR");
				}
			} while (naves.get(i).isAlive());// Esperar mientras este vivos

			System.out.println("La nave " + i + " ha terminado su dura jornada de trabajo");
		}

	}

}
