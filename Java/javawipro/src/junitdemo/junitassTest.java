package junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class junitassTest {

	    public static String reverse(String input) {
	        if (input == null) {
	            throw new IllegalArgumentException("Input cannot be null");
	        }
	        return new StringBuilder(input).reverse().toString();
	    }
	

    @Test
    public void testReverseRegularString() {
        assertEquals("olleh", junitassTest.reverse("hello"));
        assertEquals("321cba", junitassTest.reverse("abc123"));
        assertEquals("A", junitassTest.reverse("A"));
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", junitassTest.reverse(""));
    }

    @Test
    public void testReverseNullInput() {
        assertThrows(IllegalArgumentException.class, () -> junitassTest.reverse(null));
    }
}

