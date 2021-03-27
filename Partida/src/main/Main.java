package main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Runtime rt=Runtime.getRuntime();
		// TODO Auto-generated method stub
		//1 Abrir google chrome en modo incognito usando ProccessBuilder
		ProcessBuilder pb=new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","-incognito");
		try {
			pb.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
				
		//	Process procesos=rt.exec("C:\\\\\\\\Program Files\\\\\\\\Google\\\\\\\\Chrome\\\\\\\\Application\\\\\\\\chrome.exe -incognito");
		System.out.println("Tienes de procesadores "+rt.availableProcessors());
		
		int nVeces=rt.availableProcessors()*2; //hacemos el doble de procesadores
		ArrayList<Process> hijos=new ArrayList<Process>();//ArrayList con todos nuestros procesos
		//ejectuamos 
		//Mediante este for ejecutamos el doble de veces los procesos que tiene nuestro nucleo ademas de ejectutar los dados
		int memoriaTotal=0;
		for (int i = 0; i < nVeces; i++) {
			ProcessBuilder pc=new ProcessBuilder("java","-jar","./dadoHijo.jar",i+"");
			pc.inheritIO();
			Process p=pc.start();
			hijos.add(p);
			
		}
		System.out.println("Memoria ocupado del programa " + (rt.totalMemory()-rt.freeMemory())/(1024*1024) +"mb");
		System.out.println("Memoria libre "+rt.freeMemory()/(1024*1024)+"mb");
		
		
		//Espero a que se paren todos los procesos para seguir
		
		for(int i=0;i < Runtime.getRuntime().availableProcessors(); i++) {
			
			
			System.out.println("Lanzando proceso hijo nº "+i +" esta vivo? "+hijos.get(i).isAlive());
		
			hijos.get(i).waitFor();//esperamos a que terminen
		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(java.lang.ClassCastException ex) {
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
