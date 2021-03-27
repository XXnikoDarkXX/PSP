package es.com.main;

import java.util.ArrayList;
import java.util.HashMap;

public class NearEarthObject {
    private String name;//nombre del meteorito
    private boolean is_potentially_hazardous_asteroid; //si el meteorito es potencialmente peligroso o no
  
    private EstimatedDiameter estimated_diameter;//objeto de EstimatedDiamters para poder acceder a sus variables

  
    /**
     * Contructor de NearEarthObject
     * @param name
     * @param is_potentially_hazardous_asteroid
     * @param estimated_diameter
     */
    public NearEarthObject(String name, boolean is_potentially_hazardous_asteroid,
			EstimatedDiameter estimated_diameter) {
		super();
		this.name = name;
		this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
		this.estimated_diameter = estimated_diameter;
	}

    /**
     * Getter de getName
     * @return el nombre del meteorito
     */
	public String getName() {
        return name;
    }
	/**
	 * Setter de name
	 * @param name a cambiar
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter para saber si es potencialmente peligroso
     * @return true si es peligroso false si no lo es
     */
    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }
    /**
     * Setter para cambiar potencionalmente peligroso
     * @param is_potentially_hazardous_asteroid boleano para cambiar la variable
     */
    public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }
    
    /**
     * Getter para obtener el EstimatedDiameter
     * @return
     */
	public EstimatedDiameter getEstimated_diameter() {
		return estimated_diameter;
	}	
	/**
	 * Setter para cambiar el Estimated_Diameter
	 * @param estimated_diameter
	 */
	public void setEstimated_diameter(EstimatedDiameter estimated_diameter) {
		this.estimated_diameter = estimated_diameter;
	}


	/**
	 * Tostring para imprimir todas sus variables
	 */
	@Override
	public String toString() {
		return "NearEarthObject [name=" + name + ", is_potentially_hazardous_asteroid="
				+ is_potentially_hazardous_asteroid +" "+  estimated_diameter;
	}

	

	

	
	
	
    
    
    
    
    
}

