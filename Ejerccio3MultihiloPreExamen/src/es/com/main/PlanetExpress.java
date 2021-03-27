package es.com.main;

import java.util.Random;

public class PlanetExpress {
	private int desechosRestantes;//son los deseños expresados en KG

	/**
	 * Constructor de PlanetExpress con parametros
	 * @param desechos que va a tener este objeto
	 */
	public PlanetExpress(int desechos) {
		this.desechosRestantes=desechos;
	}
	
	/**
	 * Getter de desechos
	 * @return los desechos
	 */
	public int getDesechosRestantes() {
		return desechosRestantes;
	}
	
	/**
	 * Setter de desechos
	 * @param desechosRestantes a cambair
	 */
	public void setDesechosRestantes(int desechosRestantes) {
	
		this.desechosRestantes = desechosRestantes;
	}
	
	/**
	 * Funcion para restar los desechos
	 * @param desechos a restar
	 */
	public void restarDesechosRestantes(int desechos) {
		this.desechosRestantes=this.desechosRestantes-desechos;
	}
	
	public boolean comprobarDesechos(String nave) {
		
		// si es mayor de 0 los desechos
		if (this.getDesechosRestantes() > 0) {
			
			// le quitaremos un numero aleatorio
			Random r = new Random();
			System.out.println("Hay en total de desechos " + this.getDesechosRestantes());
			int anterior = this.getDesechosRestantes();
			int quitadaRandom = kilosDesechosAEliminar();
			this.restarDesechosRestantes(quitadaRandom);
			System.out.println("La nave " + nave + " va deshacerse de " + quitadaRandom
					+ " kilos de desechos  de un total de " + anterior + " quedando "
					+ this.getDesechosRestantes());
			return true;
		
		} else {
		
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return  false;
		}
	
	}
	
	
	public int kilosDesechosAEliminar() {
		Random r = new Random();

		int kilosMax = 20;
		int kilosDeschosAEliminar;
		do {
			kilosDeschosAEliminar = r.nextInt(this.getDesechosRestantes());

		} while (kilosDeschosAEliminar > kilosMax);

		return kilosDeschosAEliminar;

	}
	
	
}
