/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.model;

import com.app.entry.EntryApplication;
import com.app.entry.utils.base.BaseModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhikayusuf
 */
public class KasirLoginModel extends BaseModel {
    
    public KasirLoginModel() {
        super("tb_kasir");
    }
    
    public boolean doLogin(String username, String password){            
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE username ='" + username + "' AND password = md5('" + password + "')";            
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet res = stm.executeQuery(sql);
            int count = 0;
            while(res.next()){
                EntryApplication.ID_KASIR = Integer.valueOf(res.getString("id_kasir"));
                count++;
            }
            
            return count != 0;
        } catch (SQLException ex) {
            Logger.getLogger(KasirLoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
