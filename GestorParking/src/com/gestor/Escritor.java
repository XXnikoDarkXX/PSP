package com.gestor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * Clase que se encarga de escribir lo que se le mande por argumentos a su funci√≥n tanto en un fichero individual,como en un fichero para logs colectivo, como por consola.
 * @author mparamos
 *
 */
public class Escritor {

	private String individual; //Ruta donde escribe el proceso actual de forma individual
	private String comun; //Ruta donde escribe el proceso actual de forma colectiva: Todos los procesos ejecutados en paralelo escriben en el mismo sitio
	
	/**
	 * Constructor de la clase, recibe dos rutas de fichero en las que escribir
	 * @param ficheroLogIndividual ruta del fichero de log donde escribir· solo el proceso actual
	 * @param ficheroLogComun ruta del fichero de log donde escribir·n varios procesos ejecutados en paralelo
	 * @param machacarIndividual Si est· a true, machaca el contenido de los ficheros, dej·ndolos en blanco. Si no, concatenar·.
	 * @param machacarComun Si est· a true, machaca el contenido de los ficheros, dej·ndolos en blanco. Si no, concatenar·.
	 * @throws IOException La lanza si no puede escribir
	 */
	public Escritor(String ficheroLogIndividual,String ficheroLogComun,boolean machacarIndividual,boolean machacarComun) throws IOException {
		individual=ficheroLogIndividual;
		comun=ficheroLogComun;
		
		//Este if es solo para que me ponga en blanco el contenido de los ficheros
		if(machacarIndividual) {
			FileWriter escritorIndividual=new FileWriter(individual);
			escritorIndividual.close();
		}
		if(machacarComun) {
			FileWriter escritorComun=new FileWriter(comun);
			escritorComun.close();
		}
		
	}
	/**
	 * Funci√≥n que escribe el mensaje tanto para el fichero individual, como el fichero com√∫n como por consola.
	 * @param msg el mensaje a escribir en los tres lugares
	 * @throws IOException 
	 */
	public void escribir(String msg) throws IOException {
		FileWriter escritorIndividual=new FileWriter(individual,true);
		FileWriter escritorComun=new FileWriter(comun,true);
		
		escritorIndividual.write("["+"LocalDateTime.now()"+"]"+msg+"\n");
		escritorComun.write("["+"LocalDateTime.now()"+"]"+msg+"\n");
		
		escritorIndividual.flush();
		escritorComun.flush();
		
		escritorIndividual.close();
		escritorComun.close();
		
		System.out.println(msg);
	}
	
}
