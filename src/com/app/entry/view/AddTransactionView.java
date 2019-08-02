/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.view;

import com.app.entry.controller.AddTransactionController;
import com.app.entry.utils.EntryButton;
import com.app.entry.utils.EntryButtonCallback;
import com.app.entry.utils.base.BaseView;
import javax.swing.JFrame;

/**
 *
 * @author yongkiagustin
 */
public class AddTransactionView extends BaseView<AddTransactionController> implements EntryButtonCallback, AddTransactionController.AddTrasactionContract {

    /**
     * Creates new form AddTransactionView
     */
    
    private TransactionView mParentView;
    private Object[] mData;
    private String transactionId;
    
    
    public AddTransactionView(TransactionView view, Object[] data){
        initComponents();
        mParentView = view;
        EntryButton.addClickEffect(buttonTambah, "tambah", this);
        
        mController.getDataStudio().forEach((datum)->{
            comboStudio.addItem(datum[1]);
        });
        mData = data;
        
        if(mData != null){
            transactionId = mData[1].toString();
            fieldNama.setText(mData[2].toString());
            comboJenisPaket.setSelectedItem(mData[3]);
            fieldNoTelp.setText(mData[4].toString());
            fieldJumlahOrang.setText(mData[5].toString());
            comboStudio.setSelectedItem(mData[7].toString());
            
            labelTitle.setText("UBAH DATA TRANSAKSI");
            labelButtonTambah.setText("UPDATE");
        }
        
        fieldHarga.setText(String.valueOf(mController.getHarga(comboJenisPaket.getSelectedItem().toString())));
    }
      
    
    private AddTransactionView() {
        initComponents();                 
    }

    
    @Override
    public void onClick(String name) {
        switch(name){
            case "tambah":
                if(transactionId == null)
                    mController.tambahData(fieldNama.getText(), fieldNoTelp.getText(), fieldJumlahOrang.getText(), comboJenisPaket.getSelectedItem().toString(), mController.getDataStudio().get(comboStudio.getSelectedIndex())[0]);
                else
                    mController.updateData(transactionId, fieldNama.getText(), fieldNoTelp.getText(), fieldJumlahOrang.getText(), comboJenisPaket.getSelectedItem().toString(), mController.getDataStudio().get(comboStudio.getSelectedIndex())[0]);
                break;
        }
    }

    @Override
    public void onReleased(String name) {

    }
    
    @Override
    public AddTransactionController createController() {
        return new AddTransactionController(this);
    }
    
    
    @Override
    public void showMessage(String message) {
        showPaneMessage(message);
    }
    
    @Override
    public void onSuccessPostData() {
        mParentView.loadData();
        this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fieldNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldNoTelp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldJumlahOrang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldHarga = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JPanel();
        labelButtonTambah = new javax.swing.JLabel();
        comboJenisPaket = new javax.swing.JComboBox<>();
        labelTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboStudio = new javax.swing.JComboBox<>();

        setTitle("TAMBAH TRANSAKSI");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        fieldNama.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel1.setText("Nama");

        jLabel2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel2.setText("No Telp");

        fieldNoTelp.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel3.setText("Jenis Paket");

        jLabel4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel4.setText("Jumlah Orang");

        fieldJumlahOrang.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel5.setText("Total Harga");

        fieldHarga.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        fieldHarga.setEnabled(false);

        buttonTambah.setBackground(new java.awt.Color(0, 0, 0));
        buttonTambah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 0, 51)));

        labelButtonTambah.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        labelButtonTambah.setForeground(new java.awt.Color(255, 255, 255));
        labelButtonTambah.setText("TAMBAH");

        javax.swing.GroupLayout buttonTambahLayout = new javax.swing.GroupLayout(buttonTambah);
        buttonTambah.setLayout(buttonTambahLayout);
        buttonTambahLayout.setHorizontalGroup(
            buttonTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonTambahLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(labelButtonTambah)
                .addGap(64, 64, 64))
        );
        buttonTambahLayout.setVerticalGroup(
            buttonTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonTambahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelButtonTambah)
                .addGap(9, 9, 9))
        );

        comboJenisPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLASSIC", "MINIMALIS", "GOLD", "PLATINUM" }));
        comboJenisPaket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboJenisPaketItemStateChanged(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("TAMBAH DATA TRANSAKSI");

        jLabel8.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel8.setText("Studio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboStudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldHarga)
                            .addComponent(fieldJumlahOrang)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboJenisPaket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelTitle)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboJenisPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldJumlahOrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(76, 76, 76)
                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboJenisPaketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboJenisPaketItemStateChanged
        fieldHarga.setText(String.valueOf(mController.getHarga(comboJenisPaket.getSelectedItem().toString())));
    }//GEN-LAST:event_comboJenisPaketItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTransactionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTransactionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonTambah;
    private javax.swing.JComboBox<String> comboJenisPaket;
    private javax.swing.JComboBox<String> comboStudio;
    private javax.swing.JTextField fieldHarga;
    private javax.swing.JTextField fieldJumlahOrang;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNoTelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelButtonTambah;
    private javax.swing.JLabel labelTitle;
    // End of variables declaration//GEN-END:variables
    
}
