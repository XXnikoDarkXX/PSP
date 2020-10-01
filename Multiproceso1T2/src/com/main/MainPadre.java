package com.main;

import java.io.IOException;

public class MainPadre {

	public static void main(String[] args) {
		try {
			
			
		for (int a = 0; a < Runtime.getRuntime().availableProcessors(); a++) {
			ProcessBuilder pb=new ProcessBuilder("java","-jar","./hijomultiproceso.jar",a+"");//los argumentos
			//se separan así, //de esta manera podemos ver como se ejectuan los sout en diferentes procesos
		pb.inheritIO();//lo hace en los dos lados
				Process p=pb.start();	
		}
	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
