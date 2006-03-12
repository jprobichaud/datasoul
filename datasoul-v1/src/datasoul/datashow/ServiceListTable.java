/*
 * ServiceListTable.java
 *
 * Created on 9 de Janeiro de 2006, 22:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package datasoul.datashow;

import datasoul.*;
import datasoul.util.*;
import datasoul.datashow.*;
import datasoul.song.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrador
 */
public class ServiceListTable extends ListTable{
    
    static ServiceListTable instance;
    
    /** Creates a new instance of ServiceListTable */
    private ServiceListTable() {
    }
    
    public static ServiceListTable getInstance(){
        if(instance==null){
            instance = new ServiceListTable();
        }
        return instance;
    }

    public String getColumnName(int columnIndex) {
        if(columnIndex == 0)
            return "Service Item";
        else
            return "Template";
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            Object object = objectList.get(rowIndex);
            return  object;
        }else{
            Object object = objectList.get(rowIndex);
            return  ((ServiceItem)object).getTemplate();
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            objectList.set(rowIndex,(String)aValue.toString());
            tableModelChanged();
        }else{
            ((ServiceItem)objectList.get(rowIndex)).setTemplate((String)aValue.toString());
            tableModelChanged();
        }
    }
    
    public int getColumnCount() {
        return 2;
    }
    
     public Node writeObject() throws Exception{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //Using factory get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
         
        Document doc= db.newDocument();
        
        Node nodeOut = doc.createElement("ServiceListTable");
        Node node; 
        String paramName;
        String paramValue;
        for(int i=0;i<objectList.size();i++){
            node = ((SerializableItf)objectList.get(i)).writeObject();
            nodeOut.appendChild(doc.importNode(node,true));
        }
              
        return nodeOut.cloneNode(true);
     }
     
     public void readObject(Node nodeIn) throws Exception{
        this.objectList.clear();
         
        NodeList nodeList= nodeIn.getChildNodes();
        String paramName;
        String paramValue;
        for(int i=0;i<nodeList.getLength();i++){
            if(nodeList.item(i).getNodeType()==1){
                if(nodeList.item(i).getNodeName().equals("Song")){
                    Song song = new Song();
                    song.readObject(nodeList.item(i));
                    this.addItem(song);
                }else if(nodeList.item(i).getNodeName().equals("TextServiceItem")){
                    TextServiceItem tsi = new TextServiceItem();
                    tsi.readObject(nodeList.item(i));
                    this.addItem(tsi);
                }
            }
        }
     }
    
}
