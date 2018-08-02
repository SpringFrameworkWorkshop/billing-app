package io.spring.billing.dao;

import io.spring.billing.entities.Bill;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BillDAO extends AbstractDAO<Bill> {

    private static BillDAO instance;

    private BillDAO() {
        super(Bill.class);
    }

    public static BillDAO getInstance() {
        if (instance == null) {
            instance = new BillDAO();
        }
        return instance;
    }

    public List<Bill> findBillByProductAndQuantityGreaterThan(final Long productId, final Integer quantity) {

        List<Bill> elements = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();;
            // Get a List of elements
            elements = manager
                    .createNamedQuery("Line.findBillByProductAndQuantityGreaterThan", Bill.class)
                    .setParameter("id", productId)
                    .setParameter("quantity", quantity)
                    .getResultList();
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return elements;
    }

}
