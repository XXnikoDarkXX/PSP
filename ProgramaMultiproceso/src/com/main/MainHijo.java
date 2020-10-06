package com.main;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class MainHijo {

	public static void main(String[] args) {
		String ficheroSalida="hijo"+args[0]+".log";
		try {
			
			System.setOut(new PrintStream(ficheroSalida));
			String mensajeLog="["+LocalDateTime.now()+"] Hola mundo, soy el proceso hijo "+args[0];
			System.out.println(mensajeLog);
			FileWriter writer=new FileWriter("ejecucionCompleta.log",true);
			writer.write(mensajeLog+"\n");
			writer.flush();
			writer.close();
			
			//Vuelve a desviar la salida estándar hacia consola
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			
			BufferedReader reader=new BufferedReader(new FileReader(ficheroSalida));
			String ultimaLineaLeida=reader.readLine();
			do{
				System.out.println(ultimaLineaLeida);
				ultimaLineaLeida=reader.readLine();
			}while(ultimaLineaLeida!=null);
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

