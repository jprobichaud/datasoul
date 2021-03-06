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
 * DatasoulKeyListener.java
 *
 * Created on 25 de Junho de 2006, 23:06
 *
 */

package datasoul.util;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import datasoul.config.ConfigObj;
import datasoul.datashow.AuxiliarPanel;
import datasoul.render.vlcj.VlcjBackgroundFrame;

/**
 *
 * @author Administrador
 */
public class DatasoulKeyListener implements KeyListener, AWTEventListener{
    
    private static DatasoulKeyListener instance;

    private DatasoulKeyListener(){

    }

    public static DatasoulKeyListener getInstance(){
        if (instance == null)
            instance = new DatasoulKeyListener();
        return instance;
    }


    @Override
    public void eventDispatched(AWTEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
               keyPressed((KeyEvent) e);
            break;
            case KeyEvent.KEY_RELEASED:
               keyReleased((KeyEvent) e);
            break;
            case KeyEvent.KEY_TYPED:
               keyTyped((KeyEvent) e);
            break;        
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_F4:
                ObjectManager.getInstance().getDatasoulMainForm().showDisplayControls();
                ObjectManager.getInstance().getLivePanel().setFocusInTable();
                break;
            case KeyEvent.VK_F5:
                ObjectManager.getInstance().getDatasoulMainForm().showOutputs();
                break;
            case KeyEvent.VK_F6:
                ObjectManager.getInstance().getDatasoulMainForm().showDisplayControls();
                ObjectManager.getInstance().getAuxiliarPanel().setVisibleTab(AuxiliarPanel.TAB_DISPLAY);
                break;
            case KeyEvent.VK_F7:
                ObjectManager.getInstance().getDatasoulMainForm().showDisplayControls();
                ObjectManager.getInstance().getAuxiliarPanel().setVisibleTab(AuxiliarPanel.TAB_ALARM);
                break;
            case KeyEvent.VK_F8:
                if (ConfigObj.getActiveInstance().getTrackDurationBool()){
                    ObjectManager.getInstance().getDatasoulMainForm().showDisplayControls();
                    ObjectManager.getInstance().getAuxiliarPanel().setVisibleTab(AuxiliarPanel.TAB_CLOCK);
                }
                break;
            case KeyEvent.VK_F9:
                ObjectManager.getInstance().getAuxiliarPanel().getDisplayControlPanel().mainDisplayBlack();
                break;
            case KeyEvent.VK_F11:
                ObjectManager.getInstance().getAuxiliarPanel().getDisplayControlPanel().shortcutHideMain();
                break;
            case KeyEvent.VK_F12:
                ObjectManager.getInstance().getAuxiliarPanel().getDisplayControlPanel().shortcutShowMain();
                break;
        }

        if (e.getSource() instanceof VlcjBackgroundFrame){
            switch( e.getKeyCode()){
                case KeyEvent.VK_PAGE_DOWN:
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_DOWN:
                    ObjectManager.getInstance().getLivePanel().serviceNextSlide();
                    break;
                case KeyEvent.VK_PAGE_UP:
                case KeyEvent.VK_UP:
                case KeyEvent.VK_LEFT:
                    ObjectManager.getInstance().getLivePanel().servicePreviousSlide();
                    break;

                case KeyEvent.VK_ESCAPE:
                    ObjectManager.getInstance().getDatasoulMainForm().closeOutputs();
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // to conform with DatasoulKeyListener
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // to conform with DatasoulKeyListener
    }
}

