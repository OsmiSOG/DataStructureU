package ManejandoArchivos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MatrizMagica {

	public static int[][] CuadroMagico;
	
	public static void main(String[] args) {
		LeerCuadro();
		System.out.println(VerficacionMagico());
		if(VerficacionMagico()) {
			CrearFileVerificion("Es magico");
		}else
			CrearFileVerificion("No es magico");
		
	}
	
	public static void LeerCuadro()
	{
		File fichero = new File("magico.txt");
		Scanner reader = null;
		String[] lineaArray = null;
		
		try {
			reader = new Scanner(fichero);
			int x=0;
			
			while(reader.hasNextLine())
			{
				x+=1;
				String linea = reader.nextLine();
				lineaArray = linea.split(" ");
			}
			
			MatrizCuadro(x, lineaArray.length);
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	
	public static void MatrizCuadro(int x, int y)
	{
		File fichero = new File("magico.txt");
		Scanner reader = null;
		CuadroMagico = new int[x][y];
		
		try {
			reader = new Scanner(fichero);
			String[] linea;
		
			for(int i=0; i<x; i++) {
				linea = reader.nextLine().split(" ");
				for(int j=0; j<y; j++)
				{
					CuadroMagico[i][j] = Integer.parseInt(linea[j]); 
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static boolean VerficacionMagico()
	{
		boolean magicoVerificado = false;
		
		int Filas=0;
		int Columnas=0;
		int Diagonales=0;
		int x=0;
		int size = CuadroMagico.length;
		
		for(int i=0; i<size; i++) {
			x+=CuadroMagico[0][i];
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<CuadroMagico[i].length; j++)
			{
				Filas += CuadroMagico[i][j];
				Columnas += CuadroMagico[j][i];
				if(i==j || j==(CuadroMagico.length-1)-i)
				{
					if(i==j && j==(CuadroMagico.length-1)-i)
					{
						Diagonales += CuadroMagico[i][j];
					}
					Diagonales += CuadroMagico[i][j];
				}
			}
		}

		if(x==(Filas/size) && x==(Columnas/CuadroMagico[0].length) && x==(Diagonales/2))
		{
			magicoVerificado = true;
		}else
			magicoVerificado = false;
		
		return magicoVerificado;
	}
	
	public static void CrearFileVerificion(String Magico) {
		
		File fichero = new File("Verificado.txt");
		
		try {		
			fichero.createNewFile();//Crear el archivo 
			System.out.println(fichero.getName()+" Ha sido creado");
			PrintWriter pw = new PrintWriter(fichero, "utf-8");
			
			for(int i=0; i<CuadroMagico.length; i++) {
				for(int j=0; j<CuadroMagico[i].length; j++) 
				{
					pw.print(CuadroMagico[i][j]+" ");
				}
				pw.println();
			}pw.println();
			
			if(Magico.equals("Es magico")) {
				int x=0;
				for(int i=0; i<CuadroMagico.length; i++) {
					x+=CuadroMagico[0][i];
				}	
				pw.println("Es magico y la suma de cada fila, columna y diagonal es "+x);
			}else {
				pw.println("No es magico");
			}
			
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
