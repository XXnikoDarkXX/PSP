package com.barrera;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class MainBarreraHijo {

	public static void main(String[] args) {
		try {
			//queremos que machaque solo el invidual pero no el colectivo
			Escritor escritor=new Escritor("hijo"+args[0]+".log","ejecucionCompleta.log",true,false);
			escritor.escribir(" Hola mundo, lanzando barrera "+args[0]);
		long inicial=	System.currentTimeMillis();
		//lanzo el programa esperando 10 segundo para que no se queden los programas colgados
			while(System.currentTimeMillis()-inicial<10000){
				Thread.sleep(300);//simula que cada este tiempo 0,3 sg llega un coche
				escritor.escribir("la barrera "+args[0]+" recibe un coche");
				//Comprobamos si hay sitio en el parking
				
				
			}
			
			escritor.escribir("apagada la barrera"+args[0]);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
