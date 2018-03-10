package OperacionesArreglos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CuartoPunto {
	
	/**
	 * 
	 * @throws IOException
	 */
	public void Problema() throws IOException
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String Prices;
		String PricesArray[];
		int Less, day1=0;
		int Higher, Day2=0;
		
		bw.write("Enter seven-day prices separated by commas: \n");
		bw.flush();
		Prices = br.readLine();
		PricesArray = Prices.split(",");
		Less = Integer.parseInt(PricesArray[1]);
		Higher =	Integer.parseInt(PricesArray[1]);	
		
		for(int i = 0; i<PricesArray.length; i++)
		{
			if(Integer.parseInt(PricesArray[i]) <= Less) {
				day1 = i+1;
				Less=Integer.parseInt(PricesArray[i]);
			}
			
			if(Integer.parseInt(PricesArray[i]) >= Higher) {
				Higher=Integer.parseInt(PricesArray[i]);
				Day2 = i+1;
			}
		}
		if(day1< Day2) 
		{
			bw.write("The maximum benefit is: $"+(Higher-Less)+"\nSince you can buy at $"+Less+" on day "+day1+"\n"
					+ "if they are sold in the day "+Day2+"\n");
			bw.flush();
		}
		else
		{
			bw.write("there is no benefit: $"+(Less-Higher)+"\nSince you can buy at $"+Less+" on day "+day1+"\n"
					+ "if they are sold in the day "+(Day2)+"\n");
			bw.flush();
		}
		
	}
}
