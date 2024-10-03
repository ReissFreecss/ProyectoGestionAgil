/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControlladorPaciente;
import Entidades.EntidadPaciente;
import ModelosTablas.ModeloTablaPacientes;
import Validatores.ValidadorPacientes;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
public class VistaPacientes extends javax.swing.JPanel {

    //Cargarar el archivo para imagen
    File archivoImagen = new File("");
    // Variable para el modelo de la tabla de videojuegos
    private ModeloTablaPacientes model;

    // Variable para el objeto seleccionado de tipo Videojuego
    private EntidadPaciente ObjSeleccionado = null;

    // Método para obtener el objeto seleccionado
    public EntidadPaciente getObjSeleccionado() {
        return ObjSeleccionado;
    }

    // Método para establecer el objeto seleccionado y actualizar los campos de texto
    public void setObjSeleccionado(EntidadPaciente ObjSeleccionado) {
        this.ObjSeleccionado = ObjSeleccionado;

        // Si hay un objeto seleccionado, actualizar los campos de texto
        if (this.ObjSeleccionado != null) {
            JTA_ID.setText(String.valueOf(this.ObjSeleccionado.getIdPaciente())); // Mostrar el ID del paciente
            JTA_Nombre.setText(this.ObjSeleccionado.getNombreCompleto()); // Nombre completo
            JTA_Edad.setText(String.valueOf(this.ObjSeleccionado.getEdad())); // Edad
            JCB_Genero.setSelectedItem(this.ObjSeleccionado.getSexo()); // Género (suponiendo que el JComboBox tiene opciones como "Masculino", "Femenino", etc.)
            JTA_Ocupacion.setText(this.ObjSeleccionado.getOcupacion()); // Ocupación
            JTA_MotivoConsulta.setText(this.ObjSeleccionado.getMotivoConsulta()); // Motivo de la consulta
            JTA_Telefono.setText(this.ObjSeleccionado.getTelefono()); // Teléfono
        } // Si no hay objeto seleccionado, limpiar los campos de texto
        else {
            limpiarFormulario();
        }
    }

    // Método para limpiar los campos del formulario
    private void limpiarFormulario() {
        JTA_ID.setText(""); // Limpiar el campo ID
        JTA_Nombre.setText(""); // Limpiar el campo nombre
        JTA_Edad.setText(""); // Limpiar el campo edad
        JCB_Genero.setSelectedIndex(-1); // Desseleccionar género
        JTA_Ocupacion.setText(""); // Limpiar el campo ocupación
        JTA_MotivoConsulta.setText(""); // Limpiar el campo motivo de consulta
        JTA_Telefono.setText(""); // Limpiar el campo teléfono
    }

    // Método para refrescar los datos de la tabla de caracteristicas
    public void refrescar() {
        try {
            // Obtiene todos los caracteristicas desde el servicio
            ArrayList<EntidadPaciente> datos = ControlladorPaciente.PedirTodos();

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
    public VistaPacientes() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Inicializa el modelo de la tabla de videojuegos
        model = new ModeloTablaPacientes();

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
        JTA_BuscaNombre = new javax.swing.JTextField();
        btnBuscaNombre_ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTA_Nombre = new javax.swing.JTextField();
        JTA_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTA_Edad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JCB_Genero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JTA_Ocupacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTA_MotivoConsulta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTA_Telefono = new javax.swing.JTextField();
        jD_Fecha = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(648, 441));

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        btnRefrescar_.setText("Refrescar");
        btnRefrescar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar_ActionPerformed(evt);
            }
        });

        btnAgregar_.setText("Agregar");
        btnAgregar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_ActionPerformed(evt);
            }
        });

        btnEditar_.setText("Editar");
        btnEditar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_ActionPerformed(evt);
            }
        });

        btnEliminar_.setText("Eliminar");
        btnEliminar_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ActionPerformed(evt);
            }
        });

        btnBuscaID_.setText("Buscar ID");
        btnBuscaID_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaID_ActionPerformed(evt);
            }
        });

        btnBuscaNombre_.setText("Buscar Nombre");
        btnBuscaNombre_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaNombre_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEditar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRefrescar_, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
            .addComponent(JTA_BuscaID)
            .addComponent(btnBuscaID_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JTA_BuscaNombre)
            .addComponent(btnBuscaNombre_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(JTA_BuscaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscaNombre_)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre:");

        JTA_ID.setEditable(false);

        jLabel3.setText("Edad:");

        jLabel4.setText("Genero:");

        JCB_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel5.setText("Ocupacion:");

        jLabel6.setText("Motivo Consulta:");

        jLabel7.setText("Fecha de consulta:");

        jLabel8.setText("Telefono:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTA_Telefono)
                    .addComponent(JTA_MotivoConsulta)
                    .addComponent(JTA_Ocupacion)
                    .addComponent(JTA_Edad)
                    .addComponent(JTA_Nombre)
                    .addComponent(JTA_ID)
                    .addComponent(JCB_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTA_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTA_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JTA_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(JCB_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JTA_Ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTA_MotivoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jD_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTA_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_ActionPerformed
        // Verifica los campos obligatorios usando el ValidadorPaciente
        if (!ValidadorPacientes.campoNoVacio(JTA_Nombre.getText(), "Nombre")
                || !ValidadorPacientes.campoNoVacio(JTA_Edad.getText(), "Edad")
                || !ValidadorPacientes.campoNoVacio(JTA_Telefono.getText(), "Teléfono")
                || !ValidadorPacientes.campoNoVacio(JTA_Ocupacion.getText(), "Ocupación")
                || !ValidadorPacientes.campoNoVacio(JTA_MotivoConsulta.getText(), "Motivo de Consulta")
                || !ValidadorPacientes.esNumeroEntero(JTA_Edad.getText(), "Edad")
                || !ValidadorPacientes.fechaNoNula(jD_Fecha.getDate(), "Fecha de consulta")
                || !ValidadorPacientes.esMayorQueCero(Integer.parseInt(JTA_Edad.getText()), "Edad")) {
            return; // Si alguna validación falla, no continúa
        }

        // Pregunta de confirmación al usuario antes de agregar el paciente
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea agregar al paciente " + JTA_Nombre.getText() + "?",
                "Confirmación de agregación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", cancela la operación
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        // Crea un nuevo objeto EntityPaciente con los datos de los campos de texto
        EntidadPaciente nuevo = new EntidadPaciente(
                null, // El ID será generado automáticamente por la base de datos
                JTA_Nombre.getText(), // Nombre completo
                Integer.parseInt(JTA_Edad.getText()), // Convierte la edad a entero
                JCB_Genero.getSelectedItem().toString(), // Género seleccionado del JComboBox
                JTA_Ocupacion.getText(), // Ocupación
                JTA_MotivoConsulta.getText(),
                new java.sql.Date(jD_Fecha.getDate().getTime()), // Fecha de consulta
                JTA_Telefono.getText() // Teléfono
        );

        try {
            // Llama al servicio para insertar el nuevo paciente en la base de datos
            ControlladorPaciente.Alta(nuevo);
            // Muestra un mensaje de éxito si el paciente se agrega correctamente
            JOptionPane.showMessageDialog(this, "Paciente agregado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalArgumentException", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para mostrar el nuevo paciente
        refrescar();
    }//GEN-LAST:event_btnAgregar_ActionPerformed

    private void btnRefrescar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_ActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefrescar_ActionPerformed

    private void btnEliminar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ActionPerformed
        // Obtiene el paciente seleccionado
        EntidadPaciente seleccionado = getObjSeleccionado();

        // Valida si hay un paciente seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente para eliminar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar al paciente " + seleccionado.getNombreCompleto() + "?",
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
            // Llama al controlador para eliminar el paciente seleccionado de la base de datos
            ControlladorPaciente.Eliminar(seleccionado);

            // Muestra un mensaje de éxito si el paciente se elimina correctamente
            JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para reflejar la eliminación del paciente
        refrescar();

    }//GEN-LAST:event_btnEliminar_ActionPerformed

    private void btnEditar_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ActionPerformed
        // Obtiene el paciente seleccionado
        EntidadPaciente seleccionado = getObjSeleccionado();

        // Verifica si hay un paciente seleccionado
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente para editar.", "No seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Valida los campos obligatorios utilizando el ValidadorPaciente
        if (!ValidadorPacientes.campoNoVacio(JTA_Nombre.getText(), "Nombre")
                || !ValidadorPacientes.campoNoVacio(JTA_Edad.getText(), "Edad")
                || !ValidadorPacientes.campoNoVacio(JTA_Telefono.getText(), "Teléfono")
                || !ValidadorPacientes.campoNoVacio(JTA_Ocupacion.getText(), "Ocupación")
                || !ValidadorPacientes.campoNoVacio(JTA_MotivoConsulta.getText(), "Motivo de consulta")
                || !ValidadorPacientes.fechaNoNula(jD_Fecha.getDate(), "Fecha de consulta")
                || !ValidadorPacientes.campoNoVacio(JCB_Genero.getSelectedItem() != null ? JCB_Genero.getSelectedItem().toString() : "", "Género")) {
            return; // Detiene la ejecución si alguna validación falla
        }

        // Verifica que la edad sea un número entero válido
        if (!ValidadorPacientes.esNumeroEntero(JTA_Edad.getText(), "Edad")
                || !ValidadorPacientes.esMayorQueCero(Integer.parseInt(JTA_Edad.getText()), "Edad")) {
            return;
        }

        // Pregunta de confirmación al usuario
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea editar la información del paciente " + seleccionado.getNombreCompleto() + "?",
                "Confirmación de edición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario selecciona "No", se cancela la edición
        if (confirmacion != JOptionPane.YES_OPTION) {
            return; // No se realiza la edición
        }

        // Actualiza los datos del paciente seleccionado con los valores de los campos de texto
        seleccionado.setNombreCompleto(JTA_Nombre.getText());
        seleccionado.setEdad(Integer.parseInt(JTA_Edad.getText())); // Convierte la edad a entero
        seleccionado.setSexo(JCB_Genero.getSelectedItem().toString()); // Género seleccionado del JComboBox
        seleccionado.setOcupacion(JTA_Ocupacion.getText());
        seleccionado.setMotivoConsulta(JTA_MotivoConsulta.getText());
        seleccionado.setTelefono(JTA_Telefono.getText());

        try {
            // Llama al controlador para actualizar el paciente en la base de datos
            ControlladorPaciente.Actualizar(seleccionado);

            // Muestra un mensaje de éxito si la actualización fue exitosa
            JOptionPane.showMessageDialog(this, "Paciente editado exitosamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalAccessError ex) {
            // Muestra un mensaje de error si ocurre un IllegalAccessError
            JOptionPane.showMessageDialog(this, ex.getMessage(), "IllegalAccessError", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Muestra un mensaje de error si ocurre un SQLException
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de IO", JOptionPane.ERROR_MESSAGE);
        }

        // Refresca los datos de la tabla para mostrar los cambios
        refrescar();
    }//GEN-LAST:event_btnEditar_ActionPerformed

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
            EntidadPaciente paciente = ControlladorPaciente.PedirPorId(idPaciente);

            if (paciente != null) {
                // Si se encuentra el paciente, actualiza los datos en el modelo de la tabla
                ArrayList<EntidadPaciente> datos = new ArrayList<>();
                datos.add(paciente);
                model.setDatos(datos);
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
        limpiarFormulario(); // Limpia los campos del formulario
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
            ArrayList<EntidadPaciente> pacientes = ControlladorPaciente.PedirPorNombre(nombrePaciente);

            if (!pacientes.isEmpty()) {
                // Si se encuentran pacientes, actualiza los datos en el modelo de la tabla
                model.setDatos(pacientes);
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

        limpiarFormulario(); // Limpia los campos del formulario
    }//GEN-LAST:event_btnBuscaNombre_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCB_Genero;
    private javax.swing.JTextField JTA_BuscaID;
    private javax.swing.JTextField JTA_BuscaNombre;
    private javax.swing.JTextField JTA_Edad;
    private javax.swing.JTextField JTA_ID;
    private javax.swing.JTextField JTA_MotivoConsulta;
    private javax.swing.JTextField JTA_Nombre;
    private javax.swing.JTextField JTA_Ocupacion;
    private javax.swing.JTextField JTA_Telefono;
    private javax.swing.JTable TBDatos;
    private javax.swing.JButton btnAgregar_;
    private javax.swing.JButton btnBuscaID_;
    private javax.swing.JButton btnBuscaNombre_;
    private javax.swing.JButton btnEditar_;
    private javax.swing.JButton btnEliminar_;
    private javax.swing.JButton btnRefrescar_;
    private com.toedter.calendar.JDateChooser jD_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
