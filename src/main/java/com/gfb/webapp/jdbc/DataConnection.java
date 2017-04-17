package com.gfb.webapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by goforbroke on 17.04.17.
 */
public class DataConnection {
    private static final String driverName = "org.sqlite.JDBC";
    private static final String connectionString = "jdbc:sqlite:test.db";

    private static Connection connection = null;

    public static Connection openConnection()
            throws ClassNotFoundException, SQLException {

        if (connection == null || connection.isClosed()) {
            Class.forName(driverName);
            connection = DriverManager.getConnection(connectionString);
        }

        return connection;
    }
}
