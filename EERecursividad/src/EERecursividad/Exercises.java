package EERecursividad;

public class Exercises {
	
	/**
	 * Exercise 1
	 * @param x
	 * @return
	 */
	public int SumaEnteros(int x)
	{	
		if(x==0) {
			return 0;
		}
	
		x+=SumaEnteros(x-1);
		
		return x;
	}
	
	/**
	 * Exercise 2
	 * @param x
	 * @return
	 */
	public int SumaEnterosPositivos(int x)
	{
		if(x==2) {
			return x;
		}else
			x=x+SumaEnterosPositivos(x-2);
		
		return x;
	}
	
	/**
	 * Exercise 3
	 * @param x
	 * @param F0 
	 * @param F1
	 * @return
	 */
	public int Fibonacci(int x, int F0, int F1)
	{	
		if(x!=0)
		{
			return Fibonacci(x-1,F1,F0+F1);
		}else
			return F0;
	}
	
	/**
	 * Exercise 4
	 * @param Unsort
	 * @param x
	 * @return
	 */
	public int[] Sort(int[] Unsort, int x) 
	{
		int menor = Unsort[x];
		int cambio;
		
		if(Unsort.length ==1) // Si el arreglo es de tamaño 1 devuelve el arreglo
		{
			return Unsort;
			
		} else if(x==Unsort.length-1) // Si x es igual a la posicion del arreglo devuelve el arreglo
		{
			return Unsort;
			
		}else {//Si no compara buscando el menor y ubicandolo en su debido lugar segun el valor de x
			for(int i=x+1; i<Unsort.length; i++) {
				if (Unsort[i]<Unsort[x])
				{
					menor = Unsort[i];
					cambio = Unsort[x];
					Unsort[x]= menor;
					Unsort[i]=cambio;
					               
				}
			}
			return Sort(Unsort,x+1);//Recursividad con parametros del arreglo y x+1 
		}							
	}
	
	/**
	 * Exercise 5
	 * @param x
	 * @param r
	 * @return
	 */
	public int ManerasDiferentes(int x, int r)
	{
		int C;
		C=Factorial(x)/(Factorial(r)*Factorial(x-r));
		return C;
	}
	
	public static int Factorial(int x) {
		if(x==0 || x==1) {
			return 1;
		}else
			x*=Factorial(x-1);
		
		return x;
	}
	
	/**
	 * Exercise 6
	 * @param x
	 * @param y
	 * @return
	 */
	public int MCD(int x, int y) 
	{
		int comun=0;
		if(y==0) {
			return x;
		}else if(y!=0) {
			comun = MCD(y, x % y);
		}
		return comun;
	}
	
	/**
	 * Exercise 7
	 * @param x
	 * @return
	 */
	public int f(int x)
	{
		if (x >100)
		{
			return (x-10);
		}
		else
		{
			return(f(f(x+11)));
		}
	}
	
	public int Pascal(int nfila, int nelem)
	{
		
		if(nfila == 0) {
			return 1;
		}else if (nelem == 0)
		{
			return 1;
		}else if(nfila==1)
		{
			return 1;
		}else if(nfila == nelem) {
			return 1;
		}else
			return Pascal(nfila-1, nelem-1) + Pascal(nfila-1 , nelem);
	}
}
