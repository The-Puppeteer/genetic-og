package Genetic_Algorithms;

import java.awt.Graphics;

/**
 *
 * @author Connor McGuigan
 */
public class Genetic_Panel extends javax.swing.JPanel {

    Controller theController;
    
    public Genetic_Panel() {
        initComponents();
        theController = new Controller(this, new Individuals(300, 200, 3, 30, 30));
        theController.start();
        setLayout(null);
        setVisible(true);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        theController.paint(g);
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
