package ManejoArchivos;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* @author Osmi Santiago Otalora Guerrero
*
*/
public class RomanosArabigos {

	public static char[] Romano;
	public static int[] Arabigo;

	public static void main(String[] args) {
		leerRomano();
		Convertidor();
		System.out.println(NumeroArabigo());
		int NumArabigo = NumeroArabigo();

		for(int i=0; i<Romano.length; i++) {
			System.out.print(Romano[i]);
		}
		for(int i=0; i<Romano.length; i++) {
			System.out.print(Arabigo[i]+" ");
		}

		ArchivoArabigo(NumArabigo);
	}

	public static void leerRomano()
	{
		File fichero = new File("Romano.txt");
		Scanner reader = null;
		String linea = null;

		try {
			reader = new Scanner(fichero);
			while(reader.hasNextLine()) {
				linea = reader.nextLine();
			}

			Romano = new char[linea.length()];
			for(int i=0; i<linea.length(); i++) {
				Romano[i] = linea.charAt(i);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void Convertidor() {

		Arabigo = new int[Romano.length];
		for(int i=0; i<Romano.length; i++) {
			if(Romano[i]=='I') {
				Arabigo[i] = 1;
			}else if(Romano[i]=='V') {
				Arabigo[i] = 5;
			}else if(Romano[i]=='X') {
				Arabigo[i]=10;
			}else if(Romano[i]=='L') {
				Arabigo[i]=50;
			}else if(Romano[i] =='C') {
				Arabigo[i]=100;
			}else if(Romano[i]=='D') {
				Arabigo[i]=500;
			}else if(Romano[i]=='M')
			{
				Arabigo[i]=1000;
			}
		}

	}

	public static int NumeroArabigo() {

		int ArabigoNum=0;//Numero Arabigo
		int NoArab = 0;//Si es mayor a 3 numeros seguidos
		int Max=0;//Cuenta cuantas lestra van seguidas
		int cambio=Arabigo[0];//para comparar
		//Ciclo con el arreglo con los numeros arabigos
		for(int i=0; i<Arabigo.length; i++)
		{
			//si i es menor al tama�o-1 del arreglo y no hallan mas de 3 letras iguales segidas
			if(i<Arabigo.length-1 && Max <= 3) {
				//Cuando el que esta adelante de la posicion actual es igual
				if(Arabigo[i] == Arabigo[i+1] ) {
					if(Arabigo[i]!=cambio) {
						Max = 0;
					}
					Max += 1;
					ArabigoNum += Arabigo[i];
					cambio = Arabigo[i];
				}//Cuando el que esta en la posicion actual es menor al de adelante
				else if(Arabigo[i] < Arabigo[i+1]) {
					if(Arabigo[i]!=cambio) {
						Max = 0;
					}
					Max += 1;
					ArabigoNum -= Arabigo[i];
					cambio = Arabigo[i];
				}//Cuando el que esta en la posicion actual es mayor al que esta adelante
				else if(Arabigo[i] > Arabigo[i+1]) {
					if(Arabigo[i] != cambio) {
						Max = 0;
					}
					ArabigoNum += Arabigo[i];
					Max += 1;
					cambio = Arabigo[i];
				}
			}//Cuando llega a la ultima letra o numero del arreglo
			else if(i<Arabigo.length) {
				if(Max == 3 && Arabigo[i]==Arabigo[i-1]) {
					Max += 1;
				}else if(Arabigo[i]>Arabigo[i-1]) {
					ArabigoNum += Arabigo[i];
				}else if(Arabigo[i]<Arabigo[i-1] || Arabigo[i-1] == Arabigo[i]) {
					ArabigoNum += Arabigo[i];
				}
			}

			// Si es mayor a 3
			if (Max > 3) {
				NoArab = -1;
			}
		}
		if(NoArab == -1) {
			return NoArab;
		}else
			return ArabigoNum;
	}
	
	public static void ArchivoArabigo(int x) {
		File fichero = new File("Arabigo.txt");
		PrintWriter pw;

		try {
			fichero.createNewFile();
			pw = new PrintWriter(fichero);
			pw.print("Numero arabigo: "+x);
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
