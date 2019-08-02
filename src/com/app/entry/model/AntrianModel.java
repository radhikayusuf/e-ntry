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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhikayusuf
 */
public class AntrianModel extends BaseModel {
    
    public AntrianModel() {
        super("t_antrian");
    }

    
    public HashMap<String, String> getAntrian(){
        try {
            String sql = "SELECT `nama_studio` as `Nomor Studio`, `no_antrian` as `Nomor Antrian` FROM tb_antrian INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio WHERE tb_antrian.is_done = 0 ORDER BY tb_studio.id_studio;";
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();            
            ResultSet set = stm.executeQuery(sql);           
            HashMap<String, String> result = new HashMap<>();                        
            while(set.next()){
                result.put(set.getString(1), set.getString(2)); 
            }
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AntrianModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
