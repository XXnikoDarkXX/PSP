package es.com.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase EstimatedDiameter nos sirve para poder obtener los float de kilometers
 * @author nicoc
 *
 */
public class EstimatedDiameter {
	
	private HashMap<String,Float>kilometers;//Hashmap donde tendremos las dos opciones de float

	
	
	/**^
	 * Constructor de EstimatedDiamter con todos sus paremetros
	 * @param kilometers hashmap donde alojamos los subobjetos de kilometers
	 */
	public EstimatedDiameter(HashMap<String, Float> kilometers) {
		super();
		this.kilometers = kilometers;
	}

	public HashMap<String, Float> getKilometers() {
		return kilometers;
	}

	public void setKilometers(HashMap<String, Float> kilometers) {
		this.kilometers = kilometers;
	}
	
	/**
	 * En el toString iteramos el hash para conseguir el valor minimo
	 */
	@Override
	public String toString() {
		String estimated_diameter_min="";
		for(Map.Entry<String, Float> entry : this.kilometers.entrySet()) {
		    String key = entry.getKey();
		    float value = entry.getValue();
		    if (key.equals("estimated_diameter_min")) {
		    	estimated_diameter_min=value+"";
			}

		  
		}
		
		
		
		return "EstimatedDiameter [estimated_diameter_min=" + estimated_diameter_min + "]";
	}
	
	
	
	
	
	
	
}
