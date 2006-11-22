/*
 * EditTextItem.java
 *
 * Created on 9 de Marco de 2006, 21:04
 */

package datasoul.datashow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
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
    
    /** Creates new form EditTextItem */
    public TextServiceItemEditorForm(TextServiceItem textServiceItem) {
        initComponents();
        
        this.textServiceItem = textServiceItem;
    
        if(this.textServiceItem.getTitle().equals("")){
            isNewItem = true;
        }else{
            isNewItem = false;
        }
        //read value
        this.fieldTitle.setText(textServiceItem.getTitle());

        this.textText.setText(textServiceItem.getText());

        this.center();

        highlightlyric(this.textText);
    }

    public void center(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle frame = getBounds();
        setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/2);
    }
    
    private void actualizeValues(){
        this.textServiceItem.setTitle(this.fieldTitle.getText());
        
        this.textServiceItem.setText(this.textText.getText());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        fieldTitle = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        labelTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        textLine = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSplit = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Text");
        setAlwaysOnTop(true);
        fieldTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTitleKeyTyped(evt);
            }
        });

        labelTitle.setText("Title");

        labelTitle1.setText("Text");

        textText.setColumns(20);
        textText.setRows(5);
        textText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTextKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(textText);

        jLabel1.setText("Split text in slides with");

        textLine.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        textLine.setText("2");

        jLabel2.setText("lines");

        btnSplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/show_table_row.png")));
        btnSplit.setText("Split");
        btnSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSplitActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/button_cancel.png")));
        btnClose.setText("Cancel");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/apply.png")));
        btnSave.setText("Apply");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textLine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSplit)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 110, Short.MAX_VALUE)
                        .add(btnSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnClose))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelTitle)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, fieldTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelTitle1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(labelTitle)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fieldTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelTitle1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(textLine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnSplit)
                    .add(btnClose)
                    .add(btnSave))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        actualizeValues();
        
        if(this.textServiceItem.getTitle().equals("")){
            JOptionPane.showMessageDialog(this,"You must field the Title");
            return;
        }

        if(isNewItem){
            ServiceListTable.getActiveInstance().addItem(this.textServiceItem);
            isNewItem = false;
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSplitActionPerformed
        int lines = 0;
        String str = this.textLine.getText();
        try{
            lines = Integer.parseInt(str);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Please in the next time digit a number!");
            return;
        }
        
        String inStr = this.textText.getText();
        StringBuffer sb = new StringBuffer();
        inStr = inStr.replace(TextServiceItem.CHORUS_MARK+"\r\n","\n\n");
        inStr = inStr.replace(TextServiceItem.SLIDE_BREAK+"\r\n","");
        inStr = inStr.replace(TextServiceItem.CHORUS_MARK+"\n","\n\n");
        inStr = inStr.replace(TextServiceItem.SLIDE_BREAK+"\n","");
        String str2;
        int count = 0;
        for(int i=0; i< inStr.length()-2;i++){
            str = inStr.substring(i,i+1);
            str2 = inStr.substring(i,i+2);
            if(str2.equals("\n\r")){
                sb.append(TextServiceItem.CHORUS_MARK+"\n");
                count =0;
                i=i+2;
                continue;
            }
            if(str2.equals("\n\n")){
                sb.append("\n"+TextServiceItem.CHORUS_MARK+"\n");
                count =0;
                i=i+2;
                continue;
            }
            if(str.equals("\n")){
                count ++;
            }
            sb.append(str);
            if(count==lines){
                sb.append(TextServiceItem.SLIDE_BREAK+"\n");
                count =0;
            }
        }
        sb.append(inStr.substring(inStr.length()-2,inStr.length()));
        this.textText.setText(sb.toString());
        highlightlyric(this.textText);        
    }//GEN-LAST:event_btnSplitActionPerformed

    private void textTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTextKeyPressed
        if(evt.isConsumed()||evt.getKeyCode()==10)
            highlightlyric(this.textText);
    }//GEN-LAST:event_textTextKeyPressed

    private void fieldTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTitleKeyTyped
        if(evt.getKeyCode()==16)
            return;
        // samuelm: changed to check against disallowd chars to avoid problems with non-english chars
        //String allowed="ZXCVBNMASDFGHJKL?QWERTYUIOPzxcvbnmasdfghjkl?qwertyuiop1234567890'???????????";
        String disallowed = "\\/:*?\"<>|";
        if(disallowed.contains(String.valueOf(evt.getKeyChar())))
            evt.consume();
    }//GEN-LAST:event_fieldTitleKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSplit;
    private javax.swing.JTextField fieldTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTitle1;
    private javax.swing.JTextField textLine;
    private javax.swing.JTextArea textText;
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
