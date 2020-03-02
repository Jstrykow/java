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

public class ModuleConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public ModuleConnection(final String dbName)
{
    this.connectDatabase(dbName);
}

    /**
     *
     */
    public ModuleConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    /**
     *
     * @param ModuleTitle
     * @param credits
     * @param modulecode
     * @param level
     * @param semester
     */
    public void insertRecord(final String ModuleTitle, final int credits, final String modulecode, 
        final int level, final int semester) 
{
    final String insertStmt = "INSERT INTO CIS4005.MODULE"
            + "(ModuleTitle, credits, modulecode, level, semester) VALUES"
            + "(?,?,?,?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setString(1, ModuleTitle);
        pstmt.setInt(2, credits);
        pstmt.setString(3,  modulecode);
        pstmt.setInt(4, level);
        pstmt.setInt(5, semester);
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
final String retrieveQuerty = "Select * from CIS4005.MODULE";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {   
                int smoduleid = output.getInt(1);
                String sModuleTitle = output.getString(2);
                int scredits = output.getInt(3);
                String smodulecode = output.getString(4);
                int slevel = output.getInt(5);
                int ssemester = output.getInt(6);
                System.out.println(smoduleid + " " + sModuleTitle  + " " + 
                        scredits + " " + smodulecode + " " + slevel + " " + 
                        ssemester + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing all modules: " + 
                    sqle.toString());
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<cis4005.Module> getModules()
{
    ArrayList<cis4005.Module> modules = new ArrayList<>();
    Module module = null;
    final String queryStmt = "SELECT * FROM CIS4005.MODULE";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(queryStmt);
        ResultSet arry = pstmt.executeQuery();
       
        while (arry.next()){
            int id = arry.getInt(1);  
            String moduleTitle = arry.getString(2);
            int credits = arry.getInt(3);
            String moduleCode = arry.getString(4);
            int level = arry.getInt(5);
            int semester = arry.getInt(6);
            module = new Module(moduleTitle, (int) credits, moduleCode, (int) level, (int) 
                    semester); 
            modules.add(module);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return modules;
}   
 
//what is it? 

    /**
     *
     * @param moduleId
     * @return
     */
public Module getModulesById(final int moduleId)
{
    Module module = null;
    try
    {
         String sql = "SELECT * FROM CIS4005.MODULE WHERE ID = " 
                + moduleId;
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
        if(null != output)
        {
            while (output.next()){
                int id = output.getInt(1);  
                String moduleTitle = output.getString(2);
                int credits = output.getInt(3);
                String moduleCode = output.getString(4);
                int level = output.getInt(5);
                int semester = output.getInt(6);
                if(id == moduleId)
                {
                module = new Module(moduleTitle, (int) credits, moduleCode, (int) level, (int) 
                        semester); 
                return module;
                }
            }
            }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return module;
}   

    /**
     *
     * @param moduleCode
     * @return
     */
    public Module getModulesByCode(final String moduleCode)
{
    Module module = null;
    
         String sql = "SELECT * FROM CIS4005.MODULE WHERE MODULECODE = '" 
                + moduleCode + "'";
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while (output.next()){
                int id = output.getInt(1);  
                String moduleTitle = output.getString(2);
                int credits = output.getInt(3);
               // String moduleCode2 = output.getString(4);
                int level = output.getInt(5);
                int semester = output.getInt(6);
                module = new Module(moduleTitle, (int) credits, moduleCode, (int) level, (int) 
                        semester); 
                return module;
            }
            }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
    
  return module;
}   
 
    /**
     *
     * @param moduleCode
     * @return
     */
    public int checkModule(final String moduleCode)
   {
    final String sql = "SELECT * FROM CIS4005.MODULE";
    this.setQuery(sql);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        while(output.next())
        {
        String gottenModuleCode = output.getString(4);
        if(gottenModuleCode.equalsIgnoreCase(moduleCode))
        return output.getInt(1);
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
     * @return
     */
    public int getModuleId(final String moduleCode)
{
 int id = 0;
    try
    {
        String sql = "SELECT * FROM CIS4005.MODULE WHERE MODULECODE =  '" 
                + moduleCode + "'";
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
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return id;
}   
    
}
       