package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @authors Connor, Dalton, Chris
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
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

        jLabel1.setText("Generation Number: 1");
        add(jLabel1);
        jLabel1.setBounds(240, 40, 160, 15);

        jLabel2.setText("Fittest Individual Score:");
        add(jLabel2);
        jLabel2.setBounds(240, 70, 280, 15);

        jLabel3.setText("2nd Fittest Individual Score:");
        add(jLabel3);
        jLabel3.setBounds(240, 90, 310, 15);
    }// </editor-fold>//GEN-END:initComponents

    private void go_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_buttonActionPerformed
        theController.toggleRunning();
    }//GEN-LAST:event_go_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //theController.toggleNG();
        //theController.repaint();
        //theController.endLife();
        theController.draw=false;
        theController.speed=1;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        theController.goalX=x-theController.goal.getH()/2;
        theController.goalY=y-theController.goal.getH()/2;
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton go_button;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
