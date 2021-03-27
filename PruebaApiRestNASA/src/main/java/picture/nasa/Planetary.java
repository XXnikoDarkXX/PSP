package picture.nasa;

import java.net.URL;
import java.sql.Date;

public class Planetary {

	private String explanation;//Descripcion 
	private URL url;//Url de la foto
	
	/**
	 * Constructor de Planetary con todos sus parametros
	 * @param explanation 
	 * @param hdurl
	 */
	public Planetary(String explanation, URL hdurl) {
		super();
		
		this.explanation = explanation;
		this.url = hdurl;
	}
	
	/**
	 * Getter de explanation
	 * @return un String con la descripcion
	 */
	public String getExplanation() {
		return explanation;
	}
	/**
	 * Setter de explanation
	 * @param explanation a cambiar
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	/**
	 * Getter de url de la foto
	 * @return el url de la foto
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * Setter de url de la foto
	 * @param url a cambiar
	 */
	public void setUrl(URL url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Planetary [explanation=" + explanation + ", url=" + url + "]";
	}
	
	
	
	
}
