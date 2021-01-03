package interfaz;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import auxiliares.Constantes;
import auxiliares.Escritor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TableroMortys extends JFrame {
	
	private JLabel[][] matriz;

	public TableroMortys(int anchoMatriz,int altoMatriz) {
		
		//Aspecto de la ventana
		this.setTitle("Lanzador de Mortys (Ventana de "+Constantes.tamanioBotones*altoMatriz+" x "+Constantes.tamanioBotones*anchoMatriz+")");
		this.setSize(Constantes.tamanioBotones*anchoMatriz,Constantes.tamanioBotones*altoMatriz);
		try {
			this.setIconImage(ImageIO.read(new File("./assets/morty.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLocationRelativeTo(null);  //La lanzao centrada
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(new GridLayout(altoMatriz,anchoMatriz, 0, 0));
		
		//Inicializo la matriz de JLabel
		matriz=new JLabel[altoMatriz][anchoMatriz];
		
		//Insertando los JLabel en la matriz y en la interfaz
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j <matriz[i].length; j++) {
				JLabel label = new JLabel(); //Establezco el jlabel sin texto
				label.setOpaque(true);
				label.setSize(Constantes.tamanioBotones, Constantes.tamanioBotones);
				label.setBackground(new Color(i*3,j*3,(i+j)*3));
				getContentPane().add(label);
				matriz[i][j]=label;
			}
		}
		
		//Hago visible la interfaz
		this.setVisible(true);
	}
	
	public JLabel[][] getMatriz(){
		return matriz;
	}
	
	public void refrescar() {
		try {
			//Declaro escritor para meter cosas en el log desde aquí
			Escritor escritor = new Escritor("lanzadorMortys.log","ejecucionCompleta.log",false,false);
			
			//Abro el archivo común 
			Path archivoComun=FileSystems.getDefault().getPath("../localizacionMortys.cenec");
			RandomAccessFile accesoArchivoComun=new RandomAccessFile(archivoComun.toString(),"rw");
			
			//Leo todas las posiciones donde están los Mortys, y las meto en un String con el formato (fila,columna)(fila,columna)(fila,columna)... Así para todos los Mortys
			//Así, para ver si una posición de Jlabel tiene un morty miraré si la cadena (fila,columna) está en el String
			String posiciones="";
			for (int i = 0; i < accesoArchivoComun.length(); i+=2) {
				posiciones+="("+accesoArchivoComun.readByte()+","+accesoArchivoComun.readByte()+")";
			}
			escritor.escribir("Posiciones con Morty: "+posiciones);
			accesoArchivoComun.close();
			
			//Recorro toda la matriz de JLabel. Si no hay Morty, pongo el texto a "". Si hay un Morty, lo dibujo
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j <matriz[i].length; j++) {
					JLabel actual = matriz[i][j]; //Establezco el jlabel sin texto
					
					//Si la posición (i,j) está en el String posiciones, tengo que poner un morty escalado al tamaño del jLabel. Si no, pongo el icono a Null, por si ya había uno, para borrarlo.
					if(posiciones.contains("("+i+","+j+")")) {
						BufferedImage imagenMorty= ImageIO.read(new File("./assets/morty.png"));
						actual.setIcon(new ImageIcon(imagenMorty.getScaledInstance(actual.getWidth(), actual.getHeight(),Image.SCALE_SMOOTH)));
					}else {
						actual.setIcon(null);
					}
					
					
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getContentPane().setVisible(false);
		this.getContentPane().setVisible(true);
	}
	
}
