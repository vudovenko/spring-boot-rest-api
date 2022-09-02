package com.springboot.restapi.springbootrestapi.controller;

import com.springboot.restapi.springbootrestapi.entity.Employee;
import com.springboot.restapi.springbootrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        var allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
}