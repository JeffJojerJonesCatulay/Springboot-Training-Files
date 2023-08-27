package sb.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.rest.api.entity.Employee;
import sb.rest.api.service.EmployeeService;

@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
	// create employee service
	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id){
		return service.getEmployeeById(id);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee){
		return service.addEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
		service.updateEmployee(id, employee);
		return "Record successfully updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") Long id){
		service.deleteEmployee(id);
		return "Record deleted updated";
	}
}
