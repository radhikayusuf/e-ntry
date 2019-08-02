/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.controller;

import com.app.entry.controller.TransactionController.TransactionContract;
import com.app.entry.model.TransactionModel;
import com.app.entry.utils.ResultModel;
import com.app.entry.utils.base.BaseContract;
import com.app.entry.utils.base.BaseController;
import java.util.List;

/**
 *
 * @author radhikayusuf
 */
public class TransactionController extends BaseController<TransactionContract>{

    TransactionModel mModel = new TransactionModel();
    
    
    public TransactionController(TransactionContract contract) {
        super(contract);        
        
    } 
    
    public void getContentData(){
        mContract.onDataLoaded(mModel.getDataTransaction(""));
    }
    
    public void searchData(String searchQuery){
        mContract.onDataLoaded(mModel.getDataTransaction(searchQuery));
    }

    public void deleteData(String id) {
        ResultModel result = mModel.deleteData("id_transaksi", id);
        mContract.showMessage(result.getMessage());
        
        if(result.isSuccess()){
            mContract.onDataLoaded(mModel.getDataTransaction(""));
        }
    }
    
    public interface TransactionContract extends BaseContract{
        
        public void onDataLoaded(List<Object[]> data);
        
    }
}
