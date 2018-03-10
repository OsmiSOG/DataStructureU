package Calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

/**
 * 
 * @author Santiago Otálora
 *
 */
public class Calculator {

	/**
	 * This is the main method that will execute the program 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        
        int option;
        do 
        {
        	option =option();// Here the option that user chooses
        	int[] parameters= getParameters(option);// Here numbers are stored for the operations 
        	operation(option,parameters);//Here print the result of the operation chooses
        	
        }while (option != 11);
	}
	
	/**
	 * This function return of numbers of the operation  
	 * @return
	 * @throws IOException 
	 */
	public static int option() throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		bw.write("choose one option: \n1. Addition \n2. Subtraction \n3. Multiplication"
				+ "\n4. Division \n5. Remainder \n6. Factorial \n7. Exponent \n8. Sine \n9. Cosine"
				+ "\n10. Riemann sum \n11. Exit\n");
		bw.flush();
		
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	/**
	 * This function return the numbers need for the operation chosen
	 * @param option
	 * @return
	 * @throws IOException
	 */
	public static int[] getParameters(int option) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int[] parameters = null;// This variable store the numbers for the operation
		
		switch(option)// chose the option of the variable
		{
			case 1://Addition
			{
				parameters = new int[2];
				bw.write("Following is going to make an addition\n");
				bw.write("Write a number first: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write a number second: \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 2: //Subtraction
			{
				parameters = new int[2];
				bw.write("Following is going to make a subtraction\n");
				bw.write("Write a number first: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write a number second: \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 3: //Multiplication
			{
				parameters = new int[2];
				bw.write("Following is going to make a Multiplication\n");
				bw.write("Write a number first: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write a number second: \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 4: //Division
			{
				parameters = new int[2];
				bw.write("Following is going to make a Division\n");
				bw.write("Write a number first: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write a number second: \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 5://Remainder
			{
				parameters = new int[2];
				bw.write("Following is going to make a Remainder\n");
				bw.write("Write a number first: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write a number second: \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 6://Factorial
			{
				parameters = new int[1];
				bw.write("Following is going to make a Factorial\n");
				bw.write("Write a number: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
			}
			break;
			case 7://Exponent
			{
				parameters = new int[2];
				bw.write("Following is going to make a potency\n");
				bw.write("Write the potency base: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write the Exponent for the potency : \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
			}
			break;
			case 8://Sine
			{
				parameters = new int[1];
				bw.write("Following is going to make a Sine\n");
				bw.write("Write a number to calculate: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
			}
			break;
			case 9://Cosine
			{
				parameters = new int[1];
				bw.write("Following is going to make a Cosine\n");
				bw.write("Write a number to calculate: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
			}
			break;
			case 10://Integral Riemann sum
			{
				parameters = new int[3];
				bw.write("Following is going to make a Riemann sum\n");
				bw.write("Write the starting point: \t");
				bw.flush();
				parameters[0]=Integer.parseInt(br.readLine());
				bw.write("Write the final point : \t");
				bw.flush();
				parameters[1]=Integer.parseInt(br.readLine());
				bw.write("Write the increment : \t");
				bw.flush();
				parameters[2]=Integer.parseInt(br.readLine());
			}
			break;
			default:
			{
				System.exit(0);
			}
		}
		return parameters;
	}
	
	/**
	 * This function print the result of the operation 
	 * @param option
	 * @param parameters
	 * @throws IOException 
	 */
	public static void operation(int option, int[] parameters) throws IOException
	{
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		Operations op = new Operations();
		
		switch(option)// chose the option of the variable
		{
			case 1://Addition
			{
				int Result = op.addition(parameters[0], parameters[1]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 2://Subtraction
			{
				int Result = op.subtraction(parameters[0], parameters[1]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			case 3://Multiplication
			{
				int Result = op.multiplication(parameters[0], parameters[1]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 4://Division
			{
				DecimalFormat df = new DecimalFormat("#0.0000");
				double Result = op.division(parameters[0], parameters[1]);
				if(Result == Double.NaN)
				{
					bw.write("The divsion for zero is not possible \n\n");
					bw.flush();
				}
				else
					bw.write("The result is: "+df.format(Result)+"\n\n");
					bw.flush();
			}
			break;
			case 5://Remainder
			{
				double Result = op.residue(parameters[0], parameters[1]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 6://Factorial
			{
				int Result = op.factorial(parameters[0]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 7://Exponent
			{
				double Result = op.exponent(parameters[0], parameters[1]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 8://sine
			{
				double Result = op.sine(parameters[0]);
				bw.write("The result sine is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 9://cosine
			{
				double Result = op.cosine(parameters[0]);
				bw.write("The result cosine is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			case 10://Riemann sum
			{
				double Result = op.integral(parameters[0], parameters[1], parameters[2]);
				bw.write("The result is: "+Result+"\n\n");
				bw.flush();
			}
			break;
			default:
			{
				System.exit(0);
			}
		}
	}
}
