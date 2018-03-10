package Fractal;

public class Logic {
	
	public static int decimal=310, width=100, height=100;//Number decimal to binary, matrix size width and height
	public static final int[][] board = new int [height][width];//matrix
	
	/**
	 * Class constructor with logic of the fractal
	 */
	public Logic()
	{
		// This for travel the matrix
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				board[i][j] = Math.random() < 0.5 ? 0:1;//the matrix fill of 1s and 0s random with 50%
			}
		}
		System.out.println("the decimal "+decimal+" in binary: "+Decimal_Binary(decimal)+"\n");
		
		/*Print the matrix of 1s and 0s random*/
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
		
		/*change value following ruler, if three first numbers has someone possible combinations between 0 and 1 whit binary number*/
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (board[i][(j+width-1)%width]==0 & board[i][j]==0 & board[i][(j+1)%width]==0) {
					//if the three are 0s the one in the center below changes with the least significant bit of the binary number
					board[(i+1)%height][j]=Integer.parseInt(""+Decimal_Binary(decimal).charAt(7));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==0 & board[i][(j+1)%width]==1) {
					//the one in the center below changes with the second least significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(6));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==1 & board[i][(j+1)%width]==0) {
					//the one in the center below changes with the third least significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(5));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==1 & board[i][(j+1)%width]==1) {
					//the one in the center below changes with the fourth least significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(4));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==0 & board[i][(j+1)%width]==0) {
					//the one in the center below changes with the fourth most significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(3));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==0 & board[i][(j+1)%width]==1) {
					//the one in the center below changes with the third most significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(2));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==1 & board[i][(j+1)%width]==0) {
					//the one in the center below changes with the second most significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(1));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==1 & board[i][(j+1)%width]==1){
					//the one in the center below changes with the most significant bit of the binary number
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(0));
				}
			}
		}
		
		
	}
	
	/**
	 * Change the number decimal to binary
	 * @param decimal
	 * @return
	 */
	public static String Decimal_Binary(int decimal)
	{
		int binario = 0;
		int exp=0;
		String binarioS;
		
		while (decimal!=0)
		{
			binario=binario+(decimal%2)*(int)Math.pow(10,exp );
			exp +=1;
			decimal = decimal/2;
		}
		
		binarioS = String.valueOf(binario);
		if (binarioS.length()<8) {
			while (binarioS.length()<8)
			{
				// if the number in binary is less to 8 bits adds 0
				binarioS="0"+binarioS;
			}
		}
		else
		{
			binarioS=binarioS.substring(binarioS.length()-8);
		}
		return binarioS; 
	}
	
	/**
	 * Logic fractal binary
	 */
	public static void Fractal()
	{
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (board[i][(j+width-1)%width]==0 & board[i][j]==0 & board[i][(j+1)%width]==0) {
					board[(i+1)%height][j]=Integer.parseInt(""+Decimal_Binary(decimal).charAt(7));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==0 & board[i][(j+1)%width]==1) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(6));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==1 & board[i][(j+1)%width]==0) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(5));
				}
				else if(board[i][(j+width-1)%width]==0 & board[i][j]==1 & board[i][(j+1)%width]==1) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(4));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==0 & board[i][(j+1)%width]==0) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(3));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==0 & board[i][(j+1)%width]==1) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(2));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==1 & board[i][(j+1)%width]==0) {
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(1));
				}
				else if(board[i][(j+width-1)%width]==1 & board[i][j]==1 & board[i][(j+1)%width]==1){
					board[(i+1)%height][j]= Integer.parseInt(""+Decimal_Binary(decimal).charAt(0));
				}
			}
		}
	}
	

}

