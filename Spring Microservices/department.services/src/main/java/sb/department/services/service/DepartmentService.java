package sb.department.services.service;

import org.springframework.stereotype.Service;
import sb.department.services.entity.Department;

import java.util.List;

@Service
public interface DepartmentService {
    // interface methods
    public List<Department> getAllDepartments();
    public Department addDepartments(Department department);
    public Department getDepartmentsById(Long id);
}
