package com.nursery.repository;

import com.nursery.model.Leaves;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends CrudRepository<Leaves, Long> {
}
