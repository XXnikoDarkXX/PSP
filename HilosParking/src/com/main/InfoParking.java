package com.main;

public class InfoParking {

	private int nPlazas;

	public InfoParking(int nPlazas) {

		this.nPlazas = nPlazas;
	}

	public InfoParking() {

		this.nPlazas = nPlazas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void añadirPlaza() {
		nPlazas++;
	}
public void restarPlaza() {
		nPlazas--;
	}

}
