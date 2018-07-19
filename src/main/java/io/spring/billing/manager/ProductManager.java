package io.spring.billing.manager;

import io.spring.billing.entities.Product;
import io.spring.billing.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager extends AbstractManager<Product> {

    private ProductRepository repository;

    @Autowired
    public ProductManager(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductRepository getRepository() {
        return repository;
    }

    public List<Product> findByName(String term) {
        return repository.findByNameLikeIgnoreCase("%"+term+"%");
    }
}
