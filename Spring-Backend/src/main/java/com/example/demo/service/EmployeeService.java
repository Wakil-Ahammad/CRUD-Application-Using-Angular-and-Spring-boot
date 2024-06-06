package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto>getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
