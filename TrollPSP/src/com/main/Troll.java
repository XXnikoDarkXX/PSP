package com.main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.print.attribute.standard.Media;

import com.grafico.GraficoImagenes;
import com.grafico.Historia;

public class Troll {
	

	public static void main(String[] args) {

		// Vamos a conocer primero la resolucion de la pantalla en java para ello vamos
		// a usar el framewoerk Toolkit
		GraficoImagenes trolBienvenida=new GraficoImagenes();
		Toolkit t = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();// con la clase Dimesions conseguimos las
			// dimensiones de  cualquier componente de AWT
		
		//Mostramos la resolucion de tu pantalla
		System.out.println("Tu resolución es de " + tamanoPantalla.width + "x" + tamanoPantalla.height);
		// instanciamos la clase Robot
		Robot robot;
		int alturaPantalla=tamanoPantalla.height;//obtenemos el alto de la resolucion y lo almacenamos
		int anchoPantalla=tamanoPantalla.width;//Obtenemos el ancho de la resolucion 
		
       
      String historiaInicial ="bienvenido al programa trollpsp ahora quedate quieto y alucina";	
        //String historiaInicial ="hola";	
      
       
    
      
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
        String mensajeSegundo="vamos a empezar un poquito mas rapido esto es solo el inicio, y recuerda una cosa la recursividad no es para ti";
        robot.delay(1000);//dormimos al robot solo 1sg
        int []tecladoSegundo=teclado(mensajeSegundo);
        // click con el boton izquierdo
        robot.mouseMove(alturaPantalla/4, anchoPantalla/4);//centramos el raton justo a al texto para escribir
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
		
		
		Random r=new Random();
		try {
			robot = new Robot();

			// cambia la posición en pantalla del puntero a las coordenadas
			// X=300 e Y=600.
			robot.mouseMove(300, 600);
			for (int i = 0; i < 2; i++) {//REVISAR
			robot.mouseMove(r.nextInt(1300), 700);	
			robot.delay(500);
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
	
		
		
		
	
}

