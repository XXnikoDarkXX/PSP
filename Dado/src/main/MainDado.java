package main;

import java.util.Random;



public class MainDado {

	public static void main(String[] args) {
	
	
		tirada(args[0]);
	
	}
	public static void tirada(String numero) {
		
		Random r=new Random();
		int nDado=r.nextInt(6)+1;
		System.out.println("!En esta tirada "+numero+" ha salido un "+nDado);
	}

}
