/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorPaciente;
import Controladores.ControladorComidas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorComidas {
    // Valida si un campo de texto no está vacío
    public static boolean campoNoVacio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete el campo: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un número entero es válido
    public static boolean esNumeroEntero(String valor, String nombreCampo) {
        try {
            Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un número entero es mayor o igual a cero (para la frecuencia de comida callejera)
    public static boolean esNumeroEnteroPositivo(String valor, String nombreCampo) {
        try {
            int numero = Integer.parseInt(valor);
            if (numero < 0) {
                JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser mayor o igual a cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un ID existe en la base de datos
    public static boolean idPacienteExisteEnBaseDatos(int id, String nombreCampo, String id_Paciente) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
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

    // Validación para el campo 'come_calle' (solo debe ser 'SI' o 'NO')
    public static boolean validarComeCalle(String valor, String nombreCampo) {
        if (!valor.equalsIgnoreCase("SI") && !valor.equalsIgnoreCase("NO")) {
            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " solo puede ser 'SI' o 'NO'.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Validación general para la tabla Comidas
    public static boolean validarComida(String comida, String horario, String platillo, String ingredientes, String cantidad, String comeCalle, String frecuenciaComidaCalle, int idPaciente) {
        return campoNoVacio(comida, "Comida") &&
               campoNoVacio(horario, "Horario") &&
               campoNoVacio(platillo, "Platillo") &&
               campoNoVacio(ingredientes, "Ingredientes") &&
               campoNoVacio(cantidad, "Cantidad") &&
               validarComeCalle(comeCalle, "Come Calle") &&
               esNumeroEnteroPositivo(frecuenciaComidaCalle, "Frecuencia Comida Calle") &&
               idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente", "ID Paciente");
    }
    // Valida si un ID existe en la base de datos
    public static boolean idExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
            boolean existe = ControladorComidas.existeComidaPorId(id); // Ejemplo para antecedentes médicos
            if (!existe) {
                JOptionPane.showMessageDialog(null, "El " + nombreCampo + " no existe en " + nombreEntidad, "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de SQL al validar " + nombreCampo + ": " + e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
