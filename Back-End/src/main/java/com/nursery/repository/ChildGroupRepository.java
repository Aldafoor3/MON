package com.nursery.repository;

import com.nursery.model.ChildGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildGroupRepository extends CrudRepository<ChildGroup, Long> {
}
