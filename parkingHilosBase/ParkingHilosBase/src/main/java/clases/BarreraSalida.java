package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BarreraSalida implements Runnable{
    private InfoParking parking;
    
    public BarreraSalida(InfoParking parking){

        this.parking=parking;
    }
	@Override
	public void run() {
		 try {
          
	            Thread.sleep(100);
	            
	            long momentoInicial=System.currentTimeMillis(); //Para que la barrera funcione solo un tiempo
	            //Pongo a funcionar la barrera un tiempo fijo. En el mundo real, sería un while(true)
	            while(System.currentTimeMillis()-momentoInicial<1500){
	           
	            	
	                boolean haEntrado=false;
	                do{
	                	
	                	haEntrado=parking.decidirSiSumar();

	                	
	                }while(!haEntrado);
	            	
	            }
	            
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Barrera.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}



}
