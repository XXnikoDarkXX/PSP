package es.nicolas.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class VentanaRepro extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRepro frame = new VentanaRepro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaRepro() throws IOException {
		FileWriter info=new FileWriter("./canciones.log");
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnMario = new JButton("Mario");
		btnMario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 FileWriter info=new FileWriter("./canciones.log",true);
					 LocalDateTime now = LocalDateTime.now().withNano(0); //Aquí le quitas los nanos
	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					 //escribimos la fecha y la cancion en el log
					info.write("["+now.format(formatter)+"]"+ " mario.mp3"+"\n");
					info.flush();
					info.close();
					//mediante este proceso llamamos al hijoMusica que es una funcion de reproducir musica y le pasamos como argumento
					//la ruta de la musica
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./hijoMusica.jar","./musica\\\\mario.mp3");
					pb.inheritIO();
					Process p;

					p = pb.start();

					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnMario, BorderLayout.WEST);
		
		JButton btnGallo = new JButton("Gallo");
		btnGallo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					LocalDateTime now = LocalDateTime.now().withNano(0); //Aquí le quitas los nanos
	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					 //escribimos la fecha y la cancion en el log
					
					 FileWriter info=new FileWriter("./canciones.log",true);
					info.write("["+now.format(formatter)+"]"+ " Gallo.mp3"+"\n");
					info.flush();
					info.close();
					
					
					
					
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./hijoMusica.jar","./musica\\Gallo.mp3");
					pb.inheritIO();
					Process p;
				
					p = pb.start();
					
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		contentPane.add(btnGallo, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Reproducir Canciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnPolicia = new JButton("Policia");
		btnPolicia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 FileWriter info=new FileWriter("./canciones.log",true);
						LocalDateTime now = LocalDateTime.now().withNano(0); //Aquí le quitas los nanos
		                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						 //escribimos la fecha y la cancion en el log
						
					info.write("["+now.format(formatter)+"]"+ " Police.mp3"+"\n");
					info.flush();
					info.close();
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./hijoMusica.jar","./musica\\POLICE.mp3");
					pb.inheritIO();
					Process p;

					p = pb.start();
					
					
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnPolicia, BorderLayout.EAST);
		
		JButton btnTono = new JButton("Tono");
		btnTono.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					LocalDateTime now = LocalDateTime.now().withNano(0); //Aquí le quitas los nanos
	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					 //escribimos la fecha y la cancion en el log
					 FileWriter info=new FileWriter("./canciones.log",true);
					info.write("["+now.format(formatter)+"]"+ " Tono.mp3"+"\n");
					info.flush();
					info.close();
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./hijoMusica.jar","./musica\\Tono.mp3");
					pb.inheritIO();
					Process p;

					p = pb.start();
					
					
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnTono, BorderLayout.SOUTH);
		this.setVisible(true);
	}

}
