package auxiliares;

/**
 * Clase que se utiliza para definir constantes que afectan a todo el programa, y cuya modificación podría adaptar
 * el funcionamiento del programa a otros equipos, donde la configuración por defecto no funcione correctamente.
 * @author Miguel Páramos
 *
 */
public class Constantes {
	
	/* tamaño en pixels (ancho y alto) de cada uno de los JLabel que componen la interfaz Tablero*/
	public static final byte tamanioBotones=50;
	
	/* multiplicador del número de núcleos de procesamiento para calcular el tamaño de la matriz y el número de Mortys lanzados */
	public static final byte multiplicadorNumeroNucleos=2;

	/* Número de milisegundos que pasará entre refrescos de la matriz, para el seguimiento del movimiento de los mortys*/
	public static final long tasaDeRefresco=50;

}
