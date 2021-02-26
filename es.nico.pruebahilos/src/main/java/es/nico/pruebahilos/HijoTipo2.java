package es.nico.pruebahilos;
//Segunda forma de hacer hilos mediante 
//heredamiento de Threads
public class HijoTipo2 extends Thread {
	private int idHilo;
	
	public HijoTipo2(int nHilo) {
		idHilo=nHilo;
	}


	//Para realizarlo vamos a source override method
	@Override
	public void run() {

		
		super.run();
		System.out.println("Hola desde el hilo tipo 2 nº "+idHilo);
	}

	
	
	
}
