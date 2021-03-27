package barrera;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class MainBarrera {

	public static void main(String[] args) {
		try {
			
			Escritor escritor=new Escritor("hijo"+args[0]+".log","ejecucionCompleta.log",true,false);
			escritor.escribir("Lanzando barrera "+args[0]);
			
			long inicial=System.currentTimeMillis();
			
			
			//Lanzo el programa durante 10 segundos, para que no se quede perpetuamente ejecutando
			while(System.currentTimeMillis()-inicial<10000) {
				Thread.sleep(300); //Simulo que cada 300 ms llega un coche a la barrera
				escritor.escribir("La barrera "+args[0]+" recibe un coche.");
				//Comprobar si hay sitio en el parking
			}
			
			escritor.escribir("WApagada la barrera "+args[0]);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
