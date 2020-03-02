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
public class StudentRegisterConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public StudentRegisterConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param studentid
     * @param registerid
     */
    public void insertRecord(final int studentid, final int registerid) 
{
    final String insertStmt = "INSERT INTO CIS4005.STUDENTREGISTER"
            + "(studentid, registerid) VALUES"
            + "(?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setInt(1, studentid);
        pstmt.setInt(2,  registerid);
        
        pstmt.executeUpdate();   
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" 
                + sqle.toString());
    }
}

    /**
     *
     */
    public void printAllRecords()
    {
final String retrieveQuerty = "Select * from CIS4005.STUDENTREGISTER";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {   
                int sstudentmoduleid = output.getInt(1);
                int sstudentid = output.getInt(2);
                int sregisterid = output.getInt(3);
                System.out.println(sstudentmoduleid + " " + sstudentid + " "
                        + sregisterid + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing all studentsmodule: " 
                    + sqle.toString());
        }
    }
    
}

                 