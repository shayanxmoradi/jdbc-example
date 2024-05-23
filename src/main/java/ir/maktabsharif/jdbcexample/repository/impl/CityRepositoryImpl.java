package ir.maktabsharif.jdbcexample.repository.impl;

import ir.maktabsharif.jdbcexample.domain.BaseEntity;
import ir.maktabsharif.jdbcexample.domain.City;
import ir.maktabsharif.jdbcexample.domain.Province;
import ir.maktabsharif.jdbcexample.repository.CityRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl implements CityRepository {

    public CityRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getLong("city_id"),
                resultSet.getString("city_name"),
                new Province(
                        resultSet.getLong("province_id"),
                        resultSet.getString("province_name")
                )
        );
    }

    @Override
    protected String getFindAllQuery() {
        return """
                select c.id as city_id, c.name as city_name,
                p.id as province_id, p.name as province_name
                from city c join province p on
                c.province_id = p.id
                """;
    }

//        public List<City> findAll() throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                """
//                        select c.id as city_id, c.name as city_name,
//                        p.id as province_id, p.name as province_name
//                        from city c join province p on
//                        c.province_id = p.id
//                        """
//        );
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<City> cityList = new ArrayList<>();
//        while (resultSet.next()) {
//            cityList.add(
//                    new City(
//                            resultSet.getLong("city_id"),
//                            resultSet.getString("city_name"),
//                            new Province(
//                                    resultSet.getLong("province_id"),
//                                    resultSet.getString("province_name")
//                            )
//                    )
//            );
//        }
//        return cityList;
//    }
}
