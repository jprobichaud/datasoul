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

package datasoul.datashow;
import datasoul.config.DisplayControlConfig;
import datasoul.render.ContentManager;
import datasoul.song.Song;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author  Administrador
 */
public class LivePanel extends javax.swing.JPanel implements ListSelectionListener {

    private AutomaticChanger automaticChanger;
    
    private int lastSelectedIndex;
    
    /**
     * Creates new form LivePanel
     */
    public LivePanel() {
        initComponents();
        serviceItemTable1.addTableListener(this);
        automaticChanger = new AutomaticChanger();
    }

    public void setFocusInTable(){
        serviceItemTable1.setFocusInTable();
    }
    
    public void showItem(ServiceItem serviceItem){

        ContentManager cm = ContentManager.getInstance();
        //cm.saveTransitionImage();
        cm.setTemplateLive(serviceItem.getTemplate());
        cm.setTitleLive(serviceItem.getTitle());
        if(serviceItem instanceof Song)
            cm.setSongAuthorLive( ((Song)serviceItem).getSongAuthor() );
        this.serviceItemTable1.setServiceItem(serviceItem);
        cm.setSlideLive( serviceItemTable1.getSlideText() );
        cm.setNextSlideLive( serviceItemTable1.getNextSlideText() );
        
        // save the transition image just before changing the slide to avoid
        // problem when changing to a item that uses a template with different
        // alpha. This will cause a cut to the first slide, without any transition,
        // but at least is not buggy
        cm.saveTransitionImage();
        
        cm.slideChange(DisplayControlConfig.getInstance().getSlideTransitionTime());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serviceItemTable1 = new datasoul.datashow.ServiceItemTable();
        jPanel1 = new javax.swing.JPanel();
        cbAutoChange = new javax.swing.JCheckBox();
        spnTimer = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        labelLive = new javax.swing.JLabel();

        setDoubleBuffered(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        cbAutoChange.setText(bundle.getString("Change_automatically_every")); // NOI18N
        cbAutoChange.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbAutoChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutoChangeActionPerformed(evt);
            }
        });

        spnTimer.setModel(new SpinnerNumberModel(1, 1, 9999, 1));

        jLabel1.setText(bundle.getString("seconds")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(cbAutoChange)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(spnTimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(spnTimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(cbAutoChange)
                .add(jLabel1))
        );

        jToolBar1.setFloatable(false);

        labelLive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/projector3_small.png"))); // NOI18N
        labelLive.setText(bundle.getString("LIVE")); // NOI18N
        jToolBar1.add(labelLive);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
            .add(serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbAutoChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutoChangeActionPerformed

        if (cbAutoChange.isSelected()){
            automaticChanger.startChanging( Integer.parseInt(spnTimer.getValue().toString()) * 1000 );
        }else{
            automaticChanger.stopChanging();
        }

        
    }//GEN-LAST:event_cbAutoChangeActionPerformed

    public void valueChanged(ListSelectionEvent e) {

        // when changing slides with mouse, two events are generated for
        // the same change, one for pressing and other for releasing the mouse button
        // this check avoids processing twice, what makes the transiction effect broken
        if ( serviceItemTable1.getSlideIndex() == lastSelectedIndex || serviceItemTable1.getSlideIndex() < 0){
            return;
        }else{
            lastSelectedIndex = serviceItemTable1.getSlideIndex();
        }
        
        
        ContentManager cm = ContentManager.getInstance();
        cm.saveTransitionImage();
        cm.setSlideLive( serviceItemTable1.getSlideText() );
        cm.setNextSlideLive( serviceItemTable1.getNextSlideText() );
        cm.slideChange(DisplayControlConfig.getInstance().getSlideTransitionTime());
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbAutoChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelLive;
    private datasoul.datashow.ServiceItemTable serviceItemTable1;
    private javax.swing.JSpinner spnTimer;
    // End of variables declaration//GEN-END:variables
    
    
    private class AutomaticChanger extends Thread {
        
        boolean stopThread = false;
        long timer;
        
        public AutomaticChanger(){
            this.start();
        }
        
        public void startChanging(int timer){
            this.timer = timer;
            stopThread = false;
            synchronized(this){
                this.notify();
            }
        }
        
        public void stopChanging(){
            stopThread = true;
            this.interrupt();
        }
        
        private void change(){
            
            int maxSlide = serviceItemTable1.getSlideCount();
            int showSlide = serviceItemTable1.getSlideIndex() + 1;

            if (showSlide >= maxSlide){
                showSlide = 0;
            }
            
            serviceItemTable1.setSlideIndex(showSlide);
        }
        
        public void run(){

            long t1, t2;

            while (true){
                
                synchronized(this){
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                
                while (!stopThread){

                    t1 = System.currentTimeMillis();

                    change();

                    // go sleep!
                    t2 = System.currentTimeMillis();
                    if ( (timer - (t2 - t1)) > 1 ){
                        try {
                            Thread.sleep( timer - (t2 - t1) );
                        } catch (InterruptedException ex) {
                            //ignore. just exist form sleep
                        }
                    }

                }//while stopthread
            }//while true
        }// run
    }
    
}
