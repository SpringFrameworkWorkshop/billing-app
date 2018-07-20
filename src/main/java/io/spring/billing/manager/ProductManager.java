package io.spring.billing.manager;

import io.spring.billing.dao.ProductDAO;
import io.spring.billing.entities.Product;

public class ProductManager extends AbstractBillingManager<Product> {

	private static ProductManager instance;

	private ProductManager() {
	}

	public static ProductManager getInstance() {
		if (instance == null) {
			instance = new ProductManager();
		}
		return instance;
	}

	@Override
	public ProductDAO getDao() {
		return ProductDAO.getInstance();
	}
}
