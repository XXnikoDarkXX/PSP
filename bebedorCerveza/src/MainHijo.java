import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Random;

public class MainHijo {

	public static void main(String[] args) {
		try {

			float tasaAlcoholemia=0;//tasa para saber si estamos borracho
			float cervezaBebida=0;//cerbeza que hemos bebido en total
			float cervezaEnSangre=0;//cerveza que tenemos en el curpo, lo podemos distinguir porque este disminuye y sirve para calcular la tasa de alcoholemia
			Escritor escritor = new Escritor("hijo" + args[0] + ".log", "ejecucionCompleta.log", false);
			escritor.escribir("Soy" + args[0] + " me dispongo a pimplar cerveza");

			long momentoInicial = System.currentTimeMillis();
			// Decidimos que queremos ejecutar el programa durante 5s, como podiamos haber
			// decidido
			while (System.currentTimeMillis() - momentoInicial < 5000) {
				// Primero, abrimos el grifo: Miaramos a ver si queda cerveza en el barril
				BufferedReader br = new BufferedReader(new FileReader("./barril.txt"));
				float cervezaRestante = Float.parseFloat(br.readLine());
				br.close();
				// Si queda cerveza, le resto 30cl, que caben e un vaso
				//tambien bebo solo si no estoy pimplao(borracho)
				if (cervezaRestante > 0&&tasaAlcoholemia<1.1) {
					//si cerbezaRestante>0.3 True--> le aumentamos 0.3, Falso--> Cogemos el restante que queda
					cervezaBebida+=(cervezaRestante>0.3?0.3:cervezaRestante);//aumento el contador de cerbezaBebida
					cervezaRestante -=(cervezaRestante>0.3?0.3:cervezaRestante);// leno el vaso
					cervezaEnSangre+=(cervezaRestante>0.3?0.3:cervezaRestante);
					//tasaUBEAlchojolemia=(cc bebidos*graduacion*0,8)/1000
					// bebo cerveza y actualizo mi tasa de alcoholemia.
					tasaAlcoholemia=((cervezaEnSangre*100)*4.5f*0.8f)/1000;//divido por 1000 para transformar cl en centrimetros cubicos
					escritor.escribir(args[0]+" se ha bebido un vaso. Lleva bebidos "+cervezaBebida+" l, y su cerveza en sangre es "
							+ " : "+cervezaEnSangre+ "su tasa de alcoholemia es: "+tasaAlcoholemia+" En el barril quedan "+cervezaRestante +" l");
					
					
					//Escribo en el recurso compartido el baril la cerveza que he quitado
					FileWriter escritorBarril=new FileWriter("./barril.txt");
					escritorBarril.write(cervezaRestante+"\n");
					escritorBarril.flush();
					escritorBarril.close();
					//tiempo aleatorio que tarda en acabarse el vaso de cerveza
					Random r=new Random();
					Thread.sleep(r.nextInt(100));
					escritor.escribir(args[0]+" se ha terminado su vaso, va a por otro.");
				}else {
					if (cervezaRestante==0) {
						escritor.escribir(args[0]+" se encuentra que el barril está vacio. Espera a que lo llenen");
						Thread.sleep(500);//Espero medio segundo, a ver si el barril se ha llenado ya
					}
					if (tasaAlcoholemia>=1.1) {
						escritor.escribir(args[0]+" se ha pasado bebiendo. Tiene que reposra un poco antes de seguir");
						//nos inventamos el decremento de la alcoholemia para dar cabida a la ejecucion en 5 segundos
						//cada 1sg se me ha disipado en el cuerpo 1.5 de la cerveza en sangre
						Thread.sleep(1000);
						cervezaEnSangre-=1.5;
						tasaAlcoholemia=((cervezaEnSangre*100)*4.5f*0.8f)/1000;
					}
				
				}

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
