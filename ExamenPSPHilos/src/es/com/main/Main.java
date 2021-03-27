package es.com.main;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<String>();

		nombres.add("Cuchara");
		nombres.add("Hipocondriaco");
		nombres.add("Teletubbie");
		nombres.add("Cermuzo");
		nombres.add("Asilvestrado");
		nombres.add("Zascandurrio");
		nombres.add("Peinaovejas");
		nombres.add("Chillamañanas");
		nombres.add("Cansaalmas");
		nombres.add("AdoroPSP");
		nombres.add("Kosatka");
		nombres.add("Buzzard");
		nombres.add("Hydra");
		nombres.add("Trasnochar");
		nombres.add("Malo");
		nombres.add("Cabeza");
		
		
		ReentrantLock cerrojo = new ReentrantLock();// nuestro cerrojo

		ArrayList<Thread> hijos = new ArrayList<Thread>();
		for (int i = 0; i < 16; i++) {
			hijos.add(new Thread(new SacaMasCorta(nombres, cerrojo,i)));
			hijos.get(hijos.size() - 1).start();
		}

		for (int i = 0; i < hijos.size(); i++) {
			do {
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			} while (hijos.get(i).isAlive());
				
			if (i==hijos.size()-1) {
				System.out.println("Quedan "+nombres.size());
			}
		}

	}

}
