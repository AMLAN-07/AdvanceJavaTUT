package org.example;


import org.example.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student s1=context.getBean(Student.class);

        System.out.println(s1.getName()+" "+s1.getAddress());
    }



}
