/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.utils.base;

import com.app.entry.model.AntrianModel;
import com.app.entry.utils.ResultModel;
import com.app.entry.utils.database.ConnectionBuilder;
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
public abstract class BaseModel {
    
    protected Connection mConnection = ConnectionBuilder.with("root", "password", "db_entry").isDisableSsl(true).create();
    protected String tableName;
    
    public BaseModel(String tableName){
        this.tableName = tableName;
    }
        
    public ResultSet getData(){
        
        try {            
            String sql = "SELECT * FROM " + tableName;
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            return stm.executeQuery(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
        
    public Boolean insertData(HashMap<String, String> value){return false;}
    
    public Boolean updateData(String id, HashMap<String, String> value){return false;}
    
    public ResultModel deleteData(String field, String id){
        try {            
            String sql = "DELETE FROM " + tableName + " WHERE " + field + " = " + id +";";
            System.out.println(sql);
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            stm.executeUpdate(sql);            
            return new ResultModel("Success", true);
        } catch (SQLException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ResultModel("Failed : "+ ex.getMessage(), false);            
        }
    }
      
    public List<String[]> getStudio(){
        try {
            String sql = "SELECT `id_studio` as `id`, `nama_studio` as `Nama Studio`FROM tb_studio WHERE id_photographer IS NOT NULL;";
            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();            
            ResultSet set = stm.executeQuery(sql);           
            List<String[]> result = new ArrayList<>();                        
            while(set.next()){
                result.add(new String[]{set.getString(1), set.getString(2)});                
            }
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AntrianModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
