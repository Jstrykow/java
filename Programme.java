/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005;

import java.util.ArrayList;
import cis4005.connection.ProgrammeConnection;
import cis4005.connection.ModuleProgrammeConnection;
import cis4005.connection.ModuleConnection;
import java.util.Iterator;


/**
 *
 * @author jacob
 */
public class Programme {
    private  final String programmeCode;
    private final String programmeName;
    ArrayList <Module> modules;
   
    /**
     *
     * @param programmeCode
     * @param programmeName
     */
    public Programme(final String programmeCode, final String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        //ProgrammeConnection connect = new ProgrammeConnection("cis4005");
        ModuleProgrammeConnection connect2 = new ModuleProgrammeConnection("cis4005");
        this.modules = connect2.getModulesBelongToPogramme(programmeCode);
        
    }
   
    /**
     *
     */
    public void print(){
        System.out.println("programmecode: " + this.programmeCode +
                " programmeName: " + this.programmeName);
        
        if( false == modules.isEmpty())
        {
            int i  = 0 ;
            for(Module module : modules)
            {
                modules.get(i++).print();
            }
        }
    }
    
    /**
     *
     * @param module
     */

    public void addModule(Module module)
    {
    System.out.println("module: " + module.getModuleCode() + "programme: " + 
            this.programmeName+  " connected successfully");
    modules.add(module);
    }

    /**
     *
     * @return
     */
    public ArrayList<Module> getModules()
    {
        return modules;
    }
   
    /**
     *
     * @param moduleCode
     * @return 
     */
    public Programme deleteModule(String moduleCode)
    {   
    Iterator<Module> iter = modules.iterator();
    
    while(iter.hasNext())
        {
        Module mod = iter.next();
        if(mod.getModuleCode().equalsIgnoreCase(moduleCode))
            {
            iter.remove();
            System.out.println("\n REMOVED:" +  mod.getModuleCode()
                + "programme: " + this.programmeCode);
            }
        }
    return this;
        }
    
    
    /**
     * Get the value of programmeName
     *
     * @return the value of programmeName
     */
    public String getProgrammeName() 
    {
        return programmeName;
    }

    /**
     * Get the value of programmeCode
     *
     * @return the value of programmeCode
     */
    public String getProgrammeCode() {
        return programmeCode;
    }
    
    @Override
    public String toString()
    {
    return programmeName + " " + programmeCode;
    }

}
