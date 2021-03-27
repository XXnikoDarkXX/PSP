package prueba.funciona;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {

		Socket miServidor = null;//el cliente
		try {
			// Conectamos con el servidor
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el puerto al que conectar en el servidor:");
			int puertoRemoto = Integer.parseInt(sc.nextLine());
			miServidor = new Socket("127.0.0.1", puertoRemoto); // Si se quiere conectar a otro ordenador, hay que
																// cambiar la ip aquí
			System.out.println("Conectado al servidor en " + miServidor.getRemoteSocketAddress());
			// Una vez conectados, incializamos el lector y escritor con el servidor
			DataOutputStream escritorEnServidor = new DataOutputStream(miServidor.getOutputStream());
			DataInputStream lectorDeServidor = new DataInputStream(miServidor.getInputStream());

			// Probamos una escritura y una lectura
			escritorEnServidor.writeUTF(
					"Hola, soy el cliente en " + miServidor.getLocalSocketAddress() + ", estableciendo conexión.");
			System.out.println(lectorDeServidor.readUTF());

			System.out.println(
					"Escribe los mensajes que quieras dejar en el servidor. Tienes 60 segundos hasta que la conexión se cierre. Cada línea será un mensaje:");
			while (miServidor.isConnected()) {
				escritorEnServidor.writeUTF(sc.nextLine());
				System.out.println(lectorDeServidor.readUTF());
				if (!miServidor.isConnected()) {
					miServidor.close();
				}
			}
			
		} catch (IOException ex) {
			try {
				System.out.println("El servidor te ha desconectado.");
				miServidor.close();
			} catch (IOException ex1) {
				ex1.printStackTrace();
			}
		}

	}

}
