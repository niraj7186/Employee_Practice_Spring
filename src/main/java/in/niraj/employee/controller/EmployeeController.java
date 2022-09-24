package in.niraj.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.niraj.employee.entity.Employee;
import in.niraj.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService Empservice;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(Pageable page)
	{
		return Empservice.getAllEmployee(page);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return Empservice.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployeeDetails(@Valid @RequestBody Employee employee)
	{
		return Empservice.saveEmployeeDetails(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable Long id)
	{
		Empservice.deleteEmployeeById(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployeeDetails(@RequestBody Employee employee, @PathVariable Long id)
	{
		return Empservice.updateEmployeeDetails(id, employee);
	}
	
	@GetMapping("/employee/name")
	public List<Employee> getEmployeeByName(@RequestParam String name, Pageable page)
	{
		return Empservice.readByName(name, page);
	}
}
