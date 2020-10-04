package com.main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;

public class Troll {

	public static void main(String[] args) {
	
		//Vamos a conocer primero la resolucion de la pantalla en java para ello vamos a usar el framewoerk Toolkit
		
		
		Toolkit t = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//con la clase Dimesions conseguimos las dimensiones de
		//cualquier componente de AWT
		
		
		
		//instanciamos la clase Robot
        Robot robot;
		try {
			robot = new Robot();
		
 
        //cambia la posición en pantalla del puntero a las coordenadas
        //X=300 e Y=600.
        robot.mouseMove(300, 600);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
