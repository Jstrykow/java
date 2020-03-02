/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005;

import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class Register {
ArrayList<Student> students;

    /**
     *
     * @param moduleId
     * @param noOfAttenders
     * @param weekNo
     */
    public Register(int moduleId, int noOfAttenders, int weekNo) {
        this.moduleId = moduleId;
        this.noOfAttenders = noOfAttenders;
        this.weekNo = weekNo;
    }
    
    private int moduleId;

    /**
     *
     * @param studentsIn
     */
    public void addStudents(ArrayList<Student> studentsIn)
    {
    this.students = studentsIn;
    }
    
    /**
     *
     * @param studentIn
     * @return
     */
    public boolean checkStudent(Student studentIn)
    {
        for(Student student : students)
        {
        if(student == studentIn)
        {
            return true;
        }
        }
        return false;
    }
    
    
    public String toString()
    {
        return "weekNo: " + this.weekNo + "nof: " + this.noOfAttenders+
                " moduleId: " + this.moduleId;
    }

    /**
     *
     */
    public void print()
    {
        System.out.println(this.toString());
    }
    /**
     * Get the value of moduleId
     *
     * @return the value of moduleId
     */
    public int getModuleId() {
        return moduleId;
    }

    /**
     * Set the value of moduleId
     *
     * @param moduleId new value of moduleId
     */
    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    private int noOfAttenders;

    /**
     * Get the value of noOfAttenders
     *
     * @return the value of noOfAttenders
     */
    public int getNoOfAttenders() {
        return noOfAttenders;
    }

    /**
     * Set the value of noOfAttenders
     *
     * @param noOfAttenders new value of noOfAttenders
     */
    public void setNoOfAttenders(int noOfAttenders) {
        this.noOfAttenders = noOfAttenders;
    }

    private int weekNo;

    /**
     * Get the value of weekNo
     *
     * @return the value of weekNo
     */
    public int getWeekNo() {
        return weekNo;
    }

    /**
     * Set the value of weekNo
     *
     * @param weekNo new value of weekNo
     */
    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

}
