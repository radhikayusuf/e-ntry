/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.controller;

import com.app.entry.controller.PhotographerLoginController.PhotographerLoginContract;
import com.app.entry.model.PhotographerLoginModel;
import com.app.entry.utils.base.BaseContract;
import com.app.entry.utils.base.BaseController;


/**
 *
 * @author radhikayusuf
 */
public class PhotographerLoginController extends BaseController<PhotographerLoginContract> {
       
    PhotographerLoginModel mModel = new PhotographerLoginModel();
   
    public PhotographerLoginController(PhotographerLoginContract contract){
        super(contract);        
    }

    public void processLogin(String username, String password) {
        if(username.trim().isEmpty()){
            mContract.showMessage("Username Tidak boleh kosong!");
            return;
        } else if (password.trim().isEmpty()) {
            mContract.showMessage("Password Tidak boleh kosong!");
            return;
        }
        
        if(mModel.doLogin(username, password)){
            mContract.showMessage("Welcome");
            mContract.onLoginSuccess();
        } else {
            mContract.showMessage("Username atau Password salah!");
        }
    }
       
    public interface PhotographerLoginContract extends BaseContract{
        
        void onLoginSuccess();
        
    }
    
}
