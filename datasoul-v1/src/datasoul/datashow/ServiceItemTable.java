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
 * ServiceItemTable.java
 *
 * Created on February 10, 2006, 11:22 PM
 */

package datasoul.datashow;

import java.awt.event.KeyListener;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author  samuelm
 */
public class ServiceItemTable extends javax.swing.JPanel implements ListSelectionListener {
    
    ServiceItem item;
    
    /** Creates new form ServiceItemTable */
    public ServiceItemTable() {
        initComponents();
        /*
        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put( 1, new JLabel("Small") );
        labels.put( 5, new JLabel("Large") );
        jSliderZoom.setLabelTable(labels);
        */
        
        ServiceItem empty = new ServiceItem();
        setServiceItem(empty);
        
        this.displayTable.addKeyListener(new ServiceItemTableKeyListner(this));
        addTableListener(this);
    }

    public void setFocusInTable(){
        this.displayTable.requestFocus();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTemplate = new javax.swing.JLabel();

        setDoubleBuffered(false);

        jScrollPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jScrollPane1ComponentResized(evt);
            }
        });
        jScrollPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollPane1PropertyChange(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(displayTable);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        jLabel1.setText(bundle.getString("Template:")); // NOI18N

        lblTemplate.setText(bundle.getString("(none)")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTemplate)
                .addContainerGap(210, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemplate)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane1PropertyChange

    }//GEN-LAST:event_jScrollPane1PropertyChange

    private void jScrollPane1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentResized
        if (item != null){
            item.updateHeights(displayTable);
        }
        
    }//GEN-LAST:event_jScrollPane1ComponentResized
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTemplate;
    // End of variables declaration//GEN-END:variables
    
    public void setServiceItem(ServiceItem item){
        this.item = item;
        item.registerJTable(displayTable); 
        //item.setZoom( jSliderZoom.getValue() );
        item.updateHeights(displayTable);        
        lblTemplate.setText( item.getTemplate() );
        setSlideIndex(0);
    }

    public ServiceItem getServiceItem(){
        return this.item;        
    }
    
    public void addTableListener(ListSelectionListener listener){
        displayTable.getSelectionModel().addListSelectionListener(listener);
    }
    
    public String getSlideText(){
        
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = 0;
        }

        if (! (item instanceof TextServiceItem)){
            return "";
        }
        
        return ((TextServiceItem)item).getSlideText(selectedRow);
    }

    public String getNextSlideText(){
        
        int selectedRow = displayTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = 0;
        }
        
        if (selectedRow+1 >= displayTable.getRowCount()){
            return "";
        }

        if (! (item instanceof TextServiceItem)){
            return "";
        }
        
        return ((TextServiceItem)item).getSlideText(selectedRow+1);
    }
    
    public int getSlideIndex(){
        return displayTable.getSelectedRow();
    }

    public void setSlideIndex(int x){
        displayTable.changeSelection(x, 1, false, false);
    }

    public int getSlideCount(){
        return displayTable.getRowCount();
    }
    
    public void goNextMarkedSlide(){
        int actualSlide = getSlideIndex();
        int nextMarkedSlide = getServiceItem().getNextMarkedSlide(actualSlide);
        this.setSlideIndex(nextMarkedSlide);
    }
    public void goPreviousMarkedSlide(){
        int actualSlide = getSlideIndex();
        int previousMarkedSlide = getServiceItem().getPreviousMarkedSlide(actualSlide);
        setSlideIndex(previousMarkedSlide);
    }

    public void valueChanged(ListSelectionEvent e) {
        int x = displayTable.getSelectedRow();

        // try to show next two slides
        if ( (x + 2 > e.getLastIndex()) && (x + 2 < displayTable.getRowCount()) ) {
                displayTable.scrollRectToVisible( displayTable.getCellRect(x + 2, 0, true) );
        }else if ( (x + 1 > e.getLastIndex()) && (x + 1 < displayTable.getRowCount()) ) {
                displayTable.scrollRectToVisible( displayTable.getCellRect(x + 1, 0, true) );
        }
       
        // try to show previous two slides
        if ( (x - 2 < e.getFirstIndex()) && (x - 2 >= 0) ) {
                displayTable.scrollRectToVisible( displayTable.getCellRect(x - 2, 0, true) );
        }else if ( (x - 1 < e.getFirstIndex()) && (x - 1 >= 0 )) {
                displayTable.scrollRectToVisible( displayTable.getCellRect(x - 1, 0, true) );
        }

        // ensure that the actual slide is being shown
        displayTable.scrollRectToVisible( displayTable.getCellRect(x, 0, true) );
        
    }
    
    
}
