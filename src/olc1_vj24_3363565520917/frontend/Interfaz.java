/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package olc1_vj24_3363565520917.frontend;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.Struct;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.analisis.parser;
import olc1_vj24_3363565520917.backend.analisis.scanner;
import olc1_vj24_3363565520917.backend.archivo.Archivo;
import olc1_vj24_3363565520917.backend.excepciones.Errores;
import olc1_vj24_3363565520917.backend.instrucciones.AsignacionStruct;
import olc1_vj24_3363565520917.backend.instrucciones.AsignacionVar;
import olc1_vj24_3363565520917.backend.instrucciones.AsignacionVector;
import olc1_vj24_3363565520917.backend.instrucciones.Declaracion;
import olc1_vj24_3363565520917.backend.instrucciones.DeclaracionList;
import olc1_vj24_3363565520917.backend.instrucciones.DeclaracionStruct;
import olc1_vj24_3363565520917.backend.instrucciones.DeclaracionVector;
import olc1_vj24_3363565520917.backend.instrucciones.InstanciaStruct;
import olc1_vj24_3363565520917.backend.instrucciones.Metodo;
import olc1_vj24_3363565520917.backend.instrucciones.StartWith;
import olc1_vj24_3363565520917.backend.simbolo.Arbol;
import olc1_vj24_3363565520917.backend.simbolo.Simbolo;
import olc1_vj24_3363565520917.backend.simbolo.tablaSimbolos;

/**
 *
 * @author romar
 */
public class Interfaz extends javax.swing.JFrame {

    private Archivo archivo;
    private LinkedList<Errores> listaErrores;
    private LinkedList<Simbolo> listaSimbolos;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        archivo = new Archivo();
        listaErrores = new LinkedList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        txtAreaConsola.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
                        .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 1351, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoArchivoActionPerformed
        // TODO add your handling code here:
        archivo.nuevoArchivo(pnlEntrada);
    }// GEN-LAST:event_btnNuevoArchivoActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAbrirArchivoActionPerformed
        // TODO add your handling code here:
        archivo.abrirArchivo(pnlEntrada);
    }// GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarArchivoActionPerformed
        // TODO add your handling code here:
        archivo.guardarArchivo(pnlEntrada);
    }// GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnEliminarPestaniaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarPestaniaActionPerformed
        // TODO add your handling code here:
        archivo.eliminarPestania(pnlEntrada);
    }// GEN-LAST:event_btnEliminarPestaniaActionPerformed

    private void btnTablaErroresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTablaErroresActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        int numero = 0;
        model.addColumn("#");
        model.addColumn("Tipo");
        model.addColumn("Descripcion");
        model.addColumn("Linea");
        model.addColumn("Columna");

        for (Errores error : listaErrores) {
            numero++;
            model.addRow(new Object[] { numero,
                    error.getTipo(),
                    error.getDescripcion(),
                    error.getLinea(),
                    error.getColumna() });
        }
        JTable tablaErrores = new JTable(model);
        JScrollPane sP = new JScrollPane(tablaErrores);
        JFrame frameErrores = new JFrame("Tabla de Errores");
        frameErrores.setLayout(new BorderLayout());
        frameErrores.add(sP, BorderLayout.CENTER);
        frameErrores.pack();
        frameErrores.setVisible(true);
        frameErrores.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }// GEN-LAST:event_btnTablaErroresActionPerformed

    private void btnTablaSimbolosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTablaSimbolosActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        int numero = 0;
        model.addColumn("#");
        model.addColumn("Id");
        model.addColumn("Tipo");
        model.addColumn("Tipo");
        model.addColumn("Entorno");
        model.addColumn("Valor");
        model.addColumn("Linea");
        model.addColumn("Columna");

        for (Simbolo simbolo : listaSimbolos) {
            numero++;
            model.addRow(new Object[] {
                    numero,
                    simbolo.getId(),
                    simbolo.getTipo2(),
                    simbolo.getTipo().getTipo(),
                    simbolo.getEntorno(),
                    simbolo.getValor(),
                    simbolo.getLinea(),
                    simbolo.getColumna() });
        }

        JTable tablaSimbolos = new JTable(model);
        JScrollPane sP = new JScrollPane(tablaSimbolos);

        JFrame frameErrores = new JFrame("Tabla de Simbolos");
        frameErrores.setLayout(new BorderLayout());
        frameErrores.add(sP, BorderLayout.CENTER);
        frameErrores.pack();
        frameErrores.setVisible(true);
        frameErrores.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }// GEN-LAST:event_btnTablaSimbolosActionPerformed

    private void btnASTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnASTActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnASTActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        // el breakpoint va en declaracion ast
        try {
            listaErrores.clear();
            if (this.listaSimbolos != null) {
                listaSimbolos.clear();
            }

            txtAreaConsola.setText("");

            String texto = archivo.obtenerTextoPestanaActual(pnlEntrada); // obteniendo texto del text area
            String erroresConsola = "";

            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);

            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();// creando tabla global

            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            ast.setTablaGlobal(tabla);

            listaErrores.addAll(s.listaErrores);
            listaErrores.addAll(p.listaErrores);
            // 3 recorridos del arbol

            for (var a : ast.getInstrucciones()) {// 1ra vuelta
                if (a == null) {
                    continue;
                }
                if (a instanceof Metodo) {
                    ast.addFunciones(a);
                }
                if (a instanceof DeclaracionStruct) {
                    ast.addStruct(a);
                }
                // en esta vuelta se añaden metodos, funciones y structs
            }

            for (var a : ast.getInstrucciones()) {// 2da vuelta
                if (a == null) {
                    continue;
                }

                if (a instanceof Declaracion || a instanceof AsignacionVar
                        || a instanceof DeclaracionList || a instanceof DeclaracionVector
                        || a instanceof AsignacionVector || a instanceof InstanciaStruct
                        || a instanceof AsignacionStruct) {
                    var res = a.interpretar(ast, tabla);
                    if (res instanceof Errores) {
                        listaErrores.add((Errores) res);
                    }
                }
                // esta vuelta es para declaraciones y asignaciones globales
            }

            StartWith e = null;
            for (var a : ast.getInstrucciones()) {// 3ra vuelta
                if (a == null) {
                    continue;
                }
                if (a instanceof StartWith) {
                    e = (StartWith) a;
                    break;
                }
                // en la 3ra vuelta del arbol se busca el start_with
            }

            var resultadoStart = e.interpretar(ast, tabla);
            if (resultadoStart instanceof Errores) {
                System.out.println("F");
            }

            ast.agregarSimbolos(tabla.obtenerSimbolos());
            System.out.println("fin ejecucion");
            listaSimbolos = ast.getSimbolos();
            txtAreaConsola.setText(ast.getConsola() + "\n\n\n\n\n\n\n");
            for (Errores error : listaErrores) {
                erroresConsola += "Error " + error.getTipo().toLowerCase() + ": " + error.getDescripcion()
                        + " en linea " + error.getLinea() + " y columna " + error.getColumna() + "\n";
            }
            txtAreaConsola.setText(txtAreaConsola.getText() + erroresConsola);
        } catch (Exception e) {
            System.out.println("Algo salio mal...");
            System.out.println(e);
        }

    }// GEN-LAST:event_btnEjecutarActionPerformed

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
