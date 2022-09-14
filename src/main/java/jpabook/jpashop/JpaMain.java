package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //단방향 버전
            /*Order order1 = new Order();
            em.persist(order1);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order1);
            em.persist(orderItem);*/
            //

            //양방향
            Order order2 = new Order();
            OrderItem orderItem2 = new OrderItem();
            order2.addOrderItem(orderItem2);
            em.persist(order2);
            //

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
