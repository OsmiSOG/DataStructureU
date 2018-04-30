package ManejoArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CuadroMagico {

	public static void main(String[] args) throws IOException {
		
		File fichero = new File("magico.txt");
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String Linea;
		int[] CuboArray;
		String[] LineaArray;
		int[][] Cubo = null;
		
		
		Linea = br.readLine();
		while(Linea != null);
		{	
			LineaArray = Linea.split(" ");
			CuboArray = new int[LineaArray.length];
			for(int i=0; i<LineaArray.length; i++) {
				CuboArray[i] = Integer.parseInt(LineaArray[i]);
				System.out.println(CuboArray[i]);
			}
			
			int i=0;
			i+=1;
			Cubo = MatrizCubo(CuboArray, i, Cubo);
			Linea = br.readLine();
			
		}while(Linea != null);
		
		int[][] CuboMagico = LeerCubo();
		System.out.println(CuboMagico.length);
		for(int i=0; i<CuboMagico.length; i++) {
			for(int j=0; j<CuboMagico[i].length; j++)
			{
				System.out.print(CuboMagico[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] LeerCubo() throws IOException
	{
		File fichero = new File("magico.txt");
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String Linea;
		int[] CuboArray;
		String[] LineaArray;
		int[][] Cubo = null;
		
		
		Linea = br.readLine();
		while(Linea != null);
		{	
			LineaArray = Linea.split(" ");
			CuboArray = new int[LineaArray.length];
			for(int i=0; i<LineaArray.length; i++) {
				CuboArray[i] = Integer.parseInt(LineaArray[i]);
				System.out.println(CuboArray[i]);
			}
			
			int i=0;
			i+=1;
			Cubo = MatrizCubo(CuboArray, i, Cubo);
			Linea = br.readLine();
			
		}while(Linea != null);
		
		return Cubo;
	}
	
	public static int[][] MatrizCubo(int[] CuboArray, int x, int[][] Cubo)
	{
		System.out.println(CuboArray.length);
		
		int[][] CuboNuevo = new int[x][CuboArray.length];
		
		if(x>1) {
			for(int i=0; i<x; i++) {
				for(int j=0; j<CuboArray.length; j++)
				{
					// si i es diferente de la ultima fila hace
					if(i != x-1)
					{
						CuboNuevo[i][j] = Cubo[i][j];
					}else//Si esta en la ultima fila hace 
					{
						CuboNuevo[i][j] = CuboArray[j];
					}
				}
			}
		}
		else {
			for(int j=0; j<CuboArray.length; j++) {
				CuboNuevo[0][j]=CuboArray[j];
			}
		}
		
		return CuboNuevo;
	}
	
	public static void VerificacionMagico()
	{
		
	}

}
