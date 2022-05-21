package com.example.lab2Buch.repositories;

import com.example.lab2Buch.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    EmployeeEntity findId(int id);
}
