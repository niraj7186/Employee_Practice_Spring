package in.niraj.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.niraj.employee.entity.Employee;
import in.niraj.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository Emprepo;
	
	@Override
	public List<Employee> getAllEmployee(Pageable page) {
		return Emprepo.findAll(page).toList();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = Emprepo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		throw new RuntimeException("Employee not found with id "+id);
	}

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		return Emprepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Emprepo.deleteById(id);
	}

	@Override
	public Employee updateEmployeeDetails(Long id, Employee employee) {
		Employee existingEmployee = getEmployeeById(id);
		existingEmployee.setName(employee.getName() != null ? employee.getName() : existingEmployee.getName());
		existingEmployee.setDepartment(employee.getDepartment() != null ? employee.getDepartment() : existingEmployee.getDepartment());
		existingEmployee.setDesignation(employee.getDesignation() != null ? employee.getDesignation() : existingEmployee.getDesignation());
		existingEmployee.setSalary(employee.getSalary() != null ? employee.getSalary() : existingEmployee.getSalary());
		existingEmployee.setLocation(employee.getLocation() != null ? employee.getLocation() : existingEmployee.getLocation());
		existingEmployee.setDate(employee.getDate() != null ? employee.getDate() : existingEmployee.getDate());
		return Emprepo.save(existingEmployee);
	}

	@Override
	public List<Employee> readByName(String name, Pageable page) {
		 return Emprepo.findByName(name, page).toList();
	}


}
