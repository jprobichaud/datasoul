/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 or later of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * TimerControlPanel.java
 *
 * Created on 24 May 2006, 23:42
 */

package datasoul.datashow;

import datasoul.config.ConfigObj;
import datasoul.util.ObjectManager;

/**
 *
 * @author  samuelm
 */
public class TimerControlPanel extends javax.swing.JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5844471576070312812L;
	/** Creates new form TimerControlPanel */
    public TimerControlPanel() {
        initComponents();
        btnTimerOff.setSelected(true);
        pnlTimerStart.setVisible(false);
        pnlTimerTotal.setVisible(false);
        ObjectManager.getInstance().setTimerControlPanel(this);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlTimerStart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        edtTimerStartMin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtTimerStartSec = new javax.swing.JTextField();
        pnlTimerTotal = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        edtTimerTotalMin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edtTimerTotalSec = new javax.swing.JTextField();
        btnTimerOff = new javax.swing.JToggleButton();
        btnTimerForward = new javax.swing.JToggleButton();
        btnTimerBackward = new javax.swing.JToggleButton();
        btnApplyTimer = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        jLabel1.setText(bundle.getString("TIMER DIRECTION")); // NOI18N

        pnlTimerStart.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText(bundle.getString("START")); // NOI18N
        pnlTimerStart.add(jLabel5);

        edtTimerStartMin.setText("00");
        edtTimerStartMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtTimerStartMinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtTimerStartMinKeyTyped(evt);
            }
        });
        pnlTimerStart.add(edtTimerStartMin);

        jLabel6.setText(":");
        pnlTimerStart.add(jLabel6);

        edtTimerStartSec.setColumns(2);
        edtTimerStartSec.setText("00");
        edtTimerStartSec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtTimerStartSecKeyTyped(evt);
            }
        });
        pnlTimerStart.add(edtTimerStartSec);

        pnlTimerTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText(bundle.getString("TOTAL")); // NOI18N
        pnlTimerTotal.add(jLabel7);

        edtTimerTotalMin.setText("00");
        edtTimerTotalMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtTimerTotalMinKeyTyped(evt);
            }
        });
        pnlTimerTotal.add(edtTimerTotalMin);

        jLabel8.setText(":");
        pnlTimerTotal.add(jLabel8);

        edtTimerTotalSec.setText("00");
        edtTimerTotalSec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtTimerTotalSecKeyTyped(evt);
            }
        });
        pnlTimerTotal.add(edtTimerTotalSec);

        btnTimerOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/media-playback-stop.png"))); // NOI18N
        btnTimerOff.setText(bundle.getString("OFF")); // NOI18N
        btnTimerOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerOffActionPerformed(evt);
            }
        });

        btnTimerForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/media-seek-forward.png"))); // NOI18N
        btnTimerForward.setText(bundle.getString("FORWARD")); // NOI18N
        btnTimerForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerForwardActionPerformed(evt);
            }
        });

        btnTimerBackward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/media-seek-backward.png"))); // NOI18N
        btnTimerBackward.setText(bundle.getString("BACKWARD")); // NOI18N
        btnTimerBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerBackwardActionPerformed(evt);
            }
        });

        btnApplyTimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/dialog-apply.png"))); // NOI18N
        btnApplyTimer.setText(bundle.getString("APPLY")); // NOI18N
        btnApplyTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyTimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnTimerBackward, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(btnTimerForward, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(btnTimerOff, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTimerStart, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTimerTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnApplyTimer, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimerOff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimerForward)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimerBackward)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTimerStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTimerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnApplyTimer)
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyTimerActionPerformed
        int min, sec, minTot, secTot;
        
        if (btnTimerOff.isSelected()){
            TimerManager.getInstance().setTimerOff();
        }else if (btnTimerForward.isSelected()){
            try{
                min = Integer.parseInt( edtTimerStartMin.getText() );
            }catch(Exception e){
                min = 0;
            }
            try{
                sec = Integer.parseInt( edtTimerStartSec.getText() );
                if (sec > 59)
                    sec = 59;
            }catch(Exception e){
                sec = 0;
            }
            TimerManager.getInstance().setTimerForward( (min*60 + sec)*1000 );
        }else if (btnTimerBackward.isSelected()){
            try{
                min = Integer.parseInt( edtTimerStartMin.getText() );
            }catch(Exception e){
                min = 0;
            }
            try{
                sec = Integer.parseInt( edtTimerStartSec.getText() );
                if (sec > 59)
                    sec = 59;
            }catch(Exception e){
                sec = 0;
            }
            try{
                minTot = Integer.parseInt( edtTimerTotalMin.getText() );
            }catch(Exception e){
                minTot = 0;
            }
            try{
                secTot = Integer.parseInt( edtTimerTotalSec.getText() );
                if (secTot > 59)
                    secTot = 59;
            }catch(Exception e){
                secTot = 0;
            }
            TimerManager.getInstance().setTimerBackward( (min*60 + sec)*1000, (minTot*60 + secTot)*1000 );
            
        }
    }//GEN-LAST:event_btnApplyTimerActionPerformed

    private void edtTimerTotalSecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTimerTotalSecKeyTyped
        handleNumberKeyPress(evt);
    }//GEN-LAST:event_edtTimerTotalSecKeyTyped

    private void edtTimerTotalMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTimerTotalMinKeyTyped
        handleNumberKeyPress(evt);
    }//GEN-LAST:event_edtTimerTotalMinKeyTyped

    private void edtTimerStartSecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTimerStartSecKeyTyped
        handleNumberKeyPress(evt);
    }//GEN-LAST:event_edtTimerStartSecKeyTyped

    private void edtTimerStartMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTimerStartMinKeyTyped
        handleNumberKeyPress(evt);
    }//GEN-LAST:event_edtTimerStartMinKeyTyped

    private void edtTimerStartMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTimerStartMinKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_edtTimerStartMinKeyPressed

    private void btnTimerBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerBackwardActionPerformed
        if (btnTimerBackward.isSelected() ){
            btnTimerForward.setSelected(false);
            btnTimerOff.setSelected(false);
        }else{
            btnTimerBackward.setSelected(true);
        }
        
        pnlTimerStart.setVisible(true);
        pnlTimerTotal.setVisible(true);
    }//GEN-LAST:event_btnTimerBackwardActionPerformed

    private void btnTimerForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerForwardActionPerformed
        if (btnTimerForward.isSelected() ){
            btnTimerBackward.setSelected(false);
            btnTimerOff.setSelected(false);
        }else{
            btnTimerForward.setSelected(true);
        }
        
        pnlTimerStart.setVisible(true);
        pnlTimerTotal.setVisible(false);
    }//GEN-LAST:event_btnTimerForwardActionPerformed

    private void btnTimerOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerOffActionPerformed
        if (btnTimerOff.isSelected() ){
            btnTimerBackward.setSelected(false);
            btnTimerForward.setSelected(false);
        }else{
            btnTimerOff.setSelected(true);
        }
        
        pnlTimerStart.setVisible(false);
        pnlTimerTotal.setVisible(false);
    }//GEN-LAST:event_btnTimerOffActionPerformed
    
    private void handleNumberKeyPress(java.awt.event.KeyEvent evt){
        char key = evt.getKeyChar();
        if (key < '0' || key > '9'){
            evt.consume();
        }
    }

    public void setTimerFromServiceItem(int minutes){
        btnTimerBackward.setSelected(true);
        btnTimerBackwardActionPerformed(null);
        edtTimerTotalMin.setText(Integer.toString(minutes));
        edtTimerTotalSec.setText("00");
        edtTimerStartMin.setText("00");
        edtTimerStartSec.setText("00");
        
        if (ConfigObj.getActiveInstance().getAutoStartTimerBool()){
            btnApplyTimerActionPerformed(null);
        }

    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyTimer;
    private javax.swing.JToggleButton btnTimerBackward;
    private javax.swing.JToggleButton btnTimerForward;
    private javax.swing.JToggleButton btnTimerOff;
    private javax.swing.JTextField edtTimerStartMin;
    private javax.swing.JTextField edtTimerStartSec;
    private javax.swing.JTextField edtTimerTotalMin;
    private javax.swing.JTextField edtTimerTotalSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlTimerStart;
    private javax.swing.JPanel pnlTimerTotal;
    // End of variables declaration//GEN-END:variables
    
}


