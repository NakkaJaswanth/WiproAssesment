package javawipro;
import java.util.Scanner;

public class question8 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of classes held: ");
        int totalClasses = scanner.nextInt();
        System.out.print("Enter number of classes attended: ");
        int attendedClasses = scanner.nextInt();
        if (totalClasses <= 0 || attendedClasses < 0 || attendedClasses > totalClasses) {
            System.out.println("Invalid input. Please check class numbers.");
        } else {
            double attendancePercentage = ((double) attendedClasses / totalClasses) * 100;

            System.out.printf("Attendance percentage: %.2f%%\n", attendancePercentage);

        
            System.out.print("Do you have a medical cause? (Y/N): ");
            char medicalCause = scanner.next().charAt(0);

            if (attendancePercentage >= 70 || medicalCause == 'Y' || medicalCause == 'y') {
                System.out.println("The student is allowed to sit in the exam.");
            } else {
                System.out.println("The student is NOT allowed to sit in the exam.");
            }
        }

       
        scanner.close();
    }
}

