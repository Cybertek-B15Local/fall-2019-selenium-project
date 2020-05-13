package com.cybertek.tests.day20_jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class OracleJDBCConnectionDemo {
    /**
     * JDBC  --> java api for connecting to database and manage connections, send queries etc
     * // when connecting to any database we need drivers specific to the database we want to connect to
     * // to make jdbc connection first we need to add the driver to the pom file
     * // in my project we use ORACLE so i have ojdbc8 dependency in my pom file
     * // in my project we use MYSQL so i have mysql-connector dependency in my pom file
     * // we need following database related information:
     *    type of the database  --> oracle
     *    ip address of the database  --> 54.226.100.111
     *    post number of the data base --> 1521
     *    SID (service name) of the database --> xe
     *    these 4 pieces of information will be used to create
     *    the connection URL
     *
     *    we also need the username and password to login to the database.
     *      jbcs URLs formula "jdbc:database_type:@ip_address:port:sid"
     *
     *
     **/
    @Test
    public void test() throws SQLException {
        String url = "jdbc:oracle:thin:@54.226.100.111:1521:xe";
        String username = "hr";
        String password = "hr";

        // DriverManager.getConnection --> this method is used to create connection
        // using url, username and password information
        // Connection --> class that represents the connection, helps connect to db
        Connection connection = DriverManager.getConnection(url, username, password);

        // Statement --> helps write sql queries and executes
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                 ResultSet.CONCUR_READ_ONLY);

        // the data that is returned as a result of query is stored in resultset
        // statement.executeQuery --> executed the query and returns the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from employees");

        // metadata about the connection
        DatabaseMetaData dmetaData = connection.getMetaData();
        System.out.println(dmetaData.getDatabaseProductName());
        System.out.println(dmetaData.getDatabaseProductVersion());
        System.out.println(dmetaData.getDriverName());

        // metadata about the result
        ResultSetMetaData rmetaData = resultSet.getMetaData();
        System.out.println(rmetaData.getColumnCount());
    }
}




