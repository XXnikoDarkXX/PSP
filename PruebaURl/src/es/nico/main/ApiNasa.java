package es.nico.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiNasa {

	public static void main(String[] args) {
		try {
			URL direccion=new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-03-01&end_date=2021-03-02&api_key=O4HLDxvUL7YMo7f9vrf2H5AXaJi0v4FlcjqHWRU3");
			HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
			
			BufferedReader lector=new BufferedReader(new InputStreamReader (conexion.getInputStream()));
			
			String linea="";
			String json="";
			while(linea!=null) {
				json+=linea;
				linea=lector.readLine();
				
				
			}
			System.out.println(json);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
