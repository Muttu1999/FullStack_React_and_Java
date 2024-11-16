package net.javaguides.springboot.services.impl;

import exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import mappae.EmployeeMappae;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee =EmployeeMappae.mapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMappae.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmplyeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new  ResourceNotFoundException("Employee is exists with a given id:"+employeeId));

        return EmployeeMappae.mapToEmployeeDto(employee);


    }

    @Override
    public List<EmployeeDto> getAllEmplyees() {
         List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMappae.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long emplyeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(emplyeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given id is not existed:" + emplyeeId));


        employee.setFirstNmae(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updatedEmployeObj = employeeRepository.save(employee);
        return EmployeeMappae.mapToEmployeeDto(updatedEmployeObj);
    }

    @Override
    public void deleteEmploye(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given id is not existed:" + employeeId));
        employeeRepository .deleteById(employeeId);
    }
}
