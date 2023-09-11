package sb.department.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.department.services.entity.Department;
import sb.department.services.repository.DepartmentRepository;
import sb.department.services.service.DepartmentService;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department addDepartments(Department department) {
        log.info("Inside add department of department service");
        return repository.save(department);
    }

    @Override
    public Department getDepartmentsById(Long id) {
        log.info("Inside get department with department id of department service");
        return repository.findByDepartmentId(id);
    }
}
