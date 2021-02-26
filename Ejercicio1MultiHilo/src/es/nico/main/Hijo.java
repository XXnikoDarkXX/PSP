package es.nico.main;

public class Hijo implements Runnable{

	private int idHilo;//la id del hilo
	
	private int[]array;//array que estara en comun con el padre
	/**
	 * Constructor con todos los parametros
	 * @param nHilo id del hilo
	 * @param arr array en comun
	 */
	public Hijo(int nHilo, int[] arr) {
	this.idHilo=nHilo;
	this.array=arr;
	}

	@Override
	public void run() {
	byte proce=(byte)	Runtime.getRuntime().availableProcessors();
		System.out.println("Soy el hijo nº "+idHilo);
		Thread actual=Thread.currentThread();
		array[idHilo]+=idHilo;
		
		System.out.println("El hilo nº: "+idHilo+" tiene en total "+array[idHilo]+" que es "+proce+" + "+idHilo);
		System.out.println();
		for (int i = 0; i < array.length; i++) {
		System.out.print(array[i]+" | ");
	}
		System.out.println();
		
	
	}
	
	
	
	
	
	
}
