/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.controller;

import com.app.entry.controller.ManageAntrianController.ManageAntrianContract;
import com.app.entry.model.ManageAntrianModel;
import com.app.entry.utils.ResultModel;
import com.app.entry.utils.base.BaseContract;
import com.app.entry.utils.base.BaseController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radhikayusuf
 */
public class ManageAntrianController extends BaseController<ManageAntrianContract>{

    ManageAntrianModel mModel = new ManageAntrianModel();
        String[] fieldName = new String[]{"tb_user.nama_user", "tb_studio.nama_studio", "tb_antrian.no_antrian", "tb_transaksi.jenis_paket"};
    
    public ManageAntrianController(ManageAntrianContract contract) {
        super(contract);
    }   

    public List<String[]> getDataStudio(){
        return mModel.getStudio();
    }   
    
    public List<Object[]> getDataAntrian(String idStudio, String latestId) {
        return mModel.getDataQueue(idStudio, latestId, "", "");
    }
    
    public List<Object[]> searchDataAntrian(String idStudio, String latestId, String query, int fieldPosition) {
        return mModel.getDataQueue(idStudio, latestId, query, fieldName[fieldPosition]);
    }
    
    public String[] getStatusAntrian(String idAntrian){
        return mModel.getStatusAntrian(idAntrian);
    }

    public void startQueue(String queueId) {
        ResultModel result = mModel.startOrEndQueue(queueId, true);
        mContract.showMessage(result.getMessage());
    }

    public void stopQueue(String queueId) {
        ResultModel result = mModel.startOrEndQueue(queueId, false);
        mContract.showMessage(result.getMessage());
    }
    
    public interface ManageAntrianContract extends BaseContract{
        
        
    }
}
