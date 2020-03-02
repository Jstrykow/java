/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;

import java.sql.*;
import java.util.ArrayList;
import cis4005.Module;

/**
 *
 * @author jacob
 */

public class ModuleProgrammeConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public ModuleProgrammeConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param moduleid
     * @param programmeid
     */
    public void insertRecord(final int moduleid, final int programmeid) 
{
    final String insertStmt = "INSERT INTO CIS4005.MODULEPROGRAMME"
            + "(moduleid, programmeid) VALUES"
            + "(?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setInt(1, moduleid);
        pstmt.setInt(2,  programmeid);
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
final String retrieveQuerty = "Select * from CIS4005.MODULEPROGRAMME";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {   
                int sid = output.getInt(1);
                int smoduleid = output.getInt(2);
                int sprogrammeid = output.getInt(3);
                System.out.println(sid + " " + smoduleid + " " + sprogrammeid 
                        + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing moduleprogramme: " + sqle.toString());
        }
    }
   
    /**
     *
     * @param programmeCode
     * @return
     */
    public ArrayList<Module> getModulesBelongToPogramme(final String programmeCode)
    {
     ArrayList<Module> modules = new ArrayList<>();
     ProgrammeConnection connect = new ProgrammeConnection("cis4005");
     String sql = "SELECT * FROM CIS4005.MODULEPROGRAMME WHERE PROGRAMMEID = " 
                + connect.getProgrammeId(programmeCode);
   
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
     try
        {
            if(null != output)
            {
                while(output.next())
                {
                ModuleConnection connect2 = new ModuleConnection("cis4005");
                Module module = connect2.getModulesById(output.getInt(2));
                modules.add(module);
                }
            }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing moduleprogramme: " + sqle.toString());
        }
    return modules;
    }

    /**
     *
     * @param programmeId
     */
    public void DeleteRecord(final int programmeId)
{
    final String deleteStmt = "DELETE FROM CIS4005.MODULEPROGRAMME WHERE PROGRAMMEID=(?)"; 
    try
    {
        while(1 == checkProgramme(programmeId))
        {
            System.out.println("programme id: " + programmeId);
            PreparedStatement pstmt = 
            getConnection().prepareStatement(deleteStmt);
            pstmt.setInt(1, programmeId);
            pstmt.executeUpdate(); 
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception check programme in  cis4005.programme record" + sqle.toString());
    }
}
   
    /**
     *
     * @param programmeId
     * @return
     */
    public int checkProgramme(final int programmeId)
   {
    final String sql = "SELECT * FROM CIS4005.MODULEPROGRAMME";
    this.setQuery(sql);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        while(output.next())
        {
        int temp = output.getInt("PROGRAMMEID");
                if(temp == programmeId)
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

    /**
     *
     * @param moduleCode
     * @param ProgrammeCode
     */
    public void DeleteRecord(final String moduleCode, final String ProgrammeCode)
    {
        final String deleteStmt = "DELETE FROM CIS4005.MODULEPROGRAMME WHERE MODULEID=(?) "
                + "and PROGRAMMEID=(?)";
        ProgrammeConnection connectProgramme = new ProgrammeConnection("cis4005");
        ModuleConnection connectModule = new ModuleConnection("cis4005");
        try
        { 
            PreparedStatement pstmt = 
            getConnection().prepareStatement(deleteStmt);
            pstmt.setInt(1, connectModule.getModuleId(moduleCode));
            pstmt.setInt(2, connectProgramme.getProgrammeId(ProgrammeCode));
            
           
            pstmt.executeUpdate(); 
            System.out.print("module deleted fromm programme");
        }
        catch(SQLException sqle)
        {
            System.out.println("Exception wen insert cis4005 record" + sqle.toString());
        }
    }

}

                 
