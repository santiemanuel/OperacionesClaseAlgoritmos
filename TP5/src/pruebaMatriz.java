
public class pruebaMatriz {

	public static void main(String[] args) {
		ClsMatriz miMatriz;
		miMatriz = new ClsMatriz(10,10);
		
		miMatriz.mostrarMatriz("Primera matriz: ");
		/*otraMatriz = new ClsMatriz(3,3);
		otraMatriz.mostrarMatriz("Segunda matriz: ");
		
		miMatriz.sumar(miMatriz, otraMatriz);
		miMatriz.mostrarMatriz("El resultado de la suma es: ");
		
		miMatriz.restar(miMatriz, otraMatriz);
		miMatriz.mostrarMatriz("El resultado de la resta es: ");
		
		System.out.println(miMatriz.igualdad(miMatriz, otraMatriz));
		
	    try {
	    	miMatriz.multiplicar(miMatriz, otraMatriz);
    		miMatriz.mostrarMatriz("El resultado del producto es: ");
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }	

	    try {
        	otraMatriz.potencia(otraMatriz, 2);
    		otraMatriz.mostrarMatriz("El resultado de la potencia es: ");
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }*/
		
		int sumando = 0;
		
		int resultado = miMatriz.determinante(sumando, miMatriz);
		
		System.out.println(resultado);
				
				

	}

}
