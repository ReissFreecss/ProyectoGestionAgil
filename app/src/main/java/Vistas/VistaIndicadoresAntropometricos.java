/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorIndicadoresAntropometricos;
import Entidades.EntidadIndicadoresAntropometricos;
import ModelosTablas.ModeloTablaIndicadoresAntropometricos;
import Validatores.ValidadorIndicadoresAntropometricos;
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
public class VistaIndicadoresAntropometricos extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Indicadores Antropometricos
    private ModeloTablaIndicadoresAntropometricos model;

    // Variable para el objeto seleccionado de tipo EntidadIndicadoresAntropometricos
    private EntidadIndicadoresAntropometricos ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadIndicadoresAntropometricos getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de indicador antropométrico seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadIndicadoresAntropometricos ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDIndicadorAntropometrico.setText(String.valueOf(this.ObjSeleccionado.getIdIndicador())); // Mostrar el ID del indicador antropométrico
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente

            // Actualizar las medidas antropométricas en los spinners
            JSP_Peso.setValue(this.ObjSeleccionado.getPeso()); // Peso
            JSP_Estatura.setValue(this.ObjSeleccionado.getEstatura()); // Estatura
            JSP_CircunferenciaBrazo.setValue(this.ObjSeleccionado.getCircunferenciaBrazo()); // Circunferencia del brazo
            JSP_CircunferenciaCintura.setValue(this.ObjSeleccionado.getCircunferenciaCintura()); // Circunferencia de la cintura
            JSP_CircunferenciaCadera.setValue(this.ObjSeleccionado.getCircunferenciaCadera()); // Circunferencia de la cadera
            JSP_CircunferenciaMuslo.setValue(this.ObjSeleccionado.getCircunferenciaMuslo()); // Circunferencia del muslo

            // Actualizar la fecha en el campo de calendario (JDateChooser)
            JD_Fecha.setDate(this.ObjSeleccionado.getFecha()); // Fecha de medición
        } // Si no hay objeto seleccionado, limpiar los campos de texto
        else {
            limpiarFormulario();
        }
    }

    // Método para limpiar los campos del formulario de indicadores antropométricos
    private void limpiarFormulario() {
        JTA_IDIndicadorAntropometrico.setText(""); // Limpiar el campo ID de indicador antropométrico
        JTA_IDPaciente.setText(""); // Limpiar el campo ID de paciente
        JSP_Peso.setValue(0.0); // Limpiar el peso
        JSP_Estatura.setValue(0.0); // Limpiar la estatura
        JSP_CircunferenciaBrazo.setValue(0.0); // Limpiar la circunferencia del brazo
        JSP_CircunferenciaCintura.setValue(0.0); // Limpiar la circunferencia de la cintura
        JSP_CircunferenciaCadera.setValue(0.0); // Limpiar la circunferencia de la cadera
        JSP_CircunferenciaMuslo.setValue(0.0); // Limpiar la circunferencia del muslo
        JD_Fecha.setDate(null); // Limpiar la fecha de medición
    }

    // Método para refrescar los datos de la tabla de indicadores antropométricos
    public void refrescar() {
        try {
            // Obtiene todos los indicadores antropométricos desde el servicio
            ArrayList<EntidadIndicadoresAntropometricos> datos = ControladorIndicadoresAntropometricos.PedirTodos();

            // Establece los nuevos datos en el modelo de la tabla
            model.setDatos(datos);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            // Muestra un mensaje de error si ocurre un IOException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }
        limpiarFormulario();
    }

    // Constructor de la clase
    public VistaIndicadoresAntropometricos() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla
        model = new ModeloTablaIndicadoresAntropometricos();

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTA_IDIndicadorAntropometrico = new javax.swing.JTextField();
        JD_Fecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        JSP_CircunferenciaBrazo = new javax.swing.JSpinner();
        JSP_Estatura = new javax.swing.JSpinner();
        JSP_Peso = new javax.swing.JSpinner();
        JSP_CircunferenciaCintura = new javax.swing.JSpinner();
        JSP_CircunferenciaCadera = new javax.swing.JSpinner();
        JSP_CircunferenciaMuslo = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(58, 71, 80));
        setForeground(new java.awt.Color(27, 38, 44));
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
        jLabel2.setText("Fecha:");

        JTA_IDPaciente.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDPaciente.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDPaciente.setForeground(new java.awt.Color(27, 38, 44));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 221));
        jLabel3.setText("Peso:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 221));
        jLabel4.setText("Circunferencia brazo:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("Estatura:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Circunferencia cintura:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("Circunferencia cadera:");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDIndicadorAntropometrico.setEditable(false);
        JTA_IDIndicadorAntropometrico.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDIndicadorAntropometrico.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N

        JD_Fecha.setBackground(new java.awt.Color(255, 253, 249));
        JD_Fecha.setForeground(new java.awt.Color(27, 38, 44));
        JD_Fecha.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(221, 221, 221));
        jLabel7.setText("Circunferencia muslo:");

        JSP_CircunferenciaBrazo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_CircunferenciaBrazo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_Estatura.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Estatura.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_Peso.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Peso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_CircunferenciaCintura.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_CircunferenciaCintura.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_CircunferenciaCadera.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_CircunferenciaCadera.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_CircunferenciaMuslo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_CircunferenciaMuslo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

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
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSP_CircunferenciaMuslo)
                    .addComponent(JSP_CircunferenciaCadera)
                    .addComponent(JSP_CircunferenciaCintura)
                    .addComponent(JSP_CircunferenciaBrazo)
                    .addComponent(JSP_Estatura)
                    .addComponent(JSP_Peso)
                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTA_IDIndicadorAntropometrico, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(JTA_IDIndicadorAntropometrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JSP_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JSP_Estatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JSP_CircunferenciaBrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JSP_CircunferenciaCintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JSP_CircunferenciaCadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JSP_CircunferenciaMuslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (!ValidadorIndicadoresAntropometricos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorIndicadoresAntropometricos.campoNoVacio(JSP_Peso.getValue().toString(), "Peso")
                || JD_Fecha.getDate() == null
                || !ValidadorIndicadoresAntropometricos.campoNoVacio(JSP_Estatura.getValue().toString(), "Estatura")) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorIndicadoresAntropometricos.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorIndicadoresAntropometricos.idPacienteExisteEnBaseDatos(idPaciente, "Pacientes", "ID Paciente")) {
            return;
        }

        // Verifica la fecha
        if (!ValidadorIndicadoresAntropometricos.fechaNoNula(JD_Fecha.getDate(), "Fecha de Registro")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar este indicador antropométrico?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadIndicadoresAntropometricos nuevo = new EntidadIndicadoresAntropometricos(
                null, // El ID será generado automáticamente
                idPaciente,
                new java.sql.Date(JD_Fecha.getDate().getTime()),
                Double.parseDouble(JSP_Peso.getValue().toString()),
                Double.parseDouble(JSP_Estatura.getValue().toString()),
                Double.parseDouble(JSP_CircunferenciaBrazo.getValue().toString()),
                Double.parseDouble(JSP_CircunferenciaCintura.getValue().toString()),
                Double.parseDouble(JSP_CircunferenciaCadera.getValue().toString()),
                Double.parseDouble(JSP_CircunferenciaMuslo.getValue().toString())
        );

        try {
            ControladorIndicadoresAntropometricos.Alta(nuevo);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Indicador antropométrico registrado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el indicador antropométrico: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaIndicadoresAntropometricos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaIndicadoresAntropometricos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtiene el indicador antropométrico seleccionado
        EntidadIndicadoresAntropometricos seleccionado = getObjSeleccionado();

        // Verifica si hay un indicador antropométrico seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un indicador antropométrico para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorIndicadoresAntropometricos.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "Indicadores Antropométricos", "ID del paciente")) {
            return; // Salir si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el indicador antropométrico de la fecha " + seleccionado.getFecha() + "?",
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
            // Llama al servicio para eliminar el indicador antropométrico seleccionado de la base de datos
            ControladorIndicadoresAntropometricos.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El indicador antropométrico ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del indicador antropométrico
        refrescar();
    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        /// Obtiene el indicador antropométrico seleccionado
        EntidadIndicadoresAntropometricos seleccionado = getObjSeleccionado();

        // Verifica si hay un indicador antropométrico seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un indicador antropométrico para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de campos vacíos usando ValidadorDatos
        if (!ValidadorIndicadoresAntropometricos.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorIndicadoresAntropometricos.campoNoVacio(JSP_Peso.getValue().toString(), "Peso")
                || !ValidadorIndicadoresAntropometricos.campoNoVacio(JSP_Estatura.getValue().toString(), "Altura")
                || JD_Fecha.getDate() == null) {
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
        if (!ValidadorIndicadoresAntropometricos.idPacienteExisteEnBaseDatos(idPaciente, "Paciente", "ID del paciente")) {
            return; // Sale si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información de los indicadores antropométricos del paciente " + seleccionado.getIdPaciente() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos del indicador antropométrico seleccionado con los valores de los campos de texto y los componentes gráficos
        seleccionado.setIdPaciente(Integer.parseInt(JTA_IDPaciente.getText())); // Asignar el ID del paciente
        seleccionado.setFecha(new java.sql.Date(JD_Fecha.getDate().getTime()));

        // Obtener y asignar los valores desde los JSpinners para las mediciones antropométricas
        seleccionado.setPeso((Double) JSP_Peso.getValue()); // Asignar el peso desde el JSpinner
        seleccionado.setEstatura((Double) JSP_Estatura.getValue()); // Asignar la estatura desde el JSpinner
        seleccionado.setCircunferenciaBrazo((Double) JSP_CircunferenciaBrazo.getValue()); // Asignar circunferencia de brazo
        seleccionado.setCircunferenciaCadera((Double) JSP_CircunferenciaCadera.getValue()); // Asignar circunferencia de cadera
        seleccionado.setCircunferenciaCintura((Double) JSP_CircunferenciaCintura.getValue()); // Asignar circunferencia de cintura
        seleccionado.setCircunferenciaMuslo((Double) JSP_CircunferenciaMuslo.getValue()); // Asignar circunferencia de muslo

        try {
            // Llama al servicio para actualizar el indicador antropométrico en la base de datos
            ControladorIndicadoresAntropometricos.Actualizar(seleccionado);
            JOptionPane.showMessageDialog(this, "Los datos de los indicadores antropométricos han sido actualizados con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
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
            if (!ValidadorIndicadoresAntropometricos.campoNoVacio(JTA_BuscaID.getText(), "ID Indicador Antropométrico")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idIndicadorAntropometrico;
            try {
                idIndicadorAntropometrico = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del indicador antropométrico debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el indicador antropométrico existe en la base de datos usando la clase ValidadorDatos
            if (!ValidadorIndicadoresAntropometricos.idExisteEnBaseDatos(idIndicadorAntropometrico, "Indicadores Antropométricos", "ID del indicador antropométrico")) {
                return;
            }

            // Llama al método para obtener el indicador antropométrico por ID
            EntidadIndicadoresAntropometricos indicador = ControladorIndicadoresAntropometricos.PedirIndicadorPorId(idIndicadorAntropometrico);

            // Verifica si se obtuvo el indicador correctamente y actualiza la tabla
            if (indicador != null) {
                ArrayList<EntidadIndicadoresAntropometricos> datos = new ArrayList<>();
                datos.add(indicador);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el indicador, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron indicadores antropométricos con ese ID", "Indicador no encontrado", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorIndicadoresAntropometricos.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
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
            if (!ValidadorIndicadoresAntropometricos.idPacienteExisteEnBaseDatos(idPaciente, "Indicadores Antropométricos", "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los indicadores antropométricos por ID del paciente
            ArrayList<EntidadIndicadoresAntropometricos> indicadores = ControladorIndicadoresAntropometricos.PedirIndicadoresPorIdPaciente(idPaciente);

            // Si se encuentran indicadores, actualiza los datos en la tabla
            if (!indicadores.isEmpty()) {
                model.setDatos(indicadores);
            } else {
                // Si no se encuentran indicadores, muestra un mensaje
                JOptionPane.showMessageDialog(this, "No se encontraron indicadores para el paciente con ese ID", "Paciente no encontrado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Muestra un mensaje de error si la conexión es nula o hay otro problema
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaIndicadoresAntropometricos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaIndicadoresAntropometricos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Limpia los campos del formulario después de la búsqueda
        limpiarFormulario();

    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JD_Fecha;
    private javax.swing.JSpinner JSP_CircunferenciaBrazo;
    private javax.swing.JSpinner JSP_CircunferenciaCadera;
    private javax.swing.JSpinner JSP_CircunferenciaCintura;
    private javax.swing.JSpinner JSP_CircunferenciaMuslo;
    private javax.swing.JSpinner JSP_Estatura;
    private javax.swing.JSpinner JSP_Peso;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_IDIndicadorAntropometrico;
    private javax.swing.JTextField JTA_IDPaciente;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
