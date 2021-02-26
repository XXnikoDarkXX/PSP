package es.nico.main;

public class Padre {

	public static void main(String[] args) {
		
		int []array=new int[Runtime.getRuntime().availableProcessors()];
		//creo un array de Thread que me servira para luego esperar todos los hilos
		Thread[]hilos= new Thread[Runtime.getRuntime().availableProcessors()];
		
		//mediante este bucle les digo que posiciones vale el array
for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
	array[i]=Runtime.getRuntime().availableProcessors();
}
//En este for inicializamos los hilos y la variable Hijo
for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
	Hijo h=new Hijo(i,array);
	Thread t=new Thread(h);
	hilos[i]=t;
	t.start();
	
	
	
		
}



//en este foreach esperemos a los hilos a que terminen su ejecuciones
for (Thread thread : hilos) {
  try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	//en este for imprimimos los datos del array
System.out.println("Array Final");
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i]+"| ");
		
	}
	



	}

}
