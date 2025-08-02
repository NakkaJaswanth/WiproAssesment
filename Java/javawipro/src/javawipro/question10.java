package javawipro;
import java.util.Scanner;

public class question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of eggs: ");
        int totalEggs = scanner.nextInt();

      
        int gross = totalEggs / 144;
        int remainingAfterGross = totalEggs % 144;
        int dozen = remainingAfterGross / 12;
        int leftover = remainingAfterGross % 12;

     
        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + leftover);

        scanner.close();
    }
}
