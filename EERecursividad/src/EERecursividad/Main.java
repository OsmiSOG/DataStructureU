package EERecursividad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Exercises Ex = new Exercises();
		
		int x;
		int y;
		
		int opcion= Opcion();
		while(opcion!=0) {
			switch(opcion) {
			
			case 1:
				bw.write("escriba un numero para sumarlo con los anteriores:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				System.out.println(Ex.SumaEnteros(x)+"\n");
				break;
				
			case 2:
				bw.write("escriba un numero para sumarlo con lo anteriores de a 2:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				if (x%2==0)
					System.out.println(Ex.SumaEnterosPositivos(x)+"\n");
				else
					System.out.println("Error\n");
				break;
				
			case 3:
				bw.write("escriba un numero para encontrar el enesimo de fibonacci:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				System.out.println(Ex.Fibonacci(x, 0, 1)+"\n");
				break;
				
			case 4:
				int[] Unsort;
				bw.write("Escriba numeros separados por coma para ordenar:  ");
				bw.flush();
				String [] A=br.readLine().split(",");
				Unsort=new int [A.length];
				for(int i=0; i<A.length; i++) {
					Unsort[i]=Integer.parseInt(A[i]);
				}
				int[] Sorted = Ex.Sort(Unsort, 0);
				for(int i=0; i<Sorted.length; i++)
				{
					System.out.print(Sorted[i]+" ");
				}
				System.out.println();
				break;
				
			case 5:
				bw.write("escriba un numero n: ");
				bw.flush();
				int n=Integer.parseInt(br.readLine());
				bw.write("escriba un numero r: ");
				bw.flush();
				int r=Integer.parseInt(br.readLine());
				System.out.println(Ex.ManerasDiferentes(n, r)+"\n");
				break;
				
			case 6:
				bw.write("MCD \nEscriba un numero:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				bw.write("MCD \nEscriba otro numero:  ");
				bw.flush();
				y=Integer.parseInt(br.readLine());
				int mcd;
				if(x>=y){
					mcd=Ex.MCD(x, y);
				}else
					mcd=Ex.MCD(y,x);
				System.out.println(mcd+"\n");
				break;
				
			case 7:
				bw.write("escriba un numero:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				System.out.println(Ex.f(x)+"\n");
				break;
				
			case 8:
				bw.write("escriba un numero fila:  ");
				bw.flush();
				x=Integer.parseInt(br.readLine());
				bw.write("Escriba un numero para la possicion");
				bw.flush();
				y=Integer.parseInt(br.readLine());
				System.out.println(Ex.Pascal(x, y)+"\n");
				
				break;
			}
			opcion= Opcion();
		}	
	}
	
	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static int Opcion() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Escoja una opcion \n1.Ejercicio 1\n2.Ejercicio 2 \n3.Ejercicio 3 \n4.Ejercicio 4 \n5.Ejercicio 5 \n6.Ejercicio 6 \n7.Ejercicio 7 \n8.Pascal \n0. Salir\n");
		bw.flush();
		int x = Integer.parseInt(br.readLine());
		return x;
	}
	
}
