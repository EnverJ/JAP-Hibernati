package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class jpaPersistenceContextDemo {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("new employee");
        employee.setSsn("233ss");
        employee.setDob(new Date());
        employee.setAge(24);
        employee.setType(EmployeeType.FULL_TIME);
        System.out.println("*****************Create employee instance********");

        // create an entity manager factory. is a service to manage @Entity (data holder)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class, and it will connect to persistence.xml
        EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("************Starting transition**********");


        entityManager.persist(employee);
        System.out.println("************After Persist method called**********");
        transaction.commit();
        System.out.println("************After Persist method transition**********");
        entityManager.close();
        entityManagerFactory.close();


    }
}
