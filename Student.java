/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005;

import cis4005.connection.StudentConnection;

/**
 *
 * @author jacob
 */
public class Student {
    private String forename;
    
    private String surname;
    
    private String studentNo;

    private String fullPartTime;

    /**
     *
     * @param forename
     * @param surname
     * @param studentNo
     * @param fullPartTime
     */
    public Student(String forename, String surname, String studentNo, 
            String fullPartTime) {
        this.forename = forename;
        this.surname = surname;
        this.studentNo = studentNo;
        this.fullPartTime = fullPartTime;
    }

    /**
     *
     */
    public void print(){
        System.out.println(this.forename + " " +this.surname + " " + 
                this.studentNo + " " +   this.fullPartTime);
    }
    
    /**
     * Get the value of fullPartTime
     *
     * @return the value of fullPartTime
     */
    public String getFullPartTime() {
        return fullPartTime;
    }

    /**
     * Set the value of fullPartTime
     *
     * @param fullPartTime new value of fullPartTime
     */
    public void setFullPartTime(String fullPartTime) {
        this.fullPartTime = fullPartTime;
    }

    /**
     * Get the value of studentNo
     *
     * @return the value of studentNo
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * Set the value of studentNo
     *
     * @param studentNo new value of studentNo
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * Get the value of surname
     *
     * @return the value of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the value of surname
     *
     * @param surname new value of surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get the value of forename
     *
     * @return the value of forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * Set the value of forename
     *
     * @param forename new value of forename
     */
    public void setForename(String forename) {
        this.forename = forename;
    }
    
    /**
     *
     * @return
     */
    public String toStringStudentName()
    {
    return this.forename + " " + this.surname;
    }

    /**
     *
     * @return
     */
    public String toStringStudentNo()
    {
    return this.studentNo;
    }
    @Override
    public String toString()
    {
    StudentConnection connect = new StudentConnection("cis4005");
    return connect.getStudentId(studentNo) +". " + this.forename + " " 
            + this.surname + " studentNo: " + this.studentNo
            + " full/part: " +fullPartTime;
    }
}
