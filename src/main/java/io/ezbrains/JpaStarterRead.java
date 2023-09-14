package io.ezbrains;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Employee employee = entityManager.find(Employee.class,1);
//        System.out.println("****************Fetched Employee");
//        System.out.println(employee.getName());
//        System.out.println("****************Access card");
//        System.out.println(employee.getCard());
//        System.out.println("**************** Employee");
//        System.out.println(employee);

        // or

        AccessCard card = entityManager.find(AccessCard.class,3);
        System.out.println(card);

    }
}
