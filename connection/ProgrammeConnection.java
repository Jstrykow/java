/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;
import cis4005.Programme;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author jacob
 */
public class ProgrammeConnection extends DBConnection {
    
    /**
     *
     * @param dbName
     */
    public ProgrammeConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param programmecode
     * @param programmename
     */
    public void insertRecord(final String programmecode, final String programmename) 
{
final String insertStmt = "INSERT INTO CIS4005.PROGRAMME"
            + "(programmecode, programmename) VALUES"
            + "(?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setString(1, programmecode);
        pstmt.setString(2,  programmename);
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
final String retrieveQuerty = "Select * from CIS4005.PROGRAMME";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {
                String sprogrammeid = output.getString(1);
                String sprogrammecode = output.getString(2);
                String sprogrammename= output.getString(3);
                System.out.println(sprogrammeid + " " + sprogrammecode + " " + 
                        sprogrammename + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing all programs " + 
                    sqle.toString());
        }
    }
    
 
    /**
     *
     * @return
     */
  public ArrayList<cis4005.Programme> getProgrammes()
{
    ArrayList<cis4005.Programme> programmes = new ArrayList<>();
    Programme programme = null;
    final String queryStmt = "SELECT * FROM CIS4005.PROGRAMME";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(queryStmt);
        ResultSet arry = pstmt.executeQuery();
       
        while (arry.next()){
            int id = arry.getInt(1);  
            String programmeCode = arry.getString(2);
            String programmeName= arry.getString(3);
             programme = new Programme( programmeCode, programmeName);
            programmes.add(programme);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return programmes;
}

    /**
     *
     * @param programmeCode
     * @return
     */
    public int getProgrammeId(final String programmeCode)
{
 int id = 0;
    try
    {
        String sql = "SELECT * FROM CIS4005.PROGRAMME WHERE PROGRAMMECODE =  '" 
                + programmeCode + "'";
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
        if(null != output)
        {
            while (output.next()){
                id = output.getInt(1);  
                return id;
            }
            }
    }
    catch(SQLException sqle)
    {
        System.out.println("Dupa Exception wen insert cis4005 record" + sqle.toString());
    }
  //* Programme checks it is more than 0
  System.out.print("There is no programme withthat programmecode: " + programmeCode);
  return id;
}   
   
    /**
     *
     * @param programmeCode
     */
    public void DeleteRecord(final String programmeCode)
{
    final String deleteStmt = "DELETE FROM CIS4005.PROGRAMME WHERE PROGRAMMECODE=(?)";
    ModuleProgrammeConnection con = new ModuleProgrammeConnection("cis4005");
    con.DeleteRecord(this.getProgrammeId(programmeCode));
    try
    { 
        PreparedStatement pstmt = 
        getConnection().prepareStatement(deleteStmt);
        pstmt.setString(1, programmeCode);
        pstmt.executeUpdate(); 
        System.out.print("programme deleted");
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
}

    /**
     *
     * @param programmeCode
     * @return
     */
    public int checkProgramme(final String programmeCode)
   {
    final String sql = "SELECT * FROM CIS4005.PROGRAMME";
    this.setQuery(sql);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        while(output.next())
        {
        int temp = output.getInt("ID");
                if(temp == this.getProgrammeId(programmeCode))
                {
                return 1;
                }
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
    return 0;     
   }
}

