
package GESTOR;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Clase que se encarga de escribir lo que se le mande por argumentos a su funcion tanto en un fichero individual, como en un fichero colectivo y por consola
 * @author Alejandro Ríos Díaz
 *
 */
public class Escritor {
	
	private String individual;//Ruta donde se va a escribir el proceso actual de forma individual
	private String comun;//Ruta donde se va a escribir el proceso actual de forma colectiva: Todos los procesos ejecutados en paralelo se escriben en el mismo sitio
	
	/**
	 * Constructor de la clase, recibe dos rutas de ficheros en las que escribir
	 * @param FicheroLogIndividual, ruta del fichero Log donde escribira el proceso actual
	 * @param FicheroLogComun, ruta del fichero Log donde se escribiran los procesos en paralelo
	 * @param machacarIndividual si esta a true, machaca el contenido de los ficheros, dejandolos en blanco. Si no, concatenara
	 * @param MachacarComun si esta a true, machaca el contenido de los ficheros, dejandolos en blando. Si no, concatenara
	 * @throws IOException, la lanza si no puede escribir
	 */
	public Escritor(String FicheroLogIndividual, String FicheroLogComun,  boolean machacarIndividual, boolean MachacarComun) throws IOException {
		
		this.individual=FicheroLogIndividual;
		this.comun=FicheroLogComun;
		
		//Este if es solo para que ponga en blanco el contenido de los ficheros
		if (machacarIndividual) {
			FileWriter escritorIndividual=new FileWriter(individual);
			escritorIndividual.close();
		}
	
		//Este if es solo para que ponga en blando el contenido de los fichereos
		if (MachacarComun) {
			FileWriter escritorComun=new FileWriter(comun);
			escritorComun.close();
		}
		
		
	}
	
	/**
	 * Función que escribe el mensaje tanto en el fichero individual, en el comun y por consola
	 * @param msg, el mensaje a escribir en los 3 lugares
	 * @throws IOException, la lanza si no puede escribir
	 *
	 */
	public void escribir(String msg) throws IOException {
		
		FileWriter escritorIndividual=new FileWriter(individual,true);//Instancia y concatena
		FileWriter escritorComun=new FileWriter(comun,true);
		
		escritorIndividual.write("["+LocalDateTime.now()+"] "+msg+"\n");//Escribe con fecha y hora el msg pasado por parametros
		escritorComun.write("["+LocalDateTime.now()+"] "+msg+"\n");
		
		escritorIndividual.flush();//Vuelca
		escritorComun.flush();
		
		escritorIndividual.close();//Cierra
		escritorComun.close();
		
		System.out.println("["+LocalDateTime.now()+"] "+msg);//Imprime por consola
	}
	
	
	

}
























