package com.app.cruddemo.dao;

import com.app.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field entity manager
    private EntityManager em;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent)
    {
        this.em.persist(theStudent);
    }

    @Override
    @Transactional
    public Student  findById(int id)
    {
        return this.em.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> query = em.createQuery("FROM Student ORDER BY lastName", Student.class);
        //return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = em.createQuery("FROM Student WHERE lastName = :lastname", Student.class);

        //set parameter
        query.setParameter("lastname", lastName);

        //return query
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.em.merge(student);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        Student students = em.find(Student.class, id);
        em.remove(students);
    }

    @Override
    @Transactional
    public int removeAll() {

        int numRowsDeleted = em.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

}
