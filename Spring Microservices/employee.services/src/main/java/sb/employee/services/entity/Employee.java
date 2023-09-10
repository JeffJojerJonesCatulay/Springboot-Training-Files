package sb.employee.services.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Create getter and setter
@AllArgsConstructor // Create parametized constructor
@NoArgsConstructor // empty constructor
@Entity
public class Employee{
    // specifying that the field id is primary key and auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
