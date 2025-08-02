package javawipro;

public class typecasting{
		  public static void main(String[] args) {
		    int valInt = 9;
		    double valDouble = valInt; // Automatic casting: int to double
            System.out.println(valInt);      // Outputs 9
		    System.out.println(valDouble);   // Outputs 9.0
	
		    
		    double myDouble = 9.78d;
		    int myInt = (int) myDouble; // Manual casting: double to int

		    System.out.println(myDouble);   // Outputs 9.78
		    System.out.println(myInt);      // Outputs 9
		  }
		}
