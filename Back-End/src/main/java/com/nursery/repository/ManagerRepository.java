package com.nursery.repository;

import com.nursery.model.Manager;
import com.nursery.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Manager findByUsername(String username);
}
