package com.gestor;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PadreGestor {
	
	private static final byte nBarrera=2;//numeros de barreras
	
	/**
	 * Este fichero es el padre en cual ejecutamos por medio de ProcessBuilder el proyecto en modo .java
	 * de hijo, ahi lo que hacemos es ir escribiendo con la clase Escritor (que estan en los dos proyetos)
	 * y por medio de una ruta String que esta en el constructor de dicho Escritor accedemos a los log
	 * y ya con la funcion escribir escribimos en dichos log concatenando tanto lo que escribe el padre
	 * como lo que escribe el hijo en modo proceso (.java)
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//lo ponemos a true para que machaque y lo ponga en blanco
			Escritor escritor=new Escritor("./procesoPadre.log","./ejecucionCompleta.log",true,true);//por defecto sera true al iniciar un Escritor
		
			ArrayList<Process> hijos=new ArrayList<Process>();
			 
			
			//mandamos a escribir los fichero log del main hijo
			for (int i = 0; i < nBarrera; i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","./barrera.jar",i+"");
				pb.inheritIO();
				Process p=pb.start();
				hijos.add(p);//lo metemos en el arrayList
			}
			
			
			
			//Espero a que se paren todos los procesos para seguir
		
			for(int i=0;i < nBarrera; i++) {
				//mediante los dos FileWritter que tenemos uno se encargar de escribir
				//con el individual su propio log, y con el comun lo escribe en el otro log
				//que se aloja en la carpeta del main padre
				escritor.escribir("["+LocalDateTime.now()+"] Esta  la barrera n�"+i+" vivo? "+hijos.get(i).isAlive());
				hijos.get(i).waitFor();
			}
			
			//Informar de valores de salida
			escritor.escribir("\n\n----EJECUCIÓN DE HIJOS TERMINADA------");
			for(int i=0;i < nBarrera; i++) {
				escritor.escribir("["+LocalDateTime.now()+"] Valor de salida de la barrira nº"+i+": "+hijos.get(i).exitValue());
			}
			
			escritor.escribir("----\n["+LocalDateTime.now()+"] Todos las barreras han terminado.\n------------------------------");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
