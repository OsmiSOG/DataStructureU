package GameOfLife;

import processing.core.PApplet;

public class GUIProcessing extends PApplet{
	
	// square seize, width and height 
	int square_size = 7, width = 100, height = 100; 
	
	/**
	 * Method main whit main processing
	 * @param args
	 */
	public static void main(String[] args) {		
		PApplet.main("GameOfLife.GUIProcessing");
	}
	
	Logic logic = new Logic(width, height); 
	
	/**
	 * In this method from processing is creates of canvas
	 */
	public void settings ()
	{
		size(width*square_size, height*square_size);
	}

	/**
	 * This function draw is a cycle infinity
	 * 
	 */
	public void draw ()
	{
		int counter;
			
			/*To travel the matrix*/
			for (int i=0; i<height; i++){
				for(int j=0; j<width; j++)
				{ 
					
					if(logic.Matriz_Automata[i][j] == 1){
						/* if is live"1" paint blue */
						fill(133,193,233);
					}
					else {
						/* if is dead paint white */
						fill(240);
					}
					
					/* logic of game */
					counter = logic.Matriz_Automata[(i+height-1)%height][(j+width-1)%width]+logic.Matriz_Automata[(i+height-1)%height][j]+logic.Matriz_Automata[(i+height-1)%height][(j+1)%width]
							+logic.Matriz_Automata[i][(j+width-1)%width]+logic.Matriz_Automata[i][(j+1)%width]+logic.Matriz_Automata[(i+1)%height][(j+width-1)%width]
							+logic.Matriz_Automata[(i+1)%height][j]+logic.Matriz_Automata[(i+1)%height][(j+1)%width];
					
					/*if is live"1s" and has less 2 neighbors or more of 3 neighbors, dead*/
					if (logic.Matriz_Automata[i][j]==1)
					{
						if (counter < 2 || counter > 3){
							logic.Matriz_Automata[i][j] = 0;
						}
							
					}
					else 
					{
						/*if is dead and has 3 neighbors, live*/
						if (counter == 3)
						{
							logic.Matriz_Automata[i][j]=1;
						}
					}
					rect(j*square_size, i*square_size,square_size,square_size);
				}
				try
				{
					Thread.sleep(1);//more slow speed
				}
				catch (InterruptedException e){e.printStackTrace();}
			}
		}
}
