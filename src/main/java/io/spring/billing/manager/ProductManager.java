package io.spring.billing.manager;

import io.spring.billing.dao.ProductDAO;
import io.spring.billing.entities.Product;

import java.util.List;

public class ProductManager extends AbstractManager<Product> {

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

	public List<Product> findProductByPriceLessThan(final Double price) {
		return getDao().findProductByPriceLessThan(price);
	}
}
