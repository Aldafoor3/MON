package com.nursery.repository;

import com.nursery.model.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {
    List<Child> findByName(String name);
    List<Child> findByParentId(Long parentId);
}
