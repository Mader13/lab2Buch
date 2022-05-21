package com.example.lab2Buch.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
public class EmployeeEntity {
    @Id
    private int id;
    private String lastName;
    private String firstName;
    private int salary;
    private int cash;
    private LocalDate lastEnroll;



    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeEntity() {
    }

    public LocalDate getLastEnroll() {
        return lastEnroll;
    }

    public void setLastEnroll(LocalDate lastEnroll) {
        this.lastEnroll = lastEnroll;
    }
}
