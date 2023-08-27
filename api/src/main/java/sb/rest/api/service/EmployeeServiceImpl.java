package sb.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import sb.rest.api.entity.Employee;
import sb.rest.api.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	// create instance of repository
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public void updateEmployee(Long id, Employee employee) {
		Employee employeeDb = repository.findById(id).get();
		employeeDb.setName(employee.getName());
		employeeDb.setEmail(employee.getEmail());
		repository.save(employeeDb);
	}

	@Override
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}
	
}
