package com.nursery.repository;

import com.nursery.model.Parent;
import com.nursery.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {

    Parent findByUsername(String username);
}
