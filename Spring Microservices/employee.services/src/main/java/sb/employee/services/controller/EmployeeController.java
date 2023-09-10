package sb.employee.services.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.employee.services.entity.Employee;
import sb.employee.services.payload.EmployeeResponseDto;
import sb.employee.services.service.EmployeeService;

import java.util.List;

@Slf4j
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
    // create employee service
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        log.info("Inside get employee of employee controller");
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside add employee of employee controller");
        return service.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("id") Long id){
        log.info("Inside get employee by id of employee controller");
        return service.getEmployeeById(id);
    }
}
