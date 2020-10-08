package com.main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Random;

import javax.print.attribute.standard.Media;

import com.grafico.GraficoImagenes;
import com.grafico.GraficoRandom;
import com.grafico.GraficoSimpson;
import com.grafico.Historia;

public class Troll {
	

	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();// Creamos un File System para poder manejar ficheros
		
		// Vamos a conocer primero la resolucion de la pantalla en java para ello vamos
		// a usar el framewoerk Toolkit
		GraficoImagenes trolBienvenida=new GraficoImagenes();
		Toolkit t = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();// con la clase Dimesions conseguimos las
			// dimensiones de  cualquier componente de AWT
		
		//Mostramos la resolucion de tu pantalla
		System.out.println("Tu resolución es de " + tamanoPantalla.width + "x" + tamanoPantalla.height);
		// instanciamos la clase Robot
		Robot robot = null;
		int alturaPantalla=tamanoPantalla.height;//obtenemos el alto de la resolucion y lo almacenamos
		int anchoPantalla=tamanoPantalla.width;//Obtenemos el ancho de la resolucion 
		
       
      String historiaInicial ="bienvenido al programa trollpsp ahora quedate quieto y alucina";	
      
      
       
    
      
        int []pruebaTecla=teclado(historiaInicial);
		try {
			
			robot = new Robot();
		
 
        //esperamos 7 segundos antes de empezar a escribir
        robot.delay(7000);
 
        
     // click con el boton izquierdo
        robot.mouseMove(alturaPantalla/2, anchoPantalla/2);//centramos el raton justo a la consola
        robot.mousePress(InputEvent.BUTTON1_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_MASK);
        
        //iteramos a través del arreglo de teclas
        for (int i = 0 ; i < pruebaTecla.length ; i++) {
            //presionamos y soltamos cada tecla del array
            robot.keyPress(pruebaTecla[i]);//presionamos la tecla
            robot.keyRelease(pruebaTecla[i]);//la esribimos
       
            //dormimos el robot por 250 mili segundos luego de usar cada tecla
            robot.delay(250);
       
	}
        Historia ventanaHistoria=new Historia(); 
        
        String mensajeSegundo="es la hora del sufrimiento  recuerda una cosa la recursividad no es para vosotros cermuzoos";
        robot.delay(1000);//dormimos al robot solo 1sg
        int []tecladoSegundo=teclado(mensajeSegundo);
        // click con el boton izquierdo
        robot.mouseMove(100, 100);//centramos el raton justo a al texto para escribir
        robot.mousePress(InputEvent.BUTTON1_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //Segunda fase de escritura en cosola pero mas rapido
        for (int i = 0; i < tecladoSegundo.length; i++) {
        	  //presionamos y soltamos cada tecla del array
            robot.keyPress(tecladoSegundo[i]);//presionamos la tecla
            robot.keyRelease(tecladoSegundo[i]);//la esribimos
       
            //dormimos el robot por 250 mili segundos luego de usar cada tecla
            robot.delay(80);
		}
        
        
		 } catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//vamos a empezar a crear carpetas a lo loco y tambien algun que otro archivo
		
		

		// dentro de esta carpeta vamos a iterar en bucle creando carpetillas
		Path actual = fs.getPath("copiasMultiverso");
		
		System.out.println(actual.toAbsolutePath());
		
		//creamos copiasMultiverso 
		try {
			Files.createDirectories(actual);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		carpetaTroll(actual, "cermuzooos");
		
		
		
		//ahora vamos a crear un arhvico txt y le vamos a escribir algo
	Path archivoHack=fs.getPath(actual+"\\hack.txt");
		
		if (Files.exists(archivoHack)) {
			
		}else {
			System.out.println("Creando archivo");
			try {
				Files.createFile(fs.getPath(actual.toString(),"hack.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
       
		FileWriter escritor;
		String ubi=actual.toString();
			try {
				escritor = new FileWriter(actual+"/hack.txt");
		
		

		escritor.write("Hola,te he creado un txt\n");

		escritor.write("Cuando termines revisa esta ubicacion: "+archivoHack.toAbsolutePath()+"\n");
		escritor.write("bueno si te lo pongo yo");
		
		escritor.flush();

		escritor.close();
		
	
				
		BufferedReader  br=new BufferedReader(new FileReader(actual+"/hack.txt"));
	    String textoArchivo="";
	            String textoLinea="";
	            while(textoLinea!=null){
	                textoArchivo+=textoLinea+"\n";
	                textoLinea=br.readLine();
	                
	            }
	            System.out.println(textoArchivo);
	            br.close();
		
	        	Thread.sleep(2000);
	    		
	    		//Nos metemos en la carpeta del TrollPSP
	    				
	    		Process p = new ProcessBuilder("explorer.exe", "/select,"+actual.toAbsolutePath()+"\\c").start();
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//Le metemos el grafico de homerSimsomp
	    		
	    		GraficoSimpson simpson=new GraficoSimpson();
	    		try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		//3 parte de historia
	    		GraficoImagenes trolFinalizar=new GraficoImagenes();
	    		try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		  Historia ventanaHistoria=new Historia();
	    	        String mensajeSegundo="la ultima parte crack";
	    	        robot.delay(80);//dormimos al robot solo 1sg
	    	        int []tecladoSegundo=teclado(mensajeSegundo);
	    	        // click con el boton izquierdo
	    	        robot.mouseMove(100, 100);//centramos el raton justo a al texto para escribir
	    	        robot.mousePress(InputEvent.BUTTON1_MASK);
	    	       robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    	        //Segunda fase de escritura en cosola pero mas rapido
	    	        for (int i = 0; i < tecladoSegundo.length; i++) {
	    	        	  //presionamos y soltamos cada tecla del array
	    	            robot.keyPress(tecladoSegundo[i]);//presionamos la tecla
	    	            robot.keyRelease(tecladoSegundo[i]);//la esribimos
	    	       
	    	            //dormimos el robot por 250 mili segundos luego de usar cada tecla
	    	            robot.delay(80);
	    	        }
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		Random r=new Random();
		try {
			robot = new Robot();

			// cambia la posición en pantalla del puntero a las coordenadas
			// X=300 e Y=600.
			robot.mouseMove(300, 600);
			for (int i = 0; i < 50; i++) {
		   GraficoRandom imagenRandom=new GraficoRandom();
			robot.mouseMove(r.nextInt(1300), 700);	
			robot.delay(80);
			}
			int x;
			int y;
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		
		
		

	}


	
	 /**
	  * Funcion para poder controlar el teclado del ordenador
	  * Mediante un switch comprobamos el string historia letra a letra y lo metemos en un likedList
	  * Finalmente lo metemos en un array y escuchamos el codigo con el keyPresss y keyRelease
	  * @param historiaInicial String con el texto que vamos a escribir
	  * @return un array int de enteros que son las letras que vamos a escribir
	  */
	 public static int[] teclado(String historiaInicial) {
		 
		 LinkedList <Integer> teclaTotal= new LinkedList();
		 for (int i = 0; i < historiaInicial.length(); i++) {
			char letra=historiaInicial.charAt(i);
			
			switch(letra) {
			case ' ':
				teclaTotal.add(KeyEvent.VK_SPACE);
				break;
			case 'a':
				 teclaTotal.add(KeyEvent.VK_A);
				 break;
			case 'b':
				teclaTotal.add(KeyEvent.VK_B);
				break;
				
			case 'c':
			teclaTotal.add(KeyEvent.VK_C);
			break;
			
			case 'd':
				
				teclaTotal.add(KeyEvent.VK_D);
				break;
				
			case 'e':
			teclaTotal.add(KeyEvent.VK_E);
			break;
			
			case 'f':
				teclaTotal.add(KeyEvent.VK_F);
				
				break;
				
			case 'g':
				teclaTotal.add(KeyEvent.VK_G);
				break;
				
			case 'h':
				teclaTotal.add(KeyEvent.VK_H);
				break;
				
			case 'i':
				teclaTotal.add(KeyEvent.VK_I);
				break;
				
			case 'j':
				teclaTotal.add(KeyEvent.VK_J);
				break;
				
			case 'k':
				teclaTotal.add(KeyEvent.VK_K);
				break;
				
			case 'l':
				teclaTotal.add(KeyEvent.VK_L);
				break;
				
			case'm':
				teclaTotal.add(KeyEvent.VK_M);
				break;
				
			case 'n':
				teclaTotal.add(KeyEvent.VK_N);
				break;
				
			
				
			case 'o':
				teclaTotal.add(KeyEvent.VK_O);
				break;
				
			case 'p':
				teclaTotal.add(KeyEvent.VK_P);
				break;
				
			case 'q':
				teclaTotal.add(KeyEvent.VK_Q);
				break;
				
			case 'r':
				teclaTotal.add(KeyEvent.VK_R);
				break;
				
			case 's':
				teclaTotal.add(KeyEvent.VK_S);
				break;
			case 't':
				
				teclaTotal.add(KeyEvent.VK_T);
				break;
			case 'u':
				teclaTotal.add(KeyEvent.VK_U);
				break;
				
			case 'v':
			teclaTotal.add(KeyEvent.VK_V);
			break;
			case 'w':
				
				
				teclaTotal.add(KeyEvent.VK_W);
				break;
				
			case 'x':
				teclaTotal.add(KeyEvent.VK_X);
				break;
			case 'y':
				teclaTotal.add(KeyEvent.VK_Y);
				break;
			case 'z':
				teclaTotal.add(KeyEvent.VK_Z);
				break;
			}
			 
		}
	//	 Integer teclaEntero[]=teclaTotal.toArray(new Integer[teclaTotal.size()]);
		 int teclaSiempre[]=new int[teclaTotal.size()];
		 for (int i = 0; i < teclaSiempre.length; i++) {
			teclaSiempre[i]=teclaTotal.get(i);
		}
		
		 
		 return teclaSiempre;
		 
	 }

		/**
		 * Mediante esta funcion creamos en un path una marquesina de carpetas
		 * 
		 * @param ruta a la cual vamos a meter las carpetas
		 * @param msj  nombre de las carpetas
		 */
		public static void carpetaTroll(Path ruta, String msj) {
			try {
				FileSystem fs = FileSystems.getDefault();// Creamos un File System para poder manejar ficheros
				String res = "";

				for (int i = 0; i < msj.length() - 1; i++) {

					res += msj.charAt(i);

					Path carpetaMuchas = fs.getPath(ruta + fs.getSeparator() + res);

					Files.createDirectories(carpetaMuchas);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
}

