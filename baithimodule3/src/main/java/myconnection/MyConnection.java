package myconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/baithimodule3";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
