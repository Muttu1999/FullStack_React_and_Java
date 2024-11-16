package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private EmployeeService employeeService;

    //build add employee Rest API
    //http://localhost:8080/api/employees

    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmplyee =employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(savedEmplyee, HttpStatus.CREATED);
    }

    //Build get employee rest api
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long   employeeId){
        EmployeeDto employeeDto = employeeService.getEmplyeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }


    // Build getall employees rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees( ){
        List<EmployeeDto> employees= employeeService.getAllEmplyees();
        return ResponseEntity.ok(employees);
    }

    //Build update employee rest api
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeID,
                                                       @RequestBody  EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeID, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build delete employee rest api
    //http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmploye(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");

    }

}
