package com.main;

import java.util.Random;

public class Barrera implements Runnable {
	private int id;
	private InfoParking parking;

	public Barrera(int id, InfoParking parking) {
		this.id = id;
		this.parking = parking;
	}

	@Override
	public void run() {
		try {
			System.out.println("La barrera " + this.id + " empieza a funcionar");

			Thread.sleep(100);// simulo que cada cierto tiempo llega un coche
			long momentoInicial = System.currentTimeMillis();// Para que la barrera funcione solo un tiempo
			// Pongo a funcionar la barrera un tiempo fijo. En el mundo relal, sería un
			// while (true)
			while (System.currentTimeMillis() - momentoInicial < 1500) {
				String matriculaActual = this.generarMatricula();
				System.out.println("A la barrera " + id + " llega el vehículo " + matriculaActual+" plazas Restantes "+parking.getnPlazas());

				boolean haEntrado = false;
				do {
					// Si hay plazas disponibles, lo deja pasar.
					if (parking.getnPlazas() > 0) {
						System.out.println("La barrera " + id + " deja pasar al vehículo " + matriculaActual);
						parking.restarPlaza();
						haEntrado = true;
					} else {
						// Si no hay plazas libres, espera un tiempo. Simulando que en ese tiempo otro
						// coche a salido hay
						Thread.sleep(100);
					}
				} while (!haEntrado);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

	public String generarMatricula() {
		String res = "";
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			res += r.nextInt(10);
		}
		for (int i = 0; i < 3; i++) {
			res += (char) (64 + r.nextInt(24));
		}
		return res;
	}

}
