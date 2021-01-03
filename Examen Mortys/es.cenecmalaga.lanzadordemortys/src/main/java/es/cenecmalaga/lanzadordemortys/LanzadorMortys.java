package es.cenecmalaga.lanzadordemortys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import auxiliares.Constantes;
import auxiliares.Escritor;
import interfaz.TableroMortys;

public class LanzadorMortys {

	public static void main(String[] args) {
		
		Escritor escritor;
		try {
			//Genero el escritor
			escritor = new Escritor("lanzadorMortys.log","ejecucionCompleta.log",true,true);
			
			
			//Pongo el contador de Mortys tras sus pasos a cero antes de empezar.
			FileWriter fw=new FileWriter("../mortysTrasSusPasos.txt");
			fw.write("0\n");
			fw.flush();
			fw.close();
			
			//Si el archivo común existe lo borro, y luego lo vuelvo a generar.
			Path archivoComun=FileSystems.getDefault().getPath("../localizacionMortys.cenec");
			if(Files.exists(archivoComun)) {
				Files.delete(archivoComun);
			}
			Files.createFile(archivoComun);
			
			//Genero la interfaz con el número de filas y columnas establecido.
			int nProc=Runtime.getRuntime().availableProcessors();
			escritor.escribir("Hola, tu procesador tiene "+nProc+" núcleos. Voy a crear una interfaz con una matriz de JLabel 5 veces más grande, de "+(nProc*Constantes.multiplicadorNumeroNucleos)+"x"+(nProc*Constantes.multiplicadorNumeroNucleos));
			TableroMortys interfaz=new TableroMortys((nProc*Constantes.multiplicadorNumeroNucleos),(nProc*Constantes.multiplicadorNumeroNucleos));

			//Declaro un array de Process, donde iré guardando a todos los procesos Morty generados
			ArrayList<Process> mortys=new ArrayList<Process>();
			
			
			//Lanzo a los procesos Morty, cada uno con un número identificador, y el tamaño de la matriz en filas y columnas. En los argumentos 0, 1 y 2 respectivamente.
			for (int i = 0; i < nProc*Constantes.multiplicadorNumeroNucleos; i++) {
				ProcessBuilder pb=new ProcessBuilder("java","-jar","../morty.jar",i+"",(nProc*Constantes.multiplicadorNumeroNucleos)+"",(nProc*Constantes.multiplicadorNumeroNucleos)+"");
				pb.inheritIO();
				Process p=pb.start();
				mortys.add(p);
			}
			
			//Durante 10 segundos, refresco la pantalla cada 100 ms.
			long momentoInicial=System.currentTimeMillis();
			while(System.currentTimeMillis()-momentoInicial<10000) {
				Thread.sleep(Constantes.tasaDeRefresco);
				escritor.escribir("Quedan "+(10-(System.currentTimeMillis()-momentoInicial)/1000f)+" segundos de ejecución del programa");
				interfaz.refrescar();
			}
			
			//Espero a que se paren todos los mortys para seguir
			escritor.escribir("\n----\nESPERANDO A QUE LOS MORTYS TERMINEN.\n------------------------------");
			for(int i=0;i < nProc*Constantes.multiplicadorNumeroNucleos; i++) {
				escritor.escribir("¿Está el Morty nº"+i+" vivo? "+mortys.get(i).isAlive());
				mortys.get(i).waitFor();
			}
			
			//Informar de valores de salida
			escritor.escribir("\n\n----EJECUCIÓN DE MORTYS TERMINADA------");
			for(int i=0;i < nProc*Constantes.multiplicadorNumeroNucleos; i++) {
				escritor.escribir("Valor de salida del Morty nº"+i+": "+(mortys.get(i).exitValue()==0?"Correcto (0)":"Error, ha petado. ("+mortys.get(i).exitValue()+")"));
			}
			
			escritor.escribir("\n----\nESTUPIDÓMETRO DE MORTYs.\n------------------------------");
			BufferedReader br=new BufferedReader(new FileReader("../mortysTrasSusPasos.txt"));
			int vecesTrasSusPasos=Integer.parseInt(br.readLine());
			escritor.escribir("\nLos mortys han vuelto sobre sus pasos un total de "+vecesTrasSusPasos+" veces.");
			
			interfaz.dispose();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
