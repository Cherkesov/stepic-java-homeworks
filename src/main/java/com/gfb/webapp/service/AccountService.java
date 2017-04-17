package com.gfb.webapp.service;

import com.gfb.webapp.jdbc.DataConnection;

import java.sql.*;

/**
 * Created by goforbroke on 17.04.17.
 */
public class AccountService {
    public static boolean register(String login, String password)
            throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.openConnection();
        PreparedStatement statement = connection.prepareStatement("" +
                "INSERT INTO `user` (`login`, `password`) " +
                "VALUES(?, ?)");
        statement.setString(1, login);
        statement.setString(2, password);
        return statement.execute();
    }

    public static boolean authorize(String login, String password)
            throws SQLException, ClassNotFoundException {
        Connection connection = DataConnection.openConnection();
        PreparedStatement statement1 = connection
                .prepareStatement("SELECT * FROM `user` WHERE `login`=?");
        statement1.setString(1, login);
        ResultSet rs = statement1.executeQuery();
        return rs.next() && rs.getString("password").equals(password);
    }
}
