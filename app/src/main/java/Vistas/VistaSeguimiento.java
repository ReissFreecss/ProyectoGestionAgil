/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorSeguimiento;
import Entidades.EntidadSeguimiento;
import ModelosTablas.ModeloTablaSeguimiento;
import Validatores.ValidadorSeguimiento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vivara
 */
public class VistaSeguimiento extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Indicadores Dietéticos
    private ModeloTablaSeguimiento model;

    // Variable para el objeto seleccionado de tipo EntidadIndicadoresDieteticos
    private EntidadSeguimiento ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadSeguimiento getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de seguimiento seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadSeguimiento ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDSeguimiento.setText(String.valueOf(this.ObjSeleccionado.getIdSeguimiento())); // Mostrar el ID de seguimiento
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente
            JD_Fecha.setDate(this.ObjSeleccionado.getFecha()); // Fecha de seguimiento
            JTA_AlimentoFueraPlan.setText(this.ObjSeleccionado.getAlimentosFueraPlan()); // Alimentos fuera del plan
            JTA_JugoRefrescoAlcohol.setText(this.ObjSeleccionado.getJugosRefrescosAlcohol()); // Jugos, refrescos o alcohol
            JTA_DiasEntrenamiento.setText(String.valueOf(this.ObjSeleccionado.getDiasEntrenamiento())); // Días de entrenamiento
            JCB_NivelHambre.setSelectedItem(this.ObjSeleccionado.getPasoHambre()); // Nivel de hambre
            JTA_MejoraEjercicio.setText(this.ObjSeleccionado.getMejoroEjercicio()); // Mejoría en ejercicio
            JTA_MalestarGastrico.setText(this.ObjSeleccionado.getMalestaresGastricos()); // Malestares gástricos
            JSP_Agua.setValue(Integer.parseInt(this.ObjSeleccionado.getLitrosAgua())); // Litros de agua consumida
            JSP_HoraSueño.setValue(Integer.parseInt(this.ObjSeleccionado.getHorasSueno())); // Horas de sueño
            JCB_ApegoPlan.setValue(Integer.parseInt(this.ObjSeleccionado.getApegoPlan())); // Nivel de apego al plan
            JTA_Problemas.setText(this.ObjSeleccionado.getProblemaSolucion()); // Problema y solución
            JTA_Observaciones.setText(this.ObjSeleccionado.getExtrasObservaciones()); // Observaciones extras
        } else {
            limpiarFormulario(); // Si no hay objeto seleccionado, limpiar los campos de texto
        }
    }

    // Método para limpiar los campos del formulario de seguimiento
    private void limpiarFormulario() {
        JTA_IDSeguimiento.setText(""); // Limpiar el campo ID de seguimiento
        JTA_IDPaciente.setText(""); // Limpiar el campo ID de paciente
        JD_Fecha.setDate(null); // Limpiar el campo de fecha
        JTA_AlimentoFueraPlan.setText(""); // Limpiar el campo alimentos fuera del plan
        JTA_JugoRefrescoAlcohol.setText(""); // Limpiar el campo jugos, refrescos o alcohol
        JTA_DiasEntrenamiento.setText(""); // Limpiar el campo días de entrenamiento
        JCB_NivelHambre.setSelectedIndex(0); // Restablecer el nivel de hambre al valor por defecto
        JTA_MejoraEjercicio.setText(""); // Limpiar el campo mejoría en ejercicio
        JTA_MalestarGastrico.setText(""); // Limpiar el campo malestares gástricos
        JSP_Agua.setValue(0); // Restablecer el valor de litros de agua
        JSP_HoraSueño.setValue(0); // Restablecer el valor de horas de sueño
        JCB_ApegoPlan.setValue(0); // Restablecer el valor de apego al plan
        JTA_Problemas.setText(""); // Limpiar el campo problema y solución
        JTA_Observaciones.setText(""); // Limpiar el campo de observaciones
    }

    // Método para refrescar los datos de la tabla de seguimiento
    public void refrescar() {
        try {
            // Obtiene todos los seguimientos desde el servicio
            ArrayList<EntidadSeguimiento> datos = ControladorSeguimiento.PedirTodos();

            // Establece los nuevos datos en el modelo de la tabla
            model.setDatos(datos);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            // Muestra un mensaje de error si ocurre un IOException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        }
        limpiarFormulario();
    }

    // Constructor de la clase
    public VistaSeguimiento() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla de videojuegos
        model = new ModeloTablaSeguimiento();

        // Establece el modelo en la tabla
        TBDatos.setModel(model);

        // Añade un ListSelectionListener para manejar la selección de filas en la tabla
        TBDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Obtiene el índice de la fila seleccionada
                int idx = TBDatos.getSelectedRow();

                // Si hay una fila seleccionada, actualiza el objeto seleccionado
                if (idx >= 0) {
                    setObjSeleccionado(model.getDatos().get(idx));
                } // Si no hay fila seleccionada, establece el objeto seleccionado a null
                else {
                    setObjSeleccionado(null);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnRefrescar_ = new javax.swing.JButton();
        btnAgregar_ = new javax.swing.JButton();
        btnEditar_ = new javax.swing.JButton();
        btnEliminar_ = new javax.swing.JButton();
        JTA_BuscaID = new javax.swing.JTextField();
        btnBuscaID_ = new javax.swing.JButton();
        JTA_BuscaIDPaciente = new javax.swing.JTextField();
        btnBuscaPaciente_ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTA_AlimentoFueraPlan = new javax.swing.JTextField();
        JTA_IDPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTA_JugoRefrescoAlcohol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTA_IDSeguimiento = new javax.swing.JTextField();
        JTA_DiasEntrenamiento = new javax.swing.JTextField();
        JTA_MejoraEjercicio = new javax.swing.JTextField();
        JTA_MalestarGastrico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JSP_Agua = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        JCB_ApegoPlan = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        JSP_HoraSueño = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JD_Fecha = new com.toedter.calendar.JDateChooser();
        JCB_NivelHambre = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTA_Observaciones = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTA_Problemas = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(58, 71, 80));
        setForeground(new java.awt.Color(27, 38, 44));
        setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(648, 441));

        TBDatos.setBackground(new java.awt.Color(48, 56, 65));
        TBDatos.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        TBDatos.setForeground(new java.awt.Color(221, 221, 221));
        TBDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        TBDatos.setToolTipText("");
        TBDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TBDatos);

        jPanel1.setBackground(new java.awt.Color(82, 97, 107));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
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

        btnAgregar_.setBackground(new java.awt.Color(73, 84, 100));
        btnAgregar_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar_.setForeground(new java.awt.Color(221, 221, 221));
        btnAgregar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar_.setText("Agregar");
        btnAgregar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_ActionPerformed(evt);
            }
        });

        btnEditar_.setBackground(new java.awt.Color(73, 84, 100));
        btnEditar_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEditar_.setForeground(new java.awt.Color(221, 221, 221));
        btnEditar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEditar_.setText("Editar");
        btnEditar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_ActionPerformed(evt);
            }
        });

        btnEliminar_.setBackground(new java.awt.Color(73, 84, 100));
        btnEliminar_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEliminar_.setForeground(new java.awt.Color(221, 221, 221));
        btnEliminar_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar_.setText("Eliminar");
        btnEliminar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ActionPerformed(evt);
            }
        });

        JTA_BuscaID.setBackground(new java.awt.Color(255, 253, 249));
        JTA_BuscaID.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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

        JTA_BuscaIDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_BuscaIDPaciente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        JTA_BuscaIDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        btnBuscaPaciente_.setBackground(new java.awt.Color(73, 84, 100));
        btnBuscaPaciente_.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscaPaciente_.setForeground(new java.awt.Color(221, 221, 221));
        btnBuscaPaciente_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscaPaciente_.setText("Buscar ID Paciente");
        btnBuscaPaciente_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaPaciente_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEditar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRefrescar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JTA_BuscaID)
            .addComponent(btnBuscaID_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JTA_BuscaIDPaciente)
            .addComponent(btnBuscaPaciente_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefrescar_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTA_BuscaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscaID_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTA_BuscaIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscaPaciente_)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(82, 97, 107));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(221, 221, 221));
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(221, 221, 221));
        jLabel1.setText("ID Paciente:");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(221, 221, 221));
        jLabel2.setText("Fecha:");

        JTA_AlimentoFueraPlan.setBackground(new java.awt.Color(255, 253, 249));
        JTA_AlimentoFueraPlan.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_AlimentoFueraPlan.setForeground(new java.awt.Color(27, 38, 44));

        JTA_IDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 221));
        jLabel3.setText("% De apego al plan:");

        JTA_JugoRefrescoAlcohol.setBackground(new java.awt.Color(255, 253, 249));
        JTA_JugoRefrescoAlcohol.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_JugoRefrescoAlcohol.setForeground(new java.awt.Color(27, 38, 44));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 221));
        jLabel4.setText("Nivel hambre:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("Alimentos fuera plan:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Dias de entrenamiento:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("Mejora de ejercicio:");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDSeguimiento.setEditable(false);
        JTA_IDSeguimiento.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDSeguimiento.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDSeguimiento.setForeground(new java.awt.Color(27, 38, 44));

        JTA_DiasEntrenamiento.setBackground(new java.awt.Color(255, 253, 249));
        JTA_DiasEntrenamiento.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_DiasEntrenamiento.setForeground(new java.awt.Color(27, 38, 44));
        JTA_DiasEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTA_DiasEntrenamientoActionPerformed(evt);
            }
        });

        JTA_MejoraEjercicio.setBackground(new java.awt.Color(255, 253, 249));
        JTA_MejoraEjercicio.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_MejoraEjercicio.setForeground(new java.awt.Color(27, 38, 44));

        JTA_MalestarGastrico.setBackground(new java.awt.Color(255, 253, 249));
        JTA_MalestarGastrico.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_MalestarGastrico.setForeground(new java.awt.Color(27, 38, 44));
        JTA_MalestarGastrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTA_MalestarGastricoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(221, 221, 221));
        jLabel7.setText("Agua Consumida:");

        JSP_Agua.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Agua.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(221, 221, 221));
        jLabel10.setText("¿Malestares gastricos?");

        JCB_ApegoPlan.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JCB_ApegoPlan.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 10.0d));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(221, 221, 221));
        jLabel11.setText("Horas de sueño:");

        JSP_HoraSueño.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_HoraSueño.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(221, 221, 221));
        jLabel12.setText("Jugos/Refresco/Alcohol:");

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(221, 221, 221));
        jLabel13.setText("Problemas solucion:");

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(221, 221, 221));
        jLabel14.setText("Observaciones:");

        JCB_NivelHambre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hambre extrema", "Hambre razonable", "Hambre normal", "Sin hambre", "Satisfecho", "Muy lleno", "Saturado" }));

        JTA_Observaciones.setColumns(20);
        JTA_Observaciones.setRows(5);
        jScrollPane2.setViewportView(JTA_Observaciones);

        JTA_Problemas.setColumns(20);
        JTA_Problemas.setRows(5);
        jScrollPane3.setViewportView(JTA_Problemas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSP_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSP_HoraSueño, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCB_NivelHambre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCB_ApegoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTA_DiasEntrenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(JTA_MejoraEjercicio)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTA_IDSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTA_AlimentoFueraPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JTA_JugoRefrescoAlcohol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                .addComponent(JTA_MalestarGastrico, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(JTA_IDSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(JCB_ApegoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(JSP_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JSP_HoraSueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCB_NivelHambre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTA_MalestarGastrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTA_DiasEntrenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTA_AlimentoFueraPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTA_JugoRefrescoAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(JTA_MejoraEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorSeguimiento.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorSeguimiento.campoNoVacio(JTA_AlimentoFueraPlan.getText(), "Alimentos fuera del plan")
                || !ValidadorSeguimiento.campoNoVacio(JTA_JugoRefrescoAlcohol.getText(), "Jugos/Refrescos/Alcohol")
                || !ValidadorSeguimiento.campoNoVacio(JTA_DiasEntrenamiento.getText(), "Días de entrenamiento")
                || !ValidadorSeguimiento.campoNoVacio(JCB_NivelHambre.getSelectedItem().toString(), "Nivel de hambre")
                || !ValidadorSeguimiento.campoNoVacio(JTA_MejoraEjercicio.getText(), "Mejoró ejercicio")
                || !ValidadorSeguimiento.campoNoVacio(JTA_MalestarGastrico.getText(), "Malestares gástricos")
                || !ValidadorSeguimiento.campoNoVacio(JTA_Problemas.getText(), "Problemas/soluciones")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorSeguimiento.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }
        // Verifica si el ID del paciente es un número válido
        if (!ValidadorSeguimiento.esNumeroEntero(JTA_DiasEntrenamiento.getText(), "Dias entrenamiento")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorSeguimiento.idPacienteExisteEnBaseDatos(idPaciente, "Pacientes", "ID Paciente")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar este seguimiento?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadSeguimiento nuevo = new EntidadSeguimiento(
                null, // El ID de seguimiento será generado automáticamente
                idPaciente,
                new java.sql.Date(JD_Fecha.getDate().getTime()), // Fecha de seguimiento en formato sql.Date
                String.valueOf(JCB_ApegoPlan.getValue()),
                JTA_AlimentoFueraPlan.getText(), // Alimentos fuera del plan
                JCB_NivelHambre.getSelectedItem().toString(), // Nivel de hambre
                Integer.parseInt(JTA_DiasEntrenamiento.getText()), // Días de entrenamiento
                JTA_MejoraEjercicio.getText(), // Mejoró en el ejercicio
                JTA_JugoRefrescoAlcohol.getText(), // Jugos, refrescos y alcohol
                String.valueOf(JSP_Agua.getValue()),
                JTA_MalestarGastrico.getText(), // Malestares gástricos
                String.valueOf(JSP_HoraSueño.getValue()),
                JTA_Problemas.getText(), // Problemas y soluciones
                JTA_Observaciones.getText() // Observaciones adicionales
        );

        try {
            ControladorSeguimiento.Alta(nuevo);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Seguimiento registrado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el seguimiento: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtener el objeto seleccionado de la tabla de seguimiento
        EntidadSeguimiento seleccionado = getObjSeleccionado();

        // Verifica si hay un seguimiento seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un seguimiento para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorSeguimiento.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "Seguimiento", "ID del paciente")) {
            return; // Salir si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el seguimiento con ID " + seleccionado.getIdSeguimiento()
                + " del paciente con ID " + seleccionado.getIdPaciente() + "?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la eliminación
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la eliminación
        }

        // Si el usuario selecciona "Sí", se procede a la eliminación
        try {
            // Llama al controlador para eliminar el seguimiento seleccionado de la base de datos
            ControladorSeguimiento.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El seguimiento ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del seguimiento
        refrescar();

    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Obtiene el seguimiento seleccionado
        EntidadSeguimiento seleccionado = getObjSeleccionado();

        // Verifica si hay un seguimiento seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un seguimiento para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorSeguimiento.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorSeguimiento.campoNoVacio(JTA_IDSeguimiento.getText(), "ID Seguimiento")
                || !ValidadorSeguimiento.campoNoVacio(JTA_AlimentoFueraPlan.getText(), "Alimentos Fuera del Plan")
                || !ValidadorSeguimiento.campoNoVacio(JTA_JugoRefrescoAlcohol.getText(), "Jugos/Refrescos/Alcohol")
                || !ValidadorSeguimiento.campoNoVacio(JTA_DiasEntrenamiento.getText(), "Días de Entrenamiento")
                || !ValidadorSeguimiento.campoNoVacio(JTA_MejoraEjercicio.getText(), "Mejoras en el Ejercicio")
                || !ValidadorSeguimiento.campoNoVacio(JTA_MalestarGastrico.getText(), "Malestar Gástrico")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica que el ID del paciente sea un número entero válido
        int idPaciente;
        try {
            idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
            if (idPaciente <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de paciente válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del paciente debe ser un número válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica si el paciente existe en la base de datos usando ValidadorDatos
        if (!ValidadorSeguimiento.idPacienteExisteEnBaseDatos(idPaciente, "Paciente", "ID del paciente")) {
            return; // Sale si el ID no existe
        }
        // Verifica si el ID del paciente es un número válido
        if (!ValidadorSeguimiento.esNumeroEntero(JTA_DiasEntrenamiento.getText(), "Dias entrenamiento")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información del seguimiento " + seleccionado.getIdSeguimiento()
                + " del paciente " + seleccionado.getIdPaciente() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos del seguimiento seleccionado con los valores de los campos de texto
        seleccionado.setIdPaciente(idPaciente); // Actualiza el ID del paciente
        seleccionado.setAlimentosFueraPlan(JTA_AlimentoFueraPlan.getText()); // Actualiza los alimentos fuera del plan
        seleccionado.setJugosRefrescosAlcohol(JTA_JugoRefrescoAlcohol.getText()); // Actualiza jugos/refrescos/alcohol
        seleccionado.setDiasEntrenamiento(Integer.parseInt(JTA_DiasEntrenamiento.getText())); // Actualiza los días de entrenamiento
        seleccionado.setMejoroEjercicio(JTA_MejoraEjercicio.getText()); // Actualiza mejoras en ejercicio
        seleccionado.setMalestaresGastricos(JTA_MalestarGastrico.getText()); // Actualiza malestares gástricos

        // Actualiza los valores de los spinners para el agua y las horas de sueño
        seleccionado.setLitrosAgua(JSP_Agua.getValue().toString()); // Convierte a String la cantidad de agua consumida
        seleccionado.setHorasSueno(JSP_HoraSueño.getValue().toString()); // Convierte a String las horas de sueño
        seleccionado.setApegoPlan((String) JCB_NivelHambre.getSelectedItem()); // Actualiza el apego al plan

        try {
            // Llama al servicio para actualizar el seguimiento en la base de datos
            ControladorSeguimiento.Actualizar(seleccionado);
            JOptionPane.showMessageDialog(this, "Los datos del seguimiento han sido actualizados con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de acceso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para mostrar los cambios
        refrescar();
    }//GEN-LAST:event_btnEditar_ActionPerformed

    private void btnBuscaID_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaID_ActionPerformed
        try {
            // Valida si el campo de ID no está vacío
            if (!ValidadorSeguimiento.campoNoVacio(JTA_BuscaID.getText(), "ID Seguimiento")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idIndicadorDietetico;
            try {
                idIndicadorDietetico = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del Seguimiento debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el indicador dietético existe en la base de datos
            if (!ValidadorSeguimiento.idExisteEnBaseDatos(idIndicadorDietetico, "Seguimiento", "ID del Seguimiento")) {
                return;
            }

            // Llama al método correcto para obtener el indicador dietético por ID
            EntidadSeguimiento indicador = ControladorSeguimiento.PedirSeguimientoPorId(idIndicadorDietetico);

            // Verifica si se obtuvo el indicador dietético correctamente y actualiza la tabla
            if (indicador != null) {
                ArrayList<EntidadSeguimiento> datos = new ArrayList<>();
                datos.add(indicador);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el indicador, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron seguimiento con ese ID", "Seguimiento no encontrado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            // Muestra un mensaje de error si ocurre un IOException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Muestra un mensaje de error si ocurre un IllegalArgumentException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }

        // Limpia los campos del formulario después de la búsqueda
        limpiarFormulario();
    }//GEN-LAST:event_btnBuscaID_ActionPerformed

    private void btnBuscaPaciente_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPaciente_ActionPerformed
        try {
            // Valida si el campo de ID no está vacío
            if (!ValidadorSeguimiento.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idPaciente;
            try {
                idPaciente = Integer.parseInt(JTA_BuscaIDPaciente.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID Paciente debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Valida si el ID del paciente existe en la base de datos
            if (!ValidadorSeguimiento.idPacienteExisteEnBaseDatos(idPaciente, "Antecedentes Médicos", "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los antecedentes por ID del paciente
            ArrayList<EntidadSeguimiento> antecedentes = ControladorSeguimiento.PedirSeguimientoPorIdPaciente(idPaciente);

            // Si se encuentran antecedentes, actualiza los datos en la tabla
            if (!antecedentes.isEmpty()) {
                model.setDatos(antecedentes);
            } else {
                // Si no se encuentran antecedentes, muestra un mensaje
                JOptionPane.showMessageDialog(this, "No se encontraron antecedentes para el paciente con ese ID", "Paciente no encontrado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Muestra un mensaje de error si la conexión es nula o hay otro problema
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiarFormulario(); // Limpia los campos del formulario después de la búsqueda
    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed

    private void JTA_DiasEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTA_DiasEntrenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTA_DiasEntrenamientoActionPerformed

    private void JTA_MalestarGastricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTA_MalestarGastricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTA_MalestarGastricoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner JCB_ApegoPlan;
    private javax.swing.JComboBox<String> JCB_NivelHambre;
    private com.toedter.calendar.JDateChooser JD_Fecha;
    private javax.swing.JSpinner JSP_Agua;
    private javax.swing.JSpinner JSP_HoraSueño;
    private javax.swing.JTextField JTA_AlimentoFueraPlan;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_DiasEntrenamiento;
    private javax.swing.JTextField JTA_IDPaciente;
    private javax.swing.JTextField JTA_IDSeguimiento;
    private javax.swing.JTextField JTA_JugoRefrescoAlcohol;
    private javax.swing.JTextField JTA_MalestarGastrico;
    private javax.swing.JTextField JTA_MejoraEjercicio;
    private javax.swing.JTextArea JTA_Observaciones;
    private javax.swing.JTextArea JTA_Problemas;
    private javax.swing.JTable TBDatos;
    private javax.swing.JButton btnAgregar_;
    private javax.swing.JButton btnBuscaID_;
    private javax.swing.JButton btnBuscaPaciente_;
    private javax.swing.JButton btnEditar_;
    private javax.swing.JButton btnEliminar_;
    private javax.swing.JButton btnRefrescar_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
