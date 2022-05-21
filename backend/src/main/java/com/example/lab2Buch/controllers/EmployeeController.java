package com.example.lab2Buch.controllers;
import java.util.ArrayList;
import com.example.lab2Buch.entities.EmployeeEntity;
import com.example.lab2Buch.models.Employee;
import com.example.lab2Buch.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employerService;
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        try {
            Employee employee = employerService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody EmployeeEntity employee) {
        try {
            employerService.addEmployee(employee);
            return ResponseEntity.ok("Employee has been saved.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            ArrayList<Employee> employees = employerService.getAll();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }


}
