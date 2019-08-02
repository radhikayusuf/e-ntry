/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry;

import com.app.entry.view.MainView;

/**
 *
 * @author radhikayusuf
 */
public class EntryApplication {
       
    public static void main(String[] args){
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }
    
    
    public static int ID_KASIR = 0;
    
}
