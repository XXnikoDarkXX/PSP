
package clases;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Alejanddro Ríos Díaz
 *
 */
public class GestionDeDesechos {

	private int desechosRestantes;// Variable compartida
	
	public GestionDeDesechos(int desechosRestantes) {
		this.desechosRestantes = desechosRestantes;
	}

	public GestionDeDesechos() {
		this.desechosRestantes = desechosRestantes;
	}
	

	public int getDesechosRestantes() {
		return desechosRestantes;
	}

	public void setDesechosRestantes(int desechosRestantes) {
		this.desechosRestantes = desechosRestantes;
	}

	public void restarDesechos(int kilosPorNave) {
		int desechosTotal=desechosRestantes-kilosPorNave;	
		this.desechosRestantes = desechosTotal;
		
	}
	

	//Metodo Cerrojo
	public boolean comprobarExistencias(String nombreNave) throws InterruptedException {
    			
		if (getDesechosRestantes() > 0) {
		
			//int kilosXNave = kilosDesechosAEliminar(getDesechosRestantes());
			int kilosXNave=1;
			System.out.println("La nave " + nombreNave + " va a deshacerse de "+kilosXNave + " kg de desechos");
			
			restarDesechos(1);
			
			System.out.println("La nave " + nombreNave
					+ " ha escrito en el albarán, y parte a deshacerse de los desechos. __ Residuos en almacen: "
					+getDesechosRestantes()+" kg");

			return true;

		} else {
			// Si no puede eliminar desechos, espera un tiempo
			 Thread.sleep(1000);
			

			return false;
		}
		
    }
	
	public int kilosDesechosAEliminar(int desechosRestantes) {
		Random r = new Random();

		int kilosMax = 20;
		int kilosDeschosAEliminar;
		do {
			kilosDeschosAEliminar = r.nextInt(desechosRestantes);

		} while (kilosDeschosAEliminar > kilosMax);

		return kilosDeschosAEliminar;

	}

	
	
	
	
	


	

}
