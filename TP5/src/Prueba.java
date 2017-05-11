
public class Prueba {

	public static void main(String[] args) {
		ClsEntero numA;
		ClsEntero numB;
		ClsEntero numC;
		numA = new ClsEntero();
		numB = new ClsEntero();
		numC = new ClsEntero();
		numA.setNumero(3);
		numB.setNumero(5);
		numC.sumar(numA, numB);
		System.out.println("La suma es: "+numC.getNumero());
		numC.restar(numA, numB);
		System.out.println("La resta es: "+numC.getNumero());
		numC.multiplicar(numA, numB);
		System.out.println("El producto es: "+numC.getNumero());
		numC.potencia(numA, numB);
		System.out.println("La potencia es: "+numC.getNumero());
		System.out.println(numC.igualdad(numA, numB));

	}

}
