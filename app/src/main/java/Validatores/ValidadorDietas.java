/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorPaciente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorDietas {

    // Valida si un campo de texto no está vacío
    public static boolean campoNoVacio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete el campo: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un ID existe en la base de datos
    public static boolean idPacienteExisteEnBaseDatos(int id, String nombreCampo) {
        try {
            boolean existe = ControladorPaciente.existePacientePorId(id); // Ejemplo para validar existencia del paciente
            if (!existe) {
                JOptionPane.showMessageDialog(null, "El " + nombreCampo + " no existe en la base de datos", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de SQL al validar " + nombreCampo + ": " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Validación general para la tabla Dietas
    public static boolean validarDietas(String comida, String horario, String porciones,
                                         String ingredientes, String suplemento, String dosisSuplemento, int idPaciente) {

        return campoNoVacio(comida, "Comida") &&
               campoNoVacio(horario, "Horario") &&
               campoNoVacio(porciones, "Porciones") &&
               campoNoVacio(ingredientes, "Ingredientes") &&
               campoNoVacio(suplemento, "Suplemento") &&
               campoNoVacio(dosisSuplemento, "Dosis de Suplemento") &&
               idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente");
    }
}
