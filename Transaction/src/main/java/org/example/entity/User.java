package org.example.entity;

public class User {
    private int accountNo;
    private String name;
    private Double balance;

    public User() {
    }

    public User(int accountNo, String name, Double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Person{" +
                "accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
