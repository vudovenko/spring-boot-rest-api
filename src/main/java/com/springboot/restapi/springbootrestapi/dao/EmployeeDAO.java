package com.springboot.restapi.springbootrestapi.dao;

import com.springboot.restapi.springbootrestapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
}
