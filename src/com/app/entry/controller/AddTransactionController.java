/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.controller;

import com.app.entry.controller.AddTransactionController.AddTrasactionContract;
import com.app.entry.model.AddTransactionModel;
import com.app.entry.utils.ResultModel;
import com.app.entry.utils.base.BaseContract;
import com.app.entry.utils.base.BaseController;
import java.util.List;

/**
 *
 * @author radhikayusuf
 */
public class AddTransactionController extends BaseController<AddTrasactionContract>{

    AddTransactionModel mModel = new AddTransactionModel();
    
    public AddTransactionController(AddTrasactionContract contract) {
        super(contract);
    }
    
    public List<String[]> getDataStudio(){
        return mModel.getStudio();
    }

    public void tambahData(String nama, String noTelp, String jmlOrang, String jenisPaket, String idStudio) {
        if(nama.trim().isEmpty()){
            mContract.showMessage("Nama Tidak boleh kosong!");
            return;
        } else if (noTelp.trim().isEmpty()) {
            mContract.showMessage("Nomor Telp Tidak boleh kosong!");
            return;
        } else if (jenisPaket.trim().isEmpty()) {
            mContract.showMessage("Harap pilih jenis paket!");
            return;
        } else if (idStudio.trim().isEmpty()) {
            mContract.showMessage("Harap pilih studio!");
            return;
        }
        
        
        if (jmlOrang.trim().isEmpty()) {
            mContract.showMessage("Jumlah orang Tidak boleh kosong!");
            return;
        } else {
            try{
                if(Integer.parseInt(jmlOrang) <= 0){
                    mContract.showMessage("Jumlah orang harus lebih dari 0");
                    return;
                }
            } catch(NumberFormatException e){
                mContract.showMessage("Jumlah orang hanya bisa angka! \nerror : " + e.getMessage());
                return;
            }
        
        }
        
        
        ResultModel result = mModel.postData(nama, noTelp, jmlOrang, jenisPaket, idStudio);
        mContract.showMessage(result.getMessage());
        if(result.isSuccess()){
            mContract.onSuccessPostData();
        }
    }
    
    public void updateData(String id, String nama, String noTelp, String jmlOrang, String jenisPaket, String idStudio) {
        if(nama.trim().isEmpty()){
            mContract.showMessage("Nama Tidak boleh kosong!");
            return;
        } else if (noTelp.trim().isEmpty()) {
            mContract.showMessage("Nomor Telp Tidak boleh kosong!");
            return;
        } else if (jenisPaket.trim().isEmpty()) {
            mContract.showMessage("Harap pilih jenis paket!");
            return;
        } else if (idStudio.trim().isEmpty()) {
            mContract.showMessage("Harap pilih studio!");
            return;
        }
        
        
        if (jmlOrang.trim().isEmpty()) {
            mContract.showMessage("Jumlah orang Tidak boleh kosong!");
            return;
        } else {
            try{
                if(Integer.parseInt(jmlOrang) <= 0){
                    mContract.showMessage("Jumlah orang harus lebih dari 0");
                    return;
                }
            } catch(NumberFormatException e){
                mContract.showMessage("Jumlah orang hanya bisa angka! \nerror : " + e.getMessage());
                return;
            }
        
        }
        
        
        ResultModel result = mModel.updateData(id, nama, noTelp, jmlOrang, jenisPaket, idStudio);
        mContract.showMessage(result.getMessage());
        if(result.isSuccess()){
            mContract.onSuccessPostData();
        }
    }

    public int getHarga(String jenisPaket) {
        return mModel.getHarga(jenisPaket);
    }
    
    public interface AddTrasactionContract extends BaseContract{
        public void onSuccessPostData();
    }
    
}
