package sb.employee.services.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sb.employee.services.entity.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto{
    private Employee employee;
    private Department department;
}