package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Employee;
import com.example.demo1.exception.ResourceNotFoundException;
import com.example.demo1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(
						()-> new ResourceNotFoundException("Employee", "Id", id));
		emp.setFirst_name(employee.getFirst_name());
		emp.setLast_name(employee.getLast_name());
		emp.setEmail(employee.getEmail());
		employeeRepository.save(emp);
		return emp;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow( 
				()-> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
