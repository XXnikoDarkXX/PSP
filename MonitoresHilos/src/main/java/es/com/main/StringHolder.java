package es.com.main;


public class StringHolder {
	private String cadena;

	public StringHolder(String cadena) {
	super();
		this.cadena = cadena;
	}
	public StringHolder() {
		
		this.cadena = "";
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena += cadena;
	}
	@Override
	public String toString() {
		return "StringHolder [cadena=" + cadena + "]";
	}
	
	
	
}
