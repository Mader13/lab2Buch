package com.example.lab2Buch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.lab2Buch.entities.EmployeeEntity;
import com.example.lab2Buch.models.Employee;
import com.example.lab2Buch.repositories.EmployeeRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Async
    @Scheduled(fixedRate = 1750)
    public EmployeeEntity enrollSalary() {
        var employees = employeeRepository.findAll();
        LocalDate now = LocalDate.now();
        for(var employee : employees) {
            if(ChronoUnit.DAYS.between(employee.getLastEnroll(), now) == 31) {
                employee.setLastEnroll(now);
                employee.setCash( employee.getSalary() + employee.getCash() );
                employeeRepository.save(employee);
            }
        }
        return null;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employer) {
        return employeeRepository.save(employer);
    }

    public Employee getEmployeeId(int id) throws Exception {
        EmployeeEntity employee = employeeRepository.findById(id);
        if(employee == null)
            throw new Exception("Wrong ID");
        return Employee.toModel(employee);
    }

    public ArrayList<Employee> getAll() {
        var employees = employeeRepository.findAll();
        ArrayList<Employee> list = new ArrayList<Employee>();
        for(var emp : employees)
            list.add(Employee.toModel(emp));
        return list;
    }



}
