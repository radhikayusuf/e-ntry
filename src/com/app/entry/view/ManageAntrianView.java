/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entry.view;

import com.app.entry.controller.ManageAntrianController;
import com.app.entry.utils.EntryButton;
import com.app.entry.utils.EntryButtonCallback;
import com.app.entry.utils.base.BaseView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author radhikayusuf
 */
public class ManageAntrianView extends BaseView<ManageAntrianController> implements ManageAntrianController.ManageAntrianContract, EntryButtonCallback {

    
    private String[] columnName = {"No", "Nama Studio", "Nama Customer", "Nomor Antrian", "Jenis Paket"};
    private int selectedRowPos = -1;
    private int indexHelper = 0;
    private String currentQueueId = "";
    private String studioId = "";
    private DefaultTableModel tableModel = new DefaultTableModel(0, 6){
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        
    };
    
    /**
     * Creates new form ManageAntrianView
     */
    public ManageAntrianView() {
        initComponents();   
        
        EntryButton.addClickEffect(buttonAction, "action", this);
        
        
        tableModel.setColumnIdentifiers(columnName);
        tableAntrian.setModel(tableModel);
        tableAntrian.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tableAntrian.rowAtPoint(e.getPoint());                
                if (row >= 0) {
                    selectedRowPos = row;
                }
            }
            
        });
        
        comboStudio.removeAllItems();
        for(String[] item : mController.getDataStudio()){
            comboStudio.addItem(item[1]);
        }
        
        loadData();
    }

    private void loadData() {        
        clearModel(tableModel);        
        studioId = mController.getDataStudio().get(comboStudio.getSelectedIndex())[0];
        
        labelProsesAntrian.setText("-");
        labelJenisPaket.setText("-");
        
        String[] result = mController.getStatusAntrian(studioId);
        buttonAction.setVisible(result.length > 0);
        buttonHome.setVisible(result.length > 0);
        
        if(result.length > 0){
            labelProsesAntrian.setText("Antrian dalam Proses : No." + result[2]);
            labelJenisPaket.setText(result[3]);

            currentQueueId = result[0];
            labelAction.setText(result[4] == null ? "MULAI" : "BERHENTI");


            mController.getDataAntrian(studioId, currentQueueId).forEach((data)-> {
                tableModel.addRow(data);              
            });
        } 
        
    }
    
    @Override
    public void showMessage(String message) {
        showPaneMessage(message);
    }
    
    @Override
    public ManageAntrianController createController() {
        return new ManageAntrianController(this);
    }
    
    
    @Override
    public void onClick(String name) {
        switch(name){
            case "action":
                if(labelAction.getText().equalsIgnoreCase("mulai") && !currentQueueId.isEmpty()){
                    mController.startQueue(currentQueueId);
                } else if(!currentQueueId.isEmpty()){
                    mController.stopQueue(currentQueueId);
                }
                loadData();
                break;
        }
    }

    @Override
    public void onReleased(String name) {
        
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
        labelStudio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelProsesAntrian = new javax.swing.JLabel();
        labelJenisPaket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAntrian = new javax.swing.JTable();
        comboStudio = new javax.swing.JComboBox<>();
        buttonHome = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buttonAction = new javax.swing.JPanel();
        labelAction = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelStudio.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelStudio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStudio.setText("STUDIO 1");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelProsesAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProsesAntrian.setText("Antrian dalam Proses: 12");

        labelJenisPaket.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelJenisPaket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJenisPaket.setText("CLASSIC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelJenisPaket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelProsesAntrian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labelProsesAntrian)
                .addGap(18, 18, 18)
                .addComponent(labelJenisPaket)
                .addGap(16, 16, 16))
        );

        tableAntrian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAntrian);

        comboStudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Studio 1", "Studio 2", "Studio 3" }));
        comboStudio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStudioItemStateChanged(evt);
            }
        });

        buttonHome.setBackground(new java.awt.Color(0, 0, 0));
        buttonHome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 0, 51)));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PANGGIL");

        javax.swing.GroupLayout buttonHomeLayout = new javax.swing.GroupLayout(buttonHome);
        buttonHome.setLayout(buttonHomeLayout);
        buttonHomeLayout.setHorizontalGroup(
            buttonHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        buttonHomeLayout.setVerticalGroup(
            buttonHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonHomeLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        buttonAction.setBackground(new java.awt.Color(0, 0, 0));
        buttonAction.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 0, 51)));

        labelAction.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        labelAction.setForeground(new java.awt.Color(255, 255, 255));
        labelAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAction.setText("MULAI");

        javax.swing.GroupLayout buttonActionLayout = new javax.swing.GroupLayout(buttonAction);
        buttonAction.setLayout(buttonActionLayout);
        buttonActionLayout.setHorizontalGroup(
            buttonActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        buttonActionLayout.setVerticalGroup(
            buttonActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonActionLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(labelAction)
                .addContainerGap())
        );

        btnBack.setText("< KEMBALI");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 4, true));

        searchBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel1.setText("Antrian Selanjutnya : ");

        jLabel2.setText("Antrian Yang sedang di proses : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(labelStudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, Short.MAX_VALUE))
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboStudio, 0, 135, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStudio)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboStudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        setVisible(false);
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        if(!studioId.isEmpty() && !currentQueueId.isEmpty()){
            clearModel(tableModel);
            mController.searchDataAntrian(studioId, currentQueueId, searchBar.getText()).forEach((data)-> {                
                tableModel.addRow(data);              
            });                        
        }
        
    }//GEN-LAST:event_searchBarKeyReleased

    private void comboStudioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStudioItemStateChanged
        if(comboStudio.getItemCount() > 0){
            labelStudio.setText(comboStudio.getSelectedItem().toString());
            loadData();
        }        
    }//GEN-LAST:event_comboStudioItemStateChanged

    
    private void clearModel(DefaultTableModel model){
        int count = tableModel.getRowCount();
        for(int i = 0; i < count ; i++){
            tableModel.removeRow(0);
        }
    }
    
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
            java.util.logging.Logger.getLogger(ManageAntrianView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAntrianView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAntrianView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAntrianView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAntrianView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JPanel buttonAction;
    private javax.swing.JPanel buttonHome;
    private javax.swing.JComboBox<String> comboStudio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JLabel labelJenisPaket;
    private javax.swing.JLabel labelProsesAntrian;
    private javax.swing.JLabel labelStudio;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTable tableAntrian;
    // End of variables declaration//GEN-END:variables

    
    
}
