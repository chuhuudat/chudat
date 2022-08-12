package com.example.demo.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;


@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long>{

}
