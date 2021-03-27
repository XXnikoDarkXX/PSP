/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socketserverexamenpsp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Miguel
 */
public class HiloServidor implements Runnable {

    private ServerSocket socketServidor;//socket

    //constructor
    public HiloServidor(ServerSocket ss) {
        this.socketServidor = ss;
    }

    @Override
    public void run() {
        try {
            Socket miCliente = socketServidor.accept();//esperamos a que acepte el servidor
            System.out.println("He conectado con el cliente en la IP " + miCliente.getRemoteSocketAddress());
            DataInputStream lectorDeCliente = new DataInputStream(miCliente.getInputStream());
            String dni = lectorDeCliente.readUTF();
            String name = lectorDeCliente.readUTF();
            String secret = lectorDeCliente.readUTF();

            switch (dni) {
                case "111111C": 
                    if (secret.equals("CanberraPomeranianTitanium")) {
                            HiloServidor.hablaTexto(name, true);
                    } else {
                            HiloServidor.hablaTexto(name, false);
                    }

                    break;
                  default:
                    HiloServidor.hablaTexto(name, false);
                    System.out.println("nombre: " + name + " y secret " + secret + " la está liando un poco");
                    break;
            }

            miCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    /**
     **
     * función que pasa un nombre a la api de voz, y da un mensaje diciendo que
     * ha aprobado si lo ha hecho, si la ha liado en caso contrario. También
     * imprime por consola el mensaje.
     *
     * @param name Nombre que se usará en el mensaje
     * @param mensaje true -> mensaje positivo (aprobado), false -> mensaje
     * Negativo (la ha liado).
     */
    public static void hablaTexto(String name, boolean mensaje) {
        String msg;
        try {
            if (mensaje) {
                msg = name.replace(" ","%20") + "%20ya%20puede%20aprobar%20el%20examen%20facilmente";
                System.out.println(name + " ya puede aprobar el examen facilmente.");
            } else {
                msg = name.replace(" ","%20")  + "%20la%20ha%20liado.%20Su%20clave%20secret%20o%20nombre%20no%20se%20han%20recibido%20correctamente..";
                System.out.println(name + "La ha liado. Su clave secret  o nombre no se han recibido correctamente.");
            }
            URL apiTextoAVoz = new URL("http://api.voicerss.org/?key=c3027ad28dad410d8fac4d348f483fad&hl=es-es&c=wavaa&src=" + msg);
            AudioInputStream elMp3 = AudioSystem.getAudioInputStream(new BufferedInputStream(apiTextoAVoz.openStream()));
            Clip reproductor = AudioSystem.getClip();
            reproductor.open(elMp3);
            reproductor.start();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
    }
}
