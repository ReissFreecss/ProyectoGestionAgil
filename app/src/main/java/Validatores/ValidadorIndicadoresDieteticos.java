/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorPaciente;
import Controladores.ControladorIndicadoresDieteticos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorIndicadoresDieteticos {

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

    // Valida si un número decimal es válido y mayor o igual a cero
    public static boolean esDecimalPositivo(String valor, String nombreCampo) {
        try {
            double numero = Double.parseDouble(valor);
            if (numero < 0) {
                JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser mayor o igual a cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número decimal válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
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

    // Validación general para la tabla Indicadores Dietéticos
    public static boolean validarIndicadoresDieteticos(String preparadorAlimentos, String horaApetito, String alimentosPreferidos, 
                                                       String alimentosNoPreferidos, String suplemento, String dosisSuplemento, 
                                                       String aguaConsumida, String refrescoConsumido, String lecheConsumida, 
                                                       String medicamentosBajarPeso, int idPaciente) {

        return campoNoVacio(preparadorAlimentos, "Preparador de Alimentos") &&
               campoNoVacio(horaApetito, "Hora de Apetito") &&
               campoNoVacio(alimentosPreferidos, "Alimentos Preferidos") &&
               campoNoVacio(alimentosNoPreferidos, "Alimentos No Preferidos") &&
               campoNoVacio(suplemento, "Suplemento") &&
               campoNoVacio(dosisSuplemento, "Dosis de Suplemento") &&
               esDecimalPositivo(aguaConsumida, "Agua Consumida") &&
               esDecimalPositivo(refrescoConsumido, "Refresco Consumido") &&
               esDecimalPositivo(lecheConsumida, "Leche Consumida") &&
               campoNoVacio(medicamentosBajarPeso, "Medicamentos para Bajar de Peso") &&
               idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente", "ID Paciente");
    }
    // Valida si un ID existe en la base de datos
    public static boolean idExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
            boolean existe = ControladorIndicadoresDieteticos.existeConsumoPorId(id); // Ejemplo para antecedentes médicos
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

