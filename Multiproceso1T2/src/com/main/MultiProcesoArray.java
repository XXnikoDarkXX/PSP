package com.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Mediante esta clase hemos recreado como se hace para poder EJECUTAR COSAS SIEMPRE DESPUES DE QUE TERMINEN LOS HILOS
 * esto lo conseguimos gracias a un ArrayList de tipo Process mediante un bucle llamamos al proceso hijo que es un sout
 * y finalmente en otro for esperamos a que terminen las ejecuciones en los procesos.
 * @author nicoc
 *
 */
public class MultiProcesoArray {
	

  public static void main(String[] args) {
	  
		try {
			ArrayList<Process> hijos=new ArrayList<Process>();
			System.setOut(new PrintStream("ejecucionCompleta.log"));
			
			for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","../Hijo Multiproceso/hijo.jar",i+"");
				//pb.inheritIO();
				Process p=pb.start();
				hijos.add(p);
			}
			
			
			
			//Espero a que se paren todos los procesos para seguir
			for(int i=0;i < Runtime.getRuntime().availableProcessors(); i++) {
				System.out.println("["+LocalDateTime.now()+"] ¿Está hijo nº"+i+" vivo? "+hijos.get(i).isAlive());
				hijos.get(i).waitFor();
			}
			
			//Informar de valores de salida
			System.out.println("\n\n----EJECUCIÓN DE HIJOS TERMINADA------");
			for(int i=0;i < Runtime.getRuntime().availableProcessors(); i++) {
				System.out.println("["+LocalDateTime.now()+"] Valor de salida del hijo nº"+i+": "+hijos.get(i).exitValue());
			}
			
			System.out.println("----\n["+LocalDateTime.now()+"] Todos los hijos han terminado.\n------------------------------");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
  
	  /*
	    //Main antiguo revisar
		// TODO Auto-generated method stub
		ArrayList<Process> hijos = new ArrayList<Process>();
		try {
			System.setOut(new PrintStream("ejecucionCompleta.log"));//Mediante esta funcion sacamos toda la
			//ejecucion de pantalla a un texto

			for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
				ProcessBuilder pb = (new ProcessBuilder("java", "-jar", "./hijomultiproceso.jar", i + ""));

			//	pb.inheritIO(); esto es para la ejecucion por consola ahora mismo o lo queremos
				
			//	pb.redirectOutput((new File("hijo"+"i"+".log")));
				Process p = pb.start();
				
				hijos.add(p);
			}
			
			//Espero a que se paren todos los procesos para seguir, es decir que todas las ejecuciones del for de arriba
			//se hagan
			for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
				try {
					System.out.println("["+LocalDateTime.now()+"] "+"Esta hijo nº "+i+ " vivo? "+hijos.get(i).isAlive());
					hijos.get(i).waitFor();
					
				//	System.out.println("Valor de salida del hijo "+i+ ": "+hijos.get(i).exitValue());
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Informar de valores de salida
			System.out.println("---EJECUCIÓN DE HIJOS TERMINADA--------");
			for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
				
					
			System.out.println("Valor de salida del hijo "+i+ ": "+hijos.get(i).exitValue());
					
					
				
			}
			
			System.out.println("------\n-----Todos los hijos han terminado-------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}*/
