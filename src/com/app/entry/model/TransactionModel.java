/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.model;

import com.app.entry.utils.base.BaseModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhikayusuf
 */
public class TransactionModel extends BaseModel {
    
    public TransactionModel() {
        super("tb_transaksi");
    }
    
    
    public List<Object[]> getDataTransaction(String searchKey){
        List<Object[]> data = new ArrayList<>();
        try {
            String sql = "CALL searchInTransaction('%"+searchKey+"%');";           

            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet res = stm.executeQuery(sql);
            int count = 1;
            while(res.next()){
                data.add(new Object[]{count++, res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            
            return data;
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotographerLoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
