package com.nursery.repository;

import com.nursery.model.Ressource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Ressource, Long> {
}
