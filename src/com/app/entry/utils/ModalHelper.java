/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author radhikayusuf
 */
public class ModalHelper {
    
    
    public static void showAsModal(JFrame parent, String title, JFrame target){
        final JDialog frame = new JDialog(parent, title, true);
        frame.getContentPane().add(target);
        frame.pack();
        frame.setVisible(true);
    }
}
