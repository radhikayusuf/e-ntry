/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry;

import com.app.entry.view.MainView;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author radhikayusuf
 */
public class EntryApplication {
    private static class JTatto extends Component {

        public JTatto() {

        }
    }
       
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new JTatto());
        } catch (Exception e) {
            System.out.println("Tidak Ada");
        }
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }
    
    
    public static int ID_KASIR = 0;
    
}
