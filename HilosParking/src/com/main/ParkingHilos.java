package com.main;

import java.util.ArrayList;

public class ParkingHilos {
	public static final int nPlazas=30;
	public static final byte nBarreras =3;
	public static void main(String[] args) {
		
		InfoParking parking=new InfoParking(30);
			
		ArrayList<Thread>barreras=new ArrayList<Thread>();
		for (int i = 0; i < nBarreras; i++) {
			
		barreras.add(new Thread(new Barrera(i,parking)));
		barreras.get(barreras.size()-1).start();
		}
		
		
		for (int i = 0; i < barreras.size(); i++) {
			do {
				try {
					
					
					
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}while( barreras.get(i).isAlive());
			System.out.println("La barrera "+i+" ha terminado");
		}
		
	}

}
