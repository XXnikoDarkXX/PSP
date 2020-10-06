package com.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import com.grafico.Historia;





public class HistoriaAutomatica {

	
	public static void main(String[] args) {
		 
	
		 //instanciamos la clase Robot
        Robot robot;
      String historiaInicial ="hola acabas de ejecutar trollpsp estate quieto y alucinaaa";	
        //String historiaInicial ="hola";	hola acabas de ejecutar trollpsp estate quieto  alucinaaa
       
      Historia ventanaHistoria=new Historia();
      
        int []pruebaTecla=teclado(historiaInicial);
		try {
			
			robot = new Robot();
		
 
        //esperamos 2 segundos antes de empezar a escribir
        robot.delay(4000);
 
        
     // click con el boton izquierdo
        //robot.mouseMove(300, 600);
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
		 for (int i = 0; i < teclaSiempre.length; i++) {
			System.out.println(teclaSiempre[i]);
		}
		 
		 return teclaSiempre;
		 
	 }
	
}
