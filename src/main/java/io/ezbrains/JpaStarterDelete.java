package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class, and it will connect to persistence.xml
        EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
         // fetch data
        Employee employee = entityManager.find(Employee.class,2);







        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee);






        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }


}
