
public class ClsRacional implements Operaciones{
	private int Num;
	private int Den;
		
	public int getNum(){
		return (this.Num);
	}
	
	public int getDen(){
		return (this.Den);
	}
	
	public void setFraccion(int numerador, int denominador){
		
		this.Num = numerador;
		this.Den = denominador;
	}
	
	public void multiplicar(Object a, Object b){
		
		int NumA = ((ClsRacional)a).getNum();
		int NumB = ((ClsRacional)b).getNum();
		int DenA = ((ClsRacional)a).getDen();
		int DenB = ((ClsRacional)b).getDen();
		this.setFraccion(NumA*NumB,DenA*DenB);
		simplificar();
	}
	
	private int mcd(int a, int b){
		
		int valorR;
		do{
			valorR = a % b;
			a = b;
			b = valorR;
		}
		while(valorR > 0);
		
		return(a);

	}
	
	private void simplificar(){
	
		int Num = ((ClsRacional)this).getNum();
		int Den = ((ClsRacional)this).getDen();
		int comun = mcd(Num,Den);
		if (comun != 1){
			Num = Num / comun;
			Den = Den / comun;
		}
		((ClsRacional)this).setFraccion(Num,Den);
	}
	
	public void sumar (Object a, Object b){
	
		int NumA = ((ClsRacional)a).getNum();
		int NumB = ((ClsRacional)b).getNum();
		int DenA = ((ClsRacional)a).getDen();
		int DenB = ((ClsRacional)b).getDen();
		int comun = (DenA*DenB)/mcd(DenA,DenB);
		int Den;
		if (comun == 1){
			Den = DenA * DenB;
			this.setFraccion(Den/DenA*NumA + Den/DenB*NumB, Den);
		}
		else
		{
			this.setFraccion(comun/DenA*NumA + comun/DenB*NumB, comun);
		}
		simplificar();
	}
	
	private int potenciaInt(int base, int pot){

		int valor = 1;
		if (pot == 0){
			return(valor);
		}
		else
		{
			for(int i=1;i<=pot;i++){
				valor = valor * base;
			}
		}
		return(valor);
	}
	
	
	public void restar(Object a, Object b) {
		
		int NumA = ((ClsRacional)a).getNum();
		int NumB = ((ClsRacional)b).getNum();
		int DenA = ((ClsRacional)a).getDen();
		int DenB = ((ClsRacional)b).getDen();
		int comun = (DenA*DenB)/mcd(DenA,DenB);
		int Den;
		if (comun == 1){
			Den = DenA * DenB;
			this.setFraccion(Den/DenA*NumA - Den/DenB*NumB, Den);
		}
		else
		{
			this.setFraccion(comun/DenA*NumA - comun/DenB*NumB, comun);
		}
		simplificar();
	}

	public void potencia(Object a, Object b) {
		
		int NumA = ((ClsRacional)a).getNum();
		int DenA = ((ClsRacional)a).getDen();
		int pot = ((ClsRacional)b).getNum();
		this.setFraccion(potenciaInt(NumA,pot),potenciaInt(DenA,pot));
		simplificar();
		
	}

	public boolean igualdad(Object a, Object b) {
		
		int NumA = ((ClsRacional)a).getNum();
		int NumB = ((ClsRacional)b).getNum();
		int DenA = ((ClsRacional)a).getDen();
		int DenB = ((ClsRacional)b).getDen();
		
		if ((NumA == NumB) && (DenA == DenB)){
			return (true);
		}
		else
		{
			return (false);
		}
	}

}
