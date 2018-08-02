package com.company;

public class Customer {

    private String name;
    private int id;
    private double amount;

    static int count = 100;


    public Customer() {
        super();
    }

    public Customer(String name, double amount) {
        super();
        this.id = count++;
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return " id: " + id + "  name: " + name + "  Amount: "+ amount + "  ";
    }
}
