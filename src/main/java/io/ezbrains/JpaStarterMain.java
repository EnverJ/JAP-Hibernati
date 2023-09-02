package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Foo Bar");

        Employee employee1 = new Employee();
        employee.setId(2);
        employee.setName("Foo Baz");

        Employee employee3 = new Employee();
        employee.setId(2);
        employee.setName("Foo Bazar");

        // create an entity manager factory. is a service to manage @Entity (data holder)
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class and it will connect to persistence.xml
       EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
       EntityTransaction transaction = entityManager.getTransaction();
       transaction.begin();
       entityManager.persist(employee);
       transaction.commit();


    }
}
