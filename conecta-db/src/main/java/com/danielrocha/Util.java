package com.danielrocha;

import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    public static Connection getConnection() {

        ConnectionProperties properties = new ConnectionProperties();

        try {
            Class.forName(properties.getJdbcClassName());
            Connection conn =
                    DriverManager.getConnection(properties.getUrl(),
                                                properties.getUser(),
                                                properties.getPassword());

            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
