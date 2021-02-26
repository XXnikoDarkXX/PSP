package es.nico.pruebahilos;

/**
 * 
 * @author nicoc
 *
 */
public class HiloHijo implements Runnable{
	
	private int idHilo;
	private String[]array;
	public HiloHijo(int nHilo,String[]array) {
		idHilo=nHilo;//para dar una id al hilo
	}
	
	public void run() {
		System.out.println("Hola soy el hilo hijo nº "+idHilo);
		Thread actual=Thread.currentThread();//para ir usando las funciones de Thread en los hijos
		System.out.println("Id del hilo "+idHilo+ " dada por el so "+actual.getId()
		+"nombre: "+actual.getName()+", prioridad: "+actual.getPriority());//el so le da una id
		
	
	
	}//Inplementamos el Runnable
	
	

	
	
}
