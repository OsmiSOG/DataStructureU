package OperacionesArreglos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This code multiplies the numbers of the array except the current index
 * example: input {3,2,5,1}
 * 			output{10,15,6,30}
 * @author Santiago Otalora
 *
 */
public class SegundoPunto {
	
	public void Problema() throws IOException
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String Numbers;// Variable con los numeros con comas
		String[] NumbersArray;//Tendra los numeros obtenidos usando el .split
		int[] MultiplicationArray;
		bw.write("Ingerse numeros separados por comas: \n");
		bw.flush();	
		Numbers = br.readLine();
		NumbersArray = Numbers.split(",");
		MultiplicationArray = new int[NumbersArray.length];
		
		for(int i=0; i< NumbersArray.length; i++)
		{
			MultiplicationArray[i]=NumberMultiplied(i,NumbersArray);
		}
		
		for(int i=0; i<MultiplicationArray.length; i++)
		{
			bw.write(MultiplicationArray[i]+" ");
			bw.flush();
		}
		
		System.out.println("\n");
	}
	
	/**
	 * This function returns the number of the multiplication
	 * @param index
	 * @param NumbersArray
	 * @return
	 */
	public static int NumberMultiplied(int index,String[] NumbersArray)
	{
		int Multiplication=1;
		
		for(int i=0; i<NumbersArray.length; i++)
		{
			if(index!=i)
			{
				Multiplication = Multiplication*Integer.parseInt(NumbersArray[i]); 
				
			}
		}
		
		return Multiplication;
	}
}
