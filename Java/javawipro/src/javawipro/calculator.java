package javawipro;
public class calculator {
    public void add(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
    }
    public void diff(int num1, int num2) {
        int result = num1 - num2;
        System.out.println("The difference between " + num1 + " and " + num2 + " is: " + result);
    }
    public void mul(int num1, int num2) {
        int result = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + result);
    }
    public void div(int num1, int num2) {
            double result = (double) num1 / num2;
            System.out.println("The division of " + num1 + " by " + num2 + " is: " + result);
        }
    
public static void main(String[] args) {
        calculator calc = new calculator();
        calc.add(10, 5);
        calc.diff(10, 5);
        calc.mul(10, 5);
        calc.div(10, 5);
    }
}
