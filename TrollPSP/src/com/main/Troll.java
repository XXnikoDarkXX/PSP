package com.main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.print.attribute.standard.Media;

import com.grafico.Historia;

public class Troll {
	/*
	 * final static int teclas[] = { KeyEvent.VK_H, KeyEvent.VK_O, KeyEvent.VK_L,
	 * KeyEvent.VK_A, KeyEvent.VK_SPACE, KeyEvent.VK_M, KeyEvent.VK_U,
	 * KeyEvent.VK_N, KeyEvent.VK_D, KeyEvent.VK_O };
	 */

	public static void main(String[] args) {

		// Vamos a conocer primero la resolucion de la pantalla en java para ello vamos
		// a usar el framewoerk Toolkit

		Toolkit t = Toolkit.getDefaultToolkit();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// con la clase Dimesions conseguimos las
			// dimensiones de  cualquier componente de AWT
		
		//Mostramos la resolucion de tu pantalla
		System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
		// instanciamos la clase Robot
		Robot robot;
		Random r=new Random();
		try {
			robot = new Robot();

			// cambia la posición en pantalla del puntero a las coordenadas
			// X=300 e Y=600.
			robot.mouseMove(300, 600);
			for (int i = 0; i < 2; i++) {//REVISAR
			robot.mouseMove(r.nextInt(1300), 700);	
			robot.delay(1500);
			}
			int x;
			int y;
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Historia lore=new Historia();
	
		
		
		
	}
}
/*
 * //instanciamos la clase Robot Robot robot; try { robot = new Robot();
 * 
 * 
 * //esperamos 2 segundos antes de empezar a escribir robot.delay(2000);
 * 
 * //iteramos a través del arreglo de teclas for (int i = 0 ; i < teclas.length
 * ; i++) { //presionamos y soltamos cada tecla del array
 * robot.keyPress(teclas[i]); robot.keyRelease(teclas[i]);
 * 
 * //dormimos el robot por 250 mili segundos luego de usar cada tecla
 * robot.delay(250); } } catch (AWTException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } } }
 */
