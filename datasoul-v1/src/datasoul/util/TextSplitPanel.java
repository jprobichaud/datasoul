/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TextSplitPanel.java
 *
 * Created on Apr 13, 2009, 10:11:02 PM
 */

package datasoul.util;

import datasoul.serviceitems.text.TextServiceItem;
import javax.swing.text.JTextComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class TextSplitPanel extends javax.swing.JPanel {

    private JTextComponent textComp;

    /** Creates new form TextSplitPanel */
    public TextSplitPanel() {
        initComponents();
    }

    public void registerTextArea(JTextComponent textComp){
        this.textComp = textComp;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbMaxLenght = new javax.swing.JCheckBox();
        cbMaxSlideLines = new javax.swing.JCheckBox();
        txtMaxSlideLines = new javax.swing.JTextField();
        txtMaxLenght = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        cbMaxLenght.setText(bundle.getString("SPLIT IN LINES OF")); // NOI18N

        cbMaxSlideLines.setSelected(true);
        cbMaxSlideLines.setText(bundle.getString("SPLIT IN SLIDES OF")); // NOI18N

        txtMaxSlideLines.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtMaxSlideLines.setText("5");
        txtMaxSlideLines.setPreferredSize(new java.awt.Dimension(30, 20));

        txtMaxLenght.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtMaxLenght.setText("40");
        txtMaxLenght.setPreferredSize(new java.awt.Dimension(30, 20));

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_view-details.png"))); // NOI18N
        btnOk.setText(bundle.getString("SPLIT")); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("CHARACTERS")); // NOI18N

        jLabel1.setText(bundle.getString("LINES")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbMaxLenght)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaxLenght, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(cbMaxSlideLines)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaxSlideLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cbMaxLenght)
                .addComponent(cbMaxSlideLines)
                .addComponent(txtMaxSlideLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMaxLenght, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(jLabel1)
                .addComponent(btnOk))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        String str0;
        str0 = textComp.getText();

        int lines;
        try{
            lines = Integer.parseInt(txtMaxSlideLines.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("INVALID LINES PER SLIDE VALUE"),java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("DATASOUL ERROR"),0);
            return;
        }

        int maxline;
        try {
            maxline = Integer.parseInt(txtMaxLenght.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("INVALID CHARACTERS PER LINE VALUE"),java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("DATASOUL ERROR"),0);
            return;
        }


        // If needed remove slide breaks
        if ( cbMaxSlideLines.isSelected() ){
            str0 = str0.replaceAll("\n"+TextServiceItem.SLIDE_BREAK+"\n", "\n");
        }

        // If needed, remove line breaks
        if ( cbMaxLenght.isSelected() ){
            str0 = str0.replaceAll("\n"+TextServiceItem.SLIDE_BREAK+"\n", "@@"+TextServiceItem.SLIDE_BREAK+"@@");
            str0 = str0.replaceAll("\n"+TextServiceItem.CHORUS_MARK+"\n", "@@"+TextServiceItem.CHORUS_MARK+"@@");
            str0 = str0.replaceAll("\n", " ");
            str0 = str0.replaceAll("@@"+TextServiceItem.CHORUS_MARK+"@@", "\n"+TextServiceItem.CHORUS_MARK+"\n");
            str0 = str0.replaceAll("@@"+TextServiceItem.SLIDE_BREAK+"@@", "\n"+TextServiceItem.SLIDE_BREAK+"\n");
        }
        
        // if needed, break lines respecting maximum line width
        if ( cbMaxLenght.isSelected()){
            StringBuffer sb  = new StringBuffer();
            String tmp;
            int lastspace = 0;
            int lastbreak = 0;
            for (int i=0; i<str0.length(); i++){
                if ( str0.charAt(i) == ' '){
                    lastspace = i;
                }
                if ( (i-lastbreak) >  maxline){
                    tmp = str0.substring(lastbreak, lastspace).trim();
                    if (tmp.length() > 0){
                        sb.append(tmp+"\n");
                    }
                    lastbreak = lastspace;
                }
                if (str0.charAt(i) == '\n'){
                    tmp = str0.substring(lastbreak, i).trim();
                    if (tmp.length() > 0){
                        sb.append(tmp+"\n");
                    }
                    lastbreak = i;
                }
            }
            tmp = str0.substring(lastbreak).trim();
            if (tmp.length() > 0){
                sb.append(tmp+"\n");
            }

            str0 = sb.toString();
        }

        // Split in slides
        if ( cbMaxSlideLines.isSelected()){
            str0 = str0.replace("\n"+TextServiceItem.SLIDE_BREAK+"\n","\n");
        
            StringBuffer sb = new StringBuffer();

            String verses[] = str0.split(TextServiceItem.CHORUS_MARK+"\n");
            for (int i=0; i<verses.length; i++){
                String vlines[] = verses[i].split("\n");
                for (int j=0; j<vlines.length; j++){
                    sb.append(vlines[j]);
                    sb.append("\n");
                    if (lines != 0 && (j+1)%lines == 0 && vlines.length-j>1){
                        sb.append(TextServiceItem.SLIDE_BREAK);
                        sb.append("\n");
                    }
                }
                if (i < verses.length -1){
                    sb.append(TextServiceItem.CHORUS_MARK);
                    sb.append("\n");
                }
            }
            str0 = sb.toString();
        }

        // Store the result
        textComp.setText(str0);

    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JCheckBox cbMaxLenght;
    private javax.swing.JCheckBox cbMaxSlideLines;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMaxLenght;
    private javax.swing.JTextField txtMaxSlideLines;
    // End of variables declaration//GEN-END:variables

}


