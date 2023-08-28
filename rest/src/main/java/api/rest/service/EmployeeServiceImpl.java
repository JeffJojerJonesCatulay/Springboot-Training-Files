package api.rest.service;

import api.rest.entity.Employee;
import api.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
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
        //employeeDb.setName(employee.getName());
        //employeeDb.setEmail(employee.getEmail());
        repository.save(employeeDb);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
