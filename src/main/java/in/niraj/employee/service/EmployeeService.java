package in.niraj.employee.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import in.niraj.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee(Pageable page);
	
	Employee getEmployeeById(Long id);
	
	Employee saveEmployeeDetails(Employee employee);
	
	void deleteEmployeeById(Long id);
	
	Employee updateEmployeeDetails(Long id, Employee employee);
	
	List<Employee> readByName(String name, Pageable page);
}
