
public class pruebaRacional {

	public static void main(String[] args) {
		
		ClsRacional numA;
		ClsRacional numB;
		ClsRacional numC;
		ClsRacional Pot;
		numA = new ClsRacional();
		numB = new ClsRacional();
		numC = new ClsRacional();
		Pot = new ClsRacional();
		numA.setFraccion(3, 6);
		System.out.println("Primera fraccion: "+numA.getNum()+"/"+numA.getDen());
		numB.setFraccion(5, 26);
		System.out.println("Segunda fraccion: "+numB.getNum()+"/"+numB.getDen());
		Pot.setFraccion(3, 1);
		numC.sumar(numA, numB);
		System.out.println("La suma es: "+numC.getNum()+"/"+numC.getDen());
		numC.restar(numA, numB);
		System.out.println("La resta es: "+numC.getNum()+"/"+numC.getDen());
		numC.multiplicar(numA, numB);
		System.out.println("El producto es: "+numC.getNum()+"/"+numC.getDen());
		numC.potencia(numA, Pot);
		System.out.println("La potencia es: "+numC.getNum()+"/"+numC.getDen());
		
	}

}
