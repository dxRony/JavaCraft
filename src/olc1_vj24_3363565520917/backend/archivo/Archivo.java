/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_vj24_3363565520917.backend.archivo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/**
 *
 * @author romar
 */
public class Archivo {

    private String RUTA;
    private static final Font TEXT_AREA = new Font("Segoe UI", Font.PLAIN, 18);

    public void nuevoArchivo(JTabbedPane tabbedPane) {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea txtArea = new JTextArea();
        txtArea.setFont(TEXT_AREA);
        panel.add(new JScrollPane(txtArea), BorderLayout.CENTER);

        int pestanias = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + pestanias, panel);
        tabbedPane.setSelectedComponent(panel);
    }

    public void abrirArchivo(JTabbedPane tabbedPane) {
        String texto = "";
        try {
            JFileChooser buscador = new JFileChooser();
            buscador.showOpenDialog(buscador);
            RUTA = buscador.getSelectedFile().getAbsolutePath();

            File archivo = new File(RUTA);
            System.out.println("abriendo..." + RUTA);

            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                texto += linea + "\n";
            }
            buffer.close();
            lector.close();

            JPanel panel = new JPanel(new BorderLayout());
            JTextArea txtArea = new JTextArea();
            txtArea.setFont(TEXT_AREA);
            txtArea.setText(texto);
            panel.add(new JScrollPane(txtArea), BorderLayout.CENTER);
            tabbedPane.addTab(archivo.getName(), panel);
            tabbedPane.setSelectedComponent(panel);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void guardarArchivo(JTabbedPane tabbedPane) {
        int pestaniaActual = tabbedPane.getSelectedIndex();

        if (pestaniaActual != -1) {
            JPanel panel = (JPanel) tabbedPane.getComponentAt(pestaniaActual);
            JScrollPane sP = (JScrollPane) panel.getComponent(0);
            JViewport vP = sP.getViewport();
            JTextArea txtArea = (JTextArea) vP.getView();

            JFileChooser fileChooser = new JFileChooser();
            int tmp = fileChooser.showSaveDialog(null);
            if (tmp == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
                    txtArea.write(escritor);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void eliminarPestania(JTabbedPane tabbedPane) {
        int pestaniaActual = tabbedPane.getSelectedIndex();

        if (pestaniaActual != -1) {
            tabbedPane.remove(pestaniaActual);
        }
    }

    public String obtenerTextoPestanaActual(JTabbedPane tabbedPane) {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            JPanel selectedPanel = (JPanel) tabbedPane.getComponentAt(selectedIndex);
            JScrollPane scrollPane = (JScrollPane) selectedPanel.getComponent(0);
            JViewport viewport = scrollPane.getViewport();
            JTextArea txtArea = (JTextArea) viewport.getView();
            txtArea.setFont(TEXT_AREA);
            return txtArea.getText();
        }
        return null; // No hay pestaña seleccionada
    }
}
