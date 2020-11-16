
package BARRERAS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MAIN_PARKING_BARRERAS {

	public static void main(String[] args) {

		try {

			Escritor escritor = new Escritor("hijo" + args[0] + ".log", "ejecucionCompleta.log", true, false);
			escritor.escribir("Lanzando barrera " + args[0]);

			
			//EJECUCION//En este caso
			long inicial = System.currentTimeMillis();// Método que devuelve la hora actual del sistema en milisegundos

			// Lanzo el programa durante 10 segundos, para que no se quede perpetuamente ejecutandose
			while (System.currentTimeMillis() - inicial < 1000) {
				// Thread.sleep(300); //Simulo que cada 300 ms llega un coche a la barrera
				
				// Creo una matrícula Random, simulando que llega un coche con esa matrícula
				String matriculaActual = generarMatricula();

				escritor.escribir("La barrera " + args[0] + " recibe un coche: " + matriculaActual);
				// Comprobando si hay plazas

				boolean dejaEntrar = false; // Variable que decide si el coche entra, false para que entre en el bucle
				while (!dejaEntrar) {
					BufferedReader br = new BufferedReader(new FileReader("./plazas.txt"));
					byte nPlazas = Byte.parseByte(br.readLine());
					br.close();
					escritor.escribir("La barrera " + args[0] + " tiene un coche en espera (" + matriculaActual
							+ ") Plazas libres: " + nPlazas);
					if (nPlazas > 0) { // Si me quedan plazas, dejo pasar
						nPlazas--; // Dejo pasar. Queda una plaza menos
						escritor.escribir("La barrera " + args[0] + " deja pasar un coche: " + matriculaActual
								+ " Quedan " + nPlazas + " plaza.");

						// Escribo en el fichero plazas.txt el
						// nuevo número de plazas, para que el resto
						// de procesos se entere.
						FileWriter fw = new FileWriter("./plazas.txt");
						fw.write(nPlazas + "\n");// \n es importante para poder usar readLine() en todos los ficheros
						fw.flush();
						fw.close();
						dejaEntrar = true;

					} else { // Si no me quedan plazas, no dejo pasar.
						escritor.escribir("La barrera " + args[0] + " bloquea un coche: " + matriculaActual + " Quedan "
								+ nPlazas + " plazas. Esperando 500ms");
						Thread.sleep(100);
					}
				}
			}

			escritor.escribir("Apagada la barrera " + args[0]);

		} catch (IOException e) {
			e.printStackTrace();
		}  		
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String generarMatricula() {
		
		Random r = new Random();
		String matriculaActual = "";
		
		for (int i = 0; i < 4; i++) { // Genero aleatoriamente las 4 cifras de una matrícula
			matriculaActual += r.nextInt(10);
		}
		
		matriculaActual += " "; // El espacio entre números y letras
		
		while (matriculaActual.length() < 8) {
			int aleatorio = r.nextInt(25) + 66;
			if (aleatorio != 69 && aleatorio != 73 && aleatorio != 79 && aleatorio != 85) {
				matriculaActual += (char) aleatorio;
			}
		}
		
		return matriculaActual;
	}

}
