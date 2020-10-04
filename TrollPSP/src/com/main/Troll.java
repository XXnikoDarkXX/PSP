package com.main;

import java.awt.AWTException;
import java.awt.Robot;

public class Troll {

	public static void main(String[] args) {
	
		
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
