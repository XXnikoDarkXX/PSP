import java.util.concurrent.locks.Lock;

public class Hijo implements Runnable{
    private String nombre;
    private Desechos desechos;
    Lock lock;

    public Hijo(String nombre, Desechos desechos, Lock lock) {
        this.nombre = nombre;
        this.desechos = desechos;
        this.lock = lock;
    }

    @Override
    public void run() {
          lock.lock();//El hilo se queda parado aqui que es donde ocurren las cosas
          if (desechos.getDesecho()>0) {
			
		
          int numero = (int) (Math.random() * desechos.getDesecho() );
          System.out.println("La nave " + nombre + " va a eliminar " + numero + " kilos de deshechos");
          desechos.restarDesecho(numero);
        
          System.out.println("La nave " + nombre + " Ha escrito en el albaran, y parte a deshacerse de los deshechos");
          }
          
          lock.unlock();
    }
}
