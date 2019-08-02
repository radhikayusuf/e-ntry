/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author radhikayusuf
 */
public class EntryButton {
    
     public static void addClickEffect(JPanel panel, String name, EntryButtonCallback callback){
                 
         panel.addMouseListener(new MouseAdapter() {
             @Override
             public void mousePressed(MouseEvent e) {
                 super.mousePressed(e);
                 if(panel.getComponent(0) != null){
                    Component com = panel.getComponent(0);
                    if(com instanceof JLabel){
                        panel.setBackground(Color.WHITE);                 
                        com.setForeground(Color.BLACK);
                        callback.onClick(name);
                        panel.setBackground(Color.GRAY);
                        com.setForeground(Color.WHITE);  
                        callback.onReleased(name);
                    }
                }
             }        

             @Override
             public void mouseReleased(MouseEvent e) {
                 super.mouseReleased(e); 
                 if(panel.getComponent(0) != null){
                     Component com = panel.getComponent(0);
                     if(com instanceof JLabel){
                        panel.setBackground(Color.GRAY);
                        com.setForeground(Color.WHITE);  
                        callback.onReleased(name);
                     }                    
                 }
             }
             
         });         
     }
    
}