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
 * EditTextItem.java
 *
 * Created on 9 de Marco de 2006, 21:04
 */

package datasoul.serviceitems.text;

import datasoul.DatasoulMainForm;
import datasoul.config.DisplayControlConfig;
import datasoul.config.WindowPropConfig;
import datasoul.servicelist.ServiceListTable;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  Administrador
 */
public class TextServiceItemEditorForm extends javax.swing.JFrame {
    
    private TextServiceItem textServiceItem;
    private boolean isNewItem;
    private boolean updateSize;

    /** Creates new form EditTextItem */
    public TextServiceItemEditorForm(TextServiceItem textServiceItem) {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        WindowPropConfig.getInstance().getTextEditor(this);
        updateSize = true;

        
        this.textServiceItem = textServiceItem;
    
        if(this.textServiceItem.getTitle().equals("")){
            isNewItem = true;
        }else{
            isNewItem = false;
        }
        //read value
        this.fieldTitle.setText(textServiceItem.getTitle());

        this.textText.setText(textServiceItem.getText());

        highlightlyric(this.textText);
        textText.setCaretPosition(0);

        textSplitPanel1.registerTextArea(textText);
        textSplitPanel1.setVisible(btnShowSplit.isSelected());

        bibleTextPanel1.registerTitlefield(fieldTitle);
        bibleTextPanel1.registerTextArea(textText);
        bibleTextPanel1.setVisible(btnShowBible.isSelected());
    }

    public void setBibleVisible(boolean b){
        btnShowBible.setSelected(b);
        bibleTextPanel1.setVisible(btnShowBible.isSelected());
    }

    private boolean hasChanged(){
        return !textServiceItem.getText().equals(textText.getText()) || !textServiceItem.getTitle().equals(fieldTitle.getText());
    }

    private void updateValues(){
        this.textServiceItem.setTitle(this.fieldTitle.getText());
        this.textServiceItem.setText(this.textText.getText());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldTitle = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        labelTitle1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textSplitPanel1 = new datasoul.util.TextSplitPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textText = new datasoul.util.HighlightTextArea();
        bibleTextPanel1 = new datasoul.bible.BibleTextPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnShowBible = new javax.swing.JToggleButton();
        btnShowSplit = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("Edit_Text")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        fieldTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTitleActionPerformed(evt);
            }
        });
        fieldTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTitleKeyTyped(evt);
            }
        });

        labelTitle.setText(bundle.getString("Title")); // NOI18N

        labelTitle1.setText(bundle.getString("Text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 10));
        jLabel3.setText(bundle.getString("*_Use_a_line_with_==_to_split_slides_and_a_line_with_===_to_split_sessions")); // NOI18N

        textText.setColumns(20);
        textText.setRows(5);
        jScrollPane1.setViewportView(textText);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-save_big.png"))); // NOI18N
        btnSave.setText(bundle.getString("Save")); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnShowBible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/accessories-dictionary.png"))); // NOI18N
        btnShowBible.setText("Bible Options");
        btnShowBible.setFocusable(false);
        btnShowBible.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShowBible.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShowBible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBibleActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowBible);

        btnShowSplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/format-justify-center.png"))); // NOI18N
        btnShowSplit.setText("Split Options");
        btnShowSplit.setFocusable(false);
        btnShowSplit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShowSplit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShowSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSplitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowSplit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textSplitPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addComponent(labelTitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(bibleTextPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addComponent(fieldTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(bibleTextPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSplitPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean save(){
        if(this.textServiceItem.getTitle().equals("")){
            JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("You_must_field_the_Title"));
            return false;
        }

        updateValues();

        if(isNewItem){
            textServiceItem.setTemplate(DisplayControlConfig.getInstance().getDefaultTemplateText());
            ServiceListTable.getActiveInstance().addItem(this.textServiceItem);
            isNewItem = false;
        }

        return true;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void fieldTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTitleKeyTyped
        if(evt.getKeyCode()==16)
            return;
        // samuelm: changed to check against disallowd chars to avoid problems with non-english chars
        //String allowed="ZXCVBNMASDFGHJKL?QWERTYUIOPzxcvbnmasdfghjkl?qwertyuiop1234567890'???????????";
        String disallowed = "\\/:*?\"<>|";
        if(disallowed.contains(String.valueOf(evt.getKeyChar())))
            evt.consume();
    }//GEN-LAST:event_fieldTitleKeyTyped

    private void btnShowSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSplitActionPerformed
        textSplitPanel1.setVisible(btnShowSplit.isSelected());
    }//GEN-LAST:event_btnShowSplitActionPerformed

    private void btnShowBibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBibleActionPerformed
        bibleTextPanel1.setVisible(btnShowBible.isSelected());
    }//GEN-LAST:event_btnShowBibleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        bibleTextPanel1.onClose();
    }//GEN-LAST:event_formWindowClosed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (updateSize)
            WindowPropConfig.getInstance().setTextEditor(this);
    }//GEN-LAST:event_formComponentResized

    private void fieldTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTitleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (hasChanged()){
            int resp = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Save_the_changes?"), "Datasoul", JOptionPane.YES_NO_CANCEL_OPTION );

            if (resp == JOptionPane.YES_OPTION){
                if (save()){
                    this.dispose();
                }
            }else if (resp == JOptionPane.NO_OPTION){
                this.dispose();
            }
        }else{
            this.dispose();
        }

    }//GEN-LAST:event_formWindowClosing
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datasoul.bible.BibleTextPanel bibleTextPanel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnShowBible;
    private javax.swing.JToggleButton btnShowSplit;
    private javax.swing.JTextField fieldTitle;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTitle1;
    private datasoul.util.TextSplitPanel textSplitPanel1;
    private datasoul.util.HighlightTextArea textText;
    // End of variables declaration//GEN-END:variables

    public void highlightlyric(JTextComponent textComp){
        removeHighlights(textComp);
        highlight(textComp,"\n"+TextServiceItem.SLIDE_BREAK+"\n",Color.ORANGE);
        highlight(textComp,"\n"+TextServiceItem.CHORUS_MARK+"\n",Color.PINK);
    }
    // Creates highlights around all occurrences of pattern in textComp
    public void highlight(JTextComponent textComp, String pattern, Color color) {
        Highlighter.HighlightPainter highlightPainter = new MyHighlightPainter(color);
    
        try {
            Highlighter hilite = textComp.getHighlighter();
            javax.swing.text.Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos+pattern.length(), highlightPainter);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {

        }
    }
    
    // Removes only our private highlights
    public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        hilite.removeAllHighlights();
    }
    
   // A private subclass of the default highlight painter
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlightPainter(Color color) {
            super(color);
        }
    }
    
}