package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Connor McGuigan
 */
public class Genetic_Panel extends javax.swing.JPanel {
    int indNum = 10;
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

        setLayout(null);

        go_button.setText("Go");
        go_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_buttonActionPerformed(evt);
            }
        });
        add(go_button);
        go_button.setBounds(40, 30, 45, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void go_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_buttonActionPerformed
        theController.toggleRunning();
    }//GEN-LAST:event_go_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton go_button;
    // End of variables declaration//GEN-END:variables
}
