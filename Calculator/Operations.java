package Calculator;

public class Operations {
	
	/**
	 * return the sum of the parameters
	 * @param number_1
	 * @param number_2
	 * @return
	 */
	public int addition(int number_1, int number_2)
	{
		return number_1+number_2;
	}
	
	/**
	 * Return subtraction of the parameters
	 * @param number_1
	 * @param number_2
	 * @return
	 */
	public int subtraction(int number_1, int number_2)
	{
		return number_1-number_2;
	}
	
	/**
	 * Return multiplication of the parameters
	 * @param number_1
	 * @param number_2
	 * @return
	 */
	public int multiplication(int number_1, int number_2)
	{
		return number_1*number_2;
	}
	
	/**
	 * Return division of the parameters
	 * @param number_1 // numerator
	 * @param number_2 // denominator
	 * @return
	 */
	public double division(int number_1, int number_2)
	{
		// Division by zero is no possble
		if(number_2 != 0)
		{
			return (double)number_1/number_2;
		}
		else
			return Double.NaN;
	}
	
	/**
	 * Return the remainder of the parameters
	 * @param number_1 // numerator
	 * @param number_2 // denominator
	 * @return
	 */
	public double residue(int number_1, int number_2)
	{
		if(number_2 != 0)
		{
			return (double)number_1%number_2;
		}
		else
			return Double.NaN;
	}
	
	/**
	 * Return the factorial of the parameter
	 * @param number_1
	 * @return
	 */
	public int factorial(int number_1)
	{
		int solution=1;
        if (number_1 == 0){
            return 1;
        }else
        for (int i=1; i<=number_1; i++){
            solution = solution*i;
        }
        return solution;
	}
	
	/**
	 * Return the empowerment of the parameters
	 * @param number_1 // base
	 * @param number_2 // Exponent
	 * @return
	 */
	public double exponent(int number_1, int number_2)
	{
		if (number_2 == 0){
            return 1;
        }else if (number_2 == 1){
            return number_1;
        }else if (number_2 > 1){
            return (double) Math.pow(number_1, number_2);
        }else 
            return 1/(double) Math.pow(number_1,(number_2 * -1));
	}
	
	/**
	 * Return sine of the parameter
	 * @param number_1
	 * @return
	 */
	public double sine(int number_1)
	{
		return Math.sin(number_1*Math.PI/180);
	}
	
	/**
	 * Return cosine of the parameter
	 * @param number_1
	 * @return
	 */
	public double cosine(int number_1)
	{
		if(number_1 == 90)
		{
			return 0.0;
		}
		else
			return Math.cos(Math.toRadians(number_1));
	}
	
	/**
	 * Return integral riemann sum 
	 * @param number_1 // Start point
	 * @param number_2 // Final point
	 * @param number_3 // increment
	 * @return
	 */
	public double integral(int number_1, int number_2, int number_3)
	{
		double response = 0.0;
        double temp;
        int x_i, x_i_1, y_i;
        x_i_1= number_1;
        x_i = number_3 + x_i_1;
        
        for (int i=x_i; i<= number_2; i+=number_3){   
            y_i= (x_i_1*x_i_1);
            temp = (y_i)+(x_i-x_i_1);
            response += temp;
            // sum area of the rectangle
            x_i_1 = x_i;
            x_i = number_3 + x_i_1;
        }
        
        return response;
	}
}
