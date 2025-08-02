package javawipro;

public class condinationalstmts {
	public static void main(String[] args) {
		int x = 20;
		int y = 18;
		if (x > y) {
		  System.out.println("x is greater than y");
		  int time = 20;
		  if (time < 18) {
		    System.out.println("Good day.");
		  } else {
		    System.out.println("Good evening.");
		  }
		  int age = 20;
		  String result = (age < 18) ? "minor." : "major.";
		  System.out.println(result);
		  /*int i = 0;
		  while (i < 5) {
		    System.out.println(i);
		    i++;
		  }
		  int j = 10;
		  do {
		    System.out.println("j is " + j);
		    i++;
		  } while (j < 5);
		  int sum = 0;
		  for (int k = 1; k <= 5; k++) {
		    sum = sum + k;
		  }
		  System.out.println("Sum is " + sum);
		}*/
		  for (int i = 1; i <= 3; i++) {
			  for (int j = 1; j <= 3; j++) {
			    System.out.print(i * j + " ");
			  }
			  System.out.println();
			}
			
		}
	}
}


