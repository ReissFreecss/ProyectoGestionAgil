/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorPaciente;
import Controladores.ControladorDatosInterpretacion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorDatosInterpretacion {

    // Valida si un campo de texto no está vacío
    public static boolean campoNoVacio(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete el campo: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si un valor decimal es válido
    public static boolean esDecimalValido(String valor, String nombreCampo) {
        try {
            Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser un número decimal válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
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

    // Valida si una fecha no es nula
    public static boolean fechaNoNula(java.util.Date fecha, String nombreCampo) {
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha para: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
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

    // Validación general para la tabla Datos_Interpretacion
    public static boolean validarDatosInterpretacion(String mes, String peso, String porcentajeGrasaCorporal, String masaMuscular,
                                                     String masaOsea, String imc, String ingestaKilocalorias,
                                                     String edadMetabolica, String porcentajeAguaCorporal, String grasaVisceral,
                                                     String pliegueTricipital, String pliegueBicipital, String pliegueSuprailiaco,
                                                     String pliegueSubescapular, java.util.Date fecha, int idPaciente) {

        return esNumeroEntero(mes, "Mes") &&
               esDecimalValido(peso, "Peso") &&
               esDecimalValido(porcentajeGrasaCorporal, "Porcentaje de Grasa Corporal") &&
               esDecimalValido(masaMuscular, "Masa Muscular") &&
               esDecimalValido(masaOsea, "Masa Ósea") &&
               esDecimalValido(imc, "IMC") &&
               esDecimalValido(ingestaKilocalorias, "Ingesta de Kilocalorías") &&
               esNumeroEntero(edadMetabolica, "Edad Metabólica") &&
               esDecimalValido(porcentajeAguaCorporal, "Porcentaje de Agua Corporal") &&
               esDecimalValido(grasaVisceral, "Grasa Visceral") &&
               esDecimalValido(pliegueTricipital, "Pliegue Tricipital") &&
               esDecimalValido(pliegueBicipital, "Pliegue Bicipital") &&
               esDecimalValido(pliegueSuprailiaco, "Pliegue Suprailiaco") &&
               esDecimalValido(pliegueSubescapular, "Pliegue Subescapular") &&
               fechaNoNula(fecha, "Fecha") &&
               idPacienteExisteEnBaseDatos(idPaciente, "ID Paciente");
    }
    // Valida si un ID existe en la base de datos
    public static boolean idExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
            boolean existe = ControladorDatosInterpretacion.existeAntecedentePorId(id); // Ejemplo para antecedentes médicos
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

