/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author trav1
 */
public class Dialog extends javax.swing.JFrame {

    /**
     * Creates new form Dialog
     */
    public Dialog() {
        initComponents();
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Courant");
        jComboBox1.addItem("Epargne");
        Object[][] data={{"ha","e"},{"g","b"}};
            String[] titre={"nom","pre"};
            //jTable1=new JTable(data,titre);
            //JTable tab=new JTable(data,titre);
            //this.getContentPane().add(new JScrollPane(tab));
           /* jTable1.setVisible(true);
            jScrollPane1.setVisible(true);
           jTable1.removeAll();*/
         // jTable1.
          // System.out.println(jTable1.getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 110, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int p=jComboBox1.getSelectedIndex();
        System.out.println(p);
        //int t=jTextField1.g
        String solde1="233.12";
        double solde=0.,puis;
        boolean v=false;
        int compteur_avant_vir=0,comp_apres_vir=0,ind=-1,i=0,ind_vir=0;
         char[] c=solde1.toCharArray();
        for (char c1 : c){
            i++;
            if (c1=='.') {
                v=true;
                ind=i;
            }
            if (v==false){
                compteur_avant_vir++;
            }
            else {
                comp_apres_vir++;
            }
        }
        i=0;
        int cc=-1;
        compteur_avant_vir--;
        for (char c1:c){
            i++;
          if (ind!=-1){
            if (i<ind && ind!=-1){
                if (c1=='0') cc=0;
                if (c1=='1') cc=1;
                if(c1=='2') cc=2;
                if (c1=='3') cc=3;
                if (c1=='4') cc=4;
                if (c1=='5') cc=5;
                if(c1=='6') cc=6;
                if (c1=='7') cc=7;
                if (c1=='8') cc=8;
                if (c1=='9') cc=9;
               if (cc!=-1) {
                   puis=Math.pow(10,compteur_avant_vir);
                   solde+=cc*puis;
                   System.out.println("oui");
                   compteur_avant_vir--;
               }
            }
            
            if (i>ind && ind!=-1){
                ind_vir++;
                if (c1=='0') cc=0;
                if (c1=='1') cc=1;
                if(c1=='2') cc=2;
                if (c1=='3') cc=3;
                if (c1=='4') cc=4;
                if (c1=='5') cc=5;
                if(c1=='6') cc=6;
                if (c1=='7') cc=7;
                if (c1=='8') cc=8;
                if (c1=='9') cc=9;
               if (cc!=-1) {
                   puis=Math.pow(10,-(comp_apres_vir-(comp_apres_vir-ind_vir)));
                   solde+=cc*puis;
                   comp_apres_vir--;
               }
        }
          }
          if (ind==-1){
              if (c1=='0') cc=0;
                if (c1=='1') cc=1;
                if(c1=='2') cc=2;
                if (c1=='3') cc=3;
                if (c1=='4') cc=4;
                if (c1=='5') cc=5;
                if(c1=='6') cc=6;
                if (c1=='7') cc=7;
                if (c1=='8') cc=8;
                if (c1=='9') cc=9;
               if (cc!=-1) {
                   System.out.println(cc);
                   puis=Math.pow(10,compteur_avant_vir);
                   solde+=cc*puis;
                   System.out.println("ouiiiiiiii   "+solde+",,,,"+puis+"    "+compteur_avant_vir);
                   compteur_avant_vir--;
               }
          }
            System.out.println(solde);
            
            
            
            
        }
    
    
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}