package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;


public class EmployeeMapper {
   public static EmployeeDto mapToEmployeeDto(Employee employee){
       return new EmployeeDto(
               employee.getId(),
               employee.getFirstname(),
               employee.getLastname(),
               employee.getEmail()
       );
   }

   public static Employee maptoEmployee(EmployeeDto emplyoeeDto){
       return new Employee(
               emplyoeeDto.getId(),
               emplyoeeDto.getFirstName(),
               emplyoeeDto.getLastName(),
               emplyoeeDto.getEmail()
       );
   }
}
