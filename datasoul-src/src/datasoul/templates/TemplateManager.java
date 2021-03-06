/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 or later of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * TemplateManager.java
 *
 * Created on February 25, 2006, 1:05 PM
 *
 */

package datasoul.templates;

import java.io.File;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

import datasoul.config.ConfigObj;

/**
 *
 * @author samuelm
 */
public class TemplateManager implements TableModel {
    
    private static ArrayList<DisplayTemplateMetadata> availableTemplates = new ArrayList<DisplayTemplateMetadata>();
    private static TemplateManager instance = null;
    private ArrayList<javax.swing.event.TableModelListener> listeners;
   
    public static final int COLUMN_NAME = 0;
    public static final int COLUMN_TARGET_CONTENT = 1;
    public static final int COLUMN_COUNT = 2;


    /** Creates a new instance of TemplateManager */
    private TemplateManager() {
        listeners = new ArrayList<javax.swing.event.TableModelListener>();
        refreshAvailableTemplates();
    }
    
    public static synchronized TemplateManager getInstance(){
        if (instance == null){
            instance = new TemplateManager();
            // Ensure ConfigObj already loaded.
            // If any template combo box register to the TemplateManager before 
            // ConfigObj, it will cause a dead lock
            ConfigObj.getActiveInstance();
        }
        return instance;
    }
    

    public int getRowCount() {
        return availableTemplates.size();
    }

    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case COLUMN_NAME:
                return java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("TEMPLATE");
            case COLUMN_TARGET_CONTENT:
                return java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("CONTENT");
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case COLUMN_NAME:
                return availableTemplates.get(rowIndex).getName();
            case COLUMN_TARGET_CONTENT:
                return availableTemplates.get(rowIndex).getTargetContent();
        }
        return "";


    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    public void removeTableModelListener(javax.swing.event.TableModelListener l) {
        this.listeners.remove(l);
    }

    public void addTableModelListener(javax.swing.event.TableModelListener l) {
        this.listeners.add(l);
    }
    
    public void tableModelChanged(){
        TableModelEvent tme = new TableModelEvent(this);
        for(int i=0;i<this.listeners.size();i++){
            this.listeners.get(i).tableChanged(tme);            
        }
    }
    
    
    private void refreshAvailableTemplates(){
        
        availableTemplates.clear();
        String path = ConfigObj.getActiveInstance().getStoragePathTemplates();
        
        File file = new File(path);
        String[] files = file.list();
        
        // there is at least one file in the directroy?
        if (files!=null){
            int size = files.length;
            
            for(int i=0; i<size;i++){
                if(files[i].endsWith(".templatez")){
                    try {
                        availableTemplates.add(new DisplayTemplateMetadata(file.getAbsolutePath()+File.separator+files[i]));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        tableModelChanged();
        
    }
    
    
    public void deleteTemplate(String templateName) throws Exception {

        String path = ConfigObj.getActiveInstance().getStoragePathTemplates();
        File f = new File(path + File.separator + templateName + ".templatez");
        f.delete();
        DisplayTemplateMetadata todelete = null;
        for (DisplayTemplateMetadata meta : availableTemplates){
            if (meta.getName().equals(templateName)){
                todelete = meta;
                break;
            }
        }
        if (todelete != null){
            availableTemplates.remove(todelete);
        }
        tableModelChanged();
    }

    public void addTemplateMetadata(DisplayTemplateMetadata m){
        DisplayTemplateMetadata old = null;
        for (DisplayTemplateMetadata meta : availableTemplates){
            if (meta.getName().equals(m.getName())){
                old = meta;
                break;
            }
        }
        if (old != null){
            availableTemplates.remove(old);
        }
        availableTemplates.add(m);
        tableModelChanged();

    }

    public DisplayTemplateMetadata getDisplayTemplateMetadata(int i){
        return availableTemplates.get(i);
    }
   
    public DisplayTemplate newDisplayTemplate(String name) throws Exception{
        for (DisplayTemplateMetadata meta : availableTemplates){
            if (meta.getName().equals(name)){
                return meta.newDisplayTemplate();
            }
        }
        return null;
    }

    public DisplayTemplate newDisplayTemplate(String name, int width, int height) throws Exception{
        DisplayTemplate newdt = newDisplayTemplate(name);

        if (newdt != null && width != 0 && height != 0){
            newdt.setResolution(width, height);
        }

        return newdt;
    }


}


