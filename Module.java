/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005;
import cis4005.Student;
import cis4005.connection.StudentModuleConnection;
import cis4005.connection.StudentConnection;
import cis4005.connection.ModuleConnection;
import java.awt.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jacob
 * 
 */
public class Module {
    
    private String moduleTitle;
    private int level;
    private int semester;
    private int credits;
    private String moduleCode;
    ArrayList<Student> students;
    
    /**
     *
     * @param moduleTitle
     * @param credits
     * @param moduleCode
     * @param level
     * @param semester
     */
    public Module(String moduleTitle, int credits, String moduleCode,int level, int semester) {
        this.moduleTitle = moduleTitle;
        this.level = level;
        this.semester = semester;
        this.credits = credits;
        this.moduleCode = moduleCode;
        StudentModuleConnection connect = new StudentModuleConnection("cis4005");
        this.students = connect.getStudentsBelongToModule(moduleCode);
    }

    
    

    /**
     *
     */
    public void print()
    {
    System.out.println(this.moduleTitle+ " " + this.credits + " " + 
            this.moduleCode + " " + this.level + " " + this.semester);
    }

    /**
     *
     */
    public void printStudents()
    {
    System.out.println("moduleTitle: " + this.moduleTitle+ " credits: " +
            this.credits + " " + "moduleCode: " +this.moduleCode + " level: " + 
            this.level + " semester: " + this.semester);
    
    if( false == students.isEmpty())
        {
            int i  = 0 ;
            System.out.println("Students belong to this module: ");
            for(Student student : students)
            {
            System.out.print(++i + ". ");
            student.print();
            }
        }
    
    }

    /**
     *
     * @param student
     */
    public void addStudent(Student student)
    {
    System.out.println("student: " + student.getForename() + "module: " + 
            this.moduleTitle+ " connected successfully");
    students.add(student);
    }
    
    /**
     *
     * @param studentNo
     * @return
     */
    public Module deleteStudent(String studentNo)
    {
    Iterator<Student> iter = students.iterator();
    
    while(iter.hasNext())
        {
        Student stu = iter.next();
        if(stu.getStudentNo().equalsIgnoreCase(studentNo))
            {
            iter.remove();
            System.out.println("\n REMOVED:" +  stu.getStudentNo()
                + "module: " + this.moduleCode);
            }
        }
    return this;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Student> getStudents()
    {
    return students;
    }
    
    
    /**
     * Get the value of moduleCode
     *
     * @return the value of moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Set the value of moduleCode
     *
     * @param moduleCode new value of moduleCode
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Get the value of credits
     *
     * @return the value of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Set the value of credits
     *
     * @param credits new value of credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Get the value of semester
     *
     * @return the value of semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set the value of semester
     *
     * @param semester new value of semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    
     /**
     * Get the value of level
     *
     * @return the value of level
     */
    public int getLevel() {
        return level;
    }
  
    /**
     * Set the value of level
     *
     * @param level new value of level
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Get the value of moduleTitle
     *
     * @return the value of moduleTitle
     */
    public String getModuleTitle() {
        return moduleTitle;
    }

    /**
     * Set the value of moduleTitle
     *
     * @param moduleTitle new value of moduleTitle
     */
    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }
    
    /**
     *
     * @return
     */
    public String toStringmoduleTitile()
    {
    return this.moduleTitle;
    }

    /**
     *
     * @return
     */
    public String toStringmoduleCode()
    {
    return this.moduleCode;
    }
    
    
}
