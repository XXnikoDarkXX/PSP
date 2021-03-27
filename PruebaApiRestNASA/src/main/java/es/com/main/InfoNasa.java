package es.com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InfoNasa {
    private short element_count;//total de elementos de la lista
    private HashMap<String,ArrayList<NearEarthObject>> near_earth_objects;
    private ArrayList<NearEarthObject>listaCompleta;//lista con los meteoritos pero que tengan 
    
    /**
     * Constructor de InfoNasa con todos sus parametros
     * @param element_count elementos numeros de asteroides
     * @param near_earth_objects Hashmap con los asteroides
     */
    public InfoNasa(short element_count, HashMap<String, ArrayList<NearEarthObject>> near_earth_objects) {
        this.element_count = element_count;
        this.near_earth_objects = near_earth_objects;
        
    }
    /**
     * Getter de elementos
     * @return los elementos o asteroides totales
     */
    public short getElement_count() {
        return element_count;
    }
    /**
     * Setter de elementos
     * @param element_count a cambiar
     */
    public void setElement_count(short element_count) {
        this.element_count = element_count;
    }

    /**
     * Getter de para obtener el hashmpa de  nearth_earth
     * @return un hashmap  getNear_earth_objects
     */
    public HashMap<String, ArrayList<NearEarthObject>> getNear_earth_objects() {
        return near_earth_objects;
    }
    
    /**
     * Setter de near_earth_objetc
     * @param near_earth_objects a  cambiar
     */
    public void setNear_earth_objects(HashMap<String, ArrayList<NearEarthObject>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
    
    /**
     * Funcion para eliminar los asteroides que no sean potencialmente peligroso
     */
public void eliminarAsteroiodesNoPotenciales() {
	ArrayList<NearEarthObject> lista;//esta lista contendra todos los asteroideas tipo  near_earth_objects
	lista =new ArrayList<NearEarthObject>();
	//Recorremos el mapa para crear un ArrayList donde contenga todos los asteroides
	for(Map.Entry<String, ArrayList<NearEarthObject>> entry : this.near_earth_objects.entrySet()) {
	   
		String key = entry.getKey();
	     ArrayList<NearEarthObject>value = entry.getValue();
	     
	     //y se lo vamos metiendo a la lista para tener todos los asteroides
	 for (int i = 0; i <value.size(); i++) {
		lista.add(value.get(i));
	}
	 
	     
	}
	listaCompleta =new ArrayList<NearEarthObject>();//lista con asteroides a true
	//iteramos la lista con todos los asteroides y en listaCompleta metemos los asteroides que sean solo potencialmente
	//peligrosos
for (int i = 0; i < lista.size(); i++) {
	if (lista.get(i).isIs_potentially_hazardous_asteroid()) {
		

		this.listaCompleta.add(lista.get(i));
		this.element_count=(short)listaCompleta.size();
	}
	
}


	  
	}
    

    @Override
    public String toString() {
    	
        return "InfoNasa{" + "element_count=" + element_count + ", near_earth_objects=" + listaCompleta + '}';
    }
    
    
}

