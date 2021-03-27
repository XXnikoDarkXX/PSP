/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socketserverexamenpsp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Miguel
 */
public class Servidor {
    public static void main(String[] args){
        try {
            System.out.println("Comenzando el programa servidor");
            ServerSocket socketServidor=new ServerSocket(8871); 
            System.out.println("El servidor está escuchando en: "+socketServidor.getLocalPort());
            System.out.println("hilos a lanzar:");
            Scanner sc=new Scanner(System.in);
            int nHilos=1;//Integer.parseInt(sc.nextLine());
            ArrayList<Thread> hilos=new ArrayList<Thread>();
            for(int i=0;i<nHilos;i++){
                hilos.add(new Thread(new HiloServidor(socketServidor)));
                hilos.get(i).start();
            }
           while(hilos.size()>0){
               Thread.sleep(30000);
               for(int i=0;i<hilos.size();i++){
                    if(!hilos.get(i).isAlive()){
                        hilos.remove(i);
                    }
                }
               System.out.println("Quedan "+hilos.size()+" hilos vivos en el programa.");
           }
            System.out.println("EL SERVIDOR SE HA QUEDADO SIN HILOS. DEBE LANZARSE DE NUEVO");
            socketServidor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
    
}
