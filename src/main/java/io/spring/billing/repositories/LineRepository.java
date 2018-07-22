package io.spring.billing.repositories;

import io.spring.billing.entities.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LineRepository extends CrudRepository<Line, Long> {

    @Query("select sum(l.quantity) from Line l where l.product.id = ?1")
    long findAmountSold(@Param("productId") Long productId);

}
