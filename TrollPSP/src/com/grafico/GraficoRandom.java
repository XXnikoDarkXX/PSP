package com.grafico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class GraficoRandom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoRandom frame = new GraficoRandom();
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
	public GraficoRandom() {
		
		
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nicoc\\Documents\\GitHub\\PSP\\TrollPSP\\imagenes\\joke.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		establecerSitioAleatorio();
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./musica\\abrir.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
			} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
			}
		this.setVisible(true);
			
	}
	
	
	public  void establecerSitioAleatorio() {
		Random r=new Random();
		// Vamos a conocer primero la resolucion de la pantalla en java para ello vamos
				// a usar el framewoerk Toolkit
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// con la clase Dimesions conseguimos las
			// dimensiones de  cualquier componente de AWT
			int xx=screenSize.width-100;
			int yy=screenSize.height-50;
			this.setSize(400,450);
				int x=r.nextInt(xx+1);
				int y=r.nextInt(yy+1);
				this.setLocation(x, y);
		
	}

}
