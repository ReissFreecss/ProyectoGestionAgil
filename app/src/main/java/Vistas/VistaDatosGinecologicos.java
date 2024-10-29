/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorDatosGinecologicos;
import Entidades.EntidadDatosGinecologicos;
import ModelosTablas.ModeloTablaDatosGinecologicos;
import Validatores.ValidadorDatosGinecologicos;
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
 * @author dark
 */
public class VistaDatosGinecologicos extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Antecedentes Medicos
    private ModeloTablaDatosGinecologicos model;

    // Variable para el objeto seleccionado de tipo EntityAntecedentesMedicos
    private EntidadDatosGinecologicos ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadDatosGinecologicos getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de antecedente médico seleccionado y actualizar los campos de texto
    // Método para establecer el objeto de datos ginecológicos seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadDatosGinecologicos objSeleccionado) {
        this.ObjSeleccionado = objSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDAM.setText(String.valueOf(this.ObjSeleccionado.getIdGinecologico())); // Mostrar el ID de datos ginecológicos
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente
            CB_Embarazo.setSelectedItem(this.ObjSeleccionado.getEmbarazoActual()); // Estado de embarazo
            JTA_SDG.setText(this.ObjSeleccionado.getSdg()); // SDG
            JTA_ReferidoPaciente.setText(this.ObjSeleccionado.getReferidoPorPaciente()); // Referido por paciente
            JD_FUM.setDate(this.ObjSeleccionado.getFum()); // Fecha de última menstruación
            JTA_Anticonceptivo.setText(this.ObjSeleccionado.getAnticonceptivosOrales()); // Anticonceptivos orales
            JTA_Dosis.setText(this.ObjSeleccionado.getDosisAnticonceptivo()); // Dosis de anticonceptivo
            JTA_NumEmbarazos.setText(String.valueOf(this.ObjSeleccionado.getNumEmbarazos())); // Número de embarazos
        } // Si no hay objeto seleccionado, limpiar los campos de texto
        else {
            limpiarFormulario();
        }
    }

    // Método para limpiar los campos del formulario
    private void limpiarFormulario() {
        JTA_IDAM.setText("");
        JTA_IDPaciente.setText("");
        CB_Embarazo.setSelectedItem("NO"); // O el valor por defecto que quieras
        JTA_SDG.setText("");
        JTA_ReferidoPaciente.setText("");
        JD_FUM.setDate(null);
        JTA_Anticonceptivo.setText("");
        JTA_Dosis.setText("");
        JTA_NumEmbarazos.setText("");
    }

    // Método para refrescar los datos de la tabla de caracteristicas
    public void refrescar() {
        try {
            // Obtiene todos los caracteristicas desde el servicio
            ArrayList<EntidadDatosGinecologicos> datos = ControladorDatosGinecologicos.PedirTodos();

            // Establece los nuevos datos en el modelo de la tabla
            model.setDatos(datos);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }
        limpiarFormulario();
    }

    // Constructor de la clase
    public VistaDatosGinecologicos() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla de videojuegos
        model = new ModeloTablaDatosGinecologicos();

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
        JTA_IDPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTA_SDG = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JD_FUM = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        JTA_IDAM = new javax.swing.JTextField();
        CB_Embarazo = new javax.swing.JComboBox<>();
        JTA_ReferidoPaciente = new javax.swing.JTextField();
        JTA_Anticonceptivo = new javax.swing.JTextField();
        JTA_Dosis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTA_NumEmbarazos = new javax.swing.JTextField();

        setBackground(new java.awt.Color(58, 71, 80));
        setForeground(new java.awt.Color(27, 38, 44));
        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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
                .addContainerGap(26, Short.MAX_VALUE))
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
        jLabel2.setText("Embarazo:");

        JTA_IDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 221));
        jLabel3.setText("SDG:");

        JTA_SDG.setBackground(new java.awt.Color(255, 253, 249));
        JTA_SDG.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_SDG.setForeground(new java.awt.Color(27, 38, 44));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 221));
        jLabel4.setText("FUM:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("Referido Paciente:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Anticonceptivos Orales:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("Dosis:");

        JD_FUM.setBackground(new java.awt.Color(255, 253, 249));
        JD_FUM.setForeground(new java.awt.Color(27, 38, 44));
        JD_FUM.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDAM.setEditable(false);
        JTA_IDAM.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDAM.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDAM.setForeground(new java.awt.Color(27, 38, 44));

        CB_Embarazo.setBackground(new java.awt.Color(255, 253, 249));
        CB_Embarazo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        CB_Embarazo.setForeground(new java.awt.Color(27, 38, 44));
        CB_Embarazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        JTA_ReferidoPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_ReferidoPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_ReferidoPaciente.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Anticonceptivo.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Anticonceptivo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Anticonceptivo.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Dosis.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Dosis.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Dosis.setForeground(new java.awt.Color(27, 38, 44));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(221, 221, 221));
        jLabel10.setText("Num Embarazos:");

        JTA_NumEmbarazos.setBackground(new java.awt.Color(255, 253, 249));
        JTA_NumEmbarazos.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_NumEmbarazos.setForeground(new java.awt.Color(27, 38, 44));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTA_NumEmbarazos)
                            .addComponent(JTA_Dosis)
                            .addComponent(JTA_Anticonceptivo)
                            .addComponent(JD_FUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTA_ReferidoPaciente)
                            .addComponent(JTA_SDG)
                            .addComponent(CB_Embarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTA_IDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(JTA_IDAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_Embarazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTA_SDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTA_ReferidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JD_FUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTA_Anticonceptivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTA_Dosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JTA_NumEmbarazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorDatosGinecologicos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_SDG.getText(), "SDG")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_ReferidoPaciente.getText(), "Referido por Paciente")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_Anticonceptivo.getText(), "Anticonceptivo")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_Dosis.getText(), "Dosis Anticonceptivo")
                || !ValidadorDatosGinecologicos.esNumeroEntero(JTA_NumEmbarazos.getText(), "Número de Embarazos")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorDatosGinecologicos.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el numero de embarazos es un número válido
        if (!ValidadorDatosGinecologicos.esNumeroEntero(JTA_NumEmbarazos.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorDatosGinecologicos.idPacienteExisteEnBaseDatos(idPaciente, "Pacientes", "ID Paciente")) {
            return;
        }

        // Verifica las fechas
        if (!ValidadorDatosGinecologicos.fechaNoNula(JD_FUM.getDate(), "Fecha de Última Menstruación")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar estos datos ginecológicos?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadDatosGinecologicos nuevo = new EntidadDatosGinecologicos(
                null, // El ID del antecedente será generado automáticamente
                idPaciente,
                CB_Embarazo.getSelectedItem().toString(),
                JTA_SDG.getText(),
                JTA_ReferidoPaciente.getText(),
                new java.sql.Date(JD_FUM.getDate().getTime()),
                JTA_Anticonceptivo.getText(),
                JTA_Dosis.getText(),
                Integer.parseInt(JTA_NumEmbarazos.getText()) // Número de embarazos
        );

        try {
            ControladorDatosGinecologicos.Alta(nuevo);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Datos ginecológicos registrados exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar los datos ginecológicos: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtiene el dato ginecológico seleccionado
        EntidadDatosGinecologicos seleccionado = getObjSeleccionado();

        // Verifica si hay un dato ginecológico seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un dato ginecológico para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorDatosGinecologicos.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "Datos_Ginecologicos", "ID del paciente")) {
            return; // Salir si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el dato ginecológico de " + seleccionado.getEmbarazoActual() + "?",
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
            // Llama al servicio para eliminar el dato ginecológico seleccionado de la base de datos
            ControladorDatosGinecologicos.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El dato ginecológico ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Acceso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del dato ginecológico
        refrescar();
    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Verifica si hay un dato ginecológico seleccionado
        EntidadDatosGinecologicos seleccionado = getObjSeleccionado();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un dato ginecológico para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorDatosGinecologicos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_SDG.getText(), "SDG")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_ReferidoPaciente.getText(), "Referido por Paciente")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_Anticonceptivo.getText(), "Anticonceptivo")
                || !ValidadorDatosGinecologicos.campoNoVacio(JTA_Dosis.getText(), "Dosis Anticonceptivo")
                || !ValidadorDatosGinecologicos.esNumeroEntero(JTA_NumEmbarazos.getText(), "Número de Embarazos")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorDatosGinecologicos.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el número de embarazos es un número válido
        if (!ValidadorDatosGinecologicos.esNumeroEntero(JTA_NumEmbarazos.getText(), "Número de Embarazos")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorDatosGinecologicos.idPacienteExisteEnBaseDatos(idPaciente, "Pacientes", "ID Paciente")) {
            return;
        }

        // Verifica las fechas
        if (!ValidadorDatosGinecologicos.fechaNoNula(JD_FUM.getDate(), "Fecha de Última Menstruación")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información ginecologica del paciente "+ seleccionado.getIdPaciente()+"?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Si todas las validaciones son correctas, actualiza el objeto existente
        seleccionado.setIdPaciente(idPaciente);
        seleccionado.setEmbarazoActual(CB_Embarazo.getSelectedItem().toString());
        seleccionado.setSdg(JTA_SDG.getText());
        seleccionado.setReferidoPorPaciente(JTA_ReferidoPaciente.getText());
        seleccionado.setAnticonceptivosOrales(JTA_Anticonceptivo.getText());
        seleccionado.setDosisAnticonceptivo(JTA_Dosis.getText());
        seleccionado.setFum(new java.sql.Date(JD_FUM.getDate().getTime()));
        seleccionado.setNumEmbarazos(Integer.parseInt(JTA_NumEmbarazos.getText())); // Número de embarazos

        try {
            ControladorDatosGinecologicos.Actualizar(seleccionado);

            // Muestra un mensaje de éxito si la actualización fue exitosa
            JOptionPane.showMessageDialog(this, "Datos ginecológicos actualizados exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos ginecológicos: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnEditar_ActionPerformed

    private void btnBuscaID_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaID_ActionPerformed
        try {
            // Valida si el campo de ID no está vacío
            if (!ValidadorDatosGinecologicos.campoNoVacio(JTA_BuscaID.getText(), "ID Dato Ginecologico")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idAntecedente;
            try {
                idAntecedente = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del Dato Ginecologico debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el antecedente médico existe en la base de datos usando la clase ValidadorDatos
            if (!ValidadorDatosGinecologicos.idGinecologicoExisteEnBaseDatos(idAntecedente, "Dato Ginecologico", "ID del Dato Ginecologico")) {
                return;
            }

            // Llama al método para obtener el antecedente médico por ID
            EntidadDatosGinecologicos antecedente = ControladorDatosGinecologicos.PedirDatoPorId(idAntecedente);

            // Verifica si se obtuvo el antecedente correctamente y actualiza la tabla
            if (antecedente != null) {
                ArrayList<EntidadDatosGinecologicos> datos = new ArrayList<>();
                datos.add(antecedente);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el antecedente, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron Dato Ginecologico con ese ID", "Dato Ginecologico no encontrado", JOptionPane.INFORMATION_MESSAGE);
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

        limpiarFormulario(); // Limpia los campos del formulario después de la búsqueda
    }//GEN-LAST:event_btnBuscaID_ActionPerformed

    private void btnBuscaPaciente_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPaciente_ActionPerformed
        try {
            // Valida si el campo de ID no está vacío
            if (!ValidadorDatosGinecologicos.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
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
            if (!ValidadorDatosGinecologicos.idPacienteExisteEnBaseDatos(idPaciente, "Dato Ginecologico", "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los antecedentes por ID del paciente
            ArrayList<EntidadDatosGinecologicos> antecedentes = ControladorDatosGinecologicos.PedirDatosPorIdPaciente(idPaciente);

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
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaDatosGinecologicos.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiarFormulario(); // Limpia los campos del formulario después de la búsqueda
    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Embarazo;
    private com.toedter.calendar.JDateChooser JD_FUM;
    private javax.swing.JTextField JTA_Anticonceptivo;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_Dosis;
    private javax.swing.JTextField JTA_IDAM;
    private javax.swing.JTextField JTA_IDPaciente;
    private javax.swing.JTextField JTA_NumEmbarazos;
    private javax.swing.JTextField JTA_ReferidoPaciente;
    private javax.swing.JTextField JTA_SDG;
    private javax.swing.JTable TBDatos;
    private javax.swing.JButton btnAgregar_;
    private javax.swing.JButton btnBuscaID_;
    private javax.swing.JButton btnBuscaPaciente_;
    private javax.swing.JButton btnEditar_;
    private javax.swing.JButton btnEliminar_;
    private javax.swing.JButton btnRefrescar_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
