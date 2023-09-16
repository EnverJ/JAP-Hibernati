package io.ezbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); // persistence is a class, and it will connect to persistence.xml
    EntityManager entityManager = entityManagerFactory.createEntityManager(); //save Entity
    EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

}
