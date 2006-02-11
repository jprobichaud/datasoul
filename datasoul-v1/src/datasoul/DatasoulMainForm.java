/*
 * DatasoulMainForm.java
 *
 * Created on 13 de Dezembro de 2005, 21:59
 */

package datasoul;

import datasoul.datashow.DatashowPanel;
import datasoul.song.SongsPanel;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import org.jdesktop.layout.LayoutStyle;
import java.util.Locale;

/**
 *
 * @author  Administrador
 */
public class DatasoulMainForm extends javax.swing.JFrame {

    public SongsPanel songs = new SongsPanel();
    public DatashowPanel datashow = new DatashowPanel();
    
    /**
     * Creates new form DatasoulMainForm
     */
    public DatasoulMainForm() {
       
        initComponents();

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/datasoul.gif")).getImage());
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());

        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(datashow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .add(toolBarMain)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(toolBarMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(datashow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        );

        songs.setVisible(false);
        datashow.setVisible(true);
        datashow.validate();

        getContentPane().setLayout(layout);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toolBarMain = new javax.swing.JToolBar();
        btnDatashow = new javax.swing.JButton();
        btnSongs = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataSoul");
        btnDatashow.setFont(new java.awt.Font("Arial", 1, 11));
        btnDatashow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/datashow.gif")));
        btnDatashow.setText("Datashow");
        btnDatashow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatashowMouseClicked(evt);
            }
        });

        toolBarMain.add(btnDatashow);

        btnSongs.setFont(new java.awt.Font("Arial", 1, 11));
        btnSongs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/songs.gif")));
        btnSongs.setText("Songs");
        btnSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSongsMouseClicked(evt);
            }
        });

        toolBarMain.add(btnSongs);

        toolBarMain.add(jSeparator1);

        menu.setText(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("MENU"));
        menuBar.add(menu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(toolBarMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(toolBarMain)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSongsMouseClicked
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(songs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .add(toolBarMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(toolBarMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(songs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        );

        datashow.setVisible(false);
            songs.setVisible(true);
            songs.validate();
  
    }//GEN-LAST:event_btnSongsMouseClicked

    private void btnDatashowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatashowMouseClicked
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(datashow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .add(toolBarMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(toolBarMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(datashow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        );

        songs.setVisible(false);
            datashow.setVisible(true);
            datashow.validate();
    }//GEN-LAST:event_btnDatashowMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
//            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch(Exception e){
            
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatasoulMainForm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatashow;
    private javax.swing.JButton btnSongs;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToolBar toolBarMain;
    // End of variables declaration//GEN-END:variables
    
}
