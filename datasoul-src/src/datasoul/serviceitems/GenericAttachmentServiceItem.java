/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datasoul.serviceitems;

import datasoul.util.ObjectManager;
import datasoul.util.ZipReader;
import datasoul.util.ZipWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import org.w3c.dom.Node;

/**
 *
 * @author samuel
 */
public class GenericAttachmentServiceItem extends ContentlessServiceItem {

    protected String filename;
    protected String internalfilename;
    protected boolean isLink;
    protected File file;
    protected static File tmpdir;

    public GenericAttachmentServiceItem() {
        super();
    }

    public GenericAttachmentServiceItem(File f, boolean isLink) throws IOException{
        this();
        this.isLink = isLink;
        this.internalfilename = "att-"+filename;
        if (!isLink){
            InputStream is = new FileInputStream(f);
            copyFile(filename, is);
            this.filename = f.getName();
        }else{
            this.filename = f.getAbsolutePath();
            this.file = f;
        }
        int lastdot = f.getName().lastIndexOf(".");
        if (lastdot > 0){
            setTitle(f.getName().substring(0, lastdot));
        }else{
            setTitle(f.getName());
        }
        if (isLink){
            setTitle(getTitle() + " (" + "link" +")");
        }

    }

    protected void copyFile(String filename, InputStream is) throws IOException {


        // find and available name
        file = new File( getTempDir() + File.separator + filename );
        if (file.exists()){
            int i = 1;
            while (true){
                file = new File( getTempDir() + File.separator + i + "_" +filename );
                if (file.exists()){
                    i++;
                }else{
                    internalfilename = "att-"+file.getName();
                    break;
                }
            }
        }

        // Copy it to temporary directory
        file.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(file);
        try{
            byte[] buf = new byte[4096];
            int i = 0;
            while ((i = is.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }finally{
            fos.close();
            is.close();
        }
    }

    @Override
    protected void registerProperties(){
        super.registerProperties();
        properties.add("InternalFilename");
        properties.add("Filename");
        properties.add("IsLink");
    }

    protected String getTempDir(){
        if (tmpdir == null){
            tmpdir = new File(System.getProperty("java.io.tmpdir")+File.separator+"datasoul-tmp");
            if (! tmpdir.exists() ){
               tmpdir.mkdirs();
               tmpdir.deleteOnExit();
            }
        }
        return tmpdir.getAbsolutePath();
    }

    public String getFilename(){
        return filename;
    }

    public void setFilename(String s){
        this.filename = s;
    }

    public String getInternalFilename() {
        return internalfilename;
    }

    public void setInternalFilename(String filename) {
        this.internalfilename = filename;
    }


    @Override
    public Node writeObject(ZipWriter zip) throws Exception{
        Node node = super.writeObject(zip);
        if (!isLink){
            zip.appendFile(internalfilename, file.getAbsolutePath());
        }
        return node;
    }

    @Override
    public void readObject(Node nodeIn, ZipReader zip) {
        super.readObject(nodeIn, zip);
        if (!isLink){
            try {
                InputStream is = zip.getInputStream(internalfilename);
                copyFile(filename, is);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            file = new File(filename);
        }
    }

    @Override
    public Color getBackgroundColor(){
        return Color.decode("0xddffdd");
    }

    @Override
    public void dispose(){
        file.delete();
    }

    @Override
    public Icon getIcon(){
        return FileSystemView.getFileSystemView().getSystemIcon(file);
    }

    @Override
    public boolean getShowSlideTable(){
        return false;
    }

    public String getIsLink(){
        if (isLink){
            return "1";
        }else{
            return "0";
        }
    }

    public void setIsLink(String s){
        if (s.equals("1")){
            isLink = true;
        }else{
            isLink = false;
        }
    }

    public void setIsLink(boolean b){
        isLink = b;
    }

    public static boolean askForLink(){

        //Custom button text
        Object[] options = {"Link", "Copy"};
        int n = JOptionPane.showOptionDialog(ObjectManager.getInstance().getDatasoulMainForm(),
            "Do you want include a copy or a link to the file?",
            "Datasoul",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);

        return (n == 0);
    }

}
