
public class HiloHijo implements Runnable {

    private int idHilo;
    private int[] array;

    public HiloHijo(int nHilo, int[] array) {
        idHilo = nHilo;// para dar una id al hilo
        this.array = array;
    }

    public void run() {

        byte t = 8;
        System.out.println("Soy el hilo hijo nº " + idHilo + " Resultado de sumar en el array, en la posición indicada por el número de hilo, "
                + "el mismo número de hilo " + t + " + " + idHilo + " = " + arraySumaPosicion(array, idHilo));

        Thread actual = Thread.currentThread();

        array[idHilo] += idHilo;
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();

    }

    public int arraySumaPosicion(int[] array, int posicion) {

        array[posicion] += posicion;
        int res = array[posicion];
        return res;
    }

    public void imprimirArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }

    }

}
