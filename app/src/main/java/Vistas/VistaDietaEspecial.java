/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorDietaEspecial;
import Entidades.EntidadDietaEspecial;
import ModelosTablas.ModeloTablaDietaEspecial;
import Validatores.ValidadorDietaEspecial;
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
public class VistaDietaEspecial extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Dieta Especial
    private ModeloTablaDietaEspecial model;

    // Variable para el objeto seleccionado de tipo EntidadDietaEspecial
    private EntidadDietaEspecial ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadDietaEspecial getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de dieta especial seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadDietaEspecial ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDDietaEspecial.setText(String.valueOf(this.ObjSeleccionado.getIdDietaEspecial())); // Mostrar el ID de la dieta especial
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente
            JTA_DietaEspecial.setText(this.ObjSeleccionado.getDietaEspecial()); // Dieta especial
            JTA_Tipo.setText(this.ObjSeleccionado.getTipoDieta()); // Tipo de dieta
            JTA_Razon.setText(this.ObjSeleccionado.getRazonDietaEspecial()); // Razón de la dieta
            JTA_Resultado.setText(this.ObjSeleccionado.getResultadoDietaEspecial()); // Resultado de la dieta
            JTA_Tiempo.setText(this.ObjSeleccionado.getTiempoDietaEspecial()); // Tiempo de la dieta

            // Aquí puedes añadir otros campos adicionales según sea necesario
        } // Si no hay objeto seleccionado, limpiar los campos de texto
        else {
            limpiarFormulario();
        }
    }

    // Método para limpiar los campos del formulario de dieta especial
    private void limpiarFormulario() {
        JTA_IDDietaEspecial.setText(""); // Limpiar el campo ID de dieta especial
        JTA_IDPaciente.setText(""); // Limpiar el campo ID de paciente
        JTA_DietaEspecial.setText(""); // Limpiar el campo de dieta especial
        JTA_Tipo.setText(""); // Limpiar el campo tipo de dieta
        JTA_Razon.setText(""); // Limpiar el campo razón de la dieta
        JTA_Resultado.setText(""); // Limpiar el campo resultado de la dieta
        JTA_Tiempo.setText(""); // Limpiar el campo tiempo de la dieta
    }

    // Método para refrescar los datos de la tabla de caracteristicas
    public void refrescar() {
        try {
            // Obtiene todos los caracteristicas desde el servicio
            ArrayList<EntidadDietaEspecial> datos = ControladorDietaEspecial.PedirTodos();

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
    public VistaDietaEspecial() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla
        model = new ModeloTablaDietaEspecial();

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
        JTA_DietaEspecial = new javax.swing.JTextField();
        JTA_IDPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTA_Tipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTA_IDDietaEspecial = new javax.swing.JTextField();
        JTA_Tiempo = new javax.swing.JTextField();
        JTA_Razon = new javax.swing.JTextField();
        JTA_Resultado = new javax.swing.JTextField();
        JTA_Apego = new javax.swing.JTextField();

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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(82, 97, 107));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(221, 221, 221));
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.setInheritsPopupMenu(true);

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(221, 221, 221));
        jLabel1.setText("ID Paciente:");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(221, 221, 221));
        jLabel2.setText("Dieta Especial:");

        JTA_DietaEspecial.setBackground(new java.awt.Color(255, 253, 249));
        JTA_DietaEspecial.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_DietaEspecial.setForeground(new java.awt.Color(27, 38, 44));

        JTA_IDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 221));
        jLabel3.setText("Tipo:");

        JTA_Tipo.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Tipo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Tipo.setForeground(new java.awt.Color(27, 38, 44));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 221));
        jLabel4.setText("Razon de dieta:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("Tiempo:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Resultado de dieta:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("Apego a la dieta:");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDDietaEspecial.setEditable(false);
        JTA_IDDietaEspecial.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDDietaEspecial.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDDietaEspecial.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Tiempo.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Tiempo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Tiempo.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Razon.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Razon.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Razon.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Resultado.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Resultado.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Resultado.setForeground(new java.awt.Color(27, 38, 44));

        JTA_Apego.setBackground(new java.awt.Color(255, 253, 249));
        JTA_Apego.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_Apego.setForeground(new java.awt.Color(27, 38, 44));
        JTA_Apego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTA_ApegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTA_DietaEspecial)
                    .addComponent(JTA_Tipo)
                    .addComponent(JTA_Tiempo)
                    .addComponent(JTA_Razon)
                    .addComponent(JTA_Resultado)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTA_IDDietaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JTA_Apego))
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
                        .addComponent(JTA_IDDietaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTA_DietaEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTA_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTA_Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTA_Razon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTA_Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTA_Apego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorDietaEspecial.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_DietaEspecial.getText(), "Enfermedad")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Tipo.getText(), "Medicamentos")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Tiempo.getText(), "Razón")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Razon.getText(), "Razón")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Resultado.getText(), "Resultado")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Apego.getText(), "Apego")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorDietaEspecial.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorDietaEspecial.idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar esta dieta especial?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadDietaEspecial nuevaDieta = new EntidadDietaEspecial(
                null, // El ID de la dieta especial será generado automáticamente
                idPaciente,
                JTA_DietaEspecial.getText(),
                JTA_Tipo.getText(),
                JTA_Tiempo.getText(),
                JTA_Razon.getText(),
                JTA_Resultado.getText(),
                JTA_Apego.getText()
        );

        try {
            ControladorDietaEspecial.Alta(nuevaDieta);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Dieta especial registrada exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la dieta especial: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaDietaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaDietaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtiene el antecedente médico seleccionado
        EntidadDietaEspecial seleccionado = getObjSeleccionado();

        // Verifica si hay un antecedente médico seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un antecedente médico para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return; // Sale si no se ha seleccionado un antecedente
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorDietaEspecial.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "Antecedentes Médicos")) {
            JOptionPane.showMessageDialog(this, "El ID del paciente no existe en la base de datos.", "ID no encontrado", JOptionPane.WARNING_MESSAGE);
            return; // Sale si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el antecedente médico de " + seleccionado.getIdDietaEspecial() + "?",
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
            // Llama al servicio para eliminar el antecedente médico seleccionado de la base de datos
            ControladorDietaEspecial.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El antecedente médico ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Acceso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Captura cualquier otro tipo de excepción
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del antecedente médico
        refrescar();

    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Obtiene la dieta especial seleccionada
        EntidadDietaEspecial seleccionado = getObjSeleccionado();

        // Verifica si hay una dieta especial seleccionada
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una dieta especial para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return; // Sale si no se ha seleccionado una dieta
        }

        // Validación de campos vacíos usando ValidadorDatos
        if (!ValidadorDietaEspecial.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_DietaEspecial.getText(), "Dieta Especial")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Tipo.getText(), "Tipo de dieta")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Tiempo.getText(), "Tiempo de dieta")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Razon.getText(), "Razón")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Resultado.getText(), "Resultado")
                || !ValidadorDietaEspecial.campoNoVacio(JTA_Apego.getText(), "Apego")) {
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
        if (!ValidadorDietaEspecial.idPacienteExisteEnBaseDatos(idPaciente, "Paciente")) {
            return; // Sale si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información de la dieta especial del paciente " + seleccionado.getIdPaciente() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos de la dieta especial seleccionada con los valores de los campos de texto
        seleccionado.setIdPaciente(idPaciente);
        seleccionado.setDietaEspecial(JTA_DietaEspecial.getText());
        seleccionado.setTipoDieta(JTA_Tipo.getText());
        seleccionado.setTiempoDietaEspecial(JTA_Tiempo.getText());
        seleccionado.setRazonDietaEspecial(JTA_Razon.getText());
        seleccionado.setResultadoDietaEspecial(JTA_Resultado.getText());
        seleccionado.setApegoDieta(JTA_Apego.getText());

        try {
            // Llama al servicio para actualizar la dieta especial en la base de datos
            ControladorDietaEspecial.Actualizar(seleccionado);
            JOptionPane.showMessageDialog(this, "Los datos de la dieta especial han sido actualizados con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para mostrar los cambios
        refrescar();

    }//GEN-LAST:event_btnEditar_ActionPerformed

    private void btnBuscaID_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaID_ActionPerformed
        try {
            // Valida si el campo de ID no está vacío
            if (!ValidadorDietaEspecial.campoNoVacio(JTA_BuscaID.getText(), "ID Antecedente Médico")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idAntecedente;
            try {
                idAntecedente = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del antecedente médico debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el antecedente médico existe en la base de datos usando la clase ValidadorDatos
            if (!ValidadorDietaEspecial.idExisteEnBaseDatos(idAntecedente, "Antecedentes Médicos", "ID del antecedente médico")) {
                return;
            }

            // Llama al método para obtener el antecedente médico por ID
            EntidadDietaEspecial antecedente = ControladorDietaEspecial.PedirDietaPorId(idAntecedente);

            // Verifica si se obtuvo el antecedente correctamente y actualiza la tabla
            if (antecedente != null) {
                ArrayList<EntidadDietaEspecial> datos = new ArrayList<>();
                datos.add(antecedente);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el antecedente, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron dieta especial con ese ID", "Paciente no encontrado", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorDietaEspecial.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
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
            if (!ValidadorDietaEspecial.idPacienteExisteEnBaseDatos(idPaciente, "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los antecedentes por ID del paciente
            ArrayList<EntidadDietaEspecial> antecedentes = ControladorDietaEspecial.PedirDietasPorIdPaciente(idPaciente);

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
            Logger.getLogger(VistaDietaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaDietaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpiarFormulario(); // Limpia los campos del formulario después de la búsqueda
    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed

    private void JTA_ApegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTA_ApegoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTA_ApegoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTA_Apego;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_DietaEspecial;
    private javax.swing.JTextField JTA_IDDietaEspecial;
    private javax.swing.JTextField JTA_IDPaciente;
    private javax.swing.JTextField JTA_Razon;
    private javax.swing.JTextField JTA_Resultado;
    private javax.swing.JTextField JTA_Tiempo;
    private javax.swing.JTextField JTA_Tipo;
    private javax.swing.JTable TBDatos;
    private javax.swing.JButton btnAgregar_;
    private javax.swing.JButton btnBuscaID_;
    private javax.swing.JButton btnBuscaPaciente_;
    private javax.swing.JButton btnEditar_;
    private javax.swing.JButton btnEliminar_;
    private javax.swing.JButton btnRefrescar_;
    private javax.swing.JLabel jLabel1;
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
