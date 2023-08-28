package api.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.rest.entity.Employee;

@Service
public interface EmployeeService {
    // interface methods
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public Employee addEmployee(Employee employee);
    public void updateEmployee(Long id, Employee employee);
    public void deleteEmployee(Long id);
}
