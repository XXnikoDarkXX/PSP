package auxiliares;

/**
 * Clase que se utiliza para definir constantes que afectan a todo el programa, y cuya modificaci�n podr�a adaptar
 * el funcionamiento del programa a otros equipos, donde la configuraci�n por defecto no funcione correctamente.
 * @author Miguel P�ramos
 *
 */
public class Constantes {
	
	/* tama�o en pixels (ancho y alto) de cada uno de los JLabel que componen la interfaz Tablero*/
	public static final byte tamanioBotones=50;
	
	/* multiplicador del n�mero de n�cleos de procesamiento para calcular el tama�o de la matriz y el n�mero de Mortys lanzados */
	public static final byte multiplicadorNumeroNucleos=2;

	/* N�mero de milisegundos que pasar� entre refrescos de la matriz, para el seguimiento del movimiento de los mortys*/
	public static final long tasaDeRefresco=50;

}
