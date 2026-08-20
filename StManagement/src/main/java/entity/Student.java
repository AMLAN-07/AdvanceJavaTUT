package entity;

public class Student {
    private  int id;
    private  String name;
    private  String email;
    private int regdno;
    private  String password;

    public Student() {
    }

    public Student(int id, String name, String email, int regdno, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.regdno = regdno;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRegdno() {
        return regdno;
    }

    public void setRegdno(int regdno) {
        this.regdno = regdno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
