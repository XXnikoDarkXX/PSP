package es.com.main;

import java.util.Random;

public class Hilo extends Thread{

	StringHolder compartido;
	
	
	public  Hilo(StringHolder compartido) {
		this.compartido=compartido;
	}


	@Override
	public void run() {

		super.run();
		String[]mensajesPosibles= {"mensaje 1","mensaje 2","mensaje 3","mensaje 4"};
		Random r=new Random();
		this.compartido.setCadena(mensajesPosibles[r.nextInt(mensajesPosibles.length)]);
	}
	
	
}
