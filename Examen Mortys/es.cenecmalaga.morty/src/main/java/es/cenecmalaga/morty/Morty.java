package es.cenecmalaga.morty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Random;

import auxiliares.Constantes;
import auxiliares.Escritor;

public class Morty {

	public static void main(String[] args) {
		try {
			Path ficheroBloqueo=FileSystems.getDefault().getPath("../bloqueo.lock");
			//Si no existe el fichero bloqueo lo creo
			if (!Files.exists(ficheroBloqueo)) {
				Files.createFile(ficheroBloqueo);
			}
			
			//declaramos un filceChanel con un path bloqueo
			FileChannel canal= FileChannel.open(ficheroBloqueo,StandardOpenOption.READ,StandardOpenOption.WRITE);
			
			
			//Preparo el escritor y lanzo mensaje inicial. El identificador de Morty me viene en el argumento 0.
			Escritor escritor=new Escritor("morty "+args[0]+".log","ejecucionCompleta.log",true,false);
			escritor.escribir("Lanzando Morty nº "+args[0]);
			
			
			//Inicializo el set<String> que me dice las posiciones por las que ya ha pasado mi morty
			HashSet<String> posicionesAnterioresMorty=new HashSet<String>();
			
			
			//Establezco de forma aleatoria la posición inicial de este Morty. El tamaño de la matriz me viene en los argumentos 1 (filas) y 2 (columnas)
			Random r=new Random();
			byte fila=(byte) r.nextInt(Byte.parseByte(args[1]));
			byte columna=(byte) r.nextInt(Byte.parseByte(args[2]));
			
			//Escribo en la posición concreta del fichero común, donde va a ir el morty
			Path archivoComun=FileSystems.getDefault().getPath("../localizacionMortys.cenec");
			RandomAccessFile accesoArchivoComun=new RandomAccessFile(archivoComun.toString(),"rw");
			accesoArchivoComun.seek(Integer.parseInt(args[0])*2);
			accesoArchivoComun.writeByte(fila);
			accesoArchivoComun.writeByte(columna);
			accesoArchivoComun.close();
			
			//Durante 10 segundos, voy cambiando continuamente la posición de los mortys, cada (tasa de refresco) ms.
			long momentoInicial=System.currentTimeMillis();
			while(System.currentTimeMillis()-momentoInicial<10000) {
				
				//Paro durante el tiempo que diga la tasa de refresco
				Thread.sleep(Constantes.tasaDeRefresco);
				
				//Elijo de forma aleatoria el movimiento, si arriba, abajo, izda o dcha. Tengo en cuenta los valores extremo.
				//Si voy a salirme de uno, el movimiento se anula por este turno.
				switch(r.nextInt(4)) {
					case 0: //me muevo arriba si no estoy en la primera fila
						if(fila>0) {
							fila--;
						}
						break;
					case 1: //me muevo abajo si no estoy en la última fila
						if(fila<Byte.parseByte(args[1])-1) {
							fila++;
						}
						break;
					case 2: //me muevo izda si no estoy en la primera columna
						if(columna>0) {
							columna--;
						}
						break;
					case 3: //me muevo dcha si no estoy en la última columna
						if(columna<Byte.parseByte(args[2])-1) {
							columna++;
						}
						break;
				}
				
				FileLock cerrojo=canal.lock();
				//Compruebo si la nueva posición ya está en el HashSet. Si lo está, añado uno al contador de mortysTrasSusPasos
				if(posicionesAnterioresMorty.contains("("+fila+","+columna+")")) {
					
					
					BufferedReader br=new BufferedReader(new FileReader("../mortysTrasSusPasos.txt"));
					int vecesTrasSusPasos=Integer.parseInt(br.readLine());
					vecesTrasSusPasos++;
					//Pongo el contador de Mortys tras sus pasos a cero antes de empezar.
					FileWriter fw=new FileWriter("../mortysTrasSusPasos.txt");
					fw.write(vecesTrasSusPasos+"\n");
					fw.flush();
					fw.close();
				}
				
				cerrojo.close();	
				//Pongo la posición actual en el HashSet, indicando que ya se ha visitado
				posicionesAnterioresMorty.add("("+fila+","+columna+")");
				
				//Escribo en el fichero la nueva posición, para que TableroMortys la lea.
				accesoArchivoComun=new RandomAccessFile(archivoComun.toString(),"rw");
				accesoArchivoComun.seek(Integer.parseInt(args[0])*2);
				accesoArchivoComun.writeByte(fila);
				accesoArchivoComun.writeByte(columna);
				accesoArchivoComun.close();
				
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
