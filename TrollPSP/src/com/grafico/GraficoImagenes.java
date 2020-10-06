package com.grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Path;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class GraficoImagenes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoImagenes frame = new GraficoImagenes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraficoImagenes() {
		
	Toolkit mipantalla=Toolkit.getDefaultToolkit();//almacenamos en mi pantalla nuestro sistema nativo de ventana
		
		Dimension tamanoPantalla=mipantalla.getScreenSize();//obtenemos el tamaño de la pantalla principal que se este usando
		
		int alturaPantalla=tamanoPantalla.height;//obtenemos el alto de la resolucion y lo almacenamos
		
		int anchoPantalla=tamanoPantalla.width;//Obtenemos el ancho de la resolucion 
		
		
		
		this.setSize(450,300);
		this.setLocation(100,100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Bienvenido al TrollPSP");
		lblNewLabel.setIcon(new ImageIcon("./imagenes\\trolazzoInicio.gif"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblNewLabel, "name_134019831622700");
		playSound();
		this.setVisible(true);
	}
	public static void playSound() {
		try {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\nicoc\\Documents\\GitHub\\PSP\\TrollPSP\\musica\\trol1.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		
		} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace();
		}
		}

}
