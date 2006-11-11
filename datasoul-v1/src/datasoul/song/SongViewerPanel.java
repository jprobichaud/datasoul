/*
 * SongViewerPanel.java
 *
 * Created on 14 de Dezembro de 2005, 22:09
 */

package datasoul.song;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import datasoul.*;
import datasoul.util.*;
import datasoul.datashow.*;
import datasoul.song.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.print.attribute.AttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author  Administrador
 */
public class SongViewerPanel extends javax.swing.JPanel {

    private SongsPanel objectManager;
    private ArrayList<String> chordsName;
    
    private Style nameStyle;
    private Style authorStyle;
    private Style lyricsStyle;
    private Style chordsStyle;
    private Style chordShapeStyle;
    
    private SongTemplate songTemplate;
    private Song song;
    
    private String keyOrig="";
    private String keyActual="";
    
    private Vector<String> notes = new Vector<String>();

    private static ArrayList<String> specialWords = new ArrayList<String>();    

    public static String VIEW_LYRICS = "Lyrics";
    public static String VIEW_CHORDS_COMPLETE = "Chords Complete";
    public static String VIEW_CHORDS_SIMPLIFIED = "Chords Simplified";

    public static String activeView = VIEW_LYRICS;
    
    private void loadSongTemplate(){
        songTemplate = new SongTemplate();
        
        String filepath = System.getProperty("user.dir") + System.getProperty("file.separator") 
        + "config"+ System.getProperty("file.separator") + "datasoul.songtemplate";

        File songTemplateFile = new File(filepath);
        
        Document dom=null;
        Node node = null;
        Song song;
        if(songTemplateFile.exists()){
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                //Using factory get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();

                //parse using builder to get DOM representation of the XML file
                dom = db.parse(songTemplateFile);

                //node = dom.getDocumentElement().getChildNodes().item(0);
                node = dom.getElementsByTagName("SongTemplate").item(0);

                songTemplate.readObject(node);
               
            }catch(Exception e) {
                JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nFile: "+songTemplateFile.getName()+"\nError: "+e.getMessage(),"DataSoul Error",0);
            }
        }
    }
    
    /**
     * Creates new form SongViewerPanel
     */
    public SongViewerPanel() {
        initComponents();

        loadSongTemplate();

        notes.add("C");
        notes.add("C#");
        notes.add("D");
        notes.add("D#");
        notes.add("E");
        notes.add("F");
        notes.add("F#");
        notes.add("G");
        notes.add("G#");
        notes.add("A");
        notes.add("A#");
        notes.add("B");
        comboKey.removeAllItems();
        comboKey.addItem("C");
        comboKey.addItem("C#");
        comboKey.addItem("D");
        comboKey.addItem("D#");
        comboKey.addItem("E");
        comboKey.addItem("F");
        comboKey.addItem("F#");
        comboKey.addItem("G");
        comboKey.addItem("G#");
        comboKey.addItem("A");
        comboKey.addItem("A#");
        comboKey.addItem("B");

        specialWords.add("Intro");
        specialWords.add("(1x)");
        specialWords.add("(2x)");
        specialWords.add("(3x)");
        specialWords.add("(4x)");
        specialWords.add("(5x)");        
        specialWords.add("(6x)");
        specialWords.add("(7x)");
        specialWords.add("(8x)");        
        specialWords.add("(9x)");        
        
        
        chordsName = new ArrayList<String>();
        
        StyleContext sc = new StyleContext();
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    //prop font
        nameStyle = sc.addStyle("nameStyle",defaultStyle);
        authorStyle = sc.addStyle("authorStyle",defaultStyle);
        lyricsStyle = sc.addStyle("lyricsStyle",defaultStyle);
        chordsStyle = sc.addStyle("chordsStyle",defaultStyle);
        chordShapeStyle = sc.addStyle("chordShapeStyle",null);

        this.btnViewLyricsActionPerformed(null);
        
        setStyles();
    }
    
    private void setStyles(){
        StyleConstants.setForeground(nameStyle,Color.decode("0x"+songTemplate.getTitleFontColor()));
        StyleConstants.setBackground(nameStyle,Color.white);
        StyleConstants.setFontFamily(nameStyle,songTemplate.getTitleFontName());
        StyleConstants.setFontSize(nameStyle,songTemplate.getTitleFontSize());                

        StyleConstants.setForeground(authorStyle,Color.decode("0x"+songTemplate.getAuthorFontColor()));
        StyleConstants.setBackground(authorStyle,Color.white);
        StyleConstants.setFontFamily(authorStyle,songTemplate.getAuthorFontName());
        StyleConstants.setFontSize(authorStyle,songTemplate.getAuthorFontSize());                

        StyleConstants.setForeground(chordsStyle,Color.decode("0x"+songTemplate.getChordsFontColor()));
        StyleConstants.setBackground(chordsStyle,Color.white);
        StyleConstants.setFontFamily(chordsStyle,songTemplate.getChordsFontName());
        StyleConstants.setFontSize(chordsStyle,songTemplate.getChordsFontSize());       

        StyleConstants.setForeground(lyricsStyle,Color.decode("0x"+songTemplate.getLyricsFontColor()));
        StyleConstants.setBackground(lyricsStyle,Color.white);
        StyleConstants.setFontFamily(lyricsStyle,songTemplate.getLyricsFontName());
        StyleConstants.setFontSize(lyricsStyle,songTemplate.getLyricsFontSize());
        
    }
    
    public void refresh(){
        if(song!=null){
            showSong();
        }
    }
    
    public void setView(String item){
        activeView = item;
    }

    public String getView(){
        return activeView;
    }
    
    
    public void viewSong(Song song){
        keyOrig="";
        keyActual="";
        
        this.song = song;
        lblSongName.setText("   "+song.getTitle());
        showSong();
    }
    
    public void showSong(){
        setStyles();        
        
        chordsName.clear();

        try {            
            drawLyrics(this.editorSong,true);
            drawChords(this.editorSongChords,true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void drawLyrics(JEditorPane jep, boolean clearBeforeAdd) throws Exception{
        String strSong="";
        String line="";
        String nextline="";
        StringBuffer html = new StringBuffer();
        StringReader sr = null;
        BufferedReader buff= null;

       
        jep.setContentType("text/rtf");
        
        javax.swing.text.Document doc = jep.getDocument();

        if(this.getView().equals(this.VIEW_CHORDS_COMPLETE)){
            strSong = song.getChordsComplete();
        }else if(this.getView().equals(this.VIEW_CHORDS_SIMPLIFIED)){
            strSong = song.getChordsSimplified();
        }else{
            strSong = song.getText().replace(Song.CHORUS_MARK,"").replace(Song.SLIDE_BREAK,"");
        }
        
        sr = new StringReader(strSong);
        buff = new BufferedReader(sr);
        
        if(clearBeforeAdd){
            doc.remove(0,doc.getLength());
        }

        doc.insertString(doc.getLength(),song.getTitle()+"\n",nameStyle);
        doc.insertString(doc.getLength(),song.getSongAuthor()+"\n\n\n",authorStyle);

        line = buff.readLine();
        while((nextline = buff.readLine())!=null){
            addFormattedSongLine(doc,line,nextline);
            line = nextline;
        }
        addFormattedSongLine(doc,line,"");
       
    }
    
    
    private void addFormattedSongLine(javax.swing.text.Document doc, String line, String nextline) throws BadLocationException{
        if(line==null)
            return;
        
        if(isChordsLine(line)){
            doc.insertString(doc.getLength(),getFormattedChordLine(line,nextline)+"\n",chordsStyle);
        }else{
            doc.insertString(doc.getLength(),getFormattedLyricLine(line)+"\n",lyricsStyle);
        }
        return;
    }
    
    private boolean isChordsLine(String line){
        String[] chords = line.split(" ");        
        ChordsDB chordsDB = ChordsDB.getInstance();
  loop: for(int i=0;i<chords.length;i++){
            if(!chords[i].equals(""))
            {
                for(int j=0;j<specialWords.size();j++){
                    if(chords[i].toLowerCase().contains(specialWords.get(j).toLowerCase())){
                        continue loop;
                    }
                }
                
                Chord chord = chordsDB.getChordByName(chords[i]);
                if(chord==null)
                    return false;
            }
        }

        return true;
    }

    private String getFormattedLyricLine(String line){
        return line;
    }

    private String getFormattedChordLine(String line,String nextline){
        String newLine="";
        String strAux="";
        String spaces="";
        int index=0;
        int widthNextLine=0;
        int widthNewLine=0;
        int neededWidth=0;
        int spaceSize=0;
        int spacesNedded=0;
        
        String[] chords = line.split(" ");
        Font fontChords = new Font(songTemplate.getChordsFontName(), Font.PLAIN, songTemplate.getChordsFontSize());
        FontMetrics fontChordsMetrics = getFontMetrics(fontChords);
        Font fontLyrics = new Font(songTemplate.getLyricsFontName(), Font.PLAIN, songTemplate.getLyricsFontSize());
        FontMetrics fontLyricsMetrics = getFontMetrics(fontLyrics);
        spaceSize = fontChordsMetrics.stringWidth(" ");
        
        for(int i=0;i<chords.length;i++){
            if(!chords[i].equals("")){
                boolean specialWord = false;
                for(int j=0;j<specialWords.size();j++){
                    if(chords[i].toLowerCase().contains(specialWords.get(j).toLowerCase())){
                        specialWord = true;
                    }
                }
                
                String thisChord = changeKey(chords[i]);
                if(!chordsName.contains(thisChord)&&!specialWord)
                    chordsName.add(thisChord);
                index = strAux.length();
                if(index<nextline.length()){
                    widthNextLine = fontLyricsMetrics.stringWidth(nextline.substring(0,index));                
                    widthNewLine = fontChordsMetrics.stringWidth(newLine);                
                    neededWidth = (widthNextLine - widthNewLine);
                    spacesNedded = Math.round(neededWidth/spaceSize);
                    spaces = "";
                    for(int j=0;j<spacesNedded;j++)
                        spaces = spaces + " ";
                    newLine = newLine + spaces + thisChord;
                }else{
                    newLine = newLine + spaces + thisChord;                    
                }
                strAux += thisChord + " ";                    
            }else{
                strAux += " ";
                spaces = spaces + " ";
            }
        }
        
        return newLine;        
    }
    
    private String changeKey(String chord){
        String newChord = chord;
        
        if(keyActual.equals("")){
            keyActual = getNote(chord);        
            comboKey.setSelectedItem(keyActual);
        }
        if(keyOrig.equals(""))
            keyOrig = getNote(chord);

        //if key was changed
        if(!keyActual.equals(keyOrig)){
            int diff = notes.indexOf(keyActual)-notes.indexOf(keyOrig);
            //main note
            String note = getNote(chord);
            int index = notes.indexOf(note);
            int newIndex = index + diff;
            if(newIndex<0)
                newIndex = 12 - newIndex;
            if(newIndex>11)
                newIndex = newIndex-12;
            
            newChord =  notes.get(newIndex);
            
            if(chord.contains("/")){
                //main note
                note = getNote(chord.substring(chord.indexOf("/")+1,chord.length()));
                index = notes.indexOf(note);
                newIndex = index + diff;
                if(newIndex<0)
                    newIndex = 12 - newIndex;
                if(newIndex>11)
                    newIndex = newIndex-12;
                
                newChord =  newChord+chord.substring(getNote(chord).length(),chord.indexOf("/")+1)+notes.get(newIndex);                
            }else{
                newChord =  newChord+chord.substring(note.length(),chord.length());                
            }
           
        }

        return newChord;
    }
    
    private String getNote(String chord){
        if((chord.length()>1)&&(chord.substring(1,2).equals("#"))){
            return chord.substring(0,2);
        }else if((chord.length()>1)&&(chord.substring(1,2).equals("b"))){
            int index = notes.indexOf(chord.substring(0,1))-1;
            if(index==-1){
                index=11;
            }
            return notes.get(index);
        }else{
            return chord.substring(0,1);
        }
    }
    
    private void drawChords(JEditorPane jep, boolean clearBeforeAdd) throws BadLocationException {

        jep.setContentType("text/rtf");
        
        javax.swing.text.Document doc = jep.getDocument();
        
        if(clearBeforeAdd){
            doc.remove(0,doc.getLength());
        }
        
        ChordsDB chordsDB = ChordsDB.getInstance();
        for(int i=0; i<chordsName.size();i++){
            Chord chord = chordsDB.getChordByName(chordsName.get(i));
            if(chord!=null){
                int shapeSize = 1;
                if(songTemplate.getChordShapeSizeIdx() == SongTemplate.CHORDSIZE_SMALL){
                    shapeSize = 3;
                }else if(songTemplate.getChordShapeSizeIdx() == SongTemplate.CHORDSIZE_MEDIUM){
                    shapeSize = 2;
                }
                ChordShapePanel csp = new ChordShapePanel(shapeSize, chord.getName(),chord.getShape());
                
                StyleConstants.setIcon(chordShapeStyle, new ImageIcon(csp.createImage()));
                doc.insertString(doc.getLength(),"text to be ignored", chordShapeStyle);

            }else{
                doc.insertString(doc.getLength(),"\nChord not cataloged "+chordsName.get(i)+"\n", lyricsStyle);                
            }
                
        }
    }


    public SongsPanel getObjectManager() {
        return objectManager;
    }

    public void setObjectManager(SongsPanel objectManager) {
        this.objectManager = objectManager;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        split1 = new javax.swing.JSplitPane();
        panelSong = new javax.swing.JPanel();
        scroolSong = new javax.swing.JScrollPane();
        editorSong = new javax.swing.JEditorPane();
        panelSongChords = new javax.swing.JPanel();
        scroolSongChords = new javax.swing.JScrollPane();
        editorSongChords = new javax.swing.JEditorPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnPrint = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnFormat = new javax.swing.JButton();
        btnChords = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        labelVersion = new javax.swing.JLabel();
        btnViewLyrics = new javax.swing.JButton();
        btnViewChordsComplete = new javax.swing.JButton();
        btnViewChordsSimpified = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelKey = new javax.swing.JLabel();
        comboKey = new javax.swing.JComboBox();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lblSongName = new javax.swing.JLabel();

        split1.setDividerLocation(375);
        editorSong.setEditable(false);
        scroolSong.setViewportView(editorSong);

        org.jdesktop.layout.GroupLayout panelSongLayout = new org.jdesktop.layout.GroupLayout(panelSong);
        panelSong.setLayout(panelSongLayout);
        panelSongLayout.setHorizontalGroup(
            panelSongLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scroolSong)
        );
        panelSongLayout.setVerticalGroup(
            panelSongLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scroolSong, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        split1.setLeftComponent(panelSong);

        editorSongChords.setEditable(false);
        scroolSongChords.setViewportView(editorSongChords);

        org.jdesktop.layout.GroupLayout panelSongChordsLayout = new org.jdesktop.layout.GroupLayout(panelSongChords);
        panelSongChords.setLayout(panelSongChordsLayout);
        panelSongChordsLayout.setHorizontalGroup(
            panelSongChordsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scroolSongChords)
        );
        panelSongChordsLayout.setVerticalGroup(
            panelSongChordsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scroolSongChords, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        split1.setRightComponent(panelSongChords);

        jToolBar1.setFloatable(false);
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/print_printer.png")));
        btnPrint.setText("Print");
        btnPrint.setToolTipText("Print song ...");
        btnPrint.setBorderPainted(false);
        btnPrint.setFocusPainted(false);
        btnPrint.setMaximumSize(new java.awt.Dimension(61, 28));
        btnPrint.setMinimumSize(new java.awt.Dimension(61, 28));
        btnPrint.setOpaque(false);
        btnPrint.setPreferredSize(new java.awt.Dimension(61, 28));
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });

        jToolBar1.add(btnPrint);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/document.png")));
        btnExport.setText("Export");
        btnExport.setToolTipText("Export song ...");
        btnExport.setBorderPainted(false);
        btnExport.setFocusPainted(false);
        btnExport.setMaximumSize(new java.awt.Dimension(72, 28));
        btnExport.setMinimumSize(new java.awt.Dimension(72, 28));
        btnExport.setOpaque(false);
        btnExport.setPreferredSize(new java.awt.Dimension(72, 28));
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });

        jToolBar1.add(btnExport);

        btnFormat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/colors.png")));
        btnFormat.setText("Format");
        btnFormat.setToolTipText("Format song view ...");
        btnFormat.setBorderPainted(false);
        btnFormat.setFocusPainted(false);
        btnFormat.setMaximumSize(new java.awt.Dimension(76, 28));
        btnFormat.setMinimumSize(new java.awt.Dimension(72, 32));
        btnFormat.setOpaque(false);
        btnFormat.setPreferredSize(new java.awt.Dimension(76, 28));
        btnFormat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormatMouseClicked(evt);
            }
        });

        jToolBar1.add(btnFormat);

        btnChords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/chordsmanager.png")));
        btnChords.setText("Chords");
        btnChords.setBorderPainted(false);
        btnChords.setFocusPainted(false);
        btnChords.setMaximumSize(new java.awt.Dimension(180, 28));
        btnChords.setMinimumSize(new java.awt.Dimension(57, 28));
        btnChords.setOpaque(false);
        btnChords.setPreferredSize(new java.awt.Dimension(80, 28));
        btnChords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChordsActionPerformed(evt);
            }
        });

        jToolBar1.add(btnChords);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.add(jSeparator2);

        labelVersion.setText("Version ");
        jToolBar1.add(labelVersion);

        btnViewLyrics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/songView1.gif")));
        btnViewLyrics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLyricsActionPerformed(evt);
            }
        });

        jToolBar1.add(btnViewLyrics);

        btnViewChordsComplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/songView2.gif")));
        btnViewChordsComplete.setDefaultCapable(false);
        btnViewChordsComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewChordsCompleteActionPerformed(evt);
            }
        });

        jToolBar1.add(btnViewChordsComplete);

        btnViewChordsSimpified.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/songView3.gif")));
        btnViewChordsSimpified.setDefaultCapable(false);
        btnViewChordsSimpified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewChordsSimpifiedActionPerformed(evt);
            }
        });

        jToolBar1.add(btnViewChordsSimpified);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.add(jSeparator1);

        labelKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/changekey.png")));
        labelKey.setText("Key ");
        jToolBar1.add(labelKey);

        comboKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKey.setToolTipText("Select the key to song");
        comboKey.setMinimumSize(new java.awt.Dimension(25, 18));
        comboKey.setPreferredSize(new java.awt.Dimension(25, 22));
        comboKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKeyActionPerformed(evt);
            }
        });

        jToolBar1.add(comboKey);

        jToolBar2.setFloatable(false);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/playsound.png")));
        jLabel1.setText("Song:");
        jToolBar2.add(jLabel1);

        lblSongName.setText("   ");
        jToolBar2.add(lblSongName);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .add(split1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(split1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewChordsSimpifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewChordsSimpifiedActionPerformed
        this.btnViewLyrics.setEnabled(true);
        this.btnViewChordsComplete.setEnabled(true);
        this.btnViewChordsSimpified.setEnabled(false);
        
        this.setView(this.VIEW_CHORDS_SIMPLIFIED);
        this.refresh();
    }//GEN-LAST:event_btnViewChordsSimpifiedActionPerformed

    private void btnViewChordsCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewChordsCompleteActionPerformed
        this.btnViewLyrics.setEnabled(true);
        this.btnViewChordsComplete.setEnabled(false);
        this.btnViewChordsSimpified.setEnabled(true);
        
        this.setView(this.VIEW_CHORDS_COMPLETE);
        this.refresh();
    }//GEN-LAST:event_btnViewChordsCompleteActionPerformed

    private void btnViewLyricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLyricsActionPerformed
        this.btnViewLyrics.setEnabled(false);
        this.btnViewChordsComplete.setEnabled(true);
        this.btnViewChordsSimpified.setEnabled(true);
        
        this.setView(this.VIEW_LYRICS);
        this.refresh();
    }//GEN-LAST:event_btnViewLyricsActionPerformed

    private void btnChordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChordsActionPerformed
        ChordsManagerFrame cmf = new ChordsManagerFrame();
        cmf.setVisible(true);
    }//GEN-LAST:event_btnChordsActionPerformed

    private void comboKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKeyActionPerformed
        if(keyOrig.equals(""))
            return;
        
        keyActual = (String)comboKey.getSelectedItem();
        this.refresh();
    }//GEN-LAST:event_comboKeyActionPerformed

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        JEditorPane jep = new JEditorPane();
        try {            
            drawLyrics(jep,true);
            drawChords(jep,false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
        Content content = new Content(jep);
        pj.setPrintable(content, pf);
        try {
            if (pj.printDialog())
                pj.print();
        } catch (Exception e) {}

    }//GEN-LAST:event_btnPrintMouseClicked

    private void btnFormatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormatMouseClicked

        SongFormatFrame sff = new SongFormatFrame(this, songTemplate);
        sff.setVisible(true);
    }//GEN-LAST:event_btnFormatMouseClicked

        public ByteArrayOutputStream exportRTFSong(ByteArrayOutputStream os) throws Exception{
            ByteArrayOutputStream os2 = exportRTFLyrics(os);
            ByteArrayOutputStream os3 = exportRTFChords(os2);
            return os3;
        }
        public ByteArrayOutputStream exportRTFLyrics(ByteArrayOutputStream os) throws Exception{
              //writes the lyrics and its chords
              ByteArrayOutputStream osOut = new ByteArrayOutputStream();
              boolean firstPage = true;
              if(os.toByteArray().length>0){
                  osOut.write(os.toByteArray(),0,os.toByteArray().length-2);                  
                  firstPage = false;
              }

              javax.swing.text.Document doc = this.editorSong.getDocument();
              int length = doc.getLength();
              doc.getDefaultRootElement().getElement(0);
              
              if(firstPage){
                  this.editorSong.getEditorKit().write(osOut, doc, 0, length);                  
              }else{
                osOut.write("\\page ".getBytes());                                          
                ByteArrayOutputStream osAux = new ByteArrayOutputStream();
                this.editorSong.getEditorKit().write(osAux, doc, 0, length);
                String aux = osAux.toString();
                int index = aux.indexOf("}}")+2;
                osOut.write(osAux.toByteArray(),index,osAux.size()-index-2);
              }

              if(os.toByteArray().length>0){
                  osOut.write("\n}".getBytes());
              }
              
              osOut.close();
              
              return osOut;
        }

        public ByteArrayOutputStream exportRTFChords(ByteArrayOutputStream os) throws IOException{

              ByteArrayOutputStream osOut = new ByteArrayOutputStream();
              osOut.write(os.toByteArray(),0,os.toByteArray().length-2);
              
              javax.swing.text.Document docChords = this.editorSongChords.getDocument();
              int chordsLength = docChords.getLength();
 
                ChordsDB chordsDB = ChordsDB.getInstance();
                for(int i=0; i<chordsName.size();i++){
                    Chord chord = chordsDB.getChordByName(chordsName.get(i));
                    if(chord!=null){
                        int shapeSize = 1;
                        if(songTemplate.getChordShapeSizeIdx() == SongTemplate.CHORDSIZE_SMALL){
                            shapeSize = 3;
                        }else if(songTemplate.getChordShapeSizeIdx() == SongTemplate.CHORDSIZE_MEDIUM){
                            shapeSize = 2;
                        }
                        ChordShapePanel csp = new ChordShapePanel(shapeSize, chord.getName(),chord.getShape());

                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        BufferedImage bi= csp.createImage();

                        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
                        encoder.encode(bi);

                        byte[] ba=baos.toByteArray();

                        int len=ba.length,j;
                        StringBuffer sb=new StringBuffer(len*2);
                        for (j=0;j<len;j++) {
                            String sByte=Integer.toHexString((int)(ba[j] & 0xFF));
                            if (sByte.length()!=2)
                                sb.append('0'+sByte);
                            else
                                sb.append(sByte);
                        }
                        String s="{\\pict\\jpegblip " + sb.toString()+"}";

                        osOut.write(s.getBytes());
                    }else{
                    }

                }
                osOut.write("\n}".getBytes());
                osOut.close();
                
                return osOut;
        }
    
    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() { 
                      public boolean accept(File f) { 
                          if (f.isDirectory()) { 
                              return true; 
                          } 
                          String name = f.getName(); 
                          if (name.endsWith(".rtf")) { 
                              return true; 
                          } 
                          return false; 
                      } 
   
                      public String getDescription() { 
                          return ".rtf"; 
                      } 
                  });
        File dir = new File (System.getProperty("user.dir") + System.getProperty("file.separator") + "songs");
        fc.setCurrentDirectory(dir);
        fc.setDialogTitle("Select the file to export");
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            try {

                ByteArrayOutputStream osOut = exportRTFSong(new ByteArrayOutputStream());    
                String filePath = fc.getSelectedFile().getPath();
                if(!filePath.contains(".rtf"))
                    filePath = filePath + ".rtf";
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(osOut.toByteArray());
                fos.close();

            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_btnExportMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChords;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFormat;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnViewChordsComplete;
    private javax.swing.JButton btnViewChordsSimpified;
    private javax.swing.JButton btnViewLyrics;
    private javax.swing.JComboBox comboKey;
    private javax.swing.JEditorPane editorSong;
    private javax.swing.JEditorPane editorSongChords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JLabel lblSongName;
    private javax.swing.JPanel panelSong;
    private javax.swing.JPanel panelSongChords;
    private javax.swing.JScrollPane scroolSong;
    private javax.swing.JScrollPane scroolSongChords;
    private javax.swing.JSplitPane split1;
    // End of variables declaration//GEN-END:variables

    class Content implements Printable {
        JEditorPane jep;
        
        public Content(JEditorPane jep){
            this.jep = jep; 
        }
        
        public int print(Graphics g, PageFormat pf, int pageIndex) {
            jep.setSize((int)pf.getWidth(), (int)pf.getHeight());
            jep.invalidate();

            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pf.getImageableX(), pf.getImageableY());

            if (pageIndex==0){
                jep.paint(g2d);
            } else{
                return Printable.NO_SUCH_PAGE;
            }
            
            return Printable.PAGE_EXISTS;
        }
    }
}
