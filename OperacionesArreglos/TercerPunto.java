package OperacionesArreglos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TercerPunto {
	
	/**
	 * 
	 * @throws IOException
	 */
	public void Problema() throws IOException
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String Numbers;
		String[] NumbersArray;
		String UniqueNumber = "";
		
		bw.write("Write separate numbers with commas and let each number have a pair except one\n");
		bw.flush();
		Numbers =br.readLine();
		NumbersArray = Numbers.split(",");
		
		for(int i=0; i<NumbersArray.length; i++)
		{
			if(Different(NumbersArray[i],NumbersArray) == 1)
			{
				UniqueNumber = NumbersArray[i];
			}
		}
		
		bw.write("El numero que no se repite dos veces es: "+ UniqueNumber+"\n");
		bw.flush();
	}
	
	/**
	 * Devuelve la cantidad que se repite cierto numero 
	 * @param number
	 * @param Array
	 * @return
	 */
	public static int Different(String number, String[] Array) 
	{

		int Counter=0;
		for (int i=0; i<Array.length; i++)
		{
			if(Integer.parseInt(number) == Integer.parseInt(Array[i])) {
				Counter +=1;
			}

		}
		return Counter;
	}
}
