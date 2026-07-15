package org.example.entity;

public class Student {
   private int id;
   private String name;
   private String domain;

    public Student() {
    }

    public Student(int id, String name, String domain) {
        this.id = id;
        this.name = name;
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdomain() {
        return domain;
    }

    public void setdomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
