/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils.base;

import com.app.entry.controller.KasirLoginController;

/**
 *
 * @author radhikayusuf
 */
public abstract class BaseController<C extends BaseContract> {
        
    protected C mContract;
        
    public BaseController(C contract){
        mContract = contract;
    }
    
    
}
