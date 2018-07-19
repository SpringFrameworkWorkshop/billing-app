package io.spring.billing.dao;

import io.spring.billing.entities.Product;

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

}
