package ir.maktabsharif.jdbcexample.repository;

import ir.maktabsharif.jdbcexample.domain.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityRepository {

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    BaseEntity[] findAll() throws SQLException;

    BaseEntity findById(Long id);

    long count() throws SQLException;

    void deleteAll();

    void deleteById(Long id);

    boolean existsById(Long id);

}
