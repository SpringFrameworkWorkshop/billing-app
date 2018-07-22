package io.spring.billing.repositories;

import io.spring.billing.entities.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> findAllByClientId(@Param("id") Long id);

    @Query("select b from Bill b join fetch b.client c join fetch b.lines l join fetch l.product where b.id=?1")
    Bill fetchByIdWithClientWithLinesWithProduct(@Param("id") Long id);

}
