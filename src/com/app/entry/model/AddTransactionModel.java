/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.model;

import com.app.entry.EntryApplication;
import com.app.entry.utils.ResultModel;
import com.app.entry.utils.base.BaseModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhikayusuf
 */
public class AddTransactionModel extends BaseModel {
    
    public AddTransactionModel() {
        super("tb_transaksi");
    }        
    
    
    public int getHarga(String jenisPaket){
        try {
            String sql = "SELECT getPrice('"+jenisPaket+"');";              
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();                                  
            ResultSet res = stm.executeQuery(sql);
            int harga = 0;
            while(res.next()){
                harga += res.getInt(1);
            }
            return harga;
        } catch (SQLException ex) {
            Logger.getLogger(AntrianModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
    public ResultModel postData(String nama, String noTelp, String jmlOrang, String jenisPaket, String idStudio){
        try {
            String sql = "CALL createTransaction('"+nama+"', '"+noTelp+"', '"+jenisPaket+"', "+idStudio+", "+EntryApplication.ID_KASIR+", "+jmlOrang+");";            
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();                                  
            stm.executeQuery(sql);
            return new ResultModel("Sukses Menambah data", true);
        } catch (SQLException ex) {
            Logger.getLogger(AntrianModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ResultModel("Failed : " + ex.getMessage(), false);
        }
    }
    
    
    public ResultModel updateData(String id, String nama, String noTelp, String jmlOrang, String jenisPaket, String idStudio){
        try {
            String sql = "CALL updateTransaction("+id+", '"+nama+"', '"+noTelp+"', '"+jenisPaket+"', "+idStudio+", "+EntryApplication.ID_KASIR+", "+jmlOrang+");";            
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();                                  
            stm.executeQuery(sql);
            return new ResultModel("Sukses, data telah di ubah", true);
        } catch (SQLException ex) {
            Logger.getLogger(AntrianModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ResultModel("Failed : " + ex.getMessage(), false);
        }
    }
    
    
    
}
