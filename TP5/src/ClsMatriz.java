import java.util.ArrayList;
import java.util.Random;

public class ClsMatriz implements Operaciones {
	private int filas;
	private int columnas;
	private ClsEntero matriz[][];

	//Cargo la matriz con valores de la cadena valores
	public ClsMatriz(int filas, int columnas, String valores){
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new ClsEntero[filas][columnas];
		
		cargaMatriz(valores);
	}
	
	//Cargo la matriz con valores al azar
	public ClsMatriz(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new ClsEntero[filas][columnas];
		
		cargaMatriz();
	}
	
	//Convierto la cadena en valores enteros en un ArrayList
	private ArrayList<Integer> StringToMatrix(String valor){
		String[] listaNum = valor.split(" ");
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for (int i=0; i < listaNum.length; i++){
			lista.add(Integer.parseInt(listaNum[i]));
		}
		
		return (lista);
	}
	
	//Convierto una matriz en una cadena
	private String MatrixToString(int filaX, int columnaX, ClsMatriz mat){
		int filas = mat.filas;
		int columnas = mat.columnas;
		
		String valores = new String("");
		for (int i=0;i<filas;i++){
			for (int j=0;j<columnas;j++){
				if ((i != filaX) && (j != columnaX)){
					valores = valores + mat.matriz[i][j].getNumero() + " ";
				}
			}
		}
		valores = valores.substring(0, valores.length()-1);
		return (valores);
		
	}
	
	//Carga de matriz de valores al azar
	private void cargaMatriz(){
		
		int valor;
		int filas = this.filas;
		int columnas = this.columnas;
		
		for (int i=0;i<filas;i++){
			
			for (int j=0;j<columnas;j++){
				Random rnd = new Random();
				valor = rnd.nextInt(20)-10;
				this.matriz[i][j] = new ClsEntero();
				this.matriz[i][j].setNumero(valor);
				
			}
		}
	}
	
	//Carga de matriz usando la cadena valores
	private void cargaMatriz(String valores){
		
		ArrayList<Integer> lista = StringToMatrix(valores);
		
		int valor;
		int filas = this.filas;
		int columnas = this.columnas;
		
		for (int i=0;i<filas;i++){
			
			for (int j=0;j<columnas;j++){
				valor = lista.get(0);
				lista.remove(0);
				this.matriz[i][j] = new ClsEntero();
				this.matriz[i][j].setNumero(valor);
				
			}
		}
	}
	
	public void mostrarMatriz(String mensaje){
		System.out.println(mensaje);
		for (int i=0;i<this.filas;i++){
			System.out.print("|");
			for (int j=0;j<this.columnas;j++){
				System.out.print((this.matriz[i][j]).getNumero()+" ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
	}
	
	//Calculo la determinante de una matriz de 2x2
	private int detMinima(Object a){
		int valorA = ((ClsMatriz)a).matriz[0][0].getNumero();
		int valorB = ((ClsMatriz)a).matriz[0][1].getNumero();
		int valorC = ((ClsMatriz)a).matriz[1][0].getNumero();
		int valorD = ((ClsMatriz)a).matriz[1][1].getNumero();
		return (valorA*valorD - valorB*valorC);
	}
	
	private boolean Par(int a, int b){
		if ((a+b) % 2 == 0){
			return (true);
		}
		else
		{
			return (false);
		}
	}
	
	//Calculo determinante de una matriz de nxn
	public int determinante(int sumando, ClsMatriz mat){
		
		int fila = ((ClsMatriz)mat).filas;
		
		if (fila == 2){
			return (detMinima(mat));
		}
		else
		{
			int i = 0;
			while (i<fila){
				String valores = MatrixToString(i, 0, mat);
				ClsMatriz matrizAux = new ClsMatriz(fila-1,fila-1,valores);
				if (mat.matriz[i][0].getNumero() != 0){
					if (Par(i,0)){
						sumando += mat.matriz[i][0].getNumero() * determinante(0,matrizAux);
					}
					else
					{
						sumando -= mat.matriz[i][0].getNumero() * determinante(0,matrizAux);
				}
				}
			i++;
			}
		}
		return(sumando);
		
		
		
	}

	//Suma de matrices
	public void sumar(Object a, Object b){
		
		int filaA = ((ClsMatriz)a).filas;
		int columnaA = ((ClsMatriz)a).columnas;
		int filaB = ((ClsMatriz)b).filas;
		int columnaB = ((ClsMatriz)b).columnas;
		
		if ((filaA != filaB) || (columnaA != columnaB)){
			throw new IllegalArgumentException("Error: No pueden sumarse matrices de tamaños diferentes.");
		}
		else
		{
			for (int i=0;i<filas;i++){
				for (int j=0;j<columnas;j++){
					ClsEntero NumA = ((ClsMatriz)a).matriz[i][j];
					ClsEntero NumB = ((ClsMatriz)b).matriz[i][j];
					NumA.sumar(NumA, NumB);

				}
			}
		}

	}
	
	//Resta de matrices
	public void restar(Object a, Object b){
		
		int filaA = ((ClsMatriz)a).filas;
		int columnaA = ((ClsMatriz)a).columnas;
		int filaB = ((ClsMatriz)b).filas;
		int columnaB = ((ClsMatriz)b).columnas;
		
		if ((filaA != filaB) || (columnaA != columnaB)){
			throw new IllegalArgumentException("Error: No pueden sumarse matrices de tama�os diferentes.");
		}
		else
		{
			for (int i=0;i<filas;i++){
				for (int j=0;j<columnas;j++){
					ClsEntero NumA = ((ClsMatriz)a).matriz[i][j];
					ClsEntero NumB = ((ClsMatriz)b).matriz[i][j];
					NumA.restar(NumA, NumB);

				}
			}
		}

	}

	public ClsEntero[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(ClsEntero[][] matriz) {
		this.matriz = matriz;
	}

	@Override
	//Producto de matrices
	public void multiplicar(Object a, Object b) {
		
		int filaA = ((ClsMatriz)a).filas;
		int columnaA = ((ClsMatriz)a).columnas;
		int filaB = ((ClsMatriz)b).filas;
		int columnaB = ((ClsMatriz)b).columnas;
		
		if (columnaA != filaB){
			throw new IllegalArgumentException("No es posible realizar el producto de las matrices dadas.");
		}
		else
		{
			ClsMatriz matrizAux = new ClsMatriz(filaA,columnaB);
						
			for (int i=0;i<filaA;i++){
				for (int j=0;j<columnaB;j++){
					ClsEntero NumA = new ClsEntero();
					ClsEntero NumB = new ClsEntero();
					ClsEntero NumC = new ClsEntero();
					ClsEntero NumD = new ClsEntero();;
					NumD.setNumero(0);
					NumC.setNumero(0);
					for (int k=0;k<columnaA;k++){
						NumA = ((ClsMatriz)a).matriz[i][k];
						NumB = ((ClsMatriz)b).matriz[k][j];
						NumC.multiplicar(NumA, NumB);
						NumD.sumar(NumC, NumD);
					}
					((ClsMatriz)matrizAux).matriz[i][j] = NumD;
				}
			}
			this.matriz = matrizAux.matriz;
			this.filas = filaA;
			this.columnas = columnaB;
		}
	}

	@Override
	//Potencia de matriz
	public void potencia(Object a, Object b) {
		
		int filaA = ((ClsMatriz)a).filas;
		int columnaA = ((ClsMatriz)a).columnas;
		if ((filaA != columnaA)){
			throw new IllegalArgumentException("La cantidad de filas y columnas deben ser las mismas");
		}
		else
		{
			ClsMatriz matrizAux = new ClsMatriz(filaA,columnaA);
			matrizAux.matriz = ((ClsMatriz)a).matriz;
		
			int pot = (int) b;
		
			for (int i=1;i<pot;i++){
				((ClsMatriz)a).multiplicar(a, matrizAux);
			}
		}
	}

	@Override
	//Comparacion de matrices
	public boolean igualdad(Object a, Object b) {

		int filaA = ((ClsMatriz)a).filas;
		int columnaA = ((ClsMatriz)a).columnas;
		int filaB = ((ClsMatriz)b).filas;
		int columnaB = ((ClsMatriz)b).columnas;
		
		if ((filaA != filaB) || (columnaA != columnaB)){
			return(false);
		}
		else
		{
			int i,j;
			i = j = 0;
			while (i<filas){
				while (j<columnas){
					ClsEntero NumA = ((ClsMatriz)a).matriz[i][j];
					ClsEntero NumB = ((ClsMatriz)b).matriz[i][j];
					if (NumA.getNumero() != NumB.getNumero()){
						return(false);
					}
					j++;
				}
				i++;
			}
			return(true);
		}

	}
	

}
