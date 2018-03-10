package OperacionesArreglos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * In this code are made couples with the numbers that the user enters 
 * and according to a difference that the user enters 
 * and that must be between the first and second number of each pair
 * @author Santiago Otaloras
 *
 */
public class PrimerPunto {
	
	/**
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void Couples() throws NumberFormatException, IOException 
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String NumbersStr;// numbers that the user enters
		String[] NumbersArray;//Array with numbers of the user
		int kdifference;//The number restriction or difference
		String Couples = "";//To store the couples
		int counter = 0;//Counter for know quantity couples there are
		
		bw.write("Count the number of possible partners according to a difference restriction\n");
		bw.write("Next enter numbers separated by commas:\n");
		bw.flush();
		NumbersStr = br.readLine();//User enter the numbers
		NumbersArray = NumbersStr.split(",");//split the numbers in the array
	
		bw.write("Write the number of the difference: \n");
		bw.flush();
		kdifference = Integer.parseInt(br.readLine());//difference that user enter
		
		for(int i=0; i<NumbersArray.length; i++) {
			
			int summation=i;//This variable makes it compare with the rest of the numbers that follow
			
			while(summation != NumbersArray.length-1)//until summation reaches the size of the array
			{
				/*compare the index number i with the rest of the numbers*/
				if (Integer.parseInt(NumbersArray[i])-kdifference == Integer.parseInt(NumbersArray[summation+1]))
				{
					/*first the index i with the ones in front*/
					counter += 1;//if it is couple count
					Couples=(Couples+" ("+NumbersArray[i]+","+NumbersArray[summation+1]+")");
				}
				else if(Integer.parseInt(NumbersArray[summation+1])-kdifference == Integer.parseInt(NumbersArray[i]))
				{
					/*else that are in front first and then the index i*/
					counter += 1;//if it is couple count
					Couples=(Couples+" ("+NumbersArray[i]+","+NumbersArray[summation+1]+")");
				}
					
				summation += 1;
			}
			
		}
		//print couples
		bw.write("The numbers of couples are: " + counter+"\n");
		bw.write("And cuples are: \n");
		bw.write(Couples+"\n");
		bw.flush();
	}
	
		
}
