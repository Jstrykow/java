/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005;
import cis4005.connection.*;
import java.util.ArrayList;
import cis4005.gui.Menu;

/**
 *
 * @author jacob
 */
public class Cis4005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      StudentConnection studentConnect = new StudentConnection("cis4005");
      ModuleConnection moduleConnect = new ModuleConnection("cis4005");
      ProgrammeConnection programmeConnection = new ProgrammeConnection("cis4005");
    //  RegisterConnection registerConnection = new RegisterConnection("cis4005");
        MySystem sys = new MySystem(studentConnect,moduleConnect,
             programmeConnection);
    }
    }
        
/**
 * register system in not coded in case of lack of time, but the check user in 
 * gui after clicking button "check" generates on screen warning for each student
 * and value of week number
 */
         
      