import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateFiles {
	
	public CreateFiles(int lines) //class constructor whit parameter of lines for file
	{
		Random rnd = new Random(); 
		
		int start;// Positives random numbers 
		int length;// Random number, min 5, max 30, quantity of letters for each sequence
		String sequence;//Sequence of letters of "A,C,G,T"
		
		try
		{
			BufferedWriter bw = new BufferedWriter( new FileWriter( "sequences.umd" ));// Save in a file sequence.umd
			// line each: (RandomInteger, RandomInteger(higher), SequenceStringRandom(ACGT))
			for(int i=0; i<=lines; i++)//quantity lines
			{
				start = Math.abs(rnd.nextInt());//Random number positive(RamdomInteger)
				length = 5+rnd.nextInt(25);//Quantity of letters for each sequence(ACGT)
				sequence = "";//SequenceStringRandom(ACGT)
				
				for(int j=0; j<length; j++)//repeat quantity of length for create sequence string
				{
					switch(rnd.nextInt(4))//Random number from 0 to 3 for sequence(ACGT)
					{
						case 0: sequence +="A";// if random is equal 0, Add "A" in sequence 
						break;
						
						case 1: sequence +="C";// if random is equal 1, Add "C" in sequence 
						break;
						
						case 2: sequence += "G";// if random is equal 2, Add "G" in sequence 
						break;
						
						case 3: sequence += "T";// if random is equal 3, Add "T" in sequence 
						break;
					}
				}
				//line: (RandomInteger, RandomInteger(higher), SequenceStringRandom(ACGT))
				bw.write(start +", "+ (start+length) +", "+ sequence +"\n");//line for file
			}
			bw.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
