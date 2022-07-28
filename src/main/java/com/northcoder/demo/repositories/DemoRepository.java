package com.northcoder.demo.repositories;

import com.northcoder.demo.entities.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
