package GameOfLife;


public class Logic{
	
	public static int[][] Matriz_Automata = null;//Matrix with 1s and 0s (1s live, 0s dead)
	
	// In this class constructor fill of 1s and 0s randomly
	public Logic(int width, int height) 
	{
		Matriz_Automata = new int[width][height];//Matrix size whit the size of the parameters
		
		// Fill matrix
		for (int i =0; i<height ;i++)
		{
			for (int j =0; j< width; j++)
			{
				Matriz_Automata[i][j]= Math.random() < 0.05 ? 0 : 1 ;//The matrix is filled with probability of 5 percent of life "1s"

			}
		}

		
	}
	/**
	 * In this function the logic of game of life
	 * @return 
	 */
	public static int[][] Automata(int[][] matriz_Automata, int width, int height)
	{
		int counter;//in this variable counts the amount of live"1s"
		
		
			for (int i = 0; i<height; i++) 
			{
				for (int j = 0; j<width; j++)
				{
					counter = matriz_Automata[(i+height-1)%height][(j+width-1)%width]+matriz_Automata[(i+height-1)%height][j]+matriz_Automata[(i+height-1)%height][(j+1)%width]
							+matriz_Automata[i][(j+width-1)%width]+matriz_Automata[i][(j+1)%width]+matriz_Automata[(i+1)%height][(j+width-1)%width]
							+matriz_Automata[(i+1)%height][j]+matriz_Automata[(i+1)%height][(j+1)%width];
					
					/*if is live"1s" and has less 2 neighbors or more of 3 neighbors, dead*/
					if (matriz_Automata[i][j]==1)
					{
						if (counter < 2 || counter > 3){
							matriz_Automata[i][j] = 0;
						}
							
					}
					else						
					{
						/*if is dead and has 3 neighbors, live*/
						if (counter == 3)
						{
							matriz_Automata[i][j]=1;
						}
					}
					
				}
			}		
			return matriz_Automata;
			
		}
	


}
