package com.main;

import java.io.File;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
public class ReproMain {

	public static void main(String[] args) {
	

	
		playSound();

	    }
	public static void playSound() {
		try {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\nicoc\\Documents\\GitHub\\PSP\\TrollPSP\\trol1.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		
		} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace();
		}
		}
}
