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
 * ShowDialog.java
 *
 * Created on February 2, 2007, 10:28 PM
 *
 */

package datasoul.util;

import java.io.File;

import javax.swing.JOptionPane;

/**
 *
 * @author samuelm
 */
public class ShowDialog {

    public static void showReadFileError(String filename, Exception e){
            JOptionPane.showMessageDialog(ObjectManager.getInstance().getDatasoulMainForm(),
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ERROR READING FILE")+"\n"+
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("FILE")+": "+filename+"\n"+
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ERROR")+": "+
                    e.getLocalizedMessage(),
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("DATASOUL ERROR"),0);
    }
    
    public static void showReadFileError(File file, Exception e){
            showReadFileError(file.getName(), e);
    }

    public static void showWriteFileError(String filename, Exception e){
            JOptionPane.showMessageDialog(ObjectManager.getInstance().getDatasoulMainForm(),
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ERROR WRITING FILE")+"\n"+
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("FILE")+": "+filename+"\n"+
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ERROR")+": "+
                    e.getLocalizedMessage(),
                    java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("DATASOUL ERROR"),0);
    }
    
    public static void showWriteFileError(File file, Exception e){
            showWriteFileError(file.getName(), e);
    }



}


