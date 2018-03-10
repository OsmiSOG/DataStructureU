package Point2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Spiral {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Random rnd = new Random();
		
		int M, i, j, Counter=0;
		int[][] Matriz;
		int[] Spiral; 
		
		bw.write("Enter please one number for matriz size\n");
		bw.flush();
		M = Integer.parseInt(br.readLine());
		Matriz = new int [M][M];
		Spiral = new int [M*M];
		
		// Make array random 
		for (i=0; i<M; i++) {
			for(j=0; j<M; j++)
			{
				Matriz[i][j] = rnd.nextInt(21);
			}
		}
		
		// output array random
		for (i=0; i<M; i++) {
			for(j=0; j<M; j++)
			{
				System.out.print(Matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("In spiral");
		
		
		
		// start array in spiral
		int Size= M*M;
		int iN=0;
		while(Counter<Size)
		{
			for(j=iN; j<M; j++)//Up ->
			{
				Spiral[Counter]=Matriz[iN][j];
				Counter++;
			}
			for(i=iN+1; i<M;i++)//Right  |
			{
				Spiral[Counter]=Matriz[i][M-1];
				Counter++;
			}
			for(j=M-2; j>=iN; j--)//Down <-
			{
				Spiral[Counter]=Matriz[M-1][j];
				Counter++;
			}
			for(i=M-2; i>iN; i--)//Left|
			{
				Spiral[Counter]=Matriz[i][iN];
				Counter++;
			}
			iN += 1;//
			M -= 1;//
		}
		// Output of the spiral
		for(i=0; i<Counter; i++) {
			System.out.print(Spiral[i]+" ");
		}

	}

}
