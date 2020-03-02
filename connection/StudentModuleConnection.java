/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;
import cis4005.Module;
import java.sql.*;
import java.util.ArrayList;
import cis4005.Student;

/**
 *
 * @author jacob
 */
public class StudentModuleConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public StudentModuleConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param studentid
     * @param moduleid
     */
    public void insertRecord(final int studentid, final int moduleid) 
{
    final String insertStmt = "INSERT INTO CIS4005.STUDENTMODULE"
            + "(studentid, moduleid) VALUES"
            + "(?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setInt(1, studentid);
        pstmt.setInt(2,  moduleid);
        
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
final String retrieveQuerty = "Select * from CIS4005.STUDENTMODULE";
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
                int smoduleid = output.getInt(3);
                System.out.println(sstudentmoduleid + " " + sstudentid + " "
                        + smoduleid + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing all studentsmodule: " 
                    + sqle.toString());
        }
    }
  
    /**
     *
     * @return modules
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
            String moduleTitle= arry.getString(2);
            int credits = arry.getInt(3);
            String moduleCode = arry.getString(4);
            int level = arry.getInt(5);
            int semester = arry.getInt(6);
            module = new Module(moduleTitle, credits, moduleCode, level, semester);     
            modules.add(module);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return modules;
}
   
    /**
     *
     * @param moduleCode
     * @return ArrayList <Student> students
     */
    public ArrayList<Student> getStudentsBelongToModule(final String moduleCode)
    {
     ArrayList<Student> students = new ArrayList<>();
     ModuleConnection connect = new ModuleConnection("cis4005");
     String sql = "SELECT * FROM CIS4005.STUDENTMODULE WHERE MODULEID = " 
                + connect.getModuleId(moduleCode);
    StudentConnection connect2 = new StudentConnection("cis4005");
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
     try
        {
            if(null != output)
            {
                while(output.next())
                {
                Student student = connect2.getStudnetById(output.getInt("STUDENTID"));
                students.add(student);
                }
            }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing moduleprogramme: " + sqle.toString());
        }
    return students;
    }
    
    /**
     *
     * @param studentNo
     * @param moduleCode
     */
    public void DeleteRecord(final String studentNo, final String moduleCode)
    {
        final String deleteStmt = "DELETE FROM CIS4005.STUDENTMODULE WHERE STUDENTID=(?) "
                + "and MODULEID=(?)";
        StudentConnection connectStudent = new StudentConnection("cis4005");
        ModuleConnection connectModule = new ModuleConnection("cis4005");
        try
        { 
            PreparedStatement pstmt = 
            getConnection().prepareStatement(deleteStmt);
            pstmt.setInt(1, connectStudent.getStudentId(studentNo));
            pstmt.setInt(2, connectModule.getModuleId(moduleCode));
            
            System.out.print("deleted student id: " + 
                    connectStudent.getStudentId(studentNo) +
                    "form module: " + 
                    connectModule.getModuleId(moduleCode));
            pstmt.executeUpdate(); 
            System.out.print("student deleted fromm module");
        }
        catch(SQLException sqle)
        {
            System.out.println("Exception wen insert cis4005 record" + sqle.toString());
        }
    }
    
}

                 