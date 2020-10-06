package com.main;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que se enccarga de escribir lo que se le mande tanto en un fichero individual cnomo en un fichero para loogs coletivo como por consola
 * @author nicoc
 *
 */
public class Escritor {
	
	String  individual;//ruta donde escribe el proceso actual de forma individual
	String  comun;//rua donde escribe el proceso de forma colectiva todos los procesos son ejecutados en paralelos
	/**
	 * Constructor de la clase, recibe dos rutas de fichero en la que escribir
	 * @param ficheroLogIndividual ruta del fichero de log dodne escribira solo el proceso actual
	 * @param ficheroLogComun ruta del fichero de log donde escribiran varios procesos ejectuados
	 */
	public Escritor(String ficheroLogIndividual,String ficheroLogComun) {
		individual=ficheroLogIndividual;
		comun=ficheroLogIndividual;

	}
	/**
	 * Mensaje para que tanto 
	 * @param msg
	 * @throws IOException
	 */
	public void escribir(String msg) throws IOException {
		FileWriter escritorIndividual=new FileWriter(individual);
		FileWriter escritorComun=new FileWriter(comun);
		escritorIndividual.write(msg);
		escritorComun.write(msg);
		
		escritorIndividual.flush();
		escritorComun.flush();
		
		escritorComun.close();
		escritorIndividual.close();
	}
}
