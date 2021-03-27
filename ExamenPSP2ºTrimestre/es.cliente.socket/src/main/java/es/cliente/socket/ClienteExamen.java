package es.cliente.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteExamen {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Socket miServidor = null;
		try {

			miServidor = new Socket("127.0.0.1", 8871);
			System.out.println("Conectado al servidor en " + miServidor.getRemoteSocketAddress());
			// Una vez conectados, incializamos el lector y escritor con el servidor
			
			DataOutputStream escritorEnServidor = new DataOutputStream(miServidor.getOutputStream());
			DataInputStream lectorDeServidor = new DataInputStream(miServidor.getInputStream());
			
			
		System.out.println(lectorDeServidor.readUTF());
		System.out.println(lectorDeServidor.readUTF());

		while (miServidor.isConnected()) {
			
				
			
			escritorEnServidor.writeUTF(sc.nextLine());
			System.out.println(lectorDeServidor.readUTF());
			
		}
			
	
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				System.out.println("El servidor te ha desconectado.");
				miServidor.close();
			} catch (IOException ex1) {
				ex1.printStackTrace();
			}
		}

	}

}
