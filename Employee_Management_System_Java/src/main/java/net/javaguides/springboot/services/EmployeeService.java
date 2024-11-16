package net.javaguides.springboot.services;

import net.javaguides.springboot.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmplyeeById(Long employeeId);

    List<EmployeeDto> getAllEmplyees();
    EmployeeDto updateEmployee(Long emplyeeId, EmployeeDto updateEmployee);
    void deleteEmploye(Long employeeId);


}
