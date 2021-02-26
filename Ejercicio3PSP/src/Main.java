import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static int numeroDes=0;
    public static void main(String[] args) {
        Lock cerrojo= new ReentrantLock();
        String[] nombres= {"Old Bessie", "Electric Mucus", "Zoidberg killer", "Scruffy’s love song", "Hermes Budgets"};
        Scanner sc= new Scanner(System.in);
        System.out.println("Cuantos desechos quieres eliminar sutilmente?");
        numeroDes= Integer.parseInt(sc.nextLine());
        Desechos desechos = new Desechos(numeroDes);
        ArrayList<Thread> hijos=new ArrayList<Thread>();


            for (int i = 0; i < nombres.length; i++) {
                hijos.add(new Thread(new Hijo(nombres[i], desechos,cerrojo)));
                hijos.get(hijos.size()-1).start();
            }

            for (int i = 0; i < hijos.size(); i++) {
                do{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }while(hijos.get(i).isAlive());
            }

        System.out.println("Tras la eliminacion sutil, quedan: "+ desechos.getDesecho()+" kilos de deshechos por eliminar");






    }
    }

