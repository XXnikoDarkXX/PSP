package es.com.main;

import java.util.ArrayList;

public class Madre {

	public static void main(String[] args) {
		StringHolder participaciones=new StringHolder();
		
		ArrayList<Thread>hijos=new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			Hilo j=new Hilo(participaciones);
			hijos.add(j);
			j.start();
			
		}
	/*	for (int i = 0; i < 10; i++) {
			hijos.get(i).join();
		}*/
		for (int i = 0; i < 10; i++) {
			do {
				try {
					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}while(hijos.get(i).isAlive());
		}
		System.out.println(participaciones);

	}

}
