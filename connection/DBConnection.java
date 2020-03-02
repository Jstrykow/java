/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;
import java.sql.*;

/**
 *
 * @author jacob
 */
public class DBConnection {
private Connection dbConnection = null;
private Statement stmt = null;
private ResultSet dataRS = null;
private String query = null;

private void loadDriver()
{
    try
    {
    Class driver = org.apache.derby.jdbc.ClientDriver.class;
    System.out.println("Class=" + driver.getSimpleName());
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    catch(ClassNotFoundException err)
    {
    System.out.println("Could not load driver ");
    System.exit(1);
    }
}

    /**
     *
     * @param dbName
     */
    public void connectDatabase(final String dbName)
{
    try
    {
        loadDriver();
        dbConnection =DriverManager.getConnection("jdbc:derby://localhost:1527/" +
               dbName, "cis4005", "cis4005");      
    }
    catch(SQLException error)
    {
        System.err.println("Error connecting to database: " + error.toString());
    }
}

    /**
     *
     */
    public void runQuerty()
{
    try
    {
    /**create statement @param stmt */
    stmt = dbConnection.createStatement();
    dataRS = stmt.executeQuery(query);
    }
    catch(SQLException error)
    {
       System.err.println("Error connecting to database: " + error.toString());
    }
}

    /**
     *
     * @param q
     */
    public void setQuery(final String q)
{
    query = new String(q);
}

    /**
     *
     */
    public void closeConnection()
{
    try
    {
        if(null != dbConnection && ! dbConnection.isClosed())
        {
            dbConnection.close();
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Error closing connection: " + sqle.toString());
    }
}

    /**
     *
     * @return
     */
    public ResultSet getResult()
{
    return dataRS;
}

    /**
     *
     * @return
     */
    public Connection getConnection()
{
    return dbConnection;
}
    
}
 