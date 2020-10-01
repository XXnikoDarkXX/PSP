package com.main;

import java.io.IOException;

/**
 * Ejemplo de clase donde experimentamos como funciona el proceso de abrir una aplicacion o hacer llamadas a apliaciones
 * @author nicoc
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Runtime rt=Runtime.getRuntime();
		
		
	System.out.println(rt.availableProcessors());//nos dice cuantos procesos tiene nuestra maquina1
	
	System.out.println("Memoria de mi proceso "+rt.totalMemory()+" b");//Memoria  del proceso
	System.out.println("Memoria de mi proceso "+(rt.totalMemory()/(1024))+" k");//Memoria  del proceso
	System.out.println("Memoria de mi proceso "+(rt.totalMemory()/(1024*1024))+"mb");//Memoria  del proceso
	
	System.out.println(rt.freeMemory()/1024+" kb");//memoria libre del proceso no tiene codigo
	
	System.out.println("Memoria ocupado del proceso " + (rt.totalMemory()-rt.freeMemory())/1024 +"k");
	
	//rt.exec("C://Program Files/Mozilla Firefox/firefox.exe");
	try {
		//rt.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");//Abrimeos una aplicacion
		//Process p=rt.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");//Abrimeos una aplicacion
//	Process p=rt.exec("C:\\Program Files\\\\CodeBlocks\\\\codeblocks.exe");
		Process p=rt.exec("C:\\Windows\\System32\\notepad.exe");
		
		Thread.sleep(5000);
		//p.waitFor();//Espera a que acabe el que lanzes con exe
		p.destroy();//Destruye 
		System.out.println("Info 0"+p.info());
		System.out.println("Vivo "+p.isAlive());//si el proceso esta vivo en este caso la aplicacion
		System.out.println("Valor de salida: "+p.exitValue());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
