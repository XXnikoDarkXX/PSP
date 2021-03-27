package es.com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import picture.nasa.Planetary;

public class ApiNasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate dia=LocalDate.now();//Creo un localDate para saber la fecha de ahora
		System.out.println(dia);
		try {
		URL direccion=new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date="+dia+"&end_date="+dia+"&api_key=O4HLDxvUL7YMo7f9vrf2H5AXaJi0v4FlcjqHWRU3");
			//URL direccion=new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-01-01"+"&end_date=2021-01-05"+"&api_key=O4HLDxvUL7YMo7f9vrf2H5AXaJi0v4FlcjqHWRU3");

			
			HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();
			
			BufferedReader lector=new BufferedReader(new InputStreamReader (conexion.getInputStream()));
			
			String linea="";
			String json="";
			while(linea!=null) {
				json+=linea;
				linea=lector.readLine();
				
				
			}
			GsonBuilder builder=new GsonBuilder();
			Gson gson=builder.create();
	InfoNasa info=(InfoNasa)gson.fromJson(json, InfoNasa.class);
	info.eliminarAsteroiodesNoPotenciales();
	System.out.println(info);
		
			
			
	 direccion=new URL("https://api.nasa.gov/planetary/apod?start_date="+dia+"&end_date="+dia+"&api_key=O4HLDxvUL7YMo7f9vrf2H5AXaJi0v4FlcjqHWRU3");
	
	 conexion = (HttpURLConnection) direccion.openConnection();
	 lector=new BufferedReader(new InputStreamReader (conexion.getInputStream()));
	
	 linea="";
	 json="";
	while(linea!=null) {
		json+=linea;
		linea=lector.readLine();
		
		
	}
	 builder=new GsonBuilder();
	 gson=builder.create();

	 List<Planetary> r = gson.fromJson(json, new TypeToken<ArrayList<Planetary>>(){}.getType());


	 Planetary planeta =r.get(0);
	 	System.out.println(planeta.getUrl());
	 	
	InputStream in = planeta.getUrl().openStream();
	Files.deleteIfExists(Paths.get("./fotoNasa.jpg"));
	
	
		   Files.copy(in, Paths.get("./fotoNasa.jpg"));
		
	
	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}


