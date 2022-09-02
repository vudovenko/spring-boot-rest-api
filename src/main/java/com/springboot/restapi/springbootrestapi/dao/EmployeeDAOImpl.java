package com.springboot.restapi.springbootrestapi.dao;

import com.springboot.restapi.springbootrestapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        var query = entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
         var newEmployee = entityManager.merge(employee);
         employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        var employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        var query = entityManager.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}