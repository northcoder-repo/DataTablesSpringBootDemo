package com.northcoder.demo.repositories;

import com.northcoder.demo.entities.Employee;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DemoRepositoryImpl implements DemoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public DemoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        RowMapper employeeMapper = DataClassRowMapper.newInstance(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sqlFindAll, employeeMapper);
        return employees;
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject(sqlCount, Long.class);
    }

    @Override
    public <S extends Employee> S save(S entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Employee> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private final String sqlFindAll = """
        select name, position, office, age, start_date, salary 
        from employees
    """;

    private final String sqlCount = """
        select count(name) 
        from employees
    """;

}
