package io.spring.billing.repositories;

import io.spring.billing.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByNameAndSurnameAllIgnoreCase(@Param("name") String name, @Param("surname") String surname);

    List<Client> findBySurnameOrderByNameDesc(@Param("surname") String surname);

    @Query("select c from Client c left join fetch c.bills b where c.id=?1")
    Client fetchByIdWithBills(@Param("id") Long id);

    Page<Client> findByName(@Param("name") String name, Pageable page);

}
