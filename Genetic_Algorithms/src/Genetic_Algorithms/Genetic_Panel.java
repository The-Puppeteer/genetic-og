package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Connor, Dalton, Chris
 */
public class Genetic_Panel extends javax.swing.JPanel {
    int indNum = 50;
    Controller theController;
    Individuals individuals;
    public Genetic_Panel() {
        initComponents();
        theController = new Controller(this,indNum);
        theController.start();        
        setLayout(null);
        setVisible(true);
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i <indNum;++i){
        theController.paint(g,i);
        }
//        for(int i = 0; i <2;++i){
//        theController.individuals[i].paint(g);
//        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        go_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        go_button.setText("Go");
        go_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_buttonActionPerformed(evt);
            }
        });
        add(go_button);
        go_button.setBounds(40, 30, 50, 25);

        jButton1.setText("Next Generation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(100, 30, 130, 25);

        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(240, 40, 44, 15);
    }// </editor-fold>//GEN-END:initComponents

    private void go_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_buttonActionPerformed
        theController.toggleRunning();
    }//GEN-LAST:event_go_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        theController.toggleNG();
        theController.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton go_button;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
