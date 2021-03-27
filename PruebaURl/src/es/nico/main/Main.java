package es.nico.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class Main {

	public static void main(String[] args) {
		URL direccion;
		try {
			direccion = new URL("http://api.voicerss.org/?key=ffe639e2a5924de6a885e43f511f2b26&hl=es-Es&src=Voy%20hacer%20una%20jart%C3%A1%20de%20pruebas&v=Diego&r=5");
		
		HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
		System.out.println(conexion.getContent().getClass().getName());
		System.out.println(conexion.getContentLength());
		BufferedReader lector=new BufferedReader(new InputStreamReader (conexion.getInputStream()));
		String texto="";
		String linea="";
		while(linea!=null) {
			texto+=linea;
			linea=lector.readLine();
			
			
		}
		System.out.println(texto);

		System.out.println((new Timestamp(conexion.getLastModified())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
