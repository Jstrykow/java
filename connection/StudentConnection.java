/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.connection;
import java.sql.*;
import java.util.ArrayList;
import cis4005.Student;

/**
 *
 * @author jacob
 */
public class StudentConnection extends DBConnection {
   
    /**
     *
     * @param dbName
     */
    public StudentConnection(final String dbName)
{
    this.connectDatabase(dbName);
}
 
    /**
     *
     * @param forename
     * @param surname
     * @param studentno
     * @param fullparttime
     */
    public void insertRecord(final String forename, final String surname, 
        final String studentno, final String fullparttime) 
{
    final String insertStmt = "INSERT INTO CIS4005.STUDENT"
            + "(forename, surname, studentno, fullparttime) VALUES"
            + "(?,?,?,?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(insertStmt);
    
        pstmt.setString(1, forename);
        pstmt.setString(2,  surname);
        pstmt.setString(3, studentno);
        pstmt.setString(4, fullparttime);
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
final String retrieveQuerty = "Select * from CIS4005.STUDENT";
    this.setQuery(retrieveQuerty);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        if(null != output)
        {
            while(output.next())
            {   
                String sstudentid = output.getString(1);
                String fname = output.getString(2);
                String sname = output.getString(3);
                String studentno = output.getString(4);
                String fullparttime = output.getString(5);
                System.out.println(sstudentid + " " + fname + " " + sname + " "
                        + studentno + " " + fullparttime + "\n");
            }
        }
    }
    catch(SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }
    }
    
    /**
     *
     * @param studentno
     */
    public void DeleteRecord(final String studentno)
{
    final String deleteStmt = "DELETE FROM CIS4005.STUDENT WHERE STUDENTNO=(?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(deleteStmt);
        pstmt.setString(1, studentno);
        pstmt.executeUpdate(); 
        System.out.print("Student deleted");
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
}

    /**
     *
     * @param studentNo
     * @return
     */
    public int getStudentId(final String studentNo)
{
    int id = 0;
    final String queryStmt = "SELECT ID FROM CIS4005.STUDENT WHERE STUDENTNO=(?)";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(queryStmt);
        pstmt.setString(1, studentNo);
        ResultSet arry = pstmt.executeQuery();
       
        while (arry.next()){
            id = arry.getInt(1);  
            break;
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return id;
}

    /**
     *
     * @return
     */
    public ArrayList<cis4005.Student> getStudents()
{
    ArrayList<cis4005.Student> students = new ArrayList<>();
    Student student = null;
    final String queryStmt = "SELECT * FROM CIS4005.STUDENT";
    try
    {
        PreparedStatement pstmt = 
    getConnection().prepareStatement(queryStmt);
        ResultSet arry = pstmt.executeQuery();
       
        while (arry.next()){
            int id = arry.getInt(1);  
            String forename = arry.getString(2);
            String surname = arry.getString(3);
            String studentNo = arry.getString(4);
            String fullPartTime = arry.getString(5);
            student = new Student(forename, surname, studentNo, fullPartTime);     
            students.add(student);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return students;
}

    /**
     *
     * @param studentId
     * @return
     */
    public Student getStudnetById(final int studentId)
{
    Student student = null;
    try
    {
         String sql = "SELECT * FROM CIS4005.STUDENT WHERE ID = " 
                + studentId;
        this.setQuery(sql);
        this.runQuerty();
        ResultSet output = this.getResult();
        if(null != output)
        {
            while (output.next()){
                int id = output.getInt(1);  
                String foreName = output.getString(2);
                String surName = output.getString(3);
                String studentNo = output.getString(4);
                String fullPartTime = output.getString(5);
                student = new Student(foreName, surName, studentNo, fullPartTime);
                return student;
            }
            }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
  return student;
}

    /**
     *
     * @param studentNo
     * @return
     */
    public int checkStudent (final String studentNo)
   {
    final String sql = "SELECT * FROM CIS4005.STUDENT";
    this.setQuery(sql);
    this.runQuerty();
    ResultSet output = this.getResult();
    try
    {
        while(output.next())
        {
        String gottenStudentNo = output.getString(4);
        if(gottenStudentNo.equalsIgnoreCase(studentNo))
        return output.getInt(1);
        }
    }
    catch(SQLException sqle)
    {
        System.out.println("Exception wen insert cis4005 record" + sqle.toString());
    }
    return 0;     
   }



}