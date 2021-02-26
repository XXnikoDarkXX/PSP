package es.nico.pruebahilos;

public class HiloPadre {
	/**
	 * Diferencias entre extend Thread y Runable
	 * Runable puedo usar varias veces el start
	 * Thread es mas facil de usar pero solo se puede usar una vez el start
	 * @param args
	 */
	public static void main(String[] args) {
		String[]array=new String[2];
		for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
			HiloHijo h=new HiloHijo(i,array);
			Thread t=new Thread(h);
			//t.run(); si lo hacemos asi se hace secuencial 01,2,3
			//en paralelo
			t.start();//para empezar el hilo el so se encarga de saber como empezarlo
			
			System.out.println("Hilos vivos (aprox) :"+Thread.activeCount());
			System.out.println("hilo "+i+" vivo? "+t.isAlive()+" estado: "+t.getState());
			//Inicializamos otro hilo
			HijoTipo2 h2=new HijoTipo2(i);
			h2.start();
			
			/*
			 * String[]arr=new String[3];
		
		HiloHijo h=new HiloHijo(1,arr);
		for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
			new Thread(h).start();
			
			 */
			
		}
		
		try {
			Thread.sleep(1000);
			System.out.println("Hilos vivos al final (aprox) :"+Thread.activeCount());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
