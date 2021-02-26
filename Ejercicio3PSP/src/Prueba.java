import java.util.Random;

public class Prueba {

	public static void main(String[] args) {
	int numero=0;
	Random r=new Random();
	boolean loQueremos=false;
		do {
		numero=	(int) (Math.random() * 1);	
		
		if (numero==1) {
			System.out.println(numero);
			loQueremos=true;
		}
		
		}while(loQueremos==false);
				
		
		
	}

}
