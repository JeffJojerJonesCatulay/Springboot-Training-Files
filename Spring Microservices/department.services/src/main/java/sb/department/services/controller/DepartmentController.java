package sb.department.services.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.department.services.entity.Department;
import sb.department.services.repository.DepartmentRepository;
import sb.department.services.service.DepartmentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getAllDepartments(){
        log.info("Inside get department of department controller");
        return service.getAllDepartments();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside add department of department controller");
        return service.addDepartments(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        log.info("Inside get department by department id of department controller");
        return service.getDepartmentsById(id);
    }
}
