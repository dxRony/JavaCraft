/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package olc1_vj24_3363565520917.frontend;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import olc1_vj24_3363565520917.backend.Archivo;

/**
 *
 * @author romar
 */
public class Interfaz extends javax.swing.JFrame {

    private Archivo archivo;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        archivo = new Archivo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFrame = new javax.swing.JPanel();
        lblEntrada = new javax.swing.JLabel();
        pnlEntrada = new javax.swing.JTabbedPane();
        lblConsola = new javax.swing.JLabel();
        pnlConsola = new javax.swing.JScrollPane();
        txtAreaConsola = new javax.swing.JTextArea();
        btnEjecutar = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        btnNuevoArchivo = new javax.swing.JMenuItem();
        btnAbrirArchivo = new javax.swing.JMenuItem();
        btnGuardarArchivo = new javax.swing.JMenuItem();
        menuPestanias = new javax.swing.JMenu();
        btnEliminarPestania = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        btnTablaErrores = new javax.swing.JMenuItem();
        btnTablaSimbolos = new javax.swing.JMenuItem();
        btnAST = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(102, 102, 0));
        pnlFrame.setLayout(null);

        lblEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(0, 255, 204));
        lblEntrada.setText("Entrada");
        pnlFrame.add(lblEntrada);
        lblEntrada.setBounds(30, 20, 70, 43);
        pnlFrame.add(pnlEntrada);
        pnlEntrada.setBounds(30, 60, 1250, 460);

        lblConsola.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblConsola.setForeground(new java.awt.Color(0, 255, 204));
        lblConsola.setText("Consola");
        pnlFrame.add(lblConsola);
        lblConsola.setBounds(30, 530, 80, 40);

        txtAreaConsola.setEditable(false);
        txtAreaConsola.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaConsola.setColumns(20);
        txtAreaConsola.setForeground(new java.awt.Color(255, 255, 255));
        txtAreaConsola.setRows(5);
        pnlConsola.setViewportView(txtAreaConsola);

        pnlFrame.add(pnlConsola);
        pnlConsola.setBounds(30, 580, 1250, 330);

        btnEjecutar.setBackground(new java.awt.Color(153, 51, 0));
        btnEjecutar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnEjecutar);
        btnEjecutar.setBounds(1145, 13, 120, 50);

        menuArchivo.setText("Archivo");

        btnNuevoArchivo.setText("Nuevo archivo");
        btnNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(btnNuevoArchivo);

        btnAbrirArchivo.setText("Abrir archivo");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(btnAbrirArchivo);

        btnGuardarArchivo.setText("Guardar archivo");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(btnGuardarArchivo);

        barraMenu.add(menuArchivo);

        menuPestanias.setText("Pestanias");

        btnEliminarPestania.setText("Eliminar pestania");
        btnEliminarPestania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPestaniaActionPerformed(evt);
            }
        });
        menuPestanias.add(btnEliminarPestania);

        barraMenu.add(menuPestanias);

        menuReportes.setText("Reportes");

        btnTablaErrores.setText("Tabla de errores");
        btnTablaErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaErroresActionPerformed(evt);
            }
        });
        menuReportes.add(btnTablaErrores);

        btnTablaSimbolos.setText("Tabla de simbolos");
        btnTablaSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaSimbolosActionPerformed(evt);
            }
        });
        menuReportes.add(btnTablaSimbolos);

        btnAST.setText("AST");
        btnAST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnASTActionPerformed(evt);
            }
        });
        menuReportes.add(btnAST);

        barraMenu.add(menuReportes);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 1351, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArchivoActionPerformed
        // TODO add your handling code here:
        archivo.nuevoArchivo(pnlEntrada);
    }//GEN-LAST:event_btnNuevoArchivoActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        // TODO add your handling code here:
        archivo.abrirArchivo(pnlEntrada);
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        // TODO add your handling code here:
        archivo.guardarArchivo(pnlEntrada);
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnEliminarPestaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPestaniaActionPerformed
        // TODO add your handling code here:
        archivo.eliminarPestania(pnlEntrada);
    }//GEN-LAST:event_btnEliminarPestaniaActionPerformed

    private void btnTablaErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaErroresActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Column1");
        model.addColumn("Column2");
        model.addColumn("Column3");

        JTable tablaErrores = new JTable(model);
        JScrollPane sP = new JScrollPane(tablaErrores);

        JFrame frameErrores = new JFrame("Tabla de Errores");
        frameErrores.setLayout(new BorderLayout());
        frameErrores.add(sP, BorderLayout.CENTER);
        frameErrores.pack();
        frameErrores.setVisible(true);
        frameErrores.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }//GEN-LAST:event_btnTablaErroresActionPerformed

    private void btnTablaSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaSimbolosActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Column1");
        model.addColumn("Column2");
        model.addColumn("Column3");

        JTable tablaErrores = new JTable(model);
        JScrollPane sP = new JScrollPane(tablaErrores);

        JFrame frameErrores = new JFrame("Tabla de Simbolos");
        frameErrores.setLayout(new BorderLayout());
        frameErrores.add(sP, BorderLayout.CENTER);
        frameErrores.pack();
        frameErrores.setVisible(true);
        frameErrores.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }//GEN-LAST:event_btnTablaSimbolosActionPerformed

    private void btnASTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnASTActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEjecutarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem btnAST;
    private javax.swing.JMenuItem btnAbrirArchivo;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JMenuItem btnEliminarPestania;
    private javax.swing.JMenuItem btnGuardarArchivo;
    private javax.swing.JMenuItem btnNuevoArchivo;
    private javax.swing.JMenuItem btnTablaErrores;
    private javax.swing.JMenuItem btnTablaSimbolos;
    private javax.swing.JLabel lblConsola;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuPestanias;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JScrollPane pnlConsola;
    private javax.swing.JTabbedPane pnlEntrada;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JTextArea txtAreaConsola;
    // End of variables declaration//GEN-END:variables
}
