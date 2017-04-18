package com.gfb.webapp.jdbc;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by goforbroke on 17.04.17.
 */
public class DataConnection {
//    private static final String driverName = "org.sqlite.JDBC";
//    private static final String connectionString = "jdbc:sqlite:test.db";

    private static final String driverName = "org.h2.Driver";
    private static final String connectionString = "jdbc:h2:./h2db";

    private static Connection connection = null;

    public static Connection openConnection()
            throws ClassNotFoundException, SQLException {

        if (connection == null || connection.isClosed()) {
            Class.forName(driverName);
//            connection = DriverManager.getConnection(connectionString);

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(connectionString);
            ds.setUser("test");
            ds.setPassword("test");

            connection = ds.getConnection();
        }

        return connection;
    }
}
