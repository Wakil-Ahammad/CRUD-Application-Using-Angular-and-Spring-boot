package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceimpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto emplyoeeDto) {
       Employee employee = EmployeeMapper.maptoEmployee(emplyoeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId)
        );

        employee.setFirstname(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee savedupdatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedupdatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }


}
