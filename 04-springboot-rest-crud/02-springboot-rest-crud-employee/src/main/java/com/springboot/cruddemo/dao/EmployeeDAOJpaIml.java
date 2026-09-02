package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class EmployeeDAOJpaIml implements EmployeeDAO {

    //define field
    private EntityManager em;

    //constructor injection
    @Autowired
    public EmployeeDAOJpaIml(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = em.createQuery("from Employee", Employee.class);
        //execute the query and get list
        List<Employee> theList = theQuery.getResultList();
        //return it
        return theList;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee theEmployee = em.find(Employee.class, id);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //save employee
        Employee theEmployee = em.merge(employee);
        //return employee
        return theEmployee;
    }

    @Override
    public void delete(int id) {
        //delete the employee
        Employee theEmployee = em.find(Employee.class, id);
        em.remove(theEmployee);

    }
}
