package Point5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotRhomb {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M, i ,j;
		String[] Numbers;
		int[][] MultiArray;
		
		bw.write("Enter please one number for matriz sice\n");
		bw.flush();
		M = Integer.parseInt(br.readLine());//size matrix
		
		bw.write("Enter please "+M*M+" numbers separated for comma\n");
		bw.flush();
		Numbers = br.readLine().split(",");// Make array Numbers;
		MultiArray = new int[M][M];
		
		// Array number to Matrix MultiArray
		int k=0;
		for(i=0; i<M; i++) {
			for(j=0; j<M; j++)
			{
				MultiArray[i][j] = Integer.parseInt(Numbers[k]);
				k+=1;
 			}
		}
		
		// Output of the matrix 
		for(i=0; i<M; i++) {
			for(j=0; j<M; j++)
			{
				System.out.print(MultiArray[i][j]+" ");
 			}
			System.out.println();
		}
		System.out.println();
		
		
		//Output rhombus outside	
		int SizeL;//moves only between the center and the left
		int SizeR;//moves only between the center and the right
		if(M%2==0)//if the matrix size is even
		{
			SizeL = (M/2)-1;//SizeL is the half of the Matrix size minus one
			SizeR = M/2;//SizeR is the half of the matrix size
		}
		else// if the matrix size doesn't is even, SizeL and SizeR are half matrix size
		{
			SizeL = M/2;
			SizeR = M/2;
		}
		//To travel the Matrix
		for(i=0; i<M; i++) {
			for(j=0; j<M; j++)
			{	
				if(j<=SizeL || j>=SizeR)// if the matrix is not between SizeL and SizeR print the Matrix
				{
					System.out.print(MultiArray[i][j]+" ");
				}
				else
					System.out.print("  ");
			}
			//Inside first 'for' conditional if Matrix is even or Odd
			if(M%2 == 0)// if M is even
			{
				if(i<(M/2)-1)//if i is between the half upward
				{
					SizeL--;//SizeL moves toward left
					SizeR++;//SizeR moves toward Right
				}
				else// if i is between the half downward 
				{
					if(i>=M/2)
					{
						SizeL++;//SizeL moves toward Right
						SizeR--;//SizeR moves toward left
					}
				}	
			}
			else//if M is Odd
			{
				if(i<M/2)//if i is between the half upward
				{
					SizeL--;//SizeL moves toward left
					SizeR++;//SizeR moves toward Right
				}
				else// if i is between the half downward 
				{
					SizeL++;//SizeL moves toward Right
					SizeR--;//SizeR moves toward left
				}
			}
			System.out.println();
		}

	}

}
