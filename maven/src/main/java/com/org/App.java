package com.org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Update Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Exit");
            System.out.print("\n Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    add();
                }
            }

        } while (choice != 4);
    }
//        Student student = new Student(1L,"Dipak",21);
//        em.getTransaction().begin();
////        em.persist(student);
////        em.merge(student);
//        Student student2 = em.find(Student.class, 1L);
//
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();
//        System.out.println(student);

    public static boolean add(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your ID");
        Long id=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter your age");
        int age=sc.nextInt();
        Student s=new Student(id,name,age);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println(s);
        System.out.println("Student "+id+" has been created");
        return true;
    }
}
