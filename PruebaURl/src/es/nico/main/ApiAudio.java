package es.nico.main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Scanner;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;




import java.io.File;




public class ApiAudio {

	public static void main(String[] args) {
		URL direccion;
		Scanner sc=new Scanner(System.in);
		System.out.println("Escribe algo");
		String texto=sc.nextLine().replace(" ","%20");
		System.out.println(texto);
		try {
			direccion = new URL("http://api.voicerss.org/?key=ffe639e2a5924de6a885e43f511f2b26&hl=es-Es&src="+texto);
		
			AudioInputStream audio = AudioSystem.getAudioInputStream(new BufferedInputStream(direccion.openStream()));

			
			Clip reproductor =AudioSystem.getClip();
			AudioInputStream in = AudioSystem.getAudioInputStream(direccion);
		      
			reproductor.open(audio);
			reproductor.start();
			
			AudioInputStream din = null;
			 AudioFormat baseFormat = in.getFormat();
		        AudioFormat decodedFormat = new AudioFormat(
		                AudioFormat.Encoding.PCM_SIGNED,
		                baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
		                baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
		                false);
		        din = AudioSystem.getAudioInputStream(decodedFormat, in);
		        DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
		        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
		        if(line != null) {
		            line.open(decodedFormat);
		            byte[] data = new byte[4096];
		            // Start
		            line.start();

		            int nBytesRead;
		            while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
		                line.write(data, 0, nBytesRead);
		            }
		            // Stop
		            line.drain();
		            line.stop();
		            line.close();
		            din.close();
		        }
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    
	}

}
