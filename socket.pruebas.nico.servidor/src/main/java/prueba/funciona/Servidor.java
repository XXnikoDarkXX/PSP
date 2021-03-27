package prueba.funciona;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		System.out.println("Comenzando el programa servidor");
		ServerSocket socketServidor;
		try {
			socketServidor = new ServerSocket(0, 5);
			// No especificamos el puerto, y aceptamos a 5 clientes como máximo.
			System.out.println("El servidor está escuchando en: " + socketServidor.getLocalPort());
			socketServidor.setSoTimeout(30000); // Esperará durante 30 segundos

			// Este objeto Socket representa la conexión con el cliente
			// En el accept me quedo parado hasta que alguien conecte.
			Socket miCliente = socketServidor.accept();//paramos el servidor hasta que un cliente se conecte
			
			// Ahora tengo al cliente, informo sobre su ip.
			System.out.println("He conectado con el cliente en la IP " + miCliente.getRemoteSocketAddress());

			// Una vez conectados, incializamos el lector y escritor con el cliente
			DataOutputStream escritorEnCliente = new DataOutputStream(miCliente.getOutputStream());
			DataInputStream lectorDeCliente = new DataInputStream(miCliente.getInputStream());

			// Aquí imprimo lo que diga el cliente. readUTF me lee el texto de todo lo que
			// envíe el cliente de golpe.
			// El servidor se queda parado hasta que no se reciba algo aquí
			System.out.println(lectorDeCliente.readUTF());
			// Después, el servidor escribe al cliente este mensaje. El cliente DEBE tener
			// un readUTF preparado para recibirlo.
			escritorEnCliente.writeUTF("Hola Cliente, el servidor " + miCliente.getLocalSocketAddress()
					+ " está listo para oirte. Puedes escribir cualquier cosa en el próximo minuto");

			// Estos tiempos son para comprobar que no han pasado los 60 segundos durante
			// los que el programa puede enviar y recibir info.
			long tiempoInicial = System.currentTimeMillis();
			long tiempoActual = System.currentTimeMillis();
			System.out.println("Servidor entrando en escucha ya.");
			while (tiempoActual - tiempoInicial < 60000) {
				// Espero de nuevo a que el cliente escriba algo
				System.out.println("Cliente dice: " + lectorDeCliente.readUTF());
				tiempoActual = System.currentTimeMillis();

			} 
			
			System.out.println("Desconectando al cliente.");
			miCliente.close();
			socketServidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
