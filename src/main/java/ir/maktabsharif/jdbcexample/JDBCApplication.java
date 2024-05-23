package ir.maktabsharif.jdbcexample;

import ir.maktabsharif.jdbcexample.domain.BaseEntity;
import ir.maktabsharif.jdbcexample.repository.CityRepository;
import ir.maktabsharif.jdbcexample.repository.impl.CityRepositoryImpl;
import ir.maktabsharif.jdbcexample.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCApplication {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD
        );
        connection.setAutoCommit(true);

//        ProvinceRepository provinceRepository = new ProvinceRepositoryImpl(connection);
//        for (BaseEntity baseEntity : provinceRepository.findAll()) {
//            Province province = (Province) baseEntity;
//            System.out.println(province);
//        }

        CityRepository cityRepository = new CityRepositoryImpl(connection);
        for (BaseEntity baseEntity : cityRepository.findAll()) {
            System.out.println(baseEntity);
        }

        connection.close();
    }

}
