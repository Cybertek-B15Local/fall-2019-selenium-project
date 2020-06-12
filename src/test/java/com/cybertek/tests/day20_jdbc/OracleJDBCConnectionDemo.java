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
     *    SID (service name)  or name of the database  --> xe
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
        // get the name of the column, 1 based count
        System.out.println(rmetaData.getColumnName(1));
        // get data type of the column
        System.out.println(rmetaData.getColumnTypeName(1));

        // print names of all columns
        int numberOfColumns = rmetaData.getColumnCount();
        for (int i = 1; i <= numberOfColumns; i++) {
            System.out.println(rmetaData.getColumnName(i));
        }
        // absolute --> jumps to given row
        resultSet.absolute(1);
        // getObject --> returns the value of the cell under given column
        System.out.println(resultSet.getObject("first_name"));

        // get the name of the last person
        resultSet.last();
        System.out.println(resultSet.getObject("first_name"));

        // getrow returns the current row number
        System.out.println("number of rows = " + resultSet.getRow());

        // go back to first row
        resultSet.beforeFirst();

        // iterate through the results
        // while loop will iterate through the rows of the result table
        while (resultSet.next()) {
            // for loop is for iterating the cells in the row
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.print(resultSet.getString(i)+"\t");
            }
            System.out.println();
        }

        // Make another call to db and get other result
        resultSet = statement.executeQuery("select distinct salary  from employees e1   where 2 = (select count(distinct salary) from employees e2 where  e1.salary <= e2.salary)");

        resultSet.next();
        System.out.println(resultSet.getString("salary"));
    }

        @Test
        public void updateAndDelete() throws SQLException {
            String url = "jdbc:oracle:thin:@18.232.121.19:1521:xe";
            String username = "hr";
            String password = "hr";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery("delete * from employees where first_name = 'Steven'");
             resultSet = statement.executeQuery("UPDATE  * from employees where first_name = 'Steven'");

        }


}




