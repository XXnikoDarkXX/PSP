import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Clase que se encarga de escribir lo que se le mande por argumentos a su función tanto en un fichero individual,como en un fichero para logs colectivo, como por consola.
 * @author mparamos
 *
 */
public class Escritor {

	private String individual; //Ruta donde escribe el proceso actual de forma individual
	private String comun; //Ruta donde escribe el proceso actual de forma colectiva: Todos los procesos ejecutados en paralelo escriben en el mismo sitio
	
	/**
	 * Constructor de la clase, recibe dos rutas de fichero en las que escribir
	 * @param ficheroLogIndividual ruta del fichero de log donde escribirá solo el proceso actual
	 * @param ficheroLogComun ruta del fichero de log donde escribirán varios procesos ejecutados en paralelo
	 * @param machacar Si está a true, machaca el contenido de los ficheros, dejándolos en blanco. Si no, concatenará.
	 * @throws IOException 
	 */
	public Escritor(String ficheroLogIndividual,String ficheroLogComun,boolean machacar) throws IOException {
		individual=ficheroLogIndividual;
		comun=ficheroLogComun;
		
		//Este if es solo para que me ponga en blanco el contenido de los ficheros
		if(machacar) {
			FileWriter escritorIndividual=new FileWriter(individual);
			FileWriter escritorComun=new FileWriter(comun);
			escritorIndividual.close();
			escritorComun.close();
		}
		
	}
	
	/**
	 * Función que escribe el mensaje tanto para el fichero individual, como el fichero común como por consola.
	 * @param msg el mensaje a escribir en los tres lugares
	 * @throws IOException 
	 */
	public void escribir(String msg) throws IOException {
		FileWriter escritorIndividual=new FileWriter(individual,true);
		FileWriter escritorComun=new FileWriter(comun,true);
		
		escritorIndividual.write(msg+"\n");
		escritorComun.write(msg+"\n");
		
		escritorIndividual.flush();
		escritorComun.flush();
		
		escritorIndividual.close();
		escritorComun.close();
		
		System.out.println(msg);
	}
	
}
