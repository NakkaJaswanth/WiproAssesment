package com.example.hibernate.util;

import java.util.List;
import java.util.Scanner;

import com.example.hibernate.dao.StudentDAO;
import com.example.hibernate.model.Student_123;

public class StudentCRUDMain {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add  2. View  3. Update  4. Delete  5. View All ");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Student_123 s1 = new Student_123();
                   
                    System.out.print("Enter Name: ");
                    s1.setName(sc.next());
                    System.out.print("Enter Email: ");
                    s1.setEmail(sc.next());
                    dao.addStudent(s1);         
                    break;
                case 2:
                    System.out.print("Enter ID to view: ");
                    Student_123 s2 = dao.getStudent(sc.nextInt());
                    if (s2 != null) {
                        System.out.println("Name: " + s2.getName() + ", Email: " + s2.getEmail());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    Student_123 s3 = new Student_123();
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    s3.setName(sc.next());
                    System.out.print("Enter New Email: ");
                    s3.setEmail(sc.next());
                    s3.setId(upId);
                    boolean updated = dao.updateStudent(s3);
                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student with ID " + upId + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = dao.deleteStudent(delId);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student with ID " + delId + " not found.");
                    }
                    break;
                case 5:
                    List<Student_123> list = dao.getAllStudents();
                    for (Student_123 s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
                    }
                    break;
                case 6:
                    sc.close();
                    System.exit(0);

                    
            }
        }

	}

}



