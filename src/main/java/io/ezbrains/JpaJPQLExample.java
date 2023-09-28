package io.ezbrains;

import javax.persistence.*;
import java.util.List;
// بىسمىللاھى راھمانى رەھىم
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

        //Freeform queries and custom type
//     //    String minAge = "25; delete * from Employee_Table";   // injection. bad query
//        // if String
//        int minAge = 25;
//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee where e.age > :minAge", Employee.class);
//        query.setParameter("minAge", minAge);  // this would avoid attached query in minAge


        // NAMED QUERY
        TypedQuery<Employee> query = entityManager.createQuery("emp name and age asc", Employee.class);
        query.setParameter("age", 25);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);


//   //     int minAge =25;
//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee where e.age > "  +minAge, Employee.class);
//        List<Employee> resultList = query.getResultList();
//        resultList.forEach(System.out::println);
        // or
//        TypedQuery<Object[]> query = entityManager.createQuery("select e from Employee e", Object[].class);
//        List<Object[]> resultList = query.getResultList();
//        resultList.forEach(e -> System.out.println(e[0] + " "+ e[1]));

        entityManager.close();
        entityManagerFactory.close();
    }
}
