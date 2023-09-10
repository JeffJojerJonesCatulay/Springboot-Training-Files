package sb.employee.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.employee.services.entity.Employee;
import sb.employee.services.payload.EmployeeResponseDto;

@Repository
// <Employee, Long> Name of entity and data type of primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(long empId);
}
