package sb.employee.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sb.employee.services.entity.Employee;
import sb.employee.services.payload.Department;
import sb.employee.services.payload.EmployeeResponseDto;
import sb.employee.services.repository.EmployeeRepository;
import sb.employee.services.service.EmployeeService;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // create instance of repository
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        log.info("Inside add employee of employee service");
        return repository.save(employee);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        // Get Employee
        Employee employee = repository.findByEmployeeId(id);

        // Get Department
        Department department = restTemplate.getForObject("http://localhost:9002/api/departments/" + employee.getDepartmentId(),
                Department.class);

        // Merge and send one response
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setEmployee(employee);
        responseDto.setDepartment(department);
        log.info("Inside get employee with department of employee service");
        return responseDto;
    }
}
