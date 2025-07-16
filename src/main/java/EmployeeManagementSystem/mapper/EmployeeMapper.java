package EmployeeManagementSystem.mapper;

import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResponseDto entityToResponseDto(Employee employee)
    {
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .build();
    }

    public Employee requestDtoToEntity(EmployeeRequestDto employeeRequestDto)
    {
        return Employee.builder()
                .firstName(employeeRequestDto.getFirstName())
                .lastName(employeeRequestDto.getLastName())
                .email(employeeRequestDto.getEmail())
                .salary(employeeRequestDto.getSalary())
                .build();
    }

    public Employee updateEmployee(Employee employee, EmployeeRequestDto employeeRequestDto)
    {
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setSalary(employeeRequestDto.getSalary());
        return employee;
    }
}
