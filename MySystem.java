/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cis4005;
import cis4005.connection.StudentConnection;
import cis4005.connection.ModuleConnection;
import cis4005.connection.ProgrammeConnection;
import java.util.ArrayList;
import cis4005.Student;
import cis4005.connection.ModuleProgrammeConnection;
import cis4005.connection.StudentModuleConnection;
import java.util.Iterator;
import cis4005.connection.*;
/**
 *
 * @author jacob
 */
public class MySystem {
    ArrayList<Programme> programmes;
    ArrayList<Student> students;
    ArrayList<Module> modules;
    ArrayList<Register> registers;
    
    /**
     *
     * @param studentConnect
     * @param moduleConnect
     * @param programmeConnection
     */
    public MySystem( StudentConnection studentConnect, ModuleConnection moduleConnect,
            ProgrammeConnection programmeConnection){
        students = studentConnect.getStudents();
        modules = moduleConnect.getModules();
        programmes = programmeConnection.getProgrammes();
        //registers = registerConnection.getReggisters();
        
    }           
 
    /**
     *
     * @param moduleTitle
     * @param credits
     * @param moduleCode
     * @param level
     * @param semester
     */
    public void createModule(String moduleTitle, int credits, 
           String moduleCode,int level, int semester)
   {
       Module module = new Module(moduleTitle, credits, moduleCode, level, semester);
       modules.add(module);
       ModuleConnection connect = new ModuleConnection("cis4005");
       connect.insertRecord(moduleTitle, credits, moduleCode, level, semester);
       connect = null;
   }
   
 
   //it would be used in menu

    /**
     *
     * @param forename
     * @param surname
     * @param studentNo
     * @param fullPartTime
     */
   public void createStudent(String forename, String surname, String studentNo, 
            String fullPartTime)
   {
        Student student = new Student(forename, surname, studentNo, fullPartTime);
        students.add(student);
        StudentConnection connect = new StudentConnection("cis4005");
        connect.insertRecord(forename, surname, studentNo, fullPartTime);
        connect = null;
   }

    /**
     *
     * @param programmeCode
     * @param programmeName
     */
    public void createProgramme(String programmeCode, String programmeName)
   {
       Programme programme = new Programme(programmeCode, programmeName);
       programmes.add(programme);
   }

    /**
     *
     * @param moduleCode
     * @param programmeCode
     */
    public void ConnectModuleProgramme( String moduleCode, String programmeCode)
   {
   int i=0;
   for(Module module : modules)
   {
    if(moduleCode.equalsIgnoreCase(modules.get(i).getModuleCode()))
          {
          int j = 0;
          for(Programme programme : programmes )
              {
                 if(programmeCode.equals(programmes.get(j).getProgrammeCode()))
                      {
                     ModuleProgrammeConnection connect = new ModuleProgrammeConnection("cis4005");
                    ProgrammeConnection connectProgramme = new ProgrammeConnection("cis4005");
                    ModuleConnection connectModule = new ModuleConnection("cis4005");
                    programmes.get(j).addModule(modules.get(i));
                   // connect.insertRecord(connectModule.getModuleId(module.getModuleCode()), 
                    // connectProgramme.getProgrammeId(programmeCode));
                    break;
                      }
              j++;
              }
          }
    i++;
   }
   }
  
    /**
     *
     * @param studentNo
     * @param moduleCode
     * @return
     */
    public String ConnectStudentModule( final String studentNo, final String moduleCode)
   {
   int i=0;
   for(Module module : modules)
   {
     if(moduleCode.equalsIgnoreCase(module.getModuleCode()))
          {
          int j = 0;
          for(Student student : students )
              {
              if(studentNo.equalsIgnoreCase(student.getStudentNo()))
                 {
                      modules.get(i).addStudent(students.get(j));
                      
                      StudentModuleConnection connect = 
                              new StudentModuleConnection("cis4005");
                      ModuleConnection connectModule =
                              new ModuleConnection("cis4005");
                      StudentConnection connectStudent =
                              new StudentConnection("cis4005");
                      
                      connect.insertRecord(
                        connectStudent.getStudentId(student.getStudentNo()), 
                        connectModule.getModuleId(moduleCode));
                      
                      return "connencted: " +  studentNo + " " + moduleCode;             
                 }
              j++;
               } 
          }
     i++;
    }
   return "dont connected" +studentNo + " " + moduleCode; 
   }
   
    /**
     *
     * @param studentNo
     * @param moduleCode
     */
    public void DisconnectStudentModule( String studentNo, String moduleCode)
   {
    Iterator<Module> iter = modules.iterator();
    int i = 0;
      while(iter.hasNext())
         {
         Module mod = iter.next();
         if(moduleCode.equalsIgnoreCase(mod.getModuleCode()))
           {
                 Iterator<Student> iter2 = students.iterator();
                 while(iter2.hasNext())
                 {
                 Student stu = iter2.next();
                 if(studentNo.equalsIgnoreCase(stu.toStringStudentNo()))
                    {
                    mod.deleteStudent(studentNo);
                    StudentModuleConnection connect = 
                            new StudentModuleConnection("cis4005");
                    connect.DeleteRecord(studentNo, moduleCode);
                    }
                 }

     }
    i++;
   }    
      
   }
   
    /**
     *
     * @param moduleCode
     * @param programmeCode
     */
    public void DisconnectModuleProgramme( String moduleCode, String programmeCode)
   {
    Iterator<Programme> iter = programmes.iterator();
      while(iter.hasNext())
         {
         Programme pro = iter.next();
         if(programmeCode.equalsIgnoreCase(pro.getProgrammeCode()))
           {
                 Iterator<Module> iter2 = modules.iterator();
                 while(iter2.hasNext())
                 {
                 Module mod = iter2.next();
                 if(moduleCode.equalsIgnoreCase(mod.getModuleCode()))
                    {
                    pro.deleteModule(moduleCode);
                    ModuleProgrammeConnection connect = 
                            new ModuleProgrammeConnection("cis4005");
                    connect.DeleteRecord(moduleCode, programmeCode);
                    }
                 }

     }
   }    
   }

    /**
     *
     */
    public void printAllStudents()
   {
    System.out.println("\nAll students: ");
    int i = 0; 
    for(Student student : students)
    { 
       students.get(i++).print();
    }    
   }

    /**
     *
     */
    public void printAllModules()
   {
    System.out.println("\nAll Modules: ");
    int i = 0; 
    for(Module module : modules)
    { 
     module.print();
    }    
   }

    /**
     *
     */
    public void printAllModulesWithStudents()
   {
    System.out.println("\nAll Modules: ");
    int i = 0; 
    for(Module module : modules)
    { 
     module.printStudents();
    }    
   }

    /**
     *
     */
    public void printAllProgrammes()
   {
    System.out.println("\nAll Programmes: ");
    int i  = 0;
    for(Programme programme : programmes)
    { 
    if(programmes.get(i) != null)
    programmes.get(i++).print();
    }    
   }
   
    /**
     *
     */
    public void printAll()
   {
     this.printAllProgrammes();
     this.printAllModulesWithStudents();
     this.printAllStudents();
   }
  
    /**
     *
     * @return students it is used to update from jdbc at start of programme
     */
    public ArrayList<cis4005.Student> getStudents()
{
  StudentConnection connect = new StudentConnection("cis4005");
  return connect.getStudents();
}

    /**
     *
     * @return students it is used to update after changes
     */
    public ArrayList<cis4005.Student> getStudents2()
{
  return students;
}

    /**
     *
     * @param moduleCode
     * @return students belong to module with @moduleCode
     */
    public ArrayList<cis4005.Student> getStudents(String moduleCode)
{
  for(Module module : modules)
  {
      if(module.getModuleCode().equalsIgnoreCase(moduleCode))
      {
      return module.getStudents();
      }
      
  }
  return null;
}

    /**
     *
     * @param programmeCode
     * @return modulse belongs to programme with programmeC
     */
    public ArrayList<cis4005.Module> getModules(String programmeCode)
{
  for(Programme programme : programmes)
  {
      if(programme.getProgrammeCode().equalsIgnoreCase(programmeCode))
      {
      return programme.getModules();
      }
      
  }
  return null;
}

    /**
     *
     * @return modules it is used to update from jdbc at start of programme
     */
    public ArrayList<cis4005.Module> getModules()
{
  
  ModuleConnection connect = new ModuleConnection("cis4005");
  return connect.getModules();
  
}

    /**
     *
     * @return modules it is used to update after changes
     */
    public ArrayList<cis4005.Module> getModules2()
{
  return modules;
}

    /**
     *
     * @return programmes it is used to update from jdbc at start of programme
     */
    public ArrayList<cis4005.Programme> getProgrammes()
{
  ProgrammeConnection programmeConnection = new ProgrammeConnection("cis4005");
  return programmeConnection.getProgrammes();
}

    /**
     *
     * @return programmes it is used to update after changes
     */
    public ArrayList<cis4005.Programme> getProgrammes2()
{
  return programmes;
}

    /*
  
    public void printRegisters()
{
 System.out.println("\nAll Programmes: ");
    int i  = 0;
    for(Register register : registers)
    { 
    if(registers.get(i) != null)
    registers.get(i++).print();
    }    
}

    */
    
//public boolean checkRegister(String studentNo, String moduleCode, int weekNo)
//{
    /*
for(Student student : students)
{
    if(student.getStudentNo().equalsIgnoreCase(studentNo))
    {
        if(student.getFullPartTime().equalsIgnoreCase("F") ||
                student.getFullPartTime().equalsIgnoreCase("f"))
        {
            
        }
        else if(student.getFullPartTime().equalsIgnoreCase("P") ||
                student.getFullPartTime().equalsIgnoreCase("p"))
        {
            
        }
    }
}
return false;
}
*/
}
