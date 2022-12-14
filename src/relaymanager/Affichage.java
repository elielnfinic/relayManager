/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relaymanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
/**
 *
 * @author monordi
 */
public class Affichage extends javax.swing.JFrame {
    private SerialTest leSerialTest;
    private boolean etat = false;
    private Timer notreTps;
    /**
     * Creates new form Affichage
     */
    
    private void direBonjour(){
        System.out.println("Dire bonjour");
    }
    
    public Affichage() {
        initComponents();
        cacherBtn();
        leSerialTest = new SerialTest();
        leSerialTest.initialize();
        
        ActionListener tache_timer;
        
        tache_timer = new ActionListener(){
            public void actionPerformed(ActionEvent e1){
               //System.out.println("Boucle");
               etat = leSerialTest.etat;
               if(etat == true){
                   txtAafficher.setText("There is light");
                   montrerBtn();
               }else{
                   cacherBtn();
                   txtAafficher.setText("There is no light");
               }
            }
        };
        
        notreTps = new Timer(1000,tache_timer);
        notreTps.start();
        
    }
    
    private void cacherBtn(){
        btnPowerOn.setVisible(false);
        btnPowerOff.setVisible(false);
    }
    
    private void montrerBtn(){
        btnPowerOn.setVisible(true);
        btnPowerOff.setVisible(true);
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
        btnPowerOn = new javax.swing.JButton();
        btnPowerOff = new javax.swing.JButton();
        txtAafficher = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPowerOn.setBackground(new java.awt.Color(13, 21, 243));
        btnPowerOn.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnPowerOn.setForeground(new java.awt.Color(251, 237, 237));
        btnPowerOn.setText("Power on");
        btnPowerOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowerOnActionPerformed(evt);
            }
        });

        btnPowerOff.setBackground(new java.awt.Color(250, 12, 41));
        btnPowerOff.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnPowerOff.setForeground(new java.awt.Color(238, 238, 238));
        btnPowerOff.setText("Power off");
        btnPowerOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowerOffActionPerformed(evt);
            }
        });

        txtAafficher.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtAafficher.setText("THERE IS NO LIGHT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtAafficher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPowerOn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnPowerOff, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPowerOn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPowerOff, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(txtAafficher, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPowerOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerOnActionPerformed
        try {
            // TODO add your handling code here:
            leSerialTest.allumer();
        } catch (IOException ex) {
            Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPowerOnActionPerformed

    private void btnPowerOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerOffActionPerformed
        try {
            // TODO add your handling code here:
            leSerialTest.eteindre();
        } catch (IOException ex) {
            Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPowerOffActionPerformed

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
            java.util.logging.Logger.getLogger(Affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Affichage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPowerOff;
    private javax.swing.JButton btnPowerOn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtAafficher;
    // End of variables declaration//GEN-END:variables
}
