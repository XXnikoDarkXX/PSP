import java.util.concurrent.locks.Lock;

public class Desechos {
    private int desecho;

    public Desechos(int desecho) {
        this.desecho = desecho;
    }

//Esto lo he hecho para poder ponerle un lock a getDeshecho
    public int getDesecho() {
        return desecho;
    }


    public void restarDesecho(int numeroRestar){
        desecho = desecho - numeroRestar;


    }
}
