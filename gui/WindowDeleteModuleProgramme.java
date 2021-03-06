/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis4005.gui;

import cis4005.Programme;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import cis4005.Module;

/**
 *
 * @author jacob
 */
public class WindowDeleteModuleProgramme extends javax.swing.JFrame {
private Menu mainMenu;
DefaultListModel<Programme> modelProgramme;
DefaultListModel<Module> modelModule;
ArrayList<Programme> programmes;
ArrayList<Module> modules;

    /**
     * Creates new form WindowStudentModule
     * @param mainMenu
     */
    public WindowDeleteModuleProgramme(Menu mainMenu) {
        initComponents();
        this.mainMenu=mainMenu;
        
       
        int i = 0;
        DefaultListModel<String> modelProgramme = new DefaultListModel<>();
        programmes = mainMenu.menugetProgrammes();
        for(Programme programme : programmes)
        {
            modelProgramme.add(i++, programme.getProgrammeName()+ " "
                    + programme.getProgrammeCode());
        }
        jList2.setModel((ListModel)modelProgramme);
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
     
     System.out.println("module: " + temp1+  "programe " + temp2);
     modules = programmes.get(temp2).getModules();
     if(modules != null)
     {
        if(temp1 > -1)
        {
            modules.get(temp1).print();
            mainMenu.DisconnectModuleProgramme(modules.get(temp1).getModuleCode()
                    , programmes.get(temp2).getProgrammeCode());
        }
     }
     programmes = mainMenu.menugetProgrammes();
     DefaultListModel<String> modelModule = new DefaultListModel<>();
     modelModule.add(0, " ");
     jList1.setModel(modelModule);
     modelModule.removeAllElements();
     
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
       
      
    }//GEN-LAST:event_jList2ValueChanged

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked

        modules = this.getModuleList(programmes.get(jList2.getSelectedIndex()).getProgrammeCode());
        DefaultListModel<String> modelModule = new DefaultListModel<>();
        int temp = jList2.getSelectedIndex();
        int i = 0;
        if(modules != null)
        {
        for(Module module :modules)
        {
            modelModule.add(i++, module.toStringmoduleTitile()+ " " + 
                    module.toStringmoduleCode());
        }
        } 
        jList1.setModel((ListModel)modelModule); 
        
      
      
    }//GEN-LAST:event_jList2MouseClicked
    
     private ArrayList<Module> getModuleList()
    {
        return mainMenu.menugetModules();
    }
    
    private ArrayList<Module> getModuleList(final String programmeCode)
    {
        return mainMenu.menugetModules(programmeCode);
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
