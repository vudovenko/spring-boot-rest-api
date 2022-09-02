package com.springboot.restapi.springbootrestapi.service;


import com.springboot.restapi.springbootrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
