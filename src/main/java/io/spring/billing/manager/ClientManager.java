package io.spring.billing.manager;

import io.spring.billing.dao.ClientDAO;
import io.spring.billing.entities.Client;

public class ClientManager extends AbstractManager<Client> {

	private static ClientManager instance;

	private ClientManager() {
	}

	public static ClientManager getInstance() {
		if (instance == null) {
			instance = new ClientManager();
		}
		return instance;
	}

	@Override
	public ClientDAO getDao() {
		return ClientDAO.getInstance();
	}
}
