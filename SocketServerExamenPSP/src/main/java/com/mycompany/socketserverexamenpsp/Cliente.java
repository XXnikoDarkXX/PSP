package com.mycompany.socketserverexamenpsp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket miServidor = null;
		try {

			miServidor = new Socket("127.0.0.1", 8871);
			System.out.println("Conectado al servidor en " + miServidor.getRemoteSocketAddress());
			// Una vez conectados, incializamos el lector y escritor con el servidor
			
			DataOutputStream escritorEnServidor = new DataOutputStream(miServidor.getOutputStream());
			DataInputStream lectorDeServidor = new DataInputStream(miServidor.getInputStream());
			
			
		
				  
				escritorEnServidor.writeUTF("111111C");
				escritorEnServidor.writeUTF("nico");
				escritorEnServidor.writeUTF("CanberraPomeranianTitanium");
				
			
		miServidor.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
