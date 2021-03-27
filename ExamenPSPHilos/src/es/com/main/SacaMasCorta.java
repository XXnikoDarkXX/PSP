package es.com.main;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class SacaMasCorta implements Runnable {
private ArrayList<String> listaNombres;
private ReentrantLock cerrojo;
private int id;

public SacaMasCorta(ArrayList<String>nombres,ReentrantLock cerrojo,int id) {
	
	this.listaNombres=nombres;
	this.cerrojo=cerrojo;
	this.id=id;
}
	@Override
	public void run() {
		
		
		cerrojo.lock();
		sacarCorta();
		
		cerrojo.unlock();
		
	}
	
	public void sacarCorta() {
		int contador=0;
		for (int i = 1; i < listaNombres.size(); i++) {
		
			if (listaNombres.get(contador).length()>listaNombres.get(i).length()) {
				contador=i;
			}
			if (listaNombres.get(contador)==listaNombres.get(i)) {
				contador=i;
			}
		}
		System.out.println("el hilo "+this.id+" Removemos "+listaNombres.get(contador) +" tiene de longitud "+
		listaNombres.get(contador).length());
		listaNombres.remove(contador);
	}

}
