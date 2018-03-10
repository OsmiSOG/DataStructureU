import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchMotif {
	
	public String motifWinner;//The pattern motif most repeated in the sequence
	public int max;// Quantity most repeated pattern motif in the sequence
	
	/**
	 * This function initialize max in -1 
	 */
	public SearchMotif()
	{
		this.max = -1;
	}
	
	/**
	 * This function count the quantity of times that repeated a pattern in file, in the sequences(ACGT)
	 * @param motif 
	 * @return
	 */
	public int CountReads(String motif)
	{
		int counter=0;//Initialize counter in 0
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("sequences.umd"));
			String read = br.readLine();//read the line of each sequence
			
			while(read != null)//while read has information do
			{
				counter += read.contains(motif)? 1 : 0;//if pattern of the parameter motif is in the line of sequence sum 1 else 0
				read = br.readLine();//read other line
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return counter;// return the quantity that repeated the motif in the file
	}
	
	/**
	 * This function create patterns (ACGT)
	 * @param length // quantity of letters for pattern
	 * @param motif 
	 */
	public void GenerateKPatterns(int length, String motif)
	{	
		int tempCounter;//store the counter that return function CountReads  
		
		if( length == 1)// If size of the length is equal to 0 do
		{
			/**tempCounter stores the quantity times repeat the pattern motif and the that most repeat
			stores in motifWinner the pattern and in max the quantity that repeated
			**/
			tempCounter = CountReads(motif+"A");
			if (tempCounter>max){
				motifWinner= motif+"A";
				max = tempCounter;
			}
			tempCounter = CountReads(motif+"C");
			if (tempCounter>max){
				motifWinner= motif+"C";
				max = tempCounter;
			}
			tempCounter = CountReads(motif+"G");
			if (tempCounter>max){
				motifWinner= motif+"G";
				max = tempCounter;
			}
			tempCounter = CountReads(motif+"T");
			if (tempCounter>max){
				motifWinner= motif+"T";
				max = tempCounter;
			}
			
			// print of the patterns
			System.out.println(motif +"A\n");
			System.out.println(motif +"C\n");
			System.out.println(motif +"G\n");
			System.out.println(motif +"T\n");
		}
		else// if length is higher to 1 it is make recursion  
		{
			GenerateKPatterns(length-1, motif+"A");// to length subtract 1, to sum motif A
			GenerateKPatterns(length -1, motif+"C");// to length subtract 1, to sum motif C
			GenerateKPatterns(length -1, motif+"G");// to length subtract 1, to sum motif G
			GenerateKPatterns(length -1, motif+"T");// to length subtract 1, to sum motif T
		}
	}

	/**
	 * 
	 */
	public void reset()
	{
		max =0;
	}
	
	/**
	 * print the motifWinner and max
	 */
	public String toString()
	{
		return "\n The motif most repeated is "+ this.motifWinner+ " and repeated "+this.max+" times.\n";
	}

	/**
	 * Here if you want to check the pattern motif most repeated
	 * @param args
	 */
	public static void main(String args[])
	{
		SearchMotif sm = new SearchMotif();
		System.out.println(sm.CountReads("CACG"));
	}
}
