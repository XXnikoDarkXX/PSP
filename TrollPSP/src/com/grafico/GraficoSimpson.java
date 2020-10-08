package com.grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class GraficoSimpson extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoSimpson frame = new GraficoSimpson();
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
	public GraficoSimpson() {
		Toolkit mipantalla=Toolkit.getDefaultToolkit();//almacenamos en mi pantalla nuestro sistema nativo de ventana
		
		Dimension tamanoPantalla=mipantalla.getScreenSize();//obtenemos el tamaño de la pantalla principal que se este usando
		
		int alturaPantalla=tamanoPantalla.height-100;//obtenemos el alto de la resolucion y lo almacenamos
		
		int anchoPantalla=tamanoPantalla.width-100;//Obtenemos el ancho de la resolucion 
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, anchoPantalla,alturaPantalla);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CuidaoAmigo!");
		lblNewLabel.setIcon(new ImageIcon("./imagenes\\simpson.gif"));
		contentPane.add(lblNewLabel, "name_83295742842000");
		this.setVisible(true);
		//metemos el sonido
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./musica\\headshot.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
			} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
			}
			}
		
	}


