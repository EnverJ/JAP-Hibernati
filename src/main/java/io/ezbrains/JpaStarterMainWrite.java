package io.ezbrains;
import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

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
        employee1.setCard(card1);
        card1.setOwner(employee);


        AccessCard card2 = new AccessCard();
        card2.setIssueDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setId(20);
        card1.setOwner(employee1);
        employee1.setCard(card2);

        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setEmployee(employee);
        payStub1.setSalary(1000);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setEmployee(employee1);
        payStub2.setSalary(2000);

        EmailGroup group = new EmailGroup();
        group.setName("Company Watercooler Discussion");
        group.addMember(employee);
        group.addMember(employee1);
        employee.addEmailSubscription(group);
        employee1.addEmailSubscription(group);

        EmailGroup group1 = new EmailGroup();
        group1.setName("Engineering");
        employee.addEmailSubscription(group1);
        group1.addMember(employee);




        employee.setPayStub(List.of(payStub1, payStub2));



        // create an entity manager factory. is a service to manage @Entity (data holder)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class, and it will connect to persistence.xml
        EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);

        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(group);
        entityManager.persist(group1);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
