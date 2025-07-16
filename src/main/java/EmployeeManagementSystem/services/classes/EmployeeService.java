package EmployeeManagementSystem.services.classes;

import EmployeeManagementSystem.dao.EmployeeRepo;
import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.entity.Employee;
import EmployeeManagementSystem.mapper.EmployeeMapper;
import EmployeeManagementSystem.services.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeResponseDto getById(Long id)
    {
        Employee employee =  employeeRepo.findById(id).orElse(Employee.builder().build());
        return employeeMapper.entityToResponseDto(employee);
    }

    public List<EmployeeResponseDto> getAllEmployees()
    {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
        for(Employee e : employees)
            employeeResponseDtos.add(employeeMapper.entityToResponseDto(e));
        return employeeResponseDtos;
    }

    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto)
    {
        Employee employee = employeeMapper.requestDtoToEntity(employeeRequestDto);
        employee = employeeRepo.save(employee);
        return employeeMapper.entityToResponseDto(employee);
    }

    public String deleteEmployee(Long id)
    {
        employeeRepo.deleteAllById(Collections.singleton(id));
        return "Id "+id+" has been deleted successfully";
    }

    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto)
    {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong Employee ID"));
        employee = employeeMapper.updateEmployee(employee, employeeRequestDto);
        employee = employeeRepo.save(employee);
        return employeeMapper.entityToResponseDto(employee);
    }
}
