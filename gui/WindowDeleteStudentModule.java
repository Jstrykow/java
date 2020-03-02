/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.gui;

import cis4005.Student;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import cis4005.Module;

/**
 *
 * @author jacob
 */
public class WindowDeleteStudentModule extends javax.swing.JFrame {
private Menu mainMenu;
DefaultListModel<Student> modelStudent;
DefaultListModel<Module> modelModule;
ArrayList<Student> students;
ArrayList<Module> modules;

    /**
     * Creates new form WindowStudentModule
     * @param mainMenu
     */
    public WindowDeleteStudentModule(Menu mainMenu) {
        initComponents();
        this.mainMenu=mainMenu;
        
       
        int i = 0;
        DefaultListModel<String> modelModule = new DefaultListModel<>();
        modules = mainMenu.menugetModules();
        for(Module module: modules)
        {
            modelModule.add(i++, module.toStringmoduleTitile() + " "
                    + module.toStringmoduleCode());
        }
        jList2.setModel((ListModel)modelModule);
        //DefaultListModel<String> modelStudent = new DefaultListModel<>();
        
        /*students = this.getStudnetList();
        i = 0;
        {
        for(Student student : students)
        {
            modelStudent.add(i++, student.toStringStudentName() + " " + 
                    student.toStringStudentNo());
        }
        }
        jList1.setModel((ListModel)modelStudent);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Delete Connection");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     int temp1 = jList1.getSelectedIndex();
     int temp2 = jList2.getSelectedIndex();
     
     //System.out.println("studeent: " + temp1+  "module: " + temp2);
     students = modules.get(temp2).getStudents();
     if(students != null)
     {
        if(temp1 > -1)
        {
            students.get(temp1).print();
            mainMenu.DisconnectStudentModule(students.get(temp1).getStudentNo()
                    , modules.get(temp2).getModuleCode());
        }
     }
     modules = mainMenu.menugetModules();
     DefaultListModel<String> modelStudent = new DefaultListModel<>();
     modelStudent.add(0, " ");
     jList1.setModel(modelStudent);
     modelStudent.removeAllElements();
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
       
      
    }//GEN-LAST:event_jList2ValueChanged

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked

        //students = this.getStudnetList(modules.get(jList2.getSelectedIndex()).getModuleCode());
        DefaultListModel<String> modelStudent = new DefaultListModel<>();
        int temp = jList2.getSelectedIndex();
        students = this.getStudnetList(modules.get(temp).getModuleCode());
        int i = 0;
        if(students != null)
        {
        for(Student student : students)
        {
            modelStudent.add(i++, student.toStringStudentName() + " " + 
                    student.toStringStudentNo());
            System.out.print(temp);
        }
        } 
        jList1.setModel((ListModel)modelStudent);
        
        
      
      
    }//GEN-LAST:event_jList2MouseClicked
    
    private ArrayList<Student> getStudnetList()
    {
        return mainMenu.menugetStudents();
    }
    private ArrayList<Student> getStudnetList(final String moduleCode)
    {
        return mainMenu.menugetStudentsByModule(moduleCode);
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}