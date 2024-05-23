package ir.maktabsharif.jdbcexample.repository.impl;

import ir.maktabsharif.jdbcexample.domain.BaseEntity;
import ir.maktabsharif.jdbcexample.repository.BaseEntityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseEntityRepositoryImpl implements BaseEntityRepository {

    protected final Connection connection;

    public static final String FIND_ALL_QUERY_TEMPLATE =
            "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE =
            "select count(*) from %s";

    public BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity[] findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                getFindAllQuery()
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        BaseEntity[] baseEntities = new BaseEntity[(int) count()];
        int arrayIndex = 0;
        while (resultSet.next()) {
            baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
        }

        return baseEntities;
    }

    @Override
    public BaseEntity findById(Long id) {
        return null;
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        COUNT_ALL_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    protected String getFindAllQuery() {
        return String.format(
                FIND_ALL_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected abstract String getTableName();

    protected abstract BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException;


}
