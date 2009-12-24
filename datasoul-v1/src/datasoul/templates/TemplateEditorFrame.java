/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TemplateEditorFrame.java
 *
 * Created on Dec 19, 2009, 11:08:31 AM
 */

package datasoul.templates;

import datasoul.config.WindowPropConfig;
import datasoul.util.ObjectManager;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author samuel
 */
public class TemplateEditorFrame extends javax.swing.JFrame {

    private boolean updateSize;


    /** Creates new form TemplateEditorFrame */
    public TemplateEditorFrame() {
        initComponents();

        try{

            templateEditorPanel1.setEditorFrame(this);

            WindowPropConfig.getInstance().getTemplateSplit1(jSplitPane1);
            updateSize = true;

            for (String s : TextTemplateItem.CONTENT_TABLE){
                JMenuItem mi = new JMenuItem();
                mi.setText(s);
                mi.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        addTextItem(evt);
                    }
                });
                ppmNewText.add(mi);
            }

            for (String s : ImageTemplateItem.IMAGE_CONTENT_TABLE){
                JMenuItem mi = new JMenuItem();
                mi.setText(s);
                mi.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        addTextImage(evt);
                    }
                });
                ppmNewImage.add(mi);
            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmNewText = new javax.swing.JPopupMenu();
        ppmNewImage = new javax.swing.JPopupMenu();
        jToolBar1 = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAddText = new javax.swing.JButton();
        btnAddImage = new javax.swing.JButton();
        btnAddTimer = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelProperties = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProperties = new javax.swing.JTable();
        jToolBar5 = new javax.swing.JToolBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblActiveItem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDeleteItem = new javax.swing.JButton();
        btnMoveDown = new javax.swing.JButton();
        btnMoveUp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelTemplateEditor = new javax.swing.JPanel();
        templateEditorPanel1 = new datasoul.templates.TemplateEditorPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Datasoul Template Editor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-new.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNew);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-save-as.png"))); // NOI18N
        btnSaveAs.setText("Save As");
        btnSaveAs.setFocusable(false);
        btnSaveAs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveAs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSaveAs);
        jToolBar1.add(jSeparator1);

        btnAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/insert-text.png"))); // NOI18N
        btnAddText.setText("Add Text");
        btnAddText.setFocusable(false);
        btnAddText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddText.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTextActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddText);

        btnAddImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/insert-image.png"))); // NOI18N
        btnAddImage.setText("Add Image");
        btnAddImage.setFocusable(false);
        btnAddImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddImage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddImage);

        btnAddTimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_timer.png"))); // NOI18N
        btnAddTimer.setText("Add Timer Bar");
        btnAddTimer.setFocusable(false);
        btnAddTimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddTimer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTimerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddTimer);

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(850);
        jSplitPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSplitPane1PropertyChange(evt);
            }
        });

        jTableProperties.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableProperties);

        jToolBar5.setFloatable(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-properties.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        jLabel9.setText(bundle.getString("Properties")); // NOI18N
        jToolBar5.add(jLabel9);

        jLabel3.setText("  -  ");
        jToolBar5.add(jLabel3);

        lblActiveItem.setText("jLabel4");
        jToolBar5.add(lblActiveItem);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/edit-delete.png"))); // NOI18N
        btnDeleteItem.setText(bundle.getString("Remove")); // NOI18N
        btnDeleteItem.setToolTipText(bundle.getString("Delete_item")); // NOI18N
        btnDeleteItem.setBorderPainted(false);
        btnDeleteItem.setFocusPainted(false);
        btnDeleteItem.setFocusable(false);
        btnDeleteItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteItem);

        btnMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_object-infront.png"))); // NOI18N
        btnMoveDown.setText(bundle.getString("To_Back")); // NOI18N
        btnMoveDown.setToolTipText(bundle.getString("Move_the_item_to_the_lowest_layer")); // NOI18N
        btnMoveDown.setBorderPainted(false);
        btnMoveDown.setFocusPainted(false);
        btnMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDownActionPerformed(evt);
            }
        });
        jPanel1.add(btnMoveDown);

        btnMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_object-behind.png"))); // NOI18N
        btnMoveUp.setText(bundle.getString("To_Front")); // NOI18N
        btnMoveUp.setToolTipText(bundle.getString("Move_the_item_to_the_upper_layer")); // NOI18N
        btnMoveUp.setBorderPainted(false);
        btnMoveUp.setFocusPainted(false);
        btnMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnMoveUp);

        javax.swing.GroupLayout panelPropertiesLayout = new javax.swing.GroupLayout(panelProperties);
        panelProperties.setLayout(panelPropertiesLayout);
        panelPropertiesLayout.setHorizontalGroup(
            panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );
        panelPropertiesLayout.setVerticalGroup(
            panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPropertiesLayout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(panelProperties);

        panelTemplateEditor.setAutoscrolls(true);

        javax.swing.GroupLayout templateEditorPanel1Layout = new javax.swing.GroupLayout(templateEditorPanel1);
        templateEditorPanel1.setLayout(templateEditorPanel1Layout);
        templateEditorPanel1Layout.setHorizontalGroup(
            templateEditorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        templateEditorPanel1Layout.setVerticalGroup(
            templateEditorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jLabel5.setFont(jLabel5.getFont().deriveFont((jLabel5.getFont().getStyle() | java.awt.Font.ITALIC), jLabel5.getFont().getSize()-2));
        jLabel5.setText(bundle.getString("Hold_Shift_down_for_resizing_items")); // NOI18N

        javax.swing.GroupLayout panelTemplateEditorLayout = new javax.swing.GroupLayout(panelTemplateEditor);
        panelTemplateEditor.setLayout(panelTemplateEditorLayout);
        panelTemplateEditorLayout.setHorizontalGroup(
            panelTemplateEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTemplateEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTemplateEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(templateEditorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelTemplateEditorLayout.setVerticalGroup(
            panelTemplateEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTemplateEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(templateEditorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(panelTemplateEditor);

        jSplitPane1.setLeftComponent(jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            ObjectManager.getInstance().setBusyCursor();
            save();
            TemplateManager.getInstance().refreshAvailableTemplates();
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        TemplateEditorFrame newFrame = new TemplateEditorFrame();
        newFrame.newTemplate();
        newFrame.setVisible(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        try{
            ObjectManager.getInstance().setBusyCursor();
            saveAs();
            TemplateManager.getInstance().refreshAvailableTemplates();
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int resp = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Save_the_changes?"), "Datasoul", JOptionPane.YES_NO_CANCEL_OPTION );

        if (resp == JOptionPane.YES_OPTION){
            save();
            this.dispose();
        }else if (resp == JOptionPane.NO_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        templateEditorPanel1.deleteSelectedItem();
}//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDownActionPerformed
        templateEditorPanel1.moveDownSelectedItem();
}//GEN-LAST:event_btnMoveDownActionPerformed

    private void btnMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUpActionPerformed
        templateEditorPanel1.moveUpSelectedItem();
}//GEN-LAST:event_btnMoveUpActionPerformed

    private void jSplitPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSplitPane1PropertyChange
        if (updateSize && evt.getPropertyName().equals(javax.swing.JSplitPane.DIVIDER_LOCATION_PROPERTY)){
            WindowPropConfig.getInstance().setTemplateSplit1(Integer.toString(jSplitPane1.getDividerLocation()));
        }
}//GEN-LAST:event_jSplitPane1PropertyChange

    private void btnAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTextActionPerformed
        ppmNewText.show(btnAddText, 0, btnAddText.getHeight());
    }//GEN-LAST:event_btnAddTextActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        ppmNewImage.show(btnAddImage, 0, btnAddImage.getHeight());
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnAddTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTimerActionPerformed
        TimerProgressbarTemplateItem timer = new TimerProgressbarTemplateItem();
        templateEditorPanel1.addItem(timer);
    }//GEN-LAST:event_btnAddTimerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnAddText;
    private javax.swing.JButton btnAddTimer;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnMoveDown;
    private javax.swing.JButton btnMoveUp;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableProperties;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JLabel lblActiveItem;
    private javax.swing.JPanel panelProperties;
    private javax.swing.JPanel panelTemplateEditor;
    private javax.swing.JPopupMenu ppmNewImage;
    private javax.swing.JPopupMenu ppmNewText;
    private datasoul.templates.TemplateEditorPanel templateEditorPanel1;
    // End of variables declaration//GEN-END:variables

    private void addTextItem(java.awt.event.ActionEvent evt){
        TextTemplateItem txt = new TextTemplateItem();
        if (evt.getSource() instanceof JMenuItem){
            txt.setText( ((JMenuItem)evt.getSource()).getText() );
            txt.setContent(((JMenuItem)evt.getSource()).getText());
        }
        templateEditorPanel1.addItem(txt);
    }

    private void addTextImage(java.awt.event.ActionEvent evt){

        if (evt.getSource() instanceof JMenuItem){

            String typestr = ((JMenuItem)evt.getSource()).getText();
            int type = 0;
            for (int x=0; x<ImageTemplateItem.IMAGE_CONTENT_TABLE.length; x++){
                if (typestr.equals(ImageTemplateItem.IMAGE_CONTENT_TABLE[x])){
                    type = x;
                    break;
                }
            }
            if (type == ImageTemplateItem.IMAGE_CONTENT_STATIC){
                JFileChooser fc = new JFileChooser();
                File dir = new File (System.getProperty("datasoul.stgloc") + System.getProperty("file.separator") + "templates");
                fc.setCurrentDirectory(dir);
                fc.setDialogType(JFileChooser.OPEN_DIALOG);
                fc.setMultiSelectionEnabled(false);
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setControlButtonsAreShown(true);
                fc.setDialogTitle(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("Select_Image"));
                if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION && fc.getSelectedFile().exists() ){
                    String filename = fc.getSelectedFile().getAbsolutePath();
                    ImageTemplateItem img = new ImageTemplateItem( filename );
                    templateEditorPanel1.addItem(img);
                }
            }else if (type == ImageTemplateItem.IMAGE_CONTENT_SLIDE){
                ImageTemplateItem img = new ImageTemplateItem(getClass().getResource("/datasoul/icons/default-image.png").getFile());
                img.setContentIdx(type);
                templateEditorPanel1.addItem(img);
            }else if (type == ImageTemplateItem.IMAGE_CONTENT_NEXT_SLIDE){
                ImageTemplateItem img = new ImageTemplateItem(getClass().getResource("/datasoul/icons/default-image.png").getFile());
                img.setContentIdx(type);
                templateEditorPanel1.addItem(img);
            }

        }

    }


    public JTable getPropertiesTable(){
        return jTableProperties;
    }

    public JLabel getActiveItemLabel(){
        return lblActiveItem;
    }

    public void save(){
        templateEditorPanel1.save();
    }

    public void saveAs(){
        templateEditorPanel1.saveAs();
    }

    public DisplayTemplate getTemplate(){
        return templateEditorPanel1.getTemplate();
    }

    public void open(String filename){
        templateEditorPanel1.open(filename);
    }

    public void newTemplate(){
        templateEditorPanel1.openNewTemplate();
    }


}
