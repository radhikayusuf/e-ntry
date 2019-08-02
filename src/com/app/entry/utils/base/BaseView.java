/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils.base;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author radhikayusuf
 */
public abstract class BaseView<T extends BaseController> extends JFrame {
    
    protected T mController;
    
    public BaseView(){        
        mController = createController();
    }
    
    public void showPaneMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
       
    public abstract T createController();       
    
}
