/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorPaciente;
import Controladores.ControladorIndicadoresAntropometricos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorIndicadoresAntropometricos {
    
    // Valida si un campo de texto no está vacío
    public static boolean campoNoVacio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete el campo: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un valor es un número decimal válido y mayor que cero
    public static boolean esNumeroDecimalValido(String valor, String nombreCampo) {
        try {
            double numero = Double.parseDouble(valor);
            if (numero <= 0) {
                JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número decimal válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si una fecha no es nula
    public static boolean fechaNoNula(java.util.Date fecha, String nombreCampo) {
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha para: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Verifica si el ID del paciente existe en la base de datos
    public static boolean idPacienteExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            boolean existe = ControladorPaciente.existePacientePorId(id);
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

    // Valida los datos antropométricos (peso, estatura, circunferencias)
    public static boolean validarDatosAntropometricos(String peso, String estatura, String circunferenciaBrazo, String circunferenciaCintura, String circunferenciaCadera, String circunferenciaMuslo) {
        // Validar que los valores sean números decimales válidos y mayores que cero
        return esNumeroDecimalValido(peso, "Peso") &&
               esNumeroDecimalValido(estatura, "Estatura") &&
               esNumeroDecimalValido(circunferenciaBrazo, "Circunferencia del Brazo") &&
               esNumeroDecimalValido(circunferenciaCintura, "Circunferencia de la Cintura") &&
               esNumeroDecimalValido(circunferenciaCadera, "Circunferencia de la Cadera") &&
               esNumeroDecimalValido(circunferenciaMuslo, "Circunferencia del Muslo");
    }

    // Valida el ID del paciente
    public static boolean validarIDPaciente(String idPaciente) {
        // Verificar que el ID sea un número entero válido
        if (!esNumeroEntero(idPaciente, "ID Paciente")) {
            return false;
        }

        // Verificar que el ID exista en la base de datos
        int id = Integer.parseInt(idPaciente);
        return idPacienteExisteEnBaseDatos(id, "Paciente", "ID del Paciente");
    }

    // Valida si un número es entero
    public static boolean esNumeroEntero(String valor, String nombreCampo) {
        try {
            Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    // Valida si un ID existe en la base de datos
    public static boolean idExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
            boolean existe = ControladorIndicadoresAntropometricos.existeAntecedentePorId(id); // Ejemplo para antecedentes médicos
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

