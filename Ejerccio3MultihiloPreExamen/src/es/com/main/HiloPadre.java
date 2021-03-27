package es.com.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;





public class HiloPadre {

	public static void main(String[] args) {
		String nombreNaves[]= {"Old Bessie","Electric Mucus","Zoidberg killer","Scruffy’s love song”","Hermes Budgets"};
		boolean comproNaves[]=new boolean[nombreNaves.length];
		 ReentrantLock cerrojo=new ReentrantLock();//nuestro cerrojo
		System.out.println("Escribe cuantos desechos hay");
		Scanner sc=new Scanner(System.in);
		int desechos=Integer.parseInt(sc.nextLine());
		PlanetExpress planet=new PlanetExpress(desechos);
		 ArrayList<Thread> naves=new ArrayList<Thread>();
		 ArrayList<HiloNave>nav=new ArrayList<HiloNave>();
		for (int i = 0; i < 5; i++) {
		String nombre=nombreNaves[i];
			HiloNave estoEsNavePrueva=new HiloNave(nombre,planet,cerrojo);
			  naves.add(new Thread( estoEsNavePrueva));
			  nav.add(estoEsNavePrueva);
			  naves.get(naves.size()-1).start();
	           
		}
		
		 for (int i = 0; i < naves.size(); i++) {
	            do{
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException ex) {
	                		ex.printStackTrace();
	                }
	            }while(naves.get(i).isAlive());
	           
	            
	            System.out.println("La nave  "+((HiloNave) nav.get(i)).getNombre()+" ha terminado.");
	            if (i==naves.size()-1) {
					System.out.println("tras la eliminación sutil, quedan"+planet.getDesechosRestantes()+"  kilos de desechos por eliminar");
				}
	        }
		
		
		
	}
	/*
	public static String nombrarNave(String nombreNaves[],boolean comproNaves[] ) {
		Random r=new Random();
		for (int i = 0; i < nombreNaves.length; i++) {
			int n=r.nextInt(nombreNaves.length);
			if (comproNaves[n]==false) {
				comproNaves[n]=true;
				return nombreNaves[n];
			}else {
				i=i-1;//si no lo conseguimos volvemos al bucle anterior para pedir los numeros
			}
			
		}
		return "";
		
	}*/

}
