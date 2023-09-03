package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.util.Date;

public class JpaStarterMain {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Foo Bar");
        employee.setSsn("233");
        employee.setDob(new Date());
        employee.setType(EmployeeType.FULL_TIME);

        Employee employee1 = new Employee();
        employee1.setId(2);
        employee1.setName("Foo Baz");
        employee1.setSsn("2303");
        employee1.setType(EmployeeType.CONTRACTOR);


        Employee employee3 = new Employee();
        employee3.setId(2);
        employee3.setName("Foo Bazar");
        employee3.setSsn("2303");


        // create an entity manager factory. is a service to manage @Entity (data holder)
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class and it will connect to persistence.xml
       EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
       EntityTransaction transaction = entityManager.getTransaction();
       transaction.begin();
       entityManager.persist(employee);
       transaction.commit();


    }
}
