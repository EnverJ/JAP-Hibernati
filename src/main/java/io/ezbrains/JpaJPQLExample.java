package io.ezbrains;

import javax.persistence.*;
import java.util.List;

public class JpaJPQLExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // e.g. fetch employee named foo bar using JPQL
        // Select * from Employee_Data where EMPLOYEENAME = "foo Bar"

        //  Query query = entityManager.createQuery("select e from Employee e"); // this jpql no sql
        //  List resultList = query.getResultList();
        //or
        //     TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age > 25", Employee.class);
        // like key word
        //   TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name like '%Bar%'", Employee.class);
        // between
       // TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age between 23 and 40", Employee.class);
        // join
        // in sql: select e.* from EMPLOYEE_DATA e join ACCESSCARD a on e.card_id = a.id and a.instance = true;
        // in jpql. the join already done. so
       // TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.card.isActive=true", Employee.class);

        //Freeform queries and custom types
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }
}
