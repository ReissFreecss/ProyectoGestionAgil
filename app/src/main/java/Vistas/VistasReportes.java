/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorAntecedentesMedicos;
import Controladores.ControladorDatosInterpretacion;
import Controladores.ControladorDietas;
import Controladores.ControladorIndicadoresAntropometricos;
import Controladores.ControladorPaciente;
import Entidades.EntidadAntecedentesMedicos;
import Entidades.EntidadDatosInterpretacion;
import Entidades.EntidadDietas;
import Entidades.EntidadIndicadoresAntropometricos;
import Entidades.EntidadPaciente;
import ModelosTablas.ModeloTablaAntecedentesMedicos;
import ModelosTablas.ModeloTablaDatosInterpretacion;
import ModelosTablas.ModeloTablaDietas;
import ModelosTablas.ModeloTablaIndicadoresAntropometricos;
import ModelosTablas.ModeloTablaPacientes;
import Reportes.PDFGenerator;
import Reportes.ReporteData;
import Validatores.ValidadorPacientes;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Vivara
 */
public class VistasReportes extends javax.swing.JPanel {

    // Declaración de un objeto de tipo File y preferencia de ruta path
    File archivo;
    public static Preferences prefs1 = Preferences.userRoot().node("A");

    // Variable para el modelo de la tablas
    private ModeloTablaPacientes TablaPaciente;
    private ModeloTablaDietas TablaDieta;
    private ModeloTablaIndicadoresAntropometricos TablaDatosAntropometricos;
    private ModeloTablaAntecedentesMedicos TablaDatosMedicos;
    private ModeloTablaDatosInterpretacion TablaInterpretacion;

    // Variable para el objeto seleccionado de las tablas
    private EntidadPaciente objPaciente = null;
    private EntidadDietas objDieta = null;
    private EntidadDatosInterpretacion objDatosInterpretacion = null;
    private EntidadIndicadoresAntropometricos objDatosAntropometricos = null;
    private EntidadAntecedentesMedicos objAntecedentesMedicos = null;

    // Metodos get y set
    public EntidadPaciente getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(EntidadPaciente objPaciente) {
        this.objPaciente = objPaciente;
    }

    public EntidadDietas getObjDieta() {
        return objDieta;
    }

    public void setObjDieta(EntidadDietas objDieta) {
        this.objDieta = objDieta;
    }

    public EntidadDatosInterpretacion getObjDatosInterpretacion() {
        return objDatosInterpretacion;
    }

    public void setObjDatosInterpretacion(EntidadDatosInterpretacion objDatosInterpretacion) {
        this.objDatosInterpretacion = objDatosInterpretacion;
    }

    public EntidadIndicadoresAntropometricos getObjDatosAntropometricos() {
        return objDatosAntropometricos;
    }

    public void setObjDatosAntropometricos(EntidadIndicadoresAntropometricos objDatosAntropometricos) {
        this.objDatosAntropometricos = objDatosAntropometricos;
    }

    public EntidadAntecedentesMedicos getObjAntecedentesMedicos() {
        return objAntecedentesMedicos;
    }

    public void setObjAntecedentesMedicos(EntidadAntecedentesMedicos objAntecedentesMedicos) {
        this.objAntecedentesMedicos = objAntecedentesMedicos;
    }

    // Metodos para obtener el objeto seleccionado:
    private EntidadPaciente obtenerPacienteDeTabla(int fila) {
        if (fila >= 0) { // Verifica que la fila sea válida
            return TablaPaciente.getPaciente(fila); // Devuelve el objeto desde el modelo
        }
        return null; // Si no hay fila válida seleccionada
    }

    private EntidadDietas obtenerDietaDeTabla(int fila) {
        if (fila >= 0) { // Verifica que la fila sea válida
            return TablaDieta.getDieta(fila); // Devuelve el objeto desde el modelo
        }
        return null; // Si no hay fila válida seleccionada
    }

    private EntidadIndicadoresAntropometricos obtenerIndicadorAntropometricoDeTabla(int fila) {
        if (fila >= 0) { // Verifica que la fila sea válida
            return TablaDatosAntropometricos.getIndicadorAntropometrico(fila); // Devuelve el objeto desde el modelo
        }
        return null; // Si no hay fila válida seleccionada
    }

    private EntidadAntecedentesMedicos obtenerAntecedenteMedicoDeTabla(int fila) {
        if (fila >= 0) { // Verifica que la fila sea válida
            return TablaDatosMedicos.getAntecedenteMedico(fila); // Devuelve el objeto desde el modelo
        }
        return null; // Si no hay fila válida seleccionada
    }

    private EntidadDatosInterpretacion obtenerDatosInterpretacionDeTabla(int fila) {
        if (fila >= 0) { // Verifica que la fila sea válida
            return TablaInterpretacion.getDatosInterpretacion(fila); // Devuelve el objeto desde el modelo
        }
        return null; // Si no hay fila válida seleccionada
    }

    private void configurarListenersTablas() {
        // Listener para TBDatosPaciente
        TBDatosPaciente.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TBDatosPaciente.getSelectedRow();
                objPaciente = obtenerPacienteDeTabla(filaSeleccionada);
            }
        });

        // Listener para TBDatosDietas
        TBDatosDietas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TBDatosDietas.getSelectedRow();
                objDieta = obtenerDietaDeTabla(filaSeleccionada);
            }
        });

        // Listener para TBDatosAntropometricos
        TBDatosAntropometricos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TBDatosAntropometricos.getSelectedRow();
                objDatosAntropometricos = obtenerIndicadorAntropometricoDeTabla(filaSeleccionada);
            }
        });

        // Listener para TBDatosAntecedentesMedicos
        TBDatosAntecedentesMedicos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TBDatosAntecedentesMedicos.getSelectedRow();
                objAntecedentesMedicos = obtenerAntecedenteMedicoDeTabla(filaSeleccionada);
            }
        });

        // Listener para TBDatosInterpretacion
        TBDatosInterpretacion.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TBDatosInterpretacion.getSelectedRow();
                objDatosInterpretacion = obtenerDatosInterpretacionDeTabla(filaSeleccionada);
            }
        });
    }

    // Método para buscar plantilla
    private String buscarArchivoPDF() {
        // Obtiene la última ruta guardada desde las preferencias
        String ultimaRuta = prefs1.get("rutaPlantilla", null);

        // Si existe una ruta guardada, se usa como directorio por defecto en el JFileChooser
        File directorio = (ultimaRuta != null) ? new File(ultimaRuta).getParentFile() : new File(System.getProperty("user.home"));

        JFileChooser fileChooser = new JFileChooser(directorio); // Usar la última carpeta seleccionada
        fileChooser.setDialogTitle("Seleccionar plantilla PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf")); // Filtro para solo archivos .pdf

        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            // Guardar la ruta de la plantilla seleccionada en las preferencias
            prefs1.put("rutaPlantilla", archivoSeleccionado.getAbsolutePath());
            // Actualizar el JLabel con la ruta del archivo seleccionado
            Plantilla.setText("Plantilla seleccionada: " + archivoSeleccionado.getAbsolutePath());
            return archivoSeleccionado.getAbsolutePath();
        }
        return null; // Si no se selecciona ningún archivo
    }

    // Método para refrescar los datos de la tabla de caracteristicas
    public void refrescar() {
        try {
            // Obtiene todos los caracteristicas desde el servicio
            ArrayList<EntidadPaciente> datosPacientes = ControladorPaciente.PedirTodos();
            ArrayList<EntidadDietas> datosDietas = ControladorDietas.PedirTodos();
            ArrayList<EntidadIndicadoresAntropometricos> datosAntropometricos = ControladorIndicadoresAntropometricos.PedirTodos();
            ArrayList<EntidadAntecedentesMedicos> datosMedicos = ControladorAntecedentesMedicos.PedirTodos();
            ArrayList<EntidadDatosInterpretacion> datosInterpretacion = ControladorDatosInterpretacion.PedirTodos();

            // Establece los nuevos datos en el modelo de la tabla
            TablaPaciente.setDatos(datosPacientes);
            TablaDieta.setDatos(datosDietas);
            TablaDatosAntropometricos.setDatos(datosAntropometricos);
            TablaDatosMedicos.setDatos(datosMedicos);
            TablaInterpretacion.setDatos(datosInterpretacion);

        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Constructor de la clase
    public VistasReportes() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla de videojuegos
        TablaPaciente = new ModeloTablaPacientes();
        TablaDieta = new ModeloTablaDietas();
        TablaDatosAntropometricos = new ModeloTablaIndicadoresAntropometricos();
        TablaDatosMedicos = new ModeloTablaAntecedentesMedicos();
        TablaInterpretacion = new ModeloTablaDatosInterpretacion();

        // Establece el modelo en la tabla
        TBDatosPaciente.setModel(TablaPaciente);
        TBDatosDietas.setModel(TablaDieta);
        TBDatosAntropometricos.setModel(TablaDatosAntropometricos);
        TBDatosAntecedentesMedicos.setModel(TablaDatosMedicos);
        TBDatosInterpretacion.setModel(TablaInterpretacion);

        // Cargar la última ubicación guardada de la plantilla desde las preferencias
        String ultimaRuta = prefs1.get("rutaPlantilla", null);  // Obtiene la ruta guardada de las preferencias
        if (ultimaRuta != null) {
            File archivo = new File(ultimaRuta);  // Crea un objeto File con la ruta guardada
            Plantilla.setText("Plantilla seleccionada: " + archivo.getPath());  // Muestra la ruta en el JLabel
        } else {
            Plantilla.setText("No se ha seleccionado plantilla.");  // Mensaje por defecto si no hay ruta guardada
        }

        // Configura los listeners de las tablas
        configurarListenersTablas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnRefrescar_ = new javax.swing.JButton();
        btnGenerar_ = new javax.swing.JButton();
        JTA_BuscaID = new javax.swing.JTextField();
        btnBuscaID_ = new javax.swing.JButton();
        JTA_BuscaNombre = new javax.swing.JTextField();
        btnBuscaNombre_ = new javax.swing.JButton();
        btnBuscarPlantilla_ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Plantilla = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBDatosDietas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBDatosAntropometricos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBDatosAntecedentesMedicos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBDatosInterpretacion = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDatosPaciente = new javax.swing.JTable();

        setBackground(new java.awt.Color(58, 71, 80));
        setForeground(new java.awt.Color(27, 38, 44));
        setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(648, 441));

        jPanel1.setBackground(new java.awt.Color(82, 97, 107));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(221, 221, 221));
        jPanel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnRefrescar_.setBackground(new java.awt.Color(73, 84, 100));
        btnRefrescar_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRefrescar_.setForeground(new java.awt.Color(221, 221, 221));
        btnRefrescar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnRefrescar_.setText("Refrescar");
        btnRefrescar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar_ActionPerformed(evt);
            }
        });

        btnGenerar_.setBackground(new java.awt.Color(73, 84, 100));
        btnGenerar_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGenerar_.setForeground(new java.awt.Color(221, 221, 221));
        btnGenerar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnGenerar_.setText("Generar");
        btnGenerar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar_ActionPerformed(evt);
            }
        });

        JTA_BuscaID.setBackground(new java.awt.Color(255, 253, 249));
        JTA_BuscaID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        JTA_BuscaID.setForeground(new java.awt.Color(27, 38, 44));

        btnBuscaID_.setBackground(new java.awt.Color(73, 84, 100));
        btnBuscaID_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscaID_.setForeground(new java.awt.Color(221, 221, 221));
        btnBuscaID_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscaID_.setText("Buscar ID");
        btnBuscaID_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaID_ActionPerformed(evt);
            }
        });

        JTA_BuscaNombre.setBackground(new java.awt.Color(255, 253, 249));
        JTA_BuscaNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JTA_BuscaNombre.setForeground(new java.awt.Color(27, 38, 44));

        btnBuscaNombre_.setBackground(new java.awt.Color(73, 84, 100));
        btnBuscaNombre_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscaNombre_.setForeground(new java.awt.Color(221, 221, 221));
        btnBuscaNombre_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscaNombre_.setText("Buscar Nombre");
        btnBuscaNombre_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaNombre_ActionPerformed(evt);
            }
        });

        btnBuscarPlantilla_.setBackground(new java.awt.Color(73, 84, 100));
        btnBuscarPlantilla_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscarPlantilla_.setForeground(new java.awt.Color(221, 221, 221));
        btnBuscarPlantilla_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnBuscarPlantilla_.setText("Buscar plantilla");
        btnBuscarPlantilla_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlantilla_ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 253, 253));
        jLabel3.setText("Ubicacion de la plantilla:");

        Plantilla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Plantilla.setForeground(new java.awt.Color(253, 253, 253));
        Plantilla.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscaNombre_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscaID_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarPlantilla_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Plantilla))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTA_BuscaID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(JTA_BuscaNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefrescar_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar_, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPlantilla_)
                    .addComponent(jLabel3)
                    .addComponent(Plantilla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscaID_)
                            .addComponent(JTA_BuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTA_BuscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscaNombre_)))
                    .addComponent(btnRefrescar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );

        TBDatosDietas.setBackground(new java.awt.Color(48, 56, 65));
        TBDatosDietas.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatosDietas.setForeground(new java.awt.Color(221, 221, 221));
        TBDatosDietas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TBDatosDietas);

        TBDatosAntropometricos.setBackground(new java.awt.Color(48, 56, 65));
        TBDatosAntropometricos.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatosAntropometricos.setForeground(new java.awt.Color(221, 221, 221));
        TBDatosAntropometricos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TBDatosAntropometricos);

        TBDatosAntecedentesMedicos.setBackground(new java.awt.Color(48, 56, 65));
        TBDatosAntecedentesMedicos.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatosAntecedentesMedicos.setForeground(new java.awt.Color(221, 221, 221));
        TBDatosAntecedentesMedicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TBDatosAntecedentesMedicos);

        TBDatosInterpretacion.setBackground(new java.awt.Color(48, 56, 65));
        TBDatosInterpretacion.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatosInterpretacion.setForeground(new java.awt.Color(221, 221, 221));
        TBDatosInterpretacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TBDatosInterpretacion);

        jScrollPane1.setForeground(new java.awt.Color(27, 38, 44));

        TBDatosPaciente.setBackground(new java.awt.Color(48, 56, 65));
        TBDatosPaciente.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatosPaciente.setForeground(new java.awt.Color(221, 221, 221));
        TBDatosPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        TBDatosPaciente.setToolTipText("");
        TBDatosPaciente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBDatosPaciente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnGenerar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar_ActionPerformed
        try {
            // Obtener datos seleccionados
            EntidadPaciente pacienteSeleccionado = getObjPaciente();
            EntidadDietas dietaSeleccionada = getObjDieta();
            EntidadDatosInterpretacion datosInterpretacionSeleccionados = getObjDatosInterpretacion();
            EntidadIndicadoresAntropometricos indicadoresSeleccionados = getObjDatosAntropometricos();
            EntidadAntecedentesMedicos antecedentesSeleccionados = getObjAntecedentesMedicos();

            // Validar entidades
            if (pacienteSeleccionado == null || dietaSeleccionada == null
                    || datosInterpretacionSeleccionados == null || indicadoresSeleccionados == null
                    || antecedentesSeleccionados == null) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona todas las entidades requeridas antes de generar el reporte.");
                return;
            }

            // Crear objeto de datos
            ReporteData datosReporte = new ReporteData(
                    pacienteSeleccionado.getNombreCompleto(),
                    pacienteSeleccionado.getEdad(),
                    pacienteSeleccionado.getFechaConsulta(),
                    pacienteSeleccionado.getMotivoConsulta(),
                    datosInterpretacionSeleccionados.getPeso(),
                    datosInterpretacionSeleccionados.getImc(),
                    datosInterpretacionSeleccionados.getMasaMuscular(),
                    datosInterpretacionSeleccionados.getPorcentajeGrasaCorporal(),
                    indicadoresSeleccionados.getEstatura(),
                    indicadoresSeleccionados.getCircunferenciaCintura(),
                    antecedentesSeleccionados.getEnfermedadDiagnosticada(),
                    antecedentesSeleccionados.getAlergiaIntoleranciaAlimentos(),
                    dietaSeleccionada.getComida(),
                    dietaSeleccionada.getHorario(),
                    dietaSeleccionada.getPorciones(),
                    dietaSeleccionada.getIngredientes(),
                    dietaSeleccionada.getSuplemento(),
                    dietaSeleccionada.getDosisSuplemento()
            );

            // Obtener la ruta de la plantilla desde las preferencias
            String plantillaPath = prefs1.get("rutaPlantilla", null);
            if (plantillaPath == null) {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado una plantilla.");
                return;
            }

            // Seleccionar ubicación para guardar el archivo generado
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String outputPath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!outputPath.endsWith(".pdf")) {
                    outputPath += ".pdf";
                }

                // Generar el PDF
                PDFGenerator.generarReporte(datosReporte, plantillaPath, outputPath);
                JOptionPane.showMessageDialog(this, "Reporte generado con éxito en: " + outputPath);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGenerar_ActionPerformed

    private void btnBuscaID_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaID_ActionPerformed
        try {
            // Verifica si el campo de ID no está vacío
            if (JTA_BuscaID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idPaciente = Integer.parseInt(JTA_BuscaID.getText());

            // Llama al método para obtener el paciente por ID
            EntidadPaciente paciente = ControladorPaciente.PedirPorId(idPaciente);
            ArrayList<EntidadDietas> Dieta = ControladorDietas.PedirDietasPorIdPaciente(idPaciente);
            ArrayList<EntidadIndicadoresAntropometricos> indicadores = ControladorIndicadoresAntropometricos.PedirIndicadoresPorIdPaciente(idPaciente);
            ArrayList<EntidadAntecedentesMedicos> antecedentes = ControladorAntecedentesMedicos.PedirAntecedentesPorIdPaciente(idPaciente);
            ArrayList<EntidadDatosInterpretacion> Interpretacion = ControladorDatosInterpretacion.PedirDatosPorIdPaciente(idPaciente);

            if (paciente != null) {
                // Si se encuentra el paciente, actualiza los datos en el modelo de la tabla
                ArrayList<EntidadPaciente> datos = new ArrayList<>();
                datos.add(paciente);
                TablaPaciente.setDatos(datos);
                TablaDieta.setDatos(Dieta); // Actualiza la tabla con las comidas obtenidas
                TablaDatosAntropometricos.setDatos(indicadores);
                TablaDatosMedicos.setDatos(antecedentes);
                TablaInterpretacion.setDatos(Interpretacion);
            } else {
                // Si no se encuentra el paciente, muestra un mensaje
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con ese ID", "Paciente no encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Muestra un mensaje de error si el ID no es un número válido
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscaID_ActionPerformed

    private void btnBuscaNombre_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaNombre_ActionPerformed
        try {
            // Valida que el campo de búsqueda de nombre no esté vacío
            if (!ValidadorPacientes.campoNoVacio(JTA_BuscaNombre.getText(), "Nombre")) {
                return; // Detiene la ejecución si el nombre está vacío
            }

            // Obtiene el nombre del campo de texto
            String nombrePaciente = JTA_BuscaNombre.getText();

            // Llama al controlador para obtener los pacientes por nombre
            ArrayList<EntidadPaciente> pacientes = ControladorPaciente.PedirPorNombre(nombrePaciente);

            if (!pacientes.isEmpty()) {
                // Si se encuentran pacientes, actualiza los datos en el modelo de la tabla
                TablaPaciente.setDatos(pacientes);
            } else {
                // Si no se encuentran pacientes, muestra un mensaje
                JOptionPane.showMessageDialog(this, "No se encontraron pacientes con ese nombre", "Pacientes no encontrados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            // Muestra un mensaje de error si ocurre un IOException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscaNombre_ActionPerformed

    private void btnBuscarPlantilla_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlantilla_ActionPerformed
        String rutaPlantilla = buscarArchivoPDF();
        if (rutaPlantilla != null) {
            prefs1.put("rutaPlantilla", rutaPlantilla); // Guardar en las preferencias
            Plantilla.setText(rutaPlantilla);
            JOptionPane.showMessageDialog(this, "Plantilla seleccionada y guardada: " + rutaPlantilla,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna plantilla.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarPlantilla_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaNombre;
    private javax.swing.JLabel Plantilla;
    private javax.swing.JTable TBDatosAntecedentesMedicos;
    private javax.swing.JTable TBDatosAntropometricos;
    private javax.swing.JTable TBDatosDietas;
    private javax.swing.JTable TBDatosInterpretacion;
    private javax.swing.JTable TBDatosPaciente;
    private javax.swing.JButton btnBuscaID_;
    private javax.swing.JButton btnBuscaNombre_;
    private javax.swing.JButton btnBuscarPlantilla_;
    private javax.swing.JButton btnGenerar_;
    private javax.swing.JButton btnRefrescar_;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
