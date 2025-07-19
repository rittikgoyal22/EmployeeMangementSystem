package EmployeeManagementSystem.mapper;

import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.entity.Employee;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public EmployeeResponseDto entityToResponseDto(Employee employee)
    {
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .password(employee.getPassword())
                .build();
    }

    public Employee requestDtoToEntity(EmployeeRequestDto employeeRequestDto)
    {
        return Employee.builder()
                .firstName(employeeRequestDto.getFirstName())
                .lastName(employeeRequestDto.getLastName())
                .email(employeeRequestDto.getEmail())
                .salary(employeeRequestDto.getSalary())
                .password(encoder.encode(employeeRequestDto.getPassword()))
                .build();
    }

    public Employee updateEmployee(Employee employee, EmployeeRequestDto employeeRequestDto)
    {
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setSalary(employeeRequestDto.getSalary());
        employee.setPassword(encoder.encode(employeeRequestDto.getPassword()));
        return employee;
    }
}
