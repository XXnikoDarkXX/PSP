package multiproceso.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ProductorCerveza {

	public static void main(String[] args) {
		try {
			Path ficheroBloqueo=FileSystems.getDefault().getPath("../bloqueo.lock");
			//Si no existe el fichero bloqueo lo creo
			if (!Files.exists(ficheroBloqueo)) {
				Files.createFile(ficheroBloqueo);
			}
		
			//declaramos un filceChanel con un path bloqueo
			FileChannel canal= FileChannel.open(ficheroBloqueo,StandardOpenOption.READ,StandardOpenOption.WRITE);
			String[] bebedores= {"Javier Alcalde","Raúl González Parra","Cristina Carrillo","María Sanchez","Antonio Calvente","Jose Manuel Avilés","Yuliia Melnyk","Norberto Vargas","Javier Ruiz","Francisco España","Daniel Pérez","Juanlu Ceacero","Alex Ríos","Jaime Sánchez","Álvaro Lopez","Nico Fernández"};
			
			Escritor escritor=new Escritor("procesoPadre.log","ejecucionCompleta.log",true);
			LinkedHashMap<String,Process> hijos=new LinkedHashMap<String,Process>();
			
			//Como productor, voy a generar un barril de 30L de cerveza
			FileWriter fw=new FileWriter("../barril.txt");
			fw.write("10.0");
			fw.flush();
			fw.close();
			
			
			for (int i = 0; i < bebedores.length; i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","../bebedor.jar",bebedores[i]);
				pb.inheritIO();
				pb.environment();
				Iterator it=pb.environment().keySet().iterator();
				while(it.hasNext()) {
					String var=(String)it.next();
					System.out.println(var+" : "+pb.environment().get(var));
					
				}
				System.out.println("\n\n\n");
				Process p=pb.start();	
				
				hijos.put(bebedores[i],p);
			}
			
			long momentoInicial=System.currentTimeMillis();
			
			while(System.currentTimeMillis()-momentoInicial<5000) {
				BufferedReader reader=
						new BufferedReader(new FileReader("../barril.txt"));
				float cervezaRestante=Float.parseFloat(reader.readLine());
				reader.close();
				
				//Si no queda cerveza, relleno barril.
				if(cervezaRestante==0) {
					escritor.escribir("El productor detecta que el barril está vació, lo rellena.");
					//1º ZONA CRITICA USAREMOS FILELOCK PARA CERRAR
					FileLock cerrojo=canal.lock();
					fw=new FileWriter("../barril.txt");
					fw.write("10.0");
					fw.flush();
					fw.close();
					cerrojo.close();
				}
				
				//Espero un poco antes de mirar otra vez
				Thread.sleep(300);
			}
			
			
			
			//Espero a que se paren todos los procesos para seguir
			Iterator it=hijos.keySet().iterator();
			while(it.hasNext()) {
				String hijoActual=(String)it.next();
				hijos.get(hijoActual).waitFor();  //Espero a que se termine de ejecutar este hijo
				escritor.escribir(hijoActual+" se va a su casa, ha terminado aquÃ­.");
			}
			
			//Informar de valores de salida
			escritor.escribir("\n\n----EJECUCIÓN DE HIJOS TERMINADA------");
			Iterator itFinal=hijos.keySet().iterator();
			while(itFinal.hasNext()) {
				String hijoActual=(String)itFinal.next();
				escritor.escribir("Valor de salida del consumidor: "+hijoActual+
						" : "+hijos.get(hijoActual).exitValue());
			}
			
			escritor.escribir("----\nTodos los hijos han terminado.\n------------------------------");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
