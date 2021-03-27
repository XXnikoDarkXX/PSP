package main.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Dime a qué puerto tengo que conectar en el servidcor");
			int puerto=Integer.parseInt(sc.nextLine());
			
			System.out.println("Conectando con el servidor, esperando hasta 5 segundos para hacerlo...");
			Socket conexionServidor =new Socket();
			SocketAddress direccionServidor=new InetSocketAddress("mparamos.com",puerto);
			conexionServidor.connect(direccionServidor,5000);
			System.out.println("Conectado con el servidor: "+conexionServidor.getRemoteSocketAddress());
			
			DataInputStream lector=new DataInputStream(conexionServidor.getInputStream());
			DataOutputStream escritor=new DataOutputStream(conexionServidor.getOutputStream());

			System.out.println("Escrite tu nombre");
			escritor.writeUTF(sc.nextLine());;
			
			
			System.out.println(lector.readUTF());
			conexionServidor.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
