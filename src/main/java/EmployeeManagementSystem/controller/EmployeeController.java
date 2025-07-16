package EmployeeManagementSystem.controller;

import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.services.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee-service/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @GetMapping("/employee/{id}")
    public EmployeeResponseDto getById(@PathVariable("id") Long id)
    {
        logger.info("Inside Employee Controller : getById method");
        return employeeService.getById(id);
    }

    @GetMapping("/employee")
    public List<EmployeeResponseDto> getAllEmployee()
    {
        logger.info("Inside Employee Controller : getAllEmployee method");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto)
    {
        logger.info("Inside Employee Controller : addEmployee method");
        return employeeService.addEmployee(employeeRequestDto);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id)
    {
        logger.info("Inside Employee Controller : deleteEmployee method");
        return employeeService.deleteEmployee(id);
    }

    @PatchMapping("/employee/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequestDto employeeRequestDto)
    {
        logger.info("Inside Employee Controller : updateEmployee method");
        return employeeService.updateEmployee(id, employeeRequestDto);
    }

}
