package io.spring.billing.repositories;

import io.spring.billing.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "super-products", path = "super-products")
public interface ProductRepository extends CrudRepository<Product, Long> {

    @RestResource(exported = false)
    List<Product> findByPriceGreaterThanEqual(@Param("price") Double price);


    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByName(@Param("term") String term);

    @Override
    @RestResource(exported = false)
    Product save(Product product);

}
