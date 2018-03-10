package Fractal;

import processing.core.PApplet;

public class GUI_Fractal extends PApplet{
	
	/**
	 * Main of the API processing
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("Fractal.GUI_Fractal");
	}
	Logic logic = new Logic();
	
	/**
	 * Create the canvas
	 */
	public void settings() {
		size(6*logic.width, 6*logic.height);
	}
	
	/**
	 * paint in the canvas
	 */
	public void draw() {
		background(250);
		
			for(int i=0;i<logic.height; i++) {
				for(int j=0; j<logic.width; j++) {
					if(logic.board[i][j]==1 ) {
						fill(93,173,226);//paint blue
					}
					else {
						fill(241,186,15);//paint yellow
					}

					rect(i*6, j*6, 6,6);	
				}
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e){e.printStackTrace();}	
			}
		
	}
	
}
