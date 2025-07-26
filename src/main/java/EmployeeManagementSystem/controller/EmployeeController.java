package EmployeeManagementSystem.controller;

import EmployeeManagementSystem.dto.EmployeeRequestDto;
import EmployeeManagementSystem.dto.EmployeeResponseDto;
import EmployeeManagementSystem.dto.LoginRequestDto;
import EmployeeManagementSystem.services.interfaces.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee-service/v1/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @PostMapping("/login")
    public ResponseEntity<String> loginEmployee(@RequestBody LoginRequestDto loginRequestDto)
    {
        logger.info("Inside Employee Controller : loginEmployee method");
        return ResponseEntity.ok(employeeService.loginEmployee(loginRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto)
    {
        logger.info("Inside Employee Controller : addEmployee method");
        return ResponseEntity.ok(employeeService.addEmployee(employeeRequestDto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_IT')")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable("id") Long id)
    {
        logger.info("Inside Employee Controller : getById method");
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee()
    {
        logger.info("Inside Employee Controller : getAllEmployee method");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id)
    {
        logger.info("Inside Employee Controller : deleteEmployee method");
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequestDto employeeRequestDto)
    {
        logger.info("Inside Employee Controller : updateEmployee method");
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequestDto));
    }

}
