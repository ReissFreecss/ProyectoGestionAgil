/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorIndicadoresDieteticos;
import Entidades.EntidadIndicadoresDieteticos;
import ModelosTablas.ModeloTablaIndicadoresDieteticos;
import Validatores.ValidadorIndicadoresDieteticos;
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
public class VistaIndicadoresDieteticos extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Indicadores Dietéticos
    private ModeloTablaIndicadoresDieteticos model;

    // Variable para el objeto seleccionado de tipo EntidadIndicadoresDieteticos
    private EntidadIndicadoresDieteticos ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadIndicadoresDieteticos getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de indicador dietético seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadIndicadoresDieteticos ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDIndicaorDietetico.setText(String.valueOf(this.ObjSeleccionado.getIdIndicadoresDieteticos())); // Mostrar el ID de indicador dietético
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente
            JTA_PreparadorAlimentos.setText(this.ObjSeleccionado.getPreparadorAlimentos()); // Preparador de alimentos
            JTA_HoraApetito.setText(this.ObjSeleccionado.getHoraApetito()); // Hora de apetito
            JTA_AlimentosPreferidos.setText(this.ObjSeleccionado.getAlimentosPreferidos()); // Alimentos preferidos
            JTA_AlimentosNoPreferidos.setText(this.ObjSeleccionado.getAlimentosNoPreferidos()); // Alimentos no preferidos
            JTA_Suplemento.setText(this.ObjSeleccionado.getSuplemento()); // Suplemento
            JTA_DosisSuplemento.setText(this.ObjSeleccionado.getDosisSuplemento()); // Dosis del suplemento
            JSP_Agua.setValue(this.ObjSeleccionado.getAguaConsumida()); // Agua consumida
            JSP_Leche.setValue(this.ObjSeleccionado.getLecheConsumida()); // Leche consumida
            JSP_Refresco.setValue(this.ObjSeleccionado.getRefrescoConsumido()); // Refresco consumido
            JTA_MediacamentoPeso.setText(this.ObjSeleccionado.getMedicamentosBajarPeso()); // Medicamentos para bajar de peso
        } else {
            limpiarFormulario(); // Si no hay objeto seleccionado, limpiar los campos de texto
        }
    }

    // Método para limpiar los campos del formulario de indicadores dietéticos
    private void limpiarFormulario() {
        JTA_IDIndicaorDietetico.setText(""); // Limpiar el campo ID de indicador dietético
        JTA_IDPaciente.setText(""); // Limpiar el campo ID de paciente
        JTA_PreparadorAlimentos.setText(""); // Limpiar el campo preparador de alimentos
        JTA_HoraApetito.setText(""); // Limpiar el campo hora de apetito
        JTA_AlimentosPreferidos.setText(""); // Limpiar el campo alimentos preferidos
        JTA_AlimentosNoPreferidos.setText(""); // Limpiar el campo alimentos no preferidos
        JTA_Suplemento.setText(""); // Limpiar el campo suplemento
        JTA_DosisSuplemento.setText(""); // Limpiar el campo dosis de suplemento
        JSP_Agua.setValue(0); // Limpiar el valor de agua consumida
        JSP_Leche.setValue(0); // Limpiar el valor de leche consumida
        JSP_Refresco.setValue(0); // Limpiar el valor de refresco consumido
        JTA_MediacamentoPeso.setText(""); // Limpiar el campo de medicamentos para bajar de peso
    }

    // Método para refrescar los datos de la tabla de caracteristicas
    public void refrescar() {
        try {
            // Obtiene todos los caracteristicas desde el servicio
            ArrayList<EntidadIndicadoresDieteticos> datos = ControladorIndicadoresDieteticos.PedirTodos();

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
    public VistaIndicadoresDieteticos() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla de videojuegos
        model = new ModeloTablaIndicadoresDieteticos();

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
        JTA_PreparadorAlimentos = new javax.swing.JTextField();
        JTA_IDPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTA_HoraApetito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTA_IDIndicaorDietetico = new javax.swing.JTextField();
        JTA_AlimentosPreferidos = new javax.swing.JTextField();
        JTA_AlimentosNoPreferidos = new javax.swing.JTextField();
        JTA_Suplemento = new javax.swing.JTextField();
        JTA_DosisSuplemento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JSP_Agua = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        JSP_Refresco = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        JSP_Leche = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        JTA_MediacamentoPeso = new javax.swing.JTextField();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel2.setText("Preparador Alimentos:");

        JTA_PreparadorAlimentos.setBackground(new java.awt.Color(255, 253, 249));
        JTA_PreparadorAlimentos.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_PreparadorAlimentos.setForeground(new java.awt.Color(27, 38, 44));

        JTA_IDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 221));
        jLabel3.setText("Hora Apetito:");

        JTA_HoraApetito.setBackground(new java.awt.Color(255, 253, 249));
        JTA_HoraApetito.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_HoraApetito.setForeground(new java.awt.Color(27, 38, 44));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 221));
        jLabel4.setText("Alimentos No Preferidos:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("Alimentos Preferidos:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Suplemento:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("Dosis Suplemento:");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDIndicaorDietetico.setEditable(false);
        JTA_IDIndicaorDietetico.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDIndicaorDietetico.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDIndicaorDietetico.setForeground(new java.awt.Color(27, 38, 44));

        JTA_AlimentosPreferidos.setBackground(new java.awt.Color(255, 253, 249));
        JTA_AlimentosPreferidos.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_AlimentosPreferidos.setForeground(new java.awt.Color(27, 38, 44));
        JTA_AlimentosPreferidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTA_AlimentosPreferidosActionPerformed(evt);
            }
        });

        JTA_AlimentosNoPreferidos.setBackground(new java.awt.Color(255, 253, 249));
        JTA_AlimentosNoPreferidos.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_AlimentosNoPreferidos.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Suplemento.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Suplemento.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Suplemento.setForeground(new java.awt.Color(27, 38, 44));

        JTA_DosisSuplemento.setBackground(new java.awt.Color(255, 253, 249));
        JTA_DosisSuplemento.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_DosisSuplemento.setForeground(new java.awt.Color(27, 38, 44));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(221, 221, 221));
        jLabel7.setText("Agua Consumida:");

        JSP_Agua.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Agua.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(221, 221, 221));
        jLabel10.setText("Refresco Consumido:");

        JSP_Refresco.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Refresco.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(221, 221, 221));
        jLabel11.setText("Leche Consumido:");

        JSP_Leche.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Leche.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(221, 221, 221));
        jLabel12.setText("Medicameno para peso:");

        JTA_MediacamentoPeso.setBackground(new java.awt.Color(255, 253, 249));
        JTA_MediacamentoPeso.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_MediacamentoPeso.setForeground(new java.awt.Color(27, 38, 44));

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
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTA_AlimentosNoPreferidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTA_PreparadorAlimentos)
                            .addComponent(JTA_HoraApetito)
                            .addComponent(JTA_AlimentosPreferidos)
                            .addComponent(JTA_Suplemento)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTA_IDIndicaorDietetico, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JTA_DosisSuplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTA_MediacamentoPeso))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSP_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSP_Refresco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSP_Leche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(JTA_IDIndicaorDietetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTA_PreparadorAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTA_HoraApetito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JTA_AlimentosPreferidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addComponent(JTA_AlimentosNoPreferidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTA_Suplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTA_DosisSuplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(JTA_MediacamentoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(JSP_Leche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(JSP_Refresco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(JSP_Agua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorIndicadoresDieteticos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_PreparadorAlimentos.getText(), "Preparador de alimentos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_HoraApetito.getText(), "Hora de apetito")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_AlimentosPreferidos.getText(), "Alimentos preferidos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_AlimentosNoPreferidos.getText(), "Alimentos no preferidos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_Suplemento.getText(), "Suplemento")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_DosisSuplemento.getText(), "Dosis del suplemento")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_MediacamentoPeso.getText(), "Medicamento para bajar de peso")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorIndicadoresDieteticos.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorIndicadoresDieteticos.idPacienteExisteEnBaseDatos(idPaciente, "Pacientes", "ID Paciente")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar este indicador dietético?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadIndicadoresDieteticos nuevo = new EntidadIndicadoresDieteticos(
                null, // El ID de los indicadores será generado automáticamente
                idPaciente,
                JTA_PreparadorAlimentos.getText(),
                JTA_HoraApetito.getText(),
                JTA_AlimentosPreferidos.getText(),
                JTA_AlimentosNoPreferidos.getText(),
                JTA_Suplemento.getText(),
                JTA_DosisSuplemento.getText(),
                (Double) JSP_Agua.getValue(),
                (Double) JSP_Refresco.getValue(),
                (Double) JSP_Leche.getValue(),
                JTA_MediacamentoPeso.getText() // Medicamentos para bajar de peso
        );

        try {
            ControladorIndicadoresDieteticos.Alta(nuevo);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Indicador dietético registrado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el indicador dietético: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaIndicadoresDieteticos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaIndicadoresDieteticos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        EntidadIndicadoresDieteticos seleccionado = getObjSeleccionado();

        // Verifica si hay un indicador dietético seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un indicador dietético para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorIndicadoresDieteticos.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "Indicadores Dietéticos", "ID del paciente")) {
            return; // Salir si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el indicador dietético con ID " + seleccionado.getIdIndicadoresDieteticos()
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
            // Llama al servicio para eliminar el indicador dietético seleccionado de la base de datos
            ControladorIndicadoresDieteticos.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El indicador dietético ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del indicador dietético
        refrescar();
    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Obtiene el indicador dietético seleccionado
        EntidadIndicadoresDieteticos seleccionado = getObjSeleccionado();

        // Verifica si hay un indicador dietético seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un indicador dietético para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorIndicadoresDieteticos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_IDIndicaorDietetico.getText(), "ID Indicador Dietético")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_PreparadorAlimentos.getText(), "Preparador de alimentos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_HoraApetito.getText(), "Hora de apetito")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_AlimentosPreferidos.getText(), "Alimentos preferidos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_AlimentosNoPreferidos.getText(), "Alimentos no preferidos")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_Suplemento.getText(), "Suplemento")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_DosisSuplemento.getText(), "Dosis del suplemento")
                || !ValidadorIndicadoresDieteticos.campoNoVacio(JTA_MediacamentoPeso.getText(), "Medicamentos para bajar de peso")) {
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
        if (!ValidadorIndicadoresDieteticos.idPacienteExisteEnBaseDatos(idPaciente, "Paciente", "ID del paciente")) {
            return; // Sale si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información del indicador dietético " + seleccionado.getIdIndicadoresDieteticos()
                + " del paciente " + seleccionado.getIdPaciente() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos del indicador dietético seleccionado con los valores de los campos de texto
        seleccionado.setIdPaciente(idPaciente); // Actualiza el ID del paciente
        seleccionado.setPreparadorAlimentos(JTA_PreparadorAlimentos.getText()); // Actualiza el preparador de alimentos
        seleccionado.setHoraApetito(JTA_HoraApetito.getText()); // Actualiza la hora de apetito
        seleccionado.setAlimentosPreferidos(JTA_AlimentosPreferidos.getText()); // Actualiza los alimentos preferidos
        seleccionado.setAlimentosNoPreferidos(JTA_AlimentosNoPreferidos.getText()); // Actualiza los alimentos no preferidos
        seleccionado.setSuplemento(JTA_Suplemento.getText()); // Actualiza el suplemento
        seleccionado.setDosisSuplemento(JTA_DosisSuplemento.getText()); // Actualiza la dosis del suplemento

        // Actualiza los valores de los spinners para el agua, leche y refresco consumidos
        seleccionado.setAguaConsumida((double) JSP_Agua.getValue()); // Actualiza la cantidad de agua consumida
        seleccionado.setLecheConsumida((double) JSP_Leche.getValue()); // Actualiza la cantidad de leche consumida
        seleccionado.setRefrescoConsumido((double) JSP_Refresco.getValue()); // Actualiza la cantidad de refresco consumido

        // Actualiza los medicamentos para bajar de peso
        seleccionado.setMedicamentosBajarPeso(JTA_MediacamentoPeso.getText());

        try {
            // Llama al servicio para actualizar el indicador dietético en la base de datos
            ControladorIndicadoresDieteticos.Actualizar(seleccionado);
            JOptionPane.showMessageDialog(this, "Los datos del indicador dietético han sido actualizados con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorIndicadoresDieteticos.campoNoVacio(JTA_BuscaID.getText(), "ID Indicador Dietético")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idIndicadorDietetico;
            try {
                idIndicadorDietetico = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del indicador dietético debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el indicador dietético existe en la base de datos
            if (!ValidadorIndicadoresDieteticos.idExisteEnBaseDatos(idIndicadorDietetico, "Consumo de Sustancias", "ID del consumo de sustancia")) {
                return;
            }

            // Llama al método correcto para obtener el indicador dietético por ID
            EntidadIndicadoresDieteticos indicador = ControladorIndicadoresDieteticos.PedirIndicadorPorId(idIndicadorDietetico);

            // Verifica si se obtuvo el indicador dietético correctamente y actualiza la tabla
            if (indicador != null) {
                ArrayList<EntidadIndicadoresDieteticos> datos = new ArrayList<>();
                datos.add(indicador);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el indicador, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron indicadores dietéticos con ese ID", "Indicador no encontrado", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorIndicadoresDieteticos.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
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
            if (!ValidadorIndicadoresDieteticos.idPacienteExisteEnBaseDatos(idPaciente, "Antecedentes Médicos", "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los antecedentes por ID del paciente
            ArrayList<EntidadIndicadoresDieteticos> antecedentes = ControladorIndicadoresDieteticos.PedirPorIdPaciente(idPaciente);

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
            Logger.getLogger(VistaIndicadoresDieteticos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaIndicadoresDieteticos.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiarFormulario(); // Limpia los campos del formulario después de la búsqueda
    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed

    private void JTA_AlimentosPreferidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTA_AlimentosPreferidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTA_AlimentosPreferidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner JSP_Agua;
    private javax.swing.JSpinner JSP_Leche;
    private javax.swing.JSpinner JSP_Refresco;
    private javax.swing.JTextField JTA_AlimentosNoPreferidos;
    private javax.swing.JTextField JTA_AlimentosPreferidos;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_DosisSuplemento;
    private javax.swing.JTextField JTA_HoraApetito;
    private javax.swing.JTextField JTA_IDIndicaorDietetico;
    private javax.swing.JTextField JTA_IDPaciente;
    private javax.swing.JTextField JTA_MediacamentoPeso;
    private javax.swing.JTextField JTA_PreparadorAlimentos;
    private javax.swing.JTextField JTA_Suplemento;
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
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
