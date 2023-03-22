/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bang
 */
public class DBContext {

    private InitialContext initial;
    private Context context;
    private String dbName;
    private String serverName;
    private String portNumber;
    private String userName;
    private String password;

    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbName = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            userName = context.lookup("userName").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {
        }

    }

    /**
     * To connect with the database
     *
     * @return a connection to given database URL
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }

    /**
     * Close ResultSet
     *
     * @param resultSet the ResultSet. It is a <code>java.sql.ResultSet</code>
     * object
     * @throws SQLException
     */
    public void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
    }

    /**
     * Close Prepared Statement
     *
     * @param preparedStatement the PreparedStatement. It is a
     * <code>java.sql.PreparedStatement</code> object
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
        }
    }

    /**
     * Close Connection
     *
     * @param connection the Connection. It is a
     * <code>java.sql.Connection</code> object
     * @throws SQLException
     */
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
