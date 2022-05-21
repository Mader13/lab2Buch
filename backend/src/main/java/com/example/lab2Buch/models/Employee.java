package com.example.lab2Buch.models;

import com.example.lab2Buch.entities.EmployeeEntity;

public class Employee {
    private int id;
    private int cash;
    private float salary;
    private String lastName;
    private String firstName;
    private LocalDate lastEnroll;

    public static Employee toModel(EmployeeEntity entity) {
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setLastEnroll(entity.getLastEnroll());
        model.setSalary(entity.getSalary());
        model.setCash(entity.getCash());
        return model;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Employee() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getLastEnroll() {
        return lastEnroll;
    }

    public void setLastEnroll(LocalDate lastEnroll) {
        this.lastEnroll = lastEnroll;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
