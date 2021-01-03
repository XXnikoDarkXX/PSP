package barrera;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class MainBarrera {

	public static void main(String[] args) {
		try {
			int	contadorSalida=0;//este contador lo usaremos para cuando se lea que las plazas son 0 
			//la barrera ejecutada se pare y no siga su ejecucion
				Path ficheroBloqueo=FileSystems.getDefault().getPath("../bloqueo.lock");
				//Si no existe el fichero bloqueo lo creo
				if (!Files.exists(ficheroBloqueo)) {
					Files.createFile(ficheroBloqueo);
				}
				FileChannel canal= FileChannel.open(ficheroBloqueo,StandardOpenOption.READ,StandardOpenOption.WRITE);
				
			Escritor escritor=new Escritor("hijo"+args[0]+".log","ejecucionCompleta.log",true,false);
			escritor.escribir("Lanzando barrera "+args[0]);
			
			long inicial=System.currentTimeMillis();
			
			
			//Lanzo el programa durante 5 segundos, para que no se quede perpetuamente ejecutando
			while(System.currentTimeMillis()-inicial<1000) {
				//Usamos este if para dejar la ejecucion de las barreras en caso de que las plazan sean 0
					if (contadorSalida==1) {
						break;
					}
				//Thread.sleep(300); //Simulo que cada 300 ms llega un coche a la barrera
				//Creo una matrícula Random, simulando que llega un coche con esa matrícula
				String matriculaActual=generarMatricula();
				
				escritor.escribir("La barrera "+args[0]+" recibe un coche: "+matriculaActual);
				//Comprobando si hay plazas
				
				boolean dejaEntrar=false; //Variable que decide si el coche entra, false para que entre en el bucle
				//Punto critico tenemos que usar aqui el cerrojo a la hora de leer y escribir las plazas
				
					FileLock lock=canal.lock();
					BufferedReader br=new BufferedReader(new FileReader("./plazas.txt"));
					byte nPlazas=Byte.parseByte(br.readLine());
					br.close();
					escritor.escribir("La barrera "+args[0]+
							" tiene un coche en espera ("+matriculaActual+") Plazas libres: "+nPlazas);
					//Punto cr�tico
					if(nPlazas>0) { //Si me quedan plazas, dejo pasar
						nPlazas--; //Dejo pasar. Queda una plaza menos
						escritor.escribir("La barrera "+args[0]+" deja pasar un coche: "+matriculaActual
								+" Quedan "+nPlazas+" plazas.");
						//Escribo en el fichero plazas.txt el 
						//nuevo número de plazas, para que el resto
						//de procesos se entere.
						FileWriter fw=new FileWriter("./plazas.txt");
						fw.write(nPlazas+"\n");
						fw.flush();
						fw.close();
						dejaEntrar=true;
					}else { //Si no me quedan plazas, no dejo pasar.
						escritor.escribir("La barrera "+args[0]+" bloquea un coche: "+matriculaActual
								+" Quedan "+nPlazas+" plazas. Esperando 500ms");
						Thread.sleep(100);
						if (nPlazas==0) {
							
							
							contadorSalida=1;
						}
						
					}
					lock.close();
				}
				
			
			
			escritor.escribir("Apagada la barrera "+args[0]);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}
	
	public static String generarMatricula() {
		Random r=new Random();
		String matriculaActual="";
		for (int i = 0; i < 4; i++) { //Genero aleatoriamente las 4 cifras de una matrícula
			matriculaActual+=r.nextInt(10);
		}
		matriculaActual+=" "; //El espacio entre números y letras
		while(matriculaActual.length()<8){
			int aleatorio=r.nextInt(25)+66;
			if(aleatorio!=69&&aleatorio!=73&&aleatorio!=79&&aleatorio!=85) {
				matriculaActual+=(char)aleatorio;
			}
		}
		return matriculaActual;
	}

}
