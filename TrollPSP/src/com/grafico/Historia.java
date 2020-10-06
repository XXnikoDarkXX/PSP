package com.grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class Historia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historia frame = new Historia();
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
	public Historia() {
		
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, "name_132053070847400");
		this.setVisible(true);
		playSound();
	}
	
	public static void playSound() {
		try {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./musica\\teclado.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		
		} catch(Exception ex) {
		System.out.println("Error with playing sound.");
		ex.printStackTrace();
		}
		}
}
