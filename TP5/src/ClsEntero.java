
public class ClsEntero implements Operaciones {
	
	private int numero;
	
	public int getNumero(){
		return(this.numero);
	}
	
	public void setNumero(int numero){
		this.numero = numero;
	}
	
	public void sumar(Object a, Object b){
		this.setNumero(((ClsEntero) a).getNumero()+((ClsEntero) b).getNumero());
	}
	
	public void restar(Object a, Object b){
		this.setNumero(((ClsEntero) a).getNumero()-((ClsEntero) b).getNumero());
	}
	
	public void multiplicar(Object a, Object b){
		this.setNumero(((ClsEntero) a).getNumero()*((ClsEntero) b).getNumero());
	}
	
	public void potencia(Object a, Object b){
		int potencia = ((ClsEntero) b).getNumero();
		int valor = 1;
		if (potencia == 0){
			valor = 1;
		}
		else
		{
			for(int i=1;i<=potencia;i++){
				valor = valor * ((ClsEntero) a).getNumero();
			}
		}
		this.setNumero(valor);
	}
	
	public boolean igualdad(Object a, Object b){
		if (((ClsEntero) a).getNumero() == ((ClsEntero) b).getNumero()){
			return (true);
		}
		else
		{
			return (false);
		}
	}

}
