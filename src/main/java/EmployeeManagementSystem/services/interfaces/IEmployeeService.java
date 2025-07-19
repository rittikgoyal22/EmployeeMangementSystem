package EmployeeManagementSystem.services.interfaces;

import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.dto.LoginRequestDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeResponseDto getById(Long id);

    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto);

    String deleteEmployee(Long id);

    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto);

    String loginEmployee(LoginRequestDto loginRequestDto);
}
