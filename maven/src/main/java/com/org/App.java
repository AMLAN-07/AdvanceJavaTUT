package com.org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App");
        EntityManager em = emf.createEntityManager();

        Student student = new Student(1L,"Dipak",21);
        em.getTransaction().begin();
//        em.persist(student);
//        em.merge(student);
        Student student2 = em.find(Student.class, 1L);
        
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println(student);
    }
}
