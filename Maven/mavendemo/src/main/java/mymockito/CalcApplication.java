package mymockito;

public class CalcApplication {
calcservices cs1;
	
	public void setCs1(calcservices cs1) 
	{
		this.cs1 = cs1;
	}
	public int add_1(int input1, int input2)
	{
		 return cs1.add(input1, input2);
	}
	public int subtract_1(int input1, int input2)
	{
		   return cs1.subtract(input1, input2);
	}

	 public int multiply_1(int input1, int input2)
	 {
	    return cs1.multiply(input1, input2);
	 }
	 
	 public int divide_1(int input1, int input2)
	 {
		    return cs1.divide(input1, input2);
	 }
	

}
