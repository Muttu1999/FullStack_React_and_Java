package mappae;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;

public class EmployeeMappae {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getFirstNmae()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
