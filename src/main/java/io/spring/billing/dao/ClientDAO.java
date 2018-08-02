package io.spring.billing.dao;

import io.spring.billing.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientDAO extends AbstractDAO<Client> {

    private static ClientDAO instance;

    private ClientDAO() {
        super(Client.class);
    }

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }

    public List<Client> findByEmail(final String email) {

        List<Client> elements = null;

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
                    .createNamedQuery("Client.findByEmail", Client.class)
                    .setParameter("email", email)
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
