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
 * SongEditorFrame.java
 *
 * Created on 26 de Dezembro de 2005, 21:14
 */

package datasoul.serviceitems.song;

import datasoul.DatasoulMainForm;
import datasoul.config.WindowPropConfig;
import datasoul.servicelist.ServiceListExporterPanel;
import datasoul.util.ShowDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author  Administrador
 */
public class SongEditorForm extends javax.swing.JFrame {
    

    private Song song;
    private boolean newSong;
    boolean updateSize = false;

    /**
     * Creates new form SongEditorFrame
     */
    public SongEditorForm(File file) {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        WindowPropConfig.getInstance().getSongEditor(this);
        updateSize = true;
        
        Document dom=null;
        Node node=null;

        try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                //Using factory get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();

                //parse using builder to get DOM representation of the XML file
                dom = db.parse(file);

                //node = dom.getDocumentElement().getChildNodes().item(0);
                node = dom.getElementsByTagName("Song").item(0);
                
        }catch(Exception e) {
            ShowDialog.showReadFileError(file, e);
        }        

        song = new Song();
        try {
            song.readObject(node, null);
        } catch (Exception e) {
            ShowDialog.showReadFileError(file, e);
        }

        this.setTitle(song.getFileName());
        
        //fill object
        fillGuiValues();
        
        newSong = false;
        
        initTextAreas();

        cbUpdateSongLibrary.setVisible(song.isClone());
    }

    /**
     * Creates new form SongEditorFrame
     */
    public SongEditorForm(Song songIn) {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        WindowPropConfig.getInstance().getSongEditor(this);
        updateSize = true;

        song = songIn;
        this.setTitle(songIn.getFileName());
        
        //fill object
        fillGuiValues();
        
        newSong = false;
        
        initTextAreas();
        cbUpdateSongLibrary.setVisible(song.isClone());
    }
    
    public SongEditorForm() {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        WindowPropConfig.getInstance().getSongEditor(this);
        updateSize = true;

        song = new Song();

        this.setTitle("");
        
        newSong = true;

        initTextAreas();
        cbUpdateSongLibrary.setVisible(song.isClone());

    }
    
    private void initTextAreas(){
        songChordEditorComplete.init();
        songChordEditorSimple.init();
        textLyrics.setCaretPosition(0);
        textSplitPanel1.registerTextArea(textLyrics);
        textSplitPanel1.setVisible(btnShowSplit.isSelected());
        btnShowChordsActionPerformed(null);
        btnShowTabsActionPerformed(null);
    }

    private void fillGuiValues(){
        fieldName.setText(song.getTitle());
        fieldAuthor.setText(song.getSongAuthor());
        textLyrics.setText(song.getText());
        songChordEditorComplete.setText(song.getChordsComplete());
        songChordEditorSimple.setText(song.getChordsSimplified());
        txtCopyright.setText(song.getCopyright());
        txtSongSource.setText(song.getSongSource());
    }


    private boolean hasChanged(){
        return
            !song.getTitle().equals(fieldName.getText()) ||
            !song.getSongAuthor().equals(fieldAuthor.getText()) ||
            !song.getText().equals(textLyrics.getText()) ||
            !song.getChordsComplete().equals(songChordEditorComplete.getText()) ||
            !song.getChordsSimplified().equals(songChordEditorSimple.getText()) ||
            !song.getCopyright().equals(txtCopyright.getText()) ||
            !song.getSongSource().equals(txtSongSource.getText());
    }

    private void updateValues(){
        song.setTitle(fieldName.getText());
        song.setSongAuthor(fieldAuthor.getText());
        song.setText(textLyrics.getText());
        song.setChordsComplete(songChordEditorComplete.getText());
        song.setChordsSimplified(songChordEditorSimple.getText());
        song.setCopyright(txtCopyright.getText());
        song.setSongSource(txtSongSource.getText());
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        labelAuthor = new javax.swing.JLabel();
        fieldAuthor = new javax.swing.JTextField();
        tabSong = new javax.swing.JTabbedPane();
        pnlLyricsTab = new javax.swing.JPanel();
        textSplitPanel1 = new datasoul.util.TextSplitPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLyrics = new datasoul.util.HighlightTextArea();
        songChordEditorComplete = new datasoul.serviceitems.song.SongChordEditorPanel();
        songChordEditorSimple = new datasoul.serviceitems.song.SongChordEditorPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCopyright = new javax.swing.JTextField();
        txtSongSource = new javax.swing.JTextField();
        cbUpdateSongLibrary = new javax.swing.JCheckBox();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnShowSplit = new javax.swing.JToggleButton();
        btnShowChords = new javax.swing.JToggleButton();
        btnShowTabs = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        fieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNameKeyTyped(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        labelName.setText(bundle.getString("NAME")); // NOI18N
        labelName.setFocusable(false);

        labelAuthor.setText(bundle.getString("Author")); // NOI18N
        labelAuthor.setFocusable(false);

        tabSong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textChordsCompleteKeyPressed(evt);
            }
        });

        textLyrics.setColumns(20);
        textLyrics.setRows(5);
        jScrollPane1.setViewportView(textLyrics);

        javax.swing.GroupLayout pnlLyricsTabLayout = new javax.swing.GroupLayout(pnlLyricsTab);
        pnlLyricsTab.setLayout(pnlLyricsTabLayout);
        pnlLyricsTabLayout.setHorizontalGroup(
            pnlLyricsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textSplitPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        pnlLyricsTabLayout.setVerticalGroup(
            pnlLyricsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLyricsTabLayout.createSequentialGroup()
                .addComponent(textSplitPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        tabSong.addTab(bundle.getString("Lyrics"), pnlLyricsTab); // NOI18N
        tabSong.addTab("Chords Complete", songChordEditorComplete);
        tabSong.addTab("Chords Simplified", songChordEditorSimple);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 10));
        jLabel3.setText(bundle.getString("*_Use_a_line_with_==_to_split_slides_and_a_line_with_===_to_split_sessions")); // NOI18N

        jLabel5.setText(bundle.getString("Copyright")); // NOI18N

        jLabel6.setText(bundle.getString("Source")); // NOI18N

        txtCopyright.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCopyrightActionPerformed(evt);
            }
        });

        cbUpdateSongLibrary.setText(bundle.getString("Update_Song_Library")); // NOI18N

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

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/x-office-document_big.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setFocusable(false);
        btnExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExport);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);
        jToolBar1.add(jSeparator1);

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

        btnShowChords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_effects-sound.png"))); // NOI18N
        btnShowChords.setText("Transposition");
        btnShowChords.setFocusable(false);
        btnShowChords.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShowChords.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShowChords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowChordsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowChords);

        btnShowTabs.setText("Guitar Tabs");
        btnShowTabs.setFocusable(false);
        btnShowTabs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShowTabs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShowTabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTabsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowTabs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbUpdateSongLibrary)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(fieldAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(txtCopyright, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(txtSongSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addComponent(tabSong, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAuthor)
                    .addComponent(fieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSongSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabSong, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbUpdateSongLibrary)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean save(){

        if(this.fieldName.getText().equals("")){
            JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Please_fill_the_field_\"Song_Name\""));
            return false;
        }

        // if editing a Clone (from the ServiceList), just update the values
        // if editing from the Song library, write the .song file.
        if (song.isClone() && !cbUpdateSongLibrary.isSelected()){
            updateValues();
        }else{
            String filename = this.fieldName.getText();
            if(!filename.contains(".song"))
                filename = filename + ".song";
            String path = System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") +
                    "songs"+ System.getProperty("file.separator")+filename;

            if(!path.equals(song.getFilePath())){
                File file = new File(song.getFilePath());
                file.delete();
            }
            song.setFilePath(path);
            saveFile();
            AllSongsListTable.getInstance().refreshSong(filename);
        }

        return true;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void textChordsCompleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textChordsCompleteKeyPressed
    }//GEN-LAST:event_textChordsCompleteKeyPressed

    private void fieldNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNameKeyTyped
        if(evt.getKeyCode()==16)
            return;
        // samuelm: changed to check against disallowd chars to avoid problems with non-english chars
        //String allowed="ZXCVBNMASDFGHJKL?QWERTYUIOPzxcvbnmasdfghjkl?qwertyuiop1234567890'???????????";
        String disallowed = "\\/:*?\"<>|";
        if(disallowed.contains(String.valueOf(evt.getKeyChar())))
            evt.consume();
    }//GEN-LAST:event_fieldNameKeyTyped

    private void txtCopyrightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCopyrightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCopyrightActionPerformed

    private void btnShowSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSplitActionPerformed
        textSplitPanel1.setVisible(btnShowSplit.isSelected());
    }//GEN-LAST:event_btnShowSplitActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (updateSize)
            WindowPropConfig.getInstance().setSongEditor(this);
    }//GEN-LAST:event_formComponentResized

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

    private void btnShowChordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowChordsActionPerformed
        songChordEditorComplete.setTransposeVisible(btnShowChords.isSelected());
        songChordEditorSimple.setTransposeVisible(btnShowChords.isSelected());
    }//GEN-LAST:event_btnShowChordsActionPerformed

    private void btnShowTabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTabsActionPerformed
        songChordEditorComplete.setTabsVisible(btnShowTabs.isSelected());
        songChordEditorSimple.setTabsVisible(btnShowTabs.isSelected());
    }//GEN-LAST:event_btnShowTabsActionPerformed

    private void exportPrintSong(int mode){
        if (hasChanged()){
            int resp = JOptionPane.showConfirmDialog(this, "The song will be saved. Continue?", "Datasoul", JOptionPane.YES_NO_OPTION );

            if (resp == JOptionPane.YES_OPTION){
                if (!save()){
                    return;
                }
            }else {
                return;
            }

        }

        ServiceListExporterPanel slep = new ServiceListExporterPanel();
        slep.setLocationRelativeTo(this);
        slep.setSingleSong(song);
        slep.setMode(mode);
        slep.setVisible(true);
    }

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        exportPrintSong(ServiceListExporterPanel.MODE_EXPORT);

    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        exportPrintSong(ServiceListExporterPanel.MODE_PRINT);
    }//GEN-LAST:event_btnPrintActionPerformed

  private void saveFile(){
        updateValues();
        
        try{
            Node node = song.writeObject(null);
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(song.getFilePath());

            Source source = new DOMSource(doc);

            // Prepare the output file
            Result result = new StreamResult(fos);

            // Write the DOM document to the file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.transform(source, result);

            fos.close();

        } catch(Exception e){
            ShowDialog.showWriteFileError(song.getFileName(), e);
        }
        
        if(newSong){
            AllSongsListTable.getInstance().addItem(song);
            newSong = false;
            AllSongsListTable.getInstance().sortByName();            
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnShowChords;
    private javax.swing.JToggleButton btnShowSplit;
    private javax.swing.JToggleButton btnShowTabs;
    private javax.swing.JCheckBox cbUpdateSongLibrary;
    private javax.swing.JTextField fieldAuthor;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelName;
    private javax.swing.JPanel pnlLyricsTab;
    private datasoul.serviceitems.song.SongChordEditorPanel songChordEditorComplete;
    private datasoul.serviceitems.song.SongChordEditorPanel songChordEditorSimple;
    private javax.swing.JTabbedPane tabSong;
    private datasoul.util.HighlightTextArea textLyrics;
    private datasoul.util.TextSplitPanel textSplitPanel1;
    private javax.swing.JTextField txtCopyright;
    private javax.swing.JTextField txtSongSource;
    // End of variables declaration//GEN-END:variables
    
}