/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.ingesis.suturno.desktop.principal;

import co.edu.uniquindio.ingesis.suturno.desktop.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.desktop.tablemodels.ServicioTableModel;

/**
 *
 * @author gusta
 */
public class ServicioUI extends javax.swing.JPanel {

    /**
     * Creates new form EmpleadoUI
     */
    public ServicioUI() {
        initComponents();
        actualizarJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        bCrear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar32.png"))); // NOI18N
        bCrear.setText("Crear");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });
        add(bCrear);
        bCrear.setBounds(12, 11, 130, 42);

        tabla.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1);
        jScrollPane1.setBounds(12, 99, 752, 360);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Servicios");
        add(jLabel1);
        jLabel1.setBounds(260, 60, 340, 24);
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        ServicioModalUI modal = new ServicioModalUI();        
        modal.setVisible(true);
    }//GEN-LAST:event_bCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void actualizarJTable() {
       ServicioTableModel servicioTableModel = new ServicioTableModel(ServicioDelegate.getInstancia().listarServicios());
       tabla.setModel(servicioTableModel);       
    }
}