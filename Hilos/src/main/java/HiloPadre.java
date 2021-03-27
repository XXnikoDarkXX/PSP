
public class HiloPadre {

	public static void main(String[] args) {

		byte nProcesadores = (byte) Runtime.getRuntime().availableProcessors();
		int[] array = new int[8];

		for (int i = 0; i < array.length; i++) {
			array[i] = 8;
		}

		// creo un array de Thread que me servira para luego esperar todos los hilos
		Thread[] hilos = new Thread[8];

		for (int i = 0; i < 8; i++) {
			// Conseguimos un hilo de clase HiloHijo
			HiloHijo h = new HiloHijo(i, array);
			Thread t = new Thread(h);
			hilos[i] = t;
			t.start();

		}

		
		// En este for esperamos a los hilos a que terminen su ejecuciones
		for (int i = 0; i < hilos.length; i++) {

			do {//Con esto conseguimos q se esperen los hilos

			} while (hilos[i].isAlive());

		}
		System.out.println("asi se queda finalmente el array");
		imprimirArray(array);
	}
	
	public static void imprimirArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " | ");
		}

	}

}
