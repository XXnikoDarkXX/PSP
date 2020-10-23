package es.nicolas.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainRepro {

	public static void main(String[] args) throws JavaLayerException {
		// TODO Auto-generated method stub
		ArrayList<Process> hijos = new ArrayList<Process>();
		try {
			
			
			FileWriter fw =new FileWriter("./nombreMusica.txt");
			
			VentanaRepro reproductor=new VentanaRepro();
			
				
			
			//Espero a que se paren todos los procesos para seguir
		
			
				
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
