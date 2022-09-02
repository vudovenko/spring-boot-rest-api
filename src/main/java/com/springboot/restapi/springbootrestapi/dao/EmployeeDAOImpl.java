package com.springboot.restapi.springbootrestapi.dao;

import com.springboot.restapi.springbootrestapi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
        var session = entityManager.unwrap(Session.class);

        var query = session
                .createQuery("from Employee", Employee.class);
        var allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        var session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        var session = entityManager.unwrap(Session.class);
        var employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        var session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}