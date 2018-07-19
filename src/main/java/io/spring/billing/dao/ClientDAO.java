package io.spring.billing.dao;

import io.spring.billing.entities.Client;

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

}
