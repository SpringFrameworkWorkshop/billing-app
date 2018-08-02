package io.spring.billing.dao;

import io.spring.billing.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {

    private static ProductDAO instance;

    private ProductDAO() {
        super(Product.class);
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    public List<Product> findProductByPriceLessThan(final Double price) {

        List<Product> elements = null;

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
                    .createNamedQuery("Product.findProductByPriceLessThan", Product.class)
                    .setParameter("price", price)
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
