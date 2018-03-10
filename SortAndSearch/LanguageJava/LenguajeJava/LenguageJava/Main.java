package LenguageJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author santo
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] Numbers;//numbers write for user
		int[] Array;//Array with numbers separated
		int[] Ordenado;//Array whit the array return the merge sort function
		int search;//index of number to search
		
		//read numbers
		bw.write("Enter please numbers separeted for comma\n");
		bw.flush();
		Numbers = br.readLine().split(",");//separate numbers
		Array = new int[Numbers.length];
		Ordenado = new int[Numbers.length];
		
		//Array of type string to array of type integer
		for(int i=0; i<Numbers.length; i++)
		{
			Array[i]= Integer.parseInt(Numbers[i]);
		}
		
		Ordenado=Merge_Sort(Array);
		bw.write("Your sort numbers\n");
		bw.flush();
		for(int i=0; i<Numbers.length; i++)
		{
			System.out.print(Ordenado[i]+" ");
		}
		System.out.println();
		
		bw.write("Enter one number to search of your sorted array: \n");
		bw.flush();
		search = Integer.parseInt(br.readLine());
		System.out.println("starting count in 0 it´s index = "+InterpolationSearch(Ordenado, search));
		
		
		
	}
	/**
	 * In this function makes strategy divide and conquer
	 * This function separate the array in halves with recursivity until size array 1  
	 * @param Array - Unsorted array of numbers
	 * @return - Sorted array of numbers
	 */
	public static int[] Merge_Sort(int[] Array)
	{
		// Arrays split unsorted
		int[] LeftSubArray = new int[Array.length/2];//Array of size of the left half of array parameter 
		int[] RightSubArray = new int[Array.length-(Array.length/2)];//Array of size of the right half of array parameter
		// Array split sorted
		int[] SortedL = new int[Array.length/2];
		int[] SortedR = new int[Array.length-(Array.length/2)];
		
		if (Array.length == 1)
		{
			//Array is ready sorted
			return Array;
		}
		else// Split in two 
		{
			int i=0;
			for(i=0; i<Array.length/2; i++)
			{
				LeftSubArray[i]=Array[i];
			}
			for(i=Array.length/2; i<Array.length; i++)
			{
				RightSubArray[i-(Array.length/2)]=Array[i];
			}
			/*Sort each one of the parts */
			SortedL = Merge_Sort(LeftSubArray);
			SortedR = Merge_Sort(RightSubArray);
			/*Following the strategy divide and conquer*/
			return Merge(SortedL,SortedR);
		}
	}
	
	/**
	 * This function sort the parts of the split array
	 * @param A - sorted sub-array of numbers
	 * @param B - sorted sub-array of numbers
	 * @return - Sorted array of numbers
	 */
	public static int[] Merge(int[]A, int[] B) {
		
		int length = A.length+B.length;
		int[] C = new int[length];//Create C array
		int IndexA=0, IndexB=0, IndexC=0;//indicator for arrays size
		
		/*while A and B have elements*/
		while(A.length != IndexA && B.length != IndexB)
		{
			if(A[IndexA]<B[IndexB])
			{
				// add element from A array
				C[IndexC]=A[IndexA];
				IndexA++;
				IndexC++;
			}
			else
			{
				// add element from B array
				C[IndexC] = B[IndexB];
				IndexB++;
				IndexC++;
			}
		}
		
		/*one of A or B has still some elements*/
		while(A.length != IndexA)
		{
			C[IndexC] = A[IndexA];
			IndexA++;
			IndexC++;
		}
		while(B.length != IndexB)
		{
			C[IndexC] = B[IndexB];
			IndexB++;
			IndexC++;
		}
		return C;
	}
	
	/**
	 * This function of Interpolation search
	 * Search of direct way the index chose of the element. Restriction Sorted array
	 * @param Array - Sorted array of numbers
	 * @param x - value to be searched
	 * @return - index in the array where x is located
	 */
	public static int InterpolationSearch(int[] Array, int x)
	{
		int LowerBound = 0;
		int UpperBound =Array.length-1;
		int index = -1;
		int middlePoint;
		
		/*if upper bound is lees than lower bound, there is not a feasible solution */
		while( LowerBound < UpperBound)
		{
			middlePoint = LowerBound+((UpperBound-LowerBound)/(Array[UpperBound]-Array[LowerBound]))*(x-Array[LowerBound]);
			if (x==Array[middlePoint])
			{
				//x has been found
				index = middlePoint;
				break;
			}
			else
			{
				if (x < Array[middlePoint])
				{
					UpperBound = middlePoint-1;
				}
				else
				{
					LowerBound = middlePoint+1;
				}
			}
		}
		if (LowerBound == UpperBound && Array[LowerBound]==x)
		{
			index = LowerBound;
		}
		return index;
	}

}
