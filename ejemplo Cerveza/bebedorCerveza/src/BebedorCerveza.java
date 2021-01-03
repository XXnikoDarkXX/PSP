import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Random;

public class BebedorCerveza {

	public static void main(String[] args) {
		try {
			//tasaUBEalcoholemia=(cc bebidos*graduación*0,8)/1000
			float tasaAlcoholemia=0; //Todos empezamos abstemios en esto
			float cervezaBebida=0; //Llevamos el control de cuánto hemos bebido en total. Podría disminuir si me siento a pasar la cogorza
			float cervezaEnSangre=0; //Cerveza que tengo en el cuerpo ahora mismo
			Path ficheroBloque=FileSystems.getDefault().getPath("../bloqueo.lock");//creamos un Path
			//declaramos un filceChanel con un path bloqueo
			FileChannel canal= FileChannel.open(ficheroBloque,StandardOpenOption.READ,StandardOpenOption.WRITE);
			Escritor escritor=new Escritor("hijo"+args[0]+".log","ejecucionCompleta.log",false);
			escritor.escribir("Soy "+args[0]+" y me dispongo a pimplar cerveza.");
			
			long momentoInicial=System.currentTimeMillis();
			
			//Decidimos que queremos ejecutar el programa durante 5s, como podíamos haber decidido dar 10 vasos, o hasta quedar borracho...
			while(System.currentTimeMillis()-momentoInicial<5000) {
				FileLock lock=canal.lock();
				//Primero, abrimos el grifo: Miramos a ver si queda cerveza en el barril
				BufferedReader br=new BufferedReader(new FileReader("../barril.txt"));
				float cervezaRestante=Float.parseFloat(br.readLine());
				br.close();
				
				//Si queda cerveza, le resto 30cl, que caben en un vaso
				//Tambi�n bebo solo si no estoy pimplado
				if(cervezaRestante>0&&tasaAlcoholemia<1.1) {
					cervezaBebida+=(cervezaRestante>=0.3?0.3:cervezaRestante); //Aumento el contador de la cerveza que he bebido
					cervezaRestante-=(cervezaRestante>=0.3?0.3:cervezaRestante); //lleno el vaso
					cervezaEnSangre+=(cervezaRestante>=0.3?0.3:cervezaRestante);//Conslleguimos la cervezaenSnagre
					//Bebo cerveza y actualizo mi tasa de alcoholemia.
					//tasaUBEalcoholemia=(cc bebidos*graduación*0,8)/1000
					tasaAlcoholemia=((cervezaEnSangre*100)*4.5f*0.8f)/1000; //divido por 100 para transformar centilitros en centímetros cúbicos
					escritor.escribir(args[0]+" se est� bebiendo un vaso. Lleva bebidos "
					+cervezaBebida+" l. Su cerveza en sangre son "+cervezaEnSangre+" l y su tasa de alcoholemia UBE es de :"+tasaAlcoholemia
					+" En el barril quedan "+cervezaRestante+" l");
					
					//Escribo en el recurso compartido (el barril) la cerveza que he quitado.
					FileWriter escritorBarril=new FileWriter("../barril.txt");
					escritorBarril.write(cervezaRestante+"\n");
					escritorBarril.flush();
					escritorBarril.close();
					
					//Tiempo aleatorio que tarda en acabarse el vaso de cerveza
					Random r=new Random();
					Thread.sleep(r.nextInt(100));
					escritor.escribir(args[0]+" se ha terminado su vaso, va a por otro.");
				}else {
					if(cervezaRestante==0) {
						escritor.escribir(args[0]+" se encuentra que el barril está vacío. Espera a que lo llenen");
						Thread.sleep(500); //Espero medio segundo, a ver si el barril se ha llenado ya
					}
					if(tasaAlcoholemia>=1.1) {
						escritor.escribir(args[0]+" se ha pasado bebiendo. Tiene que reposar un poco antes de seguir");
						//Nos inventamos el decremento de la alcoholemia para dar cabida a la ejecución en 5s
						//cada 1000 se me han disipado en el cuerpo 1,5 litros de cerveza
						Thread.sleep(1000);
						cervezaEnSangre-=1.5;
						tasaAlcoholemia=((cervezaEnSangre*100)*4.5f*0.8f)/1000; //divido por 100 para transformar centilitros en centímetros cúbicos
						
					}
				}
				lock.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
