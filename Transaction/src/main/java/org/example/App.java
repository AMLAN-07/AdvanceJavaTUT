package org.example;


import org.example.CURD.CurdOperation;
import org.example.Service.service;
import org.example.entity.User;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        CurdOperation CURD = new CurdOperation();
        service service = new service();

        while (true) {

            System.out.println("\n======WELCOME TO SBI======");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Update Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Deposit Money");
            System.out.println("7. Withdraw Money");
            System.out.println("8. Transfer Money");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Account No: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Balance: ");
                    Double balance = sc.nextDouble();
                    CURD.createUser(new User(id, name, balance));

                }

                case 2 -> CURD.getAllUsers();

                case 3 -> {
                    System.out.print("Enter Account to View: ");
                    int id = sc.nextInt();
                    CURD.searchUser(id);
                }
                case 4 -> {
                    System.out.print("Enter Account to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter balance: ");
                    Double balance = sc.nextDouble();

                    CURD.updateUser(new User(id, name, balance));
                }
                case 5 -> {
                    System.out.print("Enter Account to Delete: ");
                    int id = sc.nextInt();
                    CURD.deleteUser(id);
                }
                case 6 -> {
                    System.out.print("Enter Account to Deposit: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Your Deposit Amount: ");
                    Double balance = sc.nextDouble();
                    service.deposit(id, balance);
                }
                case 7 -> {
                    System.out.print("Enter Account to Deposit: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Your Withdraw Amount: ");
                    Double balance = sc.nextDouble();
                    service.withdraw(id, balance);
                }
                case 8 -> {
                    System.out.print("Comming Soon........... ");

                }
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid Choice! Please Try Again.");
            }
        }

    }
}
