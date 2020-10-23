package es.musica.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainHijoMusica {

	public static void main(String[] args) {
		
		FileSystem fs = FileSystems.getDefault();// Creamos un File System para poder manejar ficheros
		BufferedReader br;
		//try {
		//	br = new BufferedReader (new FileReader("./nombreMusica.txt"));
		
		ejecutarMusica(args[0]);
		
	//	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

	public static void ejecutarMusica(String archivo) {
		Player apl;
		try {
			apl = new Player(new FileInputStream(archivo));

			apl.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
