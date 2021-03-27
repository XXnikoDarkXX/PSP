package es.examen.api;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;





public class Main {

	public static void main(String[] args) {
		
		
		try {
		
			
			URL direccion;
			 direccion=new URL("https://www.freetogame.com/api/games?category=shooter&games?platform=pc");

				
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
				
				 Shooter[] shoter = gson.fromJson(json, Shooter[].class);
				 for (int i = 0; i < shoter.length; i++) {
					System.out.println(shoter[i]);
				}
				 
				 
					System.out.println("Comenzando el programa servidor");
					 ServerSocket socketServidor=new ServerSocket(8871); 
						socketServidor.setSoTimeout(30000); // Esperará durante 30 segundos

					 	Socket	 miCliente = socketServidor.accept();//esperamos a que acepte el servidor
			            System.out.println("He conectado con el cliente en la IP " + miCliente.getRemoteSocketAddress());
				 
			         // Una vez conectados, incializamos el lector y escritor con el cliente
						DataOutputStream escritorEnCliente = new DataOutputStream(miCliente.getOutputStream());
						DataInputStream lectorDeCliente = new DataInputStream(miCliente.getInputStream());         
			            
			            escritorEnCliente.writeUTF("hemos recuperado de la api "+shoter.length+"juegos");
			            escritorEnCliente.writeUTF("Escribe el titulo de un juego");

			            
			            
			            
			         // Estos tiempos son para comprobar que no han pasado los 60 segundos durante
						// los que el programa puede enviar y recibir info.
						long tiempoInicial = System.currentTimeMillis();
						long tiempoActual = System.currentTimeMillis();
						System.out.println("Servidor entrando en escucha ya.");
						while (tiempoActual - tiempoInicial < 1000) {
							// Espero de nuevo a que el cliente escriba algo
							String tituloJuego=lectorDeCliente.readUTF();
						Shooter shot=buscarJuegoTitulo(shoter,	tituloJuego);
						if (shot!=null) {
				            escritorEnCliente.writeUTF(shot.toString());
				        //	miCliente.close();
						//	socketServidor.close();
						}else {
							escritorEnCliente.writeUTF("no existe el juego "+tituloJuego+" en la collecion");
						}
							tiempoActual = System.currentTimeMillis();

							
						} // Cierre del While
						
						System.out.println("Desconectando al cliente.");
						miCliente.close();
						socketServidor.close();           
			            
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			}
			
	public static Shooter buscarJuegoTitulo(Shooter[] shoter,String titulo) {
		for (int i = 0; i < shoter.length; i++) {
			if (shoter[i].getTitle().equals(titulo)) {
				return shoter[i];
			}
			
		}
		return null;
	}
			
		
	
}
