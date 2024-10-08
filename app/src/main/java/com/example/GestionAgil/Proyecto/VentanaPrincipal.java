package com.example.GestionAgil.Proyecto;

import Controladores.ControladorBDSQL;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Vivara
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Declaración de un objeto de tipo File llamado 'archivo'
    File archivo;

    // Declaración y creación de un objeto Preferences para almacenar y recuperar preferencias del usuario
    public static Preferences prefs = Preferences.userRoot().node("ProyectoIA");

    public VentanaPrincipal() {
        initComponents(); // Inicializa los componentes de la interfaz gráfica

        // Recupera la última ruta del archivo usado de las preferencias del usuario
        // Si no existe, usa "miArchivo.txt" por defecto
        archivo = new File(prefs.get("ULTIMO_ARCHIVO_USADO", "miArchivo.txt"));

        // Establece el texto de jLabel2 como la ruta del archivo
        jLabel2.setText(archivo.getPath());

        // Llama al método cargarArchivo() para cargar el archivo en cuestión
        cargarArchivo();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        cRUDPacientes1 = new Vistas.VistaPacientes();
        jPanel2 = new javax.swing.JPanel();
        cRUDAntecedentesMedicos1 = new Vistas.VistaAntecedentesMedicos();
        jPanel4 = new javax.swing.JPanel();
        vistaAntecedenteFamiliar1 = new Vistas.VistaAntecedenteFamiliar();
        jPanel5 = new javax.swing.JPanel();
        vistaDatosGinecologicos1 = new Vistas.VistaDatosGinecologicos();
        jPanel7 = new javax.swing.JPanel();
        vistaEstiloVida1 = new Vistas.VistaEstiloVida();
        jPanel8 = new javax.swing.JPanel();
        vistaConsumoSustancias1 = new Vistas.VistaConsumoSustancias();
        jPanel9 = new javax.swing.JPanel();
        vistaComidas1 = new Vistas.VistaComidas();
        jPanel10 = new javax.swing.JPanel();
        vistaIndicadoresDieteticos1 = new Vistas.VistaIndicadoresDieteticos();
        jPanel11 = new javax.swing.JPanel();
        vistaDietaEspecial1 = new Vistas.VistaDietaEspecial();
        jPanel12 = new javax.swing.JPanel();
        vistaIndicadoresAntropometricos1 = new Vistas.VistaIndicadoresAntropometricos();
        jPanel13 = new javax.swing.JPanel();
        vistaDatosInterpretacion1 = new Vistas.VistaDatosInterpretacion();
        jPanel14 = new javax.swing.JPanel();
        vistaDietas1 = new Vistas.VistaDietas();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setText("Tema: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oscuro", "Claro" }));

        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("Ubicacion de la base de datos:");

        jButton1.setText("Comprobar Conexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(22, 22, 22))
        );

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(cRUDPacientes1);

        jTabbedPane2.addTab("Pacientes", jPanel6);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(cRUDAntecedentesMedicos1);

        jTabbedPane2.addTab("Antecedentes Medicos", jPanel2);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));
        jPanel4.add(vistaAntecedenteFamiliar1);

        jTabbedPane2.addTab("Antecedentes Familiar", jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(vistaDatosGinecologicos1);

        jTabbedPane2.addTab("Datos Ginecologicos", jPanel5);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));
        jPanel7.add(vistaEstiloVida1);

        jTabbedPane2.addTab("Estilo de vida", jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));
        jPanel8.add(vistaConsumoSustancias1);

        jTabbedPane2.addTab("Consumo de Sustancias", jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));
        jPanel9.add(vistaComidas1);

        jTabbedPane2.addTab("Comidas", jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));
        jPanel10.add(vistaIndicadoresDieteticos1);

        jTabbedPane2.addTab("Indicadores Dieteticos", jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));
        jPanel11.add(vistaDietaEspecial1);

        jTabbedPane2.addTab("Dieta Especial", jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout());
        jPanel12.add(vistaIndicadoresAntropometricos1);

        jTabbedPane2.addTab("Indicadores Antropometricos", jPanel12);

        jPanel13.setLayout(new java.awt.GridLayout());
        jPanel13.add(vistaDatosInterpretacion1);

        jTabbedPane2.addTab("Datos Interpretacion", jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout());
        jPanel14.add(vistaDietas1);

        jTabbedPane2.addTab("Dietas", jPanel14);

        jLabel4.setText("Nutrición y Fitness MX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Nueva BD");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Cargar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AcercaDe acercaDeWindow = new AcercaDe();
        acercaDeWindow.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void guardarArchivo() {
        if (archivo.exists() && JOptionPane.showConfirmDialog(this, "¿Desea sobreescribir el archivo?", "Archivo existente", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            ControladorBDSQL.InicializarConexion(archivo);
            ControladorBDSQL.crearBD();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarArchivo() {
        if (archivo.exists()) {
            try {
                ControladorBDSQL.InicializarConexion(archivo);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error el archivo no existe", "Error el archivo no existe", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Crear un JFileChooser con el archivo actual como directorio por defecto
        JFileChooser fc = new JFileChooser(archivo);

        // Crear un filtro para mostrar solo archivos con extensión .db
        FileFilter filter = new FileNameExtensionFilter("Archivos SQLite *.db", "db");
        fc.setFileFilter(filter); // Aplicar el filtro al JFileChooser

        // Mostrar el diálogo para guardar archivo y comprobar si el usuario ha elegido una opción
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (!(archivo.getPath().endsWith(".txt"))) {
                // Si no termina con ".txt", añadir ".db" al nombre del archivo seleccionado
                archivo = new File(fc.getSelectedFile().getPath() + ".db");
            } else {
                archivo = fc.getSelectedFile();
            }
            // Guardar la ruta del archivo seleccionado en las preferencias del usuario
            prefs.put("ULTIMO_ARCHIVO_USADO", archivo.getPath());
            jLabel2.setText(archivo.getPath());

            // Llamar al método guardarArchivo() para guardar el archivo
            guardarArchivo();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        prefs.put("NOMBRE_TEMA", jComboBox1.getSelectedItem().toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Crear un JFileChooser con el archivo actual como directorio por defecto
        JFileChooser fc = new JFileChooser(archivo);

        // Crear un filtro para mostrar solo archivos con extensión .db
        FileFilter filter = new FileNameExtensionFilter("Archivos SQLite: *.db", "db");
        fc.setFileFilter(filter); // Aplicar el filtro al JFileChooser

        // Mostrar el diálogo para abrir archivo y comprobar si el usuario ha elegido una opción
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Asignar el archivo seleccionado a la variable 'archivo'
            archivo = fc.getSelectedFile();

            prefs.put("ULTIMO_ARCHIVO_USADO", archivo.getPath());
            jLabel2.setText(archivo.getPath());

            // Llamar al método cargarArchivo() para cargar el archivo
            cargarArchivo();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Verifica si la conexión a la base de datos no está inicializada
        if (ControladorBDSQL.conexion == null) {
            JOptionPane.showMessageDialog(this, "Error la conexion no esta inicializada", "Error SQL", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Conexion correcta", "Conectado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String tema = prefs.get("NOMBRE_TEMA", "Claro");
        System.out.println("tema" + tema);
        
        

        try {

            switch (tema) {
                case "Claro" ->
                    UIManager.setLookAndFeel(new FlatLightLaf());
                case "Oscuro" ->
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                default -> {
                    System.err.println("Error el tema " + tema + "no existe. ");
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);

        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vistas.VistaAntecedentesMedicos cRUDAntecedentesMedicos1;
    private Vistas.VistaPacientes cRUDPacientes1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private Vistas.VistaAntecedenteFamiliar vistaAntecedenteFamiliar1;
    private Vistas.VistaComidas vistaComidas1;
    private Vistas.VistaConsumoSustancias vistaConsumoSustancias1;
    private Vistas.VistaDatosGinecologicos vistaDatosGinecologicos1;
    private Vistas.VistaDatosInterpretacion vistaDatosInterpretacion1;
    private Vistas.VistaDietaEspecial vistaDietaEspecial1;
    private Vistas.VistaDietas vistaDietas1;
    private Vistas.VistaEstiloVida vistaEstiloVida1;
    private Vistas.VistaIndicadoresAntropometricos vistaIndicadoresAntropometricos1;
    private Vistas.VistaIndicadoresDieteticos vistaIndicadoresDieteticos1;
    // End of variables declaration//GEN-END:variables
}