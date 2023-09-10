package sb.employee.services.service;

import org.springframework.stereotype.Service;
import sb.employee.services.entity.Employee;
import sb.employee.services.payload.EmployeeResponseDto;

import java.util.List;

@Service
public interface EmployeeService {
    // interface methods
    public List<Employee> getAllEmployees();
    public Employee addEmployee(Employee employee);
    public EmployeeResponseDto getEmployeeById(Long id);
}
