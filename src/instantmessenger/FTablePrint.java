/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instantmessenger;

import static instantmessenger.InstantMessenger.database;
import java.io.PrintStream;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Saketh
 */
public class FTablePrint extends javax.swing.JFrame {

    /**
     * Creates new form FTablePrint
     */
    PrintStream outOrg = System.out;
    public FTablePrint() {
        initComponents();
        this.getRootPane().setDefaultButton(btnConnect);
    }
    FLogin login;
    FChat chat;
    public void getFrames(FLogin L, FChat C){
        this.login = L;
        this.chat = C;
    }
    
    
    public void displayFrnds(){
        try {
            database.getFriendsList();
            ResultSetMetaData met = database.resultSet.getMetaData();
            int numberOfColumns = met.getColumnCount();
            
            
            PrintStream printStream = new PrintStream(new CustomOutputStream(txtArea));
            System.setOut(printStream);
            System.setErr(printStream);
            try {
                database.getFriendsList();
                database.resultSet.beforeFirst();
                
                while(database.resultSet.next()){
                    for(int i=1;i<=numberOfColumns;i++)
                        System.out.printf("%-8s\t", database.resultSet.getObject(i));
                    System.out.println();
                }
                
                System.setOut(this.outOrg);
                //txtFrnd.requestFocus();
            }
            catch (SQLException ex) {
                //Logger.getLogger(FTablePrint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (SQLException ex)
        {  //         Logger.getLogger(FTablePrint.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(FTablePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtFrnd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(334, 460));
        setResizable(false);

        txtArea.setEditable(false);
        txtArea.setBackground(new java.awt.Color(250, 250, 250));
        txtArea.setColumns(20);
        txtArea.setForeground(new java.awt.Color(250, 250, 250));
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        txtArea.setFocusable(false);
        txtArea.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(txtArea);

        jLabel1.setText("type in the friend's name");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrnd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConnect)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFrnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConnect)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if((!txtFrnd.getText().equals(""))){
            try {
                String frnIP = database.getFrndIp(txtFrnd.getText());
<<<<<<< HEAD
                switch(chat.getFriend(frnIP, txtFrnd.getText())){
                    case "yes":
                        chat.setVisible(true);
                        this.setVisible(false);
                        break;
                    case "no":
                        JOptionPane.showMessageDialog(this, "Not Available!");
                        break;
                    default:
                        txtFrnd.setText("");
                }
                
                
                
=======
                if(chat.getFriend(frnIP, txtFrnd.getText())){
                    chat.setVisible(true);
                    this.setVisible(false);
                }
>>>>>>> parent of 1cfa725... Ate Caret
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "User doesn't exist");
            }
        }
    }//GEN-LAST:event_btnConnectActionPerformed

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
            java.util.logging.Logger.getLogger(FTablePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTablePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTablePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTablePrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTablePrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtFrnd;
    // End of variables declaration//GEN-END:variables
}