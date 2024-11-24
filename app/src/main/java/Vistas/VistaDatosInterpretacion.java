/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorDatosInterpretacion;
import Entidades.EntidadDatosInterpretacion;
import ModelosTablas.ModeloTablaDatosInterpretacion;
import Validatores.ValidadorDatosInterpretacion;
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
public class VistaDatosInterpretacion extends javax.swing.JPanel {

    // Variable para el modelo de la tabla de Datos de Interpretación
    private ModeloTablaDatosInterpretacion model;

    // Variable para el objeto seleccionado de tipo EntidadDatosInterpretacion
    private EntidadDatosInterpretacion ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadDatosInterpretacion getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto de interpretación seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadDatosInterpretacion ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_IDDatosInterpretacion.setText(String.valueOf(this.ObjSeleccionado.getIdDatosInterpretacion())); // Mostrar el ID de interpretación
            JTA_IDPaciente.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente

            // Actualizar las medidas en los spinners
            JSP_Mes.setValue(this.ObjSeleccionado.getMes());
            JSP_Peso.setValue(this.ObjSeleccionado.getPeso()); // Peso
            JSP_Cintura.setValue(this.ObjSeleccionado.getCintura());
            JSP_PorcentajeGrasa.setValue(this.ObjSeleccionado.getPorcentajeGrasaCorporal()); // Porcentaje de grasa
            JSP_MasaMuscular.setValue(this.ObjSeleccionado.getMasaMuscular()); // Masa muscular
            JSP_MasaOsea.setValue(this.ObjSeleccionado.getMasaOsea()); // Masa ósea
            JSP_IMC.setValue(this.ObjSeleccionado.getImc()); // IMC
            JSP_IngestaKilocalorias.setValue(this.ObjSeleccionado.getIngestaKilocalorias()); // Ingesta calórica
            JSP_GrasaViceral.setValue(this.ObjSeleccionado.getGrasaVisceral()); // Grasa visceral
            JSP_AguaCorporal.setValue(this.ObjSeleccionado.getPorcentajeAguaCorporal()); // Agua corporal
            JSP_EdadMetabolica.setValue(this.ObjSeleccionado.getEdadMetabolica()); // Edad metabólica
            JSP_Bicipital.setValue(this.ObjSeleccionado.getPliegueBicipital()); // Pliegue bicipital
            JSP_Tricipital.setValue(this.ObjSeleccionado.getPliegueTricipital()); // Pliegue tricipital
            JSP_Subescapular.setValue(this.ObjSeleccionado.getPliegueSubescapular()); // Pliegue subescapular
            JSP_Suprailiaco.setValue(this.ObjSeleccionado.getPliegueSuprailiaco()); // Pliegue suprailiaco

            // Actualizar la fecha en el campo de calendario (JDateChooser)
            JD_Fecha.setDate(this.ObjSeleccionado.getFecha()); // Fecha de medición
        } else {
            // Si no hay objeto seleccionado, limpiar los campos de texto
            limpiarFormulario();
        }
    }

    // Método para limpiar los campos del formulario de datos de interpretación
    private void limpiarFormulario() {
        JTA_IDDatosInterpretacion.setText(""); // Limpiar el campo ID de interpretación
        JTA_IDPaciente.setText(""); // Limpiar el campo ID de paciente
        JSP_Mes.setValue(0.0); // Limpiar el mes
        JSP_Peso.setValue(0.0); // Limpiar el peso
        JSP_Cintura.setValue(0.0);
        JSP_PorcentajeGrasa.setValue(0.0); // Limpiar el porcentaje de grasa
        JSP_MasaMuscular.setValue(0.0); // Limpiar la masa muscular
        JSP_MasaOsea.setValue(0.0); // Limpiar la masa ósea
        JSP_IMC.setValue(0.0); // Limpiar el IMC
        JSP_IngestaKilocalorias.setValue(0.0); // Limpiar la ingesta calórica
        JSP_GrasaViceral.setValue(0.0); // Limpiar la grasa visceral
        JSP_AguaCorporal.setValue(0.0); // Limpiar el agua corporal
        JSP_EdadMetabolica.setValue(0.0); // Limpiar la edad metabólica
        JSP_Bicipital.setValue(0.0); // Limpiar el pliegue bicipital
        JSP_Tricipital.setValue(0.0); // Limpiar el pliegue tricipital
        JSP_Subescapular.setValue(0.0); // Limpiar el pliegue subescapular
        JSP_Suprailiaco.setValue(0.0); // Limpiar el pliegue suprailiaco
        JD_Fecha.setDate(null); // Limpiar la fecha de medición
    }

    // Método para refrescar los datos de la tabla de interpretación
    public void refrescar() {
        try {
            // Obtiene todos los datos de interpretación desde el controlador
            ArrayList<EntidadDatosInterpretacion> datos = ControladorDatosInterpretacion.PedirTodos();

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
    public VistaDatosInterpretacion() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla
        model = new ModeloTablaDatosInterpretacion();

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
        JTA_IDDatosInterpretacion = new javax.swing.JTextField();
        JD_Fecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        JSP_MasaMuscular = new javax.swing.JSpinner();
        JSP_PorcentajeGrasa = new javax.swing.JSpinner();
        JSP_Peso = new javax.swing.JSpinner();
        JSP_MasaOsea = new javax.swing.JSpinner();
        JSP_IMC = new javax.swing.JSpinner();
        JSP_IngestaKilocalorias = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        JSP_EdadMetabolica = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        JSP_AguaCorporal = new javax.swing.JSpinner();
        JSP_GrasaViceral = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JSP_Tricipital = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        JSP_Bicipital = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JSP_Suprailiaco = new javax.swing.JSpinner();
        JSP_Subescapular = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JSP_Mes = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        JSP_Cintura = new javax.swing.JSpinner();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(221, 221, 221));

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
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(82, 97, 107));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(221, 221, 221));

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
        jLabel4.setText("Masa muscular:");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 221));
        jLabel5.setText("% grasa corporal:");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 221));
        jLabel6.setText("Masa osea:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 221));
        jLabel8.setText("IMC:");

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 221));
        jLabel9.setText("ID:");

        JTA_IDDatosInterpretacion.setEditable(false);
        JTA_IDDatosInterpretacion.setBackground(new java.awt.Color(255, 253, 249));
        JTA_IDDatosInterpretacion.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JTA_IDDatosInterpretacion.setForeground(new java.awt.Color(27, 38, 44));

        JD_Fecha.setBackground(new java.awt.Color(255, 253, 249));
        JD_Fecha.setForeground(new java.awt.Color(27, 38, 44));
        JD_Fecha.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(221, 221, 221));
        jLabel7.setText("Ingesta kilocalorias:");

        JSP_MasaMuscular.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_MasaMuscular.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_PorcentajeGrasa.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_PorcentajeGrasa.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_Peso.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Peso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_MasaOsea.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_MasaOsea.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_IMC.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_IMC.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_IngestaKilocalorias.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_IngestaKilocalorias.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(221, 221, 221));
        jLabel10.setText("Edad Metabolica:");

        JSP_EdadMetabolica.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_EdadMetabolica.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(221, 221, 221));
        jLabel11.setText("% agua corporal:");

        JSP_AguaCorporal.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_AguaCorporal.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_GrasaViceral.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_GrasaViceral.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(221, 221, 221));
        jLabel12.setText("Grasa viceral:");

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(221, 221, 221));
        jLabel13.setText("Tricipital:");

        JSP_Tricipital.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Tricipital.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_Bicipital.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Bicipital.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(221, 221, 221));
        jLabel14.setText("Bicipital:");

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(221, 221, 221));
        jLabel15.setText("Suprailiaco");

        JSP_Suprailiaco.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Suprailiaco.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        JSP_Subescapular.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Subescapular.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel16.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(221, 221, 221));
        jLabel16.setText("Subescapular:");

        jLabel17.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(221, 221, 221));
        jLabel17.setText("Mes");

        JSP_Mes.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Mes.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel18.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(221, 221, 221));
        jLabel18.setText("Cintura:");

        JSP_Cintura.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        JSP_Cintura.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JSP_MasaMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JSP_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(JSP_IMC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JSP_EdadMetabolica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JSP_GrasaViceral, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel17)))))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JSP_IngestaKilocalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSP_MasaOsea, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSP_PorcentajeGrasa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSP_AguaCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSP_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 135, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTA_IDDatosInterpretacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSP_Tricipital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSP_Bicipital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSP_Suprailiaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSP_Subescapular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSP_Cintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTA_IDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(JTA_IDDatosInterpretacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(JD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JSP_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(JSP_PorcentajeGrasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JSP_MasaMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JSP_MasaOsea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JSP_IMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JSP_IngestaKilocalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JSP_EdadMetabolica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(JSP_AguaCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JSP_GrasaViceral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(JSP_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(JSP_Tricipital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(JSP_Bicipital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(JSP_Suprailiaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(JSP_Subescapular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(JSP_Cintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 36, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica si los campos obligatorios están llenos antes de proceder
        if (!ValidadorDatosInterpretacion.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDatosInterpretacion.campoNoVacio(JSP_Mes.getValue().toString(), "Mes")
                || !ValidadorDatosInterpretacion.campoNoVacio(JSP_Peso.getValue().toString(), "Peso")
                || JD_Fecha.getDate() == null) {
            return; // Sale del método si alguna validación falla
        }

        // Verifica si el ID del paciente es un número válido
        if (!ValidadorDatosInterpretacion.esNumeroEntero(JTA_IDPaciente.getText(), "ID Paciente")) {
            return;
        }

        // Verifica si el ID del paciente existe en la base de datos
        int idPaciente = Integer.parseInt(JTA_IDPaciente.getText());
        if (!ValidadorDatosInterpretacion.idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente")) {
            return;
        }

        // Verifica la fecha
        if (!ValidadorDatosInterpretacion.fechaNoNula(JD_Fecha.getDate(), "Fecha de Registro")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea registrar estos datos de interpretación?",
                "Confirmación de registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela el registro
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza el registro
        }

        // Si todas las validaciones son correctas, crea el objeto y procede con la operación
        EntidadDatosInterpretacion nuevo = new EntidadDatosInterpretacion(
                null, // El ID será generado automáticamente
                idPaciente,
                new java.sql.Date(JD_Fecha.getDate().getTime()), // Fecha
                Integer.parseInt(JSP_Mes.getValue().toString()), // Mes
                Double.parseDouble(JSP_Peso.getValue().toString()), // Peso
                Double.parseDouble(JSP_Cintura.getValue().toString()),
                Double.parseDouble(JSP_PorcentajeGrasa.getValue().toString()), // Porcentaje de Grasa Corporal
                Double.parseDouble(JSP_MasaMuscular.getValue().toString()), // Masa Muscular
                Double.parseDouble(JSP_MasaOsea.getValue().toString()), // Masa Ósea
                Double.parseDouble(JSP_IMC.getValue().toString()), // IMC
                Double.parseDouble(JSP_IngestaKilocalorias.getValue().toString()), // Ingesta Kilocalorías
                Integer.parseInt(JSP_EdadMetabolica.getValue().toString()), // Edad Metabólica (cambiado a Integer)
                Double.parseDouble(JSP_AguaCorporal.getValue().toString()), // Porcentaje Agua Corporal
                Double.parseDouble(JSP_GrasaViceral.getValue().toString()), // Grasa Visceral
                Double.parseDouble(JSP_Tricipital.getValue().toString()), // Pliegue Tricipital
                Double.parseDouble(JSP_Bicipital.getValue().toString()), // Pliegue Bicipital
                Double.parseDouble(JSP_Suprailiaco.getValue().toString()), // Pliegue Suprailiaco
                Double.parseDouble(JSP_Subescapular.getValue().toString()) // Pliegue Subescapular
        );

        try {
            ControladorDatosInterpretacion.Alta(nuevo);

            // Muestra un mensaje de éxito si el registro fue exitoso
            JOptionPane.showMessageDialog(this, "Datos de interpretación registrados exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar los datos de interpretación: " + e.getMessage(), "Error de Entrada/Salida", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            Logger.getLogger(VistaDatosInterpretacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaDatosInterpretacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Actualiza la tabla o vista después de la operación
        refrescar();

    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtiene el dato de interpretación seleccionado
        EntidadDatosInterpretacion seleccionado = getObjSeleccionado();

        // Verifica si hay un dato de interpretación seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un dato de interpretación para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que el ID del paciente existe en la base de datos
        if (!ValidadorDatosInterpretacion.idPacienteExisteEnBaseDatos(seleccionado.getIdPaciente(), "ID del paciente")) {
            return; // Salir si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el dato de interpretación de la fecha " + seleccionado.getFecha() + "?",
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
            // Llama al servicio para eliminar el dato de interpretación seleccionado de la base de datos
            ControladorDatosInterpretacion.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si la eliminación fue exitosa
            JOptionPane.showMessageDialog(this, "El dato de interpretación ha sido eliminado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del dato de interpretación
        refrescar();

    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Obtiene el dato de interpretación seleccionado
        EntidadDatosInterpretacion seleccionado = getObjSeleccionado();

        // Verifica si hay un dato de interpretación seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un dato de interpretación para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de campos vacíos usando ValidadorDatos
        if (!ValidadorDatosInterpretacion.campoNoVacio(JTA_IDPaciente.getText(), "ID Paciente")
                || !ValidadorDatosInterpretacion.campoNoVacio(JSP_Peso.getValue().toString(), "Peso")
                || !ValidadorDatosInterpretacion.campoNoVacio(JSP_PorcentajeGrasa.getValue().toString(), "Porcentaje de Grasa")
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
        if (!ValidadorDatosInterpretacion.idPacienteExisteEnBaseDatos(idPaciente, "ID del paciente")) {
            return; // Sale si el ID no existe
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información de los datos de interpretación del paciente " + seleccionado.getIdPaciente() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos del dato de interpretación seleccionado con los valores de los campos de texto y los componentes gráficos
        seleccionado.setIdPaciente(Integer.parseInt(JTA_IDPaciente.getText())); // Asignar el ID del paciente
        seleccionado.setFecha(new java.sql.Date(JD_Fecha.getDate().getTime()));

        // Obtener y asignar los valores desde los JSpinners para las mediciones de interpretación
        seleccionado.setMes((Integer) JSP_Mes.getValue());
        seleccionado.setPeso((Double) JSP_Peso.getValue());
        seleccionado.setCintura((Double) JSP_Cintura.getValue());// Asignar el peso desde el JSpinner
        seleccionado.setPorcentajeGrasaCorporal((Double) JSP_PorcentajeGrasa.getValue()); // Asignar porcentaje de grasa corporal
        seleccionado.setMasaMuscular((Double) JSP_MasaMuscular.getValue()); // Asignar masa muscular
        seleccionado.setMasaOsea((Double) JSP_MasaOsea.getValue()); // Asignar masa ósea
        seleccionado.setImc((Double) JSP_IMC.getValue()); // Asignar IMC
        seleccionado.setIngestaKilocalorias((Double) JSP_IngestaKilocalorias.getValue()); // Asignar ingesta de kilocalorías
        seleccionado.setEdadMetabolica((Integer) JSP_EdadMetabolica.getValue()); // Asignar edad metabólica
        seleccionado.setPorcentajeAguaCorporal((Double) JSP_AguaCorporal.getValue()); // Asignar porcentaje de agua corporal
        seleccionado.setGrasaVisceral((Double) JSP_GrasaViceral.getValue()); // Asignar grasa visceral
        seleccionado.setPliegueTricipital((Double) JSP_Tricipital.getValue()); // Asignar pliegue tricipital
        seleccionado.setPliegueBicipital((Double) JSP_Bicipital.getValue()); // Asignar pliegue bicipital
        seleccionado.setPliegueSuprailiaco((Double) JSP_Suprailiaco.getValue()); // Asignar pliegue suprailiaco
        seleccionado.setPliegueSubescapular((Double) JSP_Subescapular.getValue()); // Asignar pliegue subescapular

        try {
            // Llama al servicio para actualizar el dato de interpretación en la base de datos
            ControladorDatosInterpretacion.Actualizar(seleccionado);
            JOptionPane.showMessageDialog(this, "Los datos de interpretación han sido actualizados con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorDatosInterpretacion.campoNoVacio(JTA_BuscaID.getText(), "ID Dato de Interpretación")) {
                return;
            }

            // Convierte el texto del campo ID a un número entero
            int idDatoInterpretacion;
            try {
                idDatoInterpretacion = Integer.parseInt(JTA_BuscaID.getText());
            } catch (NumberFormatException ex) {
                // Muestra un mensaje de error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "El ID del dato de interpretación debe ser un número entero", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verifica si el dato de interpretación existe en la base de datos usando la clase ValidadorDatos
            if (!ValidadorDatosInterpretacion.idExisteEnBaseDatos(idDatoInterpretacion, "Datos de Interpretación", "ID del dato de interpretación")) {
                return;
            }

            // Llama al método para obtener el dato de interpretación por ID
            EntidadDatosInterpretacion datoInterpretacion = ControladorDatosInterpretacion.PedirDatoPorId(idDatoInterpretacion);

            // Verifica si se obtuvo el dato correctamente y actualiza la tabla
            if (datoInterpretacion != null) {
                ArrayList<EntidadDatosInterpretacion> datos = new ArrayList<>();
                datos.add(datoInterpretacion);
                model.setDatos(datos);
            } else {
                // Si no se encuentra el dato, muestra un mensaje de advertencia
                JOptionPane.showMessageDialog(this, "No se encontraron datos de interpretación con ese ID", "Dato no encontrado", JOptionPane.INFORMATION_MESSAGE);
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
            if (!ValidadorDatosInterpretacion.campoNoVacio(JTA_BuscaIDPaciente.getText(), "ID Paciente")) {
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
            if (!ValidadorDatosInterpretacion.idPacienteExisteEnBaseDatos(idPaciente, "ID del paciente")) {
                return;
            }

            // Llama al método para obtener los indicadores antropométricos por ID del paciente
            ArrayList<EntidadDatosInterpretacion> indicadores = ControladorDatosInterpretacion.PedirDatosPorIdPaciente(idPaciente);

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
            Logger.getLogger(VistaDatosInterpretacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaDatosInterpretacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Limpia los campos del formulario después de la búsqueda
        limpiarFormulario();
    }//GEN-LAST:event_btnBuscaPaciente_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JD_Fecha;
    private javax.swing.JSpinner JSP_AguaCorporal;
    private javax.swing.JSpinner JSP_Bicipital;
    private javax.swing.JSpinner JSP_Cintura;
    private javax.swing.JSpinner JSP_EdadMetabolica;
    private javax.swing.JSpinner JSP_GrasaViceral;
    private javax.swing.JSpinner JSP_IMC;
    private javax.swing.JSpinner JSP_IngestaKilocalorias;
    private javax.swing.JSpinner JSP_MasaMuscular;
    private javax.swing.JSpinner JSP_MasaOsea;
    private javax.swing.JSpinner JSP_Mes;
    private javax.swing.JSpinner JSP_Peso;
    private javax.swing.JSpinner JSP_PorcentajeGrasa;
    private javax.swing.JSpinner JSP_Subescapular;
    private javax.swing.JSpinner JSP_Suprailiaco;
    private javax.swing.JSpinner JSP_Tricipital;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaIDPaciente;
    private javax.swing.JTextField JTA_IDDatosInterpretacion;
    private javax.swing.JTextField JTA_IDPaciente;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
