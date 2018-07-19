package io.spring.billing.repositories;

import io.spring.billing.entities.Line;
import org.springframework.data.repository.CrudRepository;

public interface LineRepository extends CrudRepository<Line, Long> {
}
