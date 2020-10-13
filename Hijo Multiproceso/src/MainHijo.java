import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class MainHijo {

	public static void main(String[] args) {
		try {
			//queremos que machaque solo el invidual pero no el colectivo
			Escritor escritor=new Escritor("hijo"+args[0]+".log","ejecucionCompleta.log",true,false);
			escritor.escribir("["+LocalDateTime.now()+"] Hola mundo, soy el proceso hijo "+args[0]);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
