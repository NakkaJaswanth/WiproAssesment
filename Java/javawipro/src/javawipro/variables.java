package javawipro;

public class variables {
	public static void main(String[] args) {
	/*int myNum = 15;
	System.out.println(myNum);*/
	
	int myNum = 15;
	myNum = 20;  
	System.out.println(myNum);
	float f1 = 35e3f;
    double d1 = 12E4d;
    System.out.println(f1);
    System.out.println(d1);
    char myVar1 = 65, myVar2 = 66, myVar3 = 67;
    System.out.println(myVar1);
    System.out.println(myVar2);
    System.out.println(myVar3);
    int items = 50;
    float costPerItem = 9.99f;
    float totalCost = items * costPerItem;
    char currency = '$';

    // Print variables
    System.out.println("Number of items: " + items);
    System.out.println("Cost per item: " + costPerItem + currency);
    System.out.println("Total cost = " + totalCost + currency);
	}
}
