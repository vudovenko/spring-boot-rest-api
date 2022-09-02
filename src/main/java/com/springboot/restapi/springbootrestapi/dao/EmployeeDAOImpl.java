package com.springboot.restapi.springbootrestapi.dao;

import com.springboot.restapi.springbootrestapi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee(Employee employee) {
        var session = entityManager.unwrap(Session.class);

        var query= session
                .createQuery("from Employee", Employee.class);
        var allEmployees = query.getResultList();

        return allEmployees;
    }
}