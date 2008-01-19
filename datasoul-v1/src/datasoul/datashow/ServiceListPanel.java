/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * ServiceListPanel.java
 *
 * Created on 26 de Dezembro de 2005, 23:14
 */

package datasoul.datashow;

import datasoul.templates.TemplateComboBox;
import datasoul.util.*;
import datasoul.song.*;
import datasoul.util.ObjectManager;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.DefaultCellEditor;
import javax.swing.JFileChooser;
import javax.swing.event.TableModelEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.serialize.OutputFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author  Administrador
 */
public class ServiceListPanel extends javax.swing.JPanel implements javax.swing.event.TableModelListener{

    private String fileName="";
    /**
     * Creates new form ServiceListPanel
     */
    public ServiceListPanel() {
        initComponents();
       
       ServiceListTable serviceListTable = ServiceListTable.getActiveInstance();
       
       serviceListTable.addTableModelListener(this);        
        
       tableServiceList.setModel(serviceListTable);

        //initTemplateCombo
        TemplateComboBox comboBox = new TemplateComboBox(); 
        comboBox.setFilterType(TemplateComboBox.FILTER_GENERAL);
        this.tableServiceList.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));          
        
        ServiceListColorRender cr = new ServiceListColorRender();
        
        this.tableServiceList.getColumnModel().getColumn(0).setCellRenderer(cr);
        this.tableServiceList.getColumnModel().getColumn(1).setCellRenderer(cr);        
    }

    
    private String getFileName(){
        return this.fileName;
    }
    private void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void tableChanged(TableModelEvent e) {
        this.repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmFile = new javax.swing.JPopupMenu();
        actOpen = new javax.swing.JMenuItem();
        actSave = new javax.swing.JMenuItem();
        actSaveAs = new javax.swing.JMenuItem();
        actExport = new javax.swing.JMenuItem();
        ppmAddItem = new javax.swing.JPopupMenu();
        actAddSong = new javax.swing.JMenuItem();
        actAddText = new javax.swing.JMenuItem();
        actImportItem = new javax.swing.JMenuItem();
        toolBar = new javax.swing.JToolBar();
        btnAddWizard = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        scroolServiceList = new javax.swing.JScrollPane();
        tableServiceList = new datasoul.util.DnDTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnFile = new javax.swing.JButton();

        actOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/fileopen.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        actOpen.setText(bundle.getString("Open")); // NOI18N
        actOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actOpenActionPerformed(evt);
            }
        });
        ppmFile.add(actOpen);

        actSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesave.png"))); // NOI18N
        actSave.setText(bundle.getString("Save")); // NOI18N
        actSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actSaveActionPerformed(evt);
            }
        });
        ppmFile.add(actSave);

        actSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesaveas.png"))); // NOI18N
        actSaveAs.setText(bundle.getString("Save_as")); // NOI18N
        actSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actSaveAsActionPerformed(evt);
            }
        });
        ppmFile.add(actSaveAs);

        actExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/compfile.png"))); // NOI18N
        actExport.setText(bundle.getString("Export")); // NOI18N
        actExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actExportActionPerformed(evt);
            }
        });
        ppmFile.add(actExport);

        actAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/playsound.png"))); // NOI18N
        actAddSong.setText(bundle.getString("Add_Song")); // NOI18N
        actAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddSongActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddSong);

        actAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/kwrite.png"))); // NOI18N
        actAddText.setText(bundle.getString("Add_Text")); // NOI18N
        actAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actAddTextActionPerformed(evt);
            }
        });
        ppmAddItem.add(actAddText);

        actImportItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/document.png"))); // NOI18N
        actImportItem.setText(bundle.getString("Import_Item")); // NOI18N
        actImportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actImportItemActionPerformed(evt);
            }
        });
        ppmAddItem.add(actImportItem);

        toolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        toolBar.setFloatable(false);
        toolBar.setMinimumSize(new java.awt.Dimension(30, 25));
        toolBar.setOpaque(false);

        btnAddWizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/window_new.png"))); // NOI18N
        btnAddWizard.setText(bundle.getString("Add_Item")); // NOI18N
        btnAddWizard.setToolTipText(bundle.getString("Add_wizard_...")); // NOI18N
        btnAddWizard.setAlignmentY(0.0F);
        btnAddWizard.setBorderPainted(false);
        btnAddWizard.setFocusPainted(false);
        btnAddWizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        toolBar.add(btnAddWizard);

        jSeparator1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        toolBar.add(jSeparator1);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/editdelete.png"))); // NOI18N
        btnRemove.setText(bundle.getString("Delete")); // NOI18N
        btnRemove.setToolTipText(bundle.getString("Delete_item")); // NOI18N
        btnRemove.setAlignmentY(0.0F);
        btnRemove.setBorderPainted(false);
        btnRemove.setFocusPainted(false);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        toolBar.add(btnRemove);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edit.png"))); // NOI18N
        btnEdit.setToolTipText(bundle.getString("Edit_selected_item_...")); // NOI18N
        btnEdit.setAlignmentY(0.0F);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        toolBar.add(btnEdit);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/up.png"))); // NOI18N
        btnUp.setToolTipText(bundle.getString("Change_item_order_to_upper_position")); // NOI18N
        btnUp.setAlignmentY(0.0F);
        btnUp.setBorderPainted(false);
        btnUp.setFocusPainted(false);
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });
        toolBar.add(btnUp);

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/down.png"))); // NOI18N
        btnDown.setToolTipText(bundle.getString("Change_item_order_to_lower_position")); // NOI18N
        btnDown.setAlignmentY(0.0F);
        btnDown.setBorderPainted(false);
        btnDown.setFocusPainted(false);
        btnDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownMouseClicked(evt);
            }
        });
        toolBar.add(btnDown);

        tableServiceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableServiceList.setCellSelectionEnabled(true);
        tableServiceList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableServiceListKeyPressed(evt);
            }
        });
        tableServiceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServiceListMouseClicked(evt);
            }
        });
        scroolServiceList.setViewportView(tableServiceList);

        jToolBar1.setFloatable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/klipper_dock.png"))); // NOI18N
        jLabel1.setText(bundle.getString("Service_List")); // NOI18N
        jToolBar1.add(jLabel1);

        jSeparator2.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jToolBar1.add(jSeparator2);

        btnFile.setText(bundle.getString("File")); // NOI18N
        btnFile.setBorderPainted(false);
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
            .addComponent(scroolServiceList, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(scroolServiceList, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actImportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actImportItemActionPerformed
        ImportServiceItemForm isif = new ImportServiceItemForm();
        isif.setVisible(true);
    }//GEN-LAST:event_actImportItemActionPerformed

    private void actAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddTextActionPerformed
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(new TextServiceItem());
        tsief.setVisible(true);
    }//GEN-LAST:event_actAddTextActionPerformed

    private void actAddSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actAddSongActionPerformed
        AddSongForm asf = new AddSongForm();
        asf.setVisible(true);
    }//GEN-LAST:event_actAddSongActionPerformed

    private void actExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actExportActionPerformed

        SongExportPanel sep = new SongExportPanel();
        sep.setVisible(true);
    }//GEN-LAST:event_actExportActionPerformed

    private void actSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actSaveAsActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() { 
                      public boolean accept(File f) { 
                          if (f.isDirectory()) { 
                              return true; 
                          } 
                          String name = f.getName(); 
                          if (name.endsWith(".servicelist")) { 
                              return true; 
                          } 
                          return false; 
                      } 
   
                      public String getDescription() { 
                          return ".servicelist"; 
                      } 
                  });
        File dir = new File (System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") + "servicelists");
        fc.setCurrentDirectory(dir);
        fc.setDialogTitle(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Select_the_file_to_save."));
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile().getPath();
            if(!fileName.contains(".servicelist"))
                 fileName = fileName + ".servicelist";            
            saveFile();
        }

    }//GEN-LAST:event_actSaveAsActionPerformed

    private void actSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actSaveActionPerformed
        if(!fileName.contains(".servicelist"))
            fileName = fileName + ".servicelist";

        if(fileName.equals("")){
            actSaveAsActionPerformed(evt);
            return;
        }
        
        saveFile();
    }//GEN-LAST:event_actSaveActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        ppmFile.show(btnFile, 0 /*btnFile.getWidth()-ppmFile.getWidth()*/, btnFile.getHeight());
    }//GEN-LAST:event_btnFileActionPerformed

    private void actOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actOpenActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() { 
                      public boolean accept(File f) { 
                          if (f.isDirectory()) { 
                              return true; 
                          } 
                          String name = f.getName(); 
                          if (name.endsWith(".servicelist")) { 
                              return true; 
                          } 
                          return false; 
                      } 
   
                      public String getDescription() { 
                          return ".servicelist"; 
                      } 
                  });
        File dir = new File (System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") + "servicelists");
        fc.setCurrentDirectory(dir);
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile().getPath();

            File file = new File(fileName);

            Document dom=null;
            Node node = null;
            ServiceListTable slt;
            try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                    //Using factory get an instance of document builder
                    DocumentBuilder db = dbf.newDocumentBuilder();

                    //parse using builder to get DOM representation of the XML file
                    dom = db.parse(file);

                    //node = dom.getDocumentElement().getChildNodes().item(0);
                    node = dom.getElementsByTagName("ServiceListTable").item(0);

            }catch(Exception e) {
                ShowDialog.showReadFileError(file, e);
            }        

            slt = ServiceListTable.getActiveInstance();
            try {
                slt.readObject(node);
            } catch (Exception e) {
                ShowDialog.showReadFileError(file, e);
            }
         
            tableServiceList.setModel(slt);
        }
    }//GEN-LAST:event_actOpenActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        if (tableServiceList.getSelectedRow() == -1){
            return;
        }
        
        ServiceItem item = (ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0);
        if(item instanceof Song){
            SongEditorForm sef = new SongEditorForm((Song)item);
            sef.setVisible(true);
        }else if(item instanceof TextServiceItem){
            TextServiceItemEditorForm tsief = new TextServiceItemEditorForm((TextServiceItem)item);
            tsief.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ppmAddItem.show(this.btnAddWizard, 0, btnAddWizard.getHeight());
    }//GEN-LAST:event_btnAddActionPerformed

    private void tableServiceListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableServiceListKeyPressed
        showItem();
    }//GEN-LAST:event_tableServiceListKeyPressed

    private void tableServiceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiceListMouseClicked
        showItem();
    }//GEN-LAST:event_tableServiceListMouseClicked

    private void showItem(){
        
        try{
            ObjectManager.getInstance().setBusyCursor();
            if(ObjectManager.getInstance().getViewActive()==ObjectManager.VIEW_PROJECTOR){
                if(ObjectManager.getInstance().getPreviewPanel()!=null)
                    ObjectManager.getInstance().getPreviewPanel().previewItem((ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0));
            }
            if(ObjectManager.getInstance().getViewActive()==ObjectManager.VIEW_SONGS){
                ServiceItem item = (ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0);
                if(item instanceof Song)
                    if(ObjectManager.getInstance().getSongViewerPanel()!=null)
                        ObjectManager.getInstance().getSongViewerPanel().viewSong((Song)item);
            }
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
    }
    
    private void saveFile(){
        try{
            ServiceListTable slt = (ServiceListTable)tableServiceList.getModel();
            Node node = slt.writeObject();
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(fileName);
            org.apache.xml.serialize.XMLSerializer xs = new org.apache.xml.serialize.XMLSerializer();
            OutputFormat outFormat = new OutputFormat();
            outFormat.setIndenting(true);
            outFormat.setEncoding("ISO-8859-1");
            xs.setOutputFormat(outFormat);
            xs.setOutputByteStream(fos);
            xs.serialize(doc);

        } catch(Exception e){
            ShowDialog.showWriteFileError(fileName, e);
        }
    }

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        tableServiceList.removeItem();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownMouseClicked
        tableServiceList.downItem();
    }//GEN-LAST:event_btnDownMouseClicked

    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpMouseClicked
        tableServiceList.upItem();
    }//GEN-LAST:event_btnUpMouseClicked
    
    public void addItem(Object object){
        ((ListTable)tableServiceList.getModel()).addItem(object);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actAddSong;
    private javax.swing.JMenuItem actAddText;
    private javax.swing.JMenuItem actExport;
    private javax.swing.JMenuItem actImportItem;
    private javax.swing.JMenuItem actOpen;
    private javax.swing.JMenuItem actSave;
    private javax.swing.JMenuItem actSaveAs;
    private javax.swing.JButton btnAddWizard;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu ppmAddItem;
    private javax.swing.JPopupMenu ppmFile;
    private javax.swing.JScrollPane scroolServiceList;
    private datasoul.util.DnDTable tableServiceList;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    
}
