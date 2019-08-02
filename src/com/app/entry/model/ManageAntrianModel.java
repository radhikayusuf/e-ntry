/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.model;

import com.app.entry.utils.ResultModel;
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
public class ManageAntrianModel extends BaseModel{
    
    public ManageAntrianModel() {
        super("tb_antrian");
    }
    
    public List<Object[]> getDataQueue(String idAntrian, String latestId, String searchKey){
        List<Object[]> data = new ArrayList<>();
        try {
            String sql = "CALL listQueueByStudio("+idAntrian+", "+latestId+", '%"+searchKey+"%');";           

            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet res = stm.executeQuery(sql);
            int count = 1;
            while(res.next()){
                data.add(new Object[]{count++, res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            
            return data;
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotographerLoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public String[] getStatusAntrian(String idantrian){
               
        try {
            String sql =    "SELECT \n" +
                            "    `tb_antrian`.`id_antrian` as `ID`,\n" +
                            "    `tb_studio`.`nama_studio` as `Nama Studio`,\n" +
                            "    `tb_antrian`.`no_antrian` as `Nomor Antrian`,\n" +
                            "    `tb_transaksi`.`jenis_paket` as `Jenis Paket`, \n" +
                            "    `tb_antrian`.`waktu_mulai` as `Start`, \n" +
                            "    `tb_antrian`.`waktu_selesai` as `End` \n" +
                            "FROM tb_antrian \n" +
                            "INNER JOIN tb_studio ON tb_antrian.id_studio = tb_studio.id_studio\n" +
                            "INNER JOIN tb_transaksi ON tb_transaksi.id_transaksi = tb_antrian.id_transaksi\n" +
                            "WHERE tb_studio.id_studio = "+idantrian+"\n" +
                            "AND tb_antrian.is_done = 0\n" +
                            "ORDER BY tb_antrian.id_antrian ASC LIMIT 1;";

            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet res = stm.executeQuery(sql);           
            while(res.next()){
                return new String[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)};
            }
            
            return new String[]{};
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotographerLoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return new String[]{};
        }
        
      
    }

    public ResultModel startOrEndQueue(String idantrian, boolean start) {        
        try {
            String sql = start ? "CALL startQueue("+idantrian+");" : "CALL endQueue("+idantrian+");";

            java.sql.Connection conn = (Connection) mConnection;
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet res = stm.executeQuery(sql);            
            return new ResultModel("Berhasil " + (start ? "memulai" : "menyelesaikan") +" antrian", true);
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotographerLoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return new ResultModel("Gagal " + (start ? "memulai" : "menyelesaikan") +" antrian\nerror : " + ex.getMessage(), false);           
        }
    }
    
}
