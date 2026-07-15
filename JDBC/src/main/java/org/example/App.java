package org.example;

import java.util.Scanner;

import org.example.CURD.CurdOperation;
import org.example.entity.Student;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CurdOperation CURD = new CurdOperation();

        while (true) {

            System.out.println("\n===== WELCOME TO MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View Student by ID");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                

                case 1-> {

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Domain: ");
                    String domain = sc.nextLine();
                    CURD.addStudent(new Student(id, name, domain));
                }

                case 2 -> CURD.getAllStudents();

                case 3 -> {
                    System.out.print("Enter Student ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Domain: ");
                    String domain = sc.nextLine();
                   
                    CURD.updateStudent(id, name, domain);
                }
                case 4 -> {
                    System.out.print("Enter Student ID to Delete: ");
                    int id = sc.nextInt();
                    CURD.deleteStudent(id);
                }

                case 5 -> {
                    System.out.print("Enter Student ID to View: ");
                    int id = sc.nextInt();
                    CURD.getStudentById(id);
                }

                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid Choice! Please Try Again.");
            }
        }
     
    }
}