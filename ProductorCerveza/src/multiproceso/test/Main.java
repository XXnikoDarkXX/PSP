package multiproceso.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {
		try {
			
			float tasaAlcoholemia=0;//Todos empezamos abstemios en esto
			float cervezaBebida=0;//Llevamos el control de cuanto hemos bebido
			
			
			String[]bebedores= {"Javier Alcalde","Raul Gonzalez Parra","Cristina Carrillo","María Sánchez","Antonio Calvente","Jose Manuel Aviles","Yuliia Melnyk","Noberto Vargas","Javier Ruiz","Francisco España","Daniel Perez,","Jualu  Ceacero","Alez Ríos","Jaime Sánchez","Alvaro Lopez","Nico Fernández"};
		
			Escritor escritor=new Escritor("procesoPadre.log","ejecucionCompleta.log",true);
			
			LinkedHashMap<String,Process>hijos=new LinkedHashMap<String,Process>();
			
			//Como productor, voy a generar un barril de 30L de cerveza
			FileWriter fw=new FileWriter("./barril.txt");
			fw.write("30.0");
			fw.flush();
			fw.close();
			//Hacemos un bucle hasta bebedores.leng
			for (int i = 0; i < bebedores.length; i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","./bebedor.jar",bebedores[i]+"");
				
				pb.inheritIO();
				Process p=pb.start();
				hijos.put(bebedores[i], p);
			}
			//vamos a leer cuanta cerveza queda
			long momentoInicial=System.currentTimeMillis();
			while(System.currentTimeMillis()-momentoInicial<5000) {
			BufferedReader reader=new BufferedReader(new FileReader("./barril.txt"));
			float cervezaRestante=Float.parseFloat(reader.readLine());
			reader.close();
			//si no queda cerveza, relleno barril
			if (cervezaRestante==0) {
				escritor.escribir("El productor detec ta que el barril esta vacio, lo rellena");
				fw=new FileWriter("./barril.txt");
					fw.write("30.0");
					fw.flush();
					fw.close();
						
			}
			//espero un poco antes de mirar otra vez
			Thread.sleep(300);
			
			}
			
			//Espero a que se paren todos los procesos para seguir
			Iterator it=hijos.keySet().iterator();
			while(it.hasNext()) {
	
		String hijoActual=(String)it.next();
		hijos.get((String)it.next());
			hijos.get(hijoActual).waitFor();//Espero a que se termine de ejecutar este hijo
			escritor.escribir(hijoActual +" se va a su casa, ha terminado aquí");
			}
			
			
			
			//Informar de valores de salida
			escritor.escribir("\n\n----EJECUCIÓN DE HIJOS TERMINADA------");
			Iterator itFinal=hijos.keySet().iterator();
			while(itFinal.hasNext()) {
				String hijoActual=(String)itFinal.next();
				escritor.escribir("Valor de salida del consumidor: "+hijos.get(hijoActual).exitValue()+" :"+hijoActual);
				
			}
			
			escritor.escribir("----\n["+LocalDateTime.now()+"] Todos los hijos han terminado.\n------------------------------");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
