package gestor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainGestor {
	
	private static final byte nBarreras=4; //Número de barreras del Párking
	private static final byte nPlazas=127; //Número de plazas inicial disponibles
	
	public static void main(String[] args) {
		try {
			Escritor escritor=new Escritor("procesoPadre.log","ejecucionCompleta.log",true,true);
			ArrayList<Process> hijos=new ArrayList<Process>();
			
			
			//Creando fichero de nº plazas compartido entre los hijos. Se limpia con cada ejecución
			FileWriter fw=new FileWriter("./plazas.txt");
			fw.write(nPlazas+"\n");
			fw.flush();
			fw.close();
			
			//Lanzamiento de barreras
			for (int i = 0; i < nBarreras; i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","./barrera.jar",i+"");
				pb.inheritIO();
				Process p=pb.start();
				hijos.add(p);
			}
			
			
			
			//Espero a que se paren todos los procesos para seguir
			for(int i=0;i < nBarreras; i++) {
				escritor.escribir("Est� la barrera n�"+i+" vivo? "+hijos.get(i).isAlive());
				hijos.get(i).waitFor();
			}
			
			//Informar de valores de salida
			escritor.escribir("\n\n----EJECUCI�N DE BARRERAS TERMINADA------");
			for(int i=0;i < nBarreras; i++) {
				escritor.escribir("Valor de salida de la barrera n�"+i+": "+hijos.get(i).exitValue());
			}
			
			escritor.escribir("----\nTodas las barreras han terminado.\n------------------------------");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
