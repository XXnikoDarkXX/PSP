
package GESTOR;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MAIN_PARKING_GESTOR {
	
	private static final byte nBarreras=2;
	private static final byte nPlazas=127;

	public static void main(String[] args) {


		try {
			
			Escritor escritor=new Escritor("procesoPadre.log", "ejecucionCompleta.log", true, false);
			ArrayList<Process> hijos=new ArrayList<Process>();
			
			//Crear un fichero con numero de plazas, compartido entre los hijos(barreras). Se limpia con cada ejecucion (va cambiando el numero de plazas libres)
			FileWriter fw=new FileWriter("./plazas.txt");
			fw.write(nPlazas+"\n");//Este \n permite que al leer desde los hijos pueda utilizar readLIne()
			fw.flush();
			fw.close();
			
			//Lanzamiento de procesos hijos (barreras)
			for (int i = 0; i < nBarreras; i++) {
				ProcessBuilder pb=new ProcessBuilder("java", "-jar", "./barrera.jar",i+"");
				pb.inheritIO();
				Process p=pb.start();
				hijos.add(p);
			}
			
			//Espero a que se paren todos los procesos para seguir
			for (int i = 0; i < nBarreras; i++) {
				escritor.escribir("¿Está la barrera numero "+i+" viva? "+hijos.get(i).isAlive());
				hijos.get(i).waitFor();
			}
			
			//Informacion de valores de salida
			escritor.escribir("\n\n--------EJECUCION DE BARRERAS TERMINADA--------");
			for (int i = 0; i < nBarreras; i++) {
				escritor.escribir("Valor de salida de la barrera numero "+i+": "+hijos.get(i).exitValue());
			}
			
			escritor.escribir("-----------\nTodas las barreras han terminado.\n----------");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
		

	}

}
