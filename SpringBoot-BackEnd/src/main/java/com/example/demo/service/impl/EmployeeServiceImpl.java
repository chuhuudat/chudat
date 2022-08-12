package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repositiory.EmployeesRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private  EmployeesRepository employeesRepository; 
	
	public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
		super();
		this.employeesRepository = employeesRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeesRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeesRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeesRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee exiEmployee = employeesRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		exiEmployee.setFirstName(employee.getFirstName());
		exiEmployee.setLastName(employee.getLastName());
		exiEmployee.setEmail(employee.getEmail());
		employeesRepository.save(exiEmployee);
		return exiEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		employeesRepository.findById(id).orElseThrow(()-> 
				new ResourceNotFoundException("Employee", "Id", id));
		employeesRepository.deleteById(id);
		
	}




}
