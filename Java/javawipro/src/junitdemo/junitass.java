package junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class junitass {
	    public static long factorial(int n) {
	        if (n < 0) {
	            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
	        }
	        long result = 1;
	        for (int i = 2; i <= n; i++) {
	            result *= i;
	        }
	        return result;
	    }
	


		    @Test
	    public void testFactorialValidInputs() {
	        assertEquals(1, junitass.factorial(0));
	        assertEquals(1, junitass.factorial(1));
	        assertEquals(2, junitass.factorial(2));
	        assertEquals(6, junitass.factorial(3));
	        assertEquals(24, junitass.factorial(4));
	        assertEquals(120,junitass.factorial(5));
	       
	    }

	    @Test
	    public void testFactorialNegativeInput() {
	        assertThrows(IllegalArgumentException.class, () -> junitass.factorial(-1));
	        assertThrows(IllegalArgumentException.class, () -> junitass.factorial(-10));
	    }
	}



