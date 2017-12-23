/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import static InterfazGrafica.InsertarGramatica.reiniciarJTable;
import static cyk.CYK.algoritmoCYK;
import static cyk.CYK.inicializarMatriz;
import static cyk.CYK.mostrarMatriz;
import static cyk.CYK.algoritmoCYK_IG;
import cyk.Gramatica;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author juanka1995
 */
public class AlgoritmoCYK extends javax.swing.JFrame {
    InsertarGramatica insertarGR;
    MyRender miRender;
    Gramatica miGramatica = new Gramatica();
    DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<ArrayList<String>> miMatriz = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<String>>> vectorMatrices = new ArrayList<>();
    ArrayList<ArrayList<Integer>> matrizIndices  = new ArrayList<>();
    String palabra = new String();
    boolean pertenece;
    int indiceVectorMatrices;
    int i1, j1;
    int i2, j2;
    int ires, jres;
    
    
    /**
     * Creates new form AlgoritmoCYK
     */
    public AlgoritmoCYK() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public AlgoritmoCYK(Gramatica unaGramatica, InsertarGramatica insertarGram){
        initComponents();
        this.setLocationRelativeTo(null);
        miGramatica = unaGramatica;
        pertenece = false;
        jLpertenece.setVisible(false);
        jTFpalabra.requestFocus();
        insertarGR = insertarGram;
        jTable.setRowSelectionAllowed(false);
        jTable.setColumnSelectionAllowed(false);
    }
    
    public void inicializarTabla(){
        String[] titulo = new String[miMatriz.size()];
        for (int i = 0; i < miMatriz.size(); i++) {
            titulo[i] = Character.toString(palabra.charAt(i));
        }
        dtm.setColumnIdentifiers(titulo);
        jTable.setModel(dtm);
    }
    
    public void limpiarTabla(){
            dtm.setRowCount(0);
            dtm.setColumnCount(0);
            jTable.setModel(dtm);
    }
    
    public static void reiniciarJTable(javax.swing.JTable table){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
    }
    
    public void mostrarMatrizTabla(ArrayList<ArrayList<String>> miMatriz){
        reiniciarJTable(jTable);
        
        for (int i=0; i < miMatriz.size();i++){
            Object aux[] = new String[miMatriz.get(i).size()];
            for (int j=0; j < miMatriz.get(i).size(); j++){
                
                String unChat= miMatriz.get(i).get(j);
                if(unChat == null)
                    aux[j] = "null";
                else
                    aux[j] = unChat;
            }
            dtm.addRow(aux);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBaccept = new javax.swing.JButton();
        jTFpalabra = new javax.swing.JTextField();
        jBclear = new javax.swing.JButton();
        jBpreviousStep = new javax.swing.JButton();
        jBnextStep = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBresolve = new javax.swing.JButton();
        jBchangeGramatic = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLpertenece = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo CYK");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 10)); // NOI18N
        jLabel2.setText("Inserta palabra:");

        jBaccept.setText("Aceptar");
        jBaccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBacceptActionPerformed(evt);
            }
        });

        jBclear.setText("Limpiar");
        jBclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclearActionPerformed(evt);
            }
        });

        jBpreviousStep.setText("Previous step...");
        jBpreviousStep.setEnabled(false);
        jBpreviousStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpreviousStepActionPerformed(evt);
            }
        });

        jBnextStep.setText("Next step...");
        jBnextStep.setEnabled(false);
        jBnextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnextStepActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 10)); // NOI18N
        jLabel3.setText("Paso a paso:");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 10)); // NOI18N
        jLabel4.setText("Resolver:");

        jBresolve.setText("Resolver");
        jBresolve.setEnabled(false);
        jBresolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresolveActionPerformed(evt);
            }
        });

        jBchangeGramatic.setText("Cambiar gramática...");
        jBchangeGramatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBchangeGramaticActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFpalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBaccept, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBresolve, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBchangeGramatic)
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBpreviousStep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBnextStep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBchangeGramatic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBaccept)
                    .addComponent(jTFpalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jBclear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBpreviousStep)
                    .addComponent(jBnextStep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(jBresolve, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setText("TABLA ALGORITMO CYK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Images/rsz_logo_ugr.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLpertenece.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLpertenece.setForeground(new java.awt.Color(37, 135, 2));
        jLpertenece.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLpertenece.setText("asd");
        jLpertenece.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLpertenece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLpertenece)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBacceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBacceptActionPerformed
        if(!jTFpalabra.getText().isEmpty()){
            // Activamos botones
            jBpreviousStep.setEnabled(false);
            jBnextStep.setEnabled(true);
            jBresolve.setEnabled(true);
            jLpertenece.setVisible(false);
            
            indiceVectorMatrices = 0;
            
            // Reseteamos si la palabra pertenece
            pertenece = false;
            
            // Obtenemos la palabra
            palabra = jTFpalabra.getText();
            
            // Color tabla
            miRender = new MyRender(palabra);
            jTable.setDefaultRenderer(Object.class, miRender);
            
            // Limpiamos la tabla
            limpiarTabla();
            
            // Cálculo del algoritmo
            miMatriz.clear();
            inicializarMatriz(miMatriz, palabra);
            vectorMatrices.clear();
            matrizIndices.clear();
            pertenece = algoritmoCYK_IG(miMatriz, palabra,miGramatica,vectorMatrices,matrizIndices);
            inicializarTabla();
                       
            mostrarMatrizTabla(vectorMatrices.get(indiceVectorMatrices));
            
            setIndicesToRender(0);
        }
    }//GEN-LAST:event_jBacceptActionPerformed

    private void setIndicesToRender(int i){
        i1 = matrizIndices.get(i).get(0);
        j1 = matrizIndices.get(i).get(1);

        i2 = matrizIndices.get(i).get(2);
        j2 = matrizIndices.get(i).get(3);

        ires = matrizIndices.get(i).get(4);
        jres = matrizIndices.get(i).get(5);
        
        miRender.setIndices(i1,j1,i2,j2,ires,jres);
    }
    
    private void jBclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclearActionPerformed
        limpiarTabla();
        pertenece = false;
        jBpreviousStep.setEnabled(false);
        jBnextStep.setEnabled(false);
        jBresolve.setEnabled(false);
        jTFpalabra.setText("");
        jLpertenece.setVisible(false);
        jTFpalabra.requestFocus();
    }//GEN-LAST:event_jBclearActionPerformed

    private void jBnextStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnextStepActionPerformed
        if(indiceVectorMatrices < vectorMatrices.size()){
            indiceVectorMatrices++;
            mostrarMatrizTabla(vectorMatrices.get(indiceVectorMatrices));
            setIndicesToRender(indiceVectorMatrices);
            jTable.repaint();
            jBpreviousStep.setEnabled(true);
            if(indiceVectorMatrices == vectorMatrices.size()-1){
                jBnextStep.setEnabled(false);
                if(pertenece){
                    jLpertenece.setText("La palabra " +palabra+ " SI PUEDE ser generada por la grámatica.");
                    jLpertenece.setForeground(new Color(37,135,2));
                    jLpertenece.setVisible(true);
                }
                else{
                    jLpertenece.setText("La palabra " +palabra+ " NO PUEDE ser generada por la grámatica.");
                    jLpertenece.setForeground(Color.red);
                    jLpertenece.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jBnextStepActionPerformed

    private void jBpreviousStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpreviousStepActionPerformed
        if(indiceVectorMatrices > 0){
            indiceVectorMatrices--;
            mostrarMatrizTabla(vectorMatrices.get(indiceVectorMatrices));
            setIndicesToRender(indiceVectorMatrices);
            jTable.repaint();
            jBnextStep.setEnabled(true);
            if(indiceVectorMatrices == 0){
                jBpreviousStep.setEnabled(false);
            }
            jLpertenece.setVisible(false);
        }
    }//GEN-LAST:event_jBpreviousStepActionPerformed

    private void jBresolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresolveActionPerformed
        indiceVectorMatrices = vectorMatrices.size()-1;
        jBnextStep.setEnabled(false);
        jBpreviousStep.setEnabled(true);
        mostrarMatrizTabla(vectorMatrices.get(indiceVectorMatrices));
        setIndicesToRender(indiceVectorMatrices);
        if(pertenece){
            jLpertenece.setText("La palabra " +palabra+ " SI PUEDE ser generada por la grámatica.");
            jLpertenece.setForeground(new Color(37,135,2));
            jLpertenece.setVisible(true);
        }
        else{
            jLpertenece.setText("La palabra " +palabra+ " NO PUEDE ser generada por la grámatica.");
            jLpertenece.setForeground(Color.red);
            jLpertenece.setVisible(true);
        }
    }//GEN-LAST:event_jBresolveActionPerformed

    private void jBchangeGramaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBchangeGramaticActionPerformed
        this.setVisible(false);
        insertarGR.setVisible(true);
    }//GEN-LAST:event_jBchangeGramaticActionPerformed

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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlgoritmoCYK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlgoritmoCYK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlgoritmoCYK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlgoritmoCYK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlgoritmoCYK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBaccept;
    private javax.swing.JButton jBchangeGramatic;
    private javax.swing.JButton jBclear;
    private javax.swing.JButton jBnextStep;
    private javax.swing.JButton jBpreviousStep;
    private javax.swing.JButton jBresolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLpertenece;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFpalabra;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
