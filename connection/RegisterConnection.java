/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;
import cis4005.Register;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class RegisterConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public RegisterConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param weekno
     * @param noofattendees
     * @param moduleid
     */
    public void insertRecord(final String weekno, final String noofattendees, 
        final String moduleid) 
{
    final String insertStmt = "INSERT INTO CIS4005.REGISTER"
            + "(weekno, noofattendees, moduleid) VALUES"
            + "(?,?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setString(1, weekno);
        pstmt.setString(2,  noofattendees);
        pstmt.setString(3, moduleid);
        pstmt.executeUpdate();   
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
}

    /**
     *
     */
    public void printAllRecords()
    {
final String retrieveQuerty = "Select * from CIS4005.REGISTER";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {   
                String sregisterid = output.getString(1);
                String sweekno = output.getString(2);
                String snoofattendees = output.getString(3);
                String smoduleid = output.getString(4);
                System.out.println(sregisterid + " " + sweekno + " " + snoofattendees + " "
                        + smoduleid+ "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing register: " + sqle.toString());
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<cis4005.Register> getReggisters()
{
    ArrayList<cis4005.Register> registers = new ArrayList<>();
    Register register = null;
    final String queryStmt = "SELECT * FROM CIS4005.REGISTER";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(queryStmt);
        ResultSet arry = pstmt.executeQuery();
       
        while (arry.next()){
            int id = arry.getInt(1);  
            int weekNo = arry.getInt(2);
            int noOfAttenders= arry.getInt(3);
            int moduleId = arry.getInt(4);
            register = new Register(moduleId, noOfAttenders, weekNo);
            registers.add(register);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return registers;
}
    
}

                 