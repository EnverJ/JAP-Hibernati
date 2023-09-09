package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterMainWrite {

    public static void main(String[] args) {
// find data 2
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class and it will connect to persistence.xml
//        EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
//        Employee employee = entityManager.find(Employee.class, 1);   // select * from Employee_Data where id=1;
//        //     System.out.println(employee);  // find


        // delete
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.remove(employee);
//        transaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();

// Enter data 1
        Employee employee = new Employee();
        employee.setName("Foo Bar");
        employee.setSsn("233");
        employee.setDob(new Date());
        employee.setAge(20);
        employee.setType(EmployeeType.FULL_TIME);

        Employee employee1 = new Employee();
        employee1.setName("Foo Baz");
        employee1.setSsn("2303");
        employee1.setType(EmployeeType.CONTRACTOR);
        employee1.setAge(30);

        // Access Card
        AccessCard card1 = new AccessCard();
        card1.setIssueDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");
        employee.setCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssueDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setId(20);
        employee1.setCard(card2);


        // create an entity manager factory. is a service to manage @Entity (data holder)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class, and it will connect to persistence.xml
        EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(card1);
        entityManager.persist(card2);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
