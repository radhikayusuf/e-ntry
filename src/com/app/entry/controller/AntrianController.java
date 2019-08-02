/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.controller;

import com.app.entry.controller.AntrianController.AntrianContract;
import com.app.entry.model.AntrianModel;
import com.app.entry.utils.base.BaseContract;
import com.app.entry.utils.base.BaseController;
import java.util.HashMap;

/**
 *
 * @author radhikayusuf
 */
public class AntrianController extends BaseController<AntrianContract>{

    private AntrianModel mModel = new AntrianModel();
    
    public AntrianController(AntrianContract contract) {
        super(contract);        
    }
    
    public void callData(){
        mContract.onDataLoaded(mModel.getAntrian());
    }
       
    public interface AntrianContract extends BaseContract {
        void onDataLoaded(HashMap<String,String> data);
    }
    
}
