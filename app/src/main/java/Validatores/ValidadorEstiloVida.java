/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validatores;

import Controladores.ControladorEstiloVida;
import Controladores.ControladorPaciente;
import Entidades.EntidadEstiloVida;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkd
 */
public class ValidadorEstiloVida {
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

    // Valida si una hora (en formato de cadena) no está vacía y es válida
    public static boolean esHoraValida(String hora, String nombreCampo) {
        if (campoNoVacio(hora, nombreCampo)) {
            try {
                java.time.LocalTime.parse(hora); // Valida el formato de hora
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser una hora válida (HH:mm).", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
        return false;
    }

    // Valida si un ID de paciente existe en la base de datos
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
    
    // Valida si un ID existe en la base de datos
    public static boolean idExisteEnBaseDatos(int id, String nombreEntidad, String nombreCampo) {
        try {
            // Aquí iría la lógica para verificar si el ID existe en la base de datos
            boolean existe = ControladorEstiloVida.existeEstiloVidaPorId(id); // Ejemplo para antecedentes médicos
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

    // Valida si el campo frecuencia es un entero mayor a cero
    public static boolean frecuenciaEjercicioValida(int frecuencia, String nombreCampo) {
        if (frecuencia <= 0) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida todos los campos del estilo de vida antes de guardarlos
    public static boolean validarEstiloVida(EntidadEstiloVida estiloVida) {
        if (!esNumeroEntero(estiloVida.getIdEstiloVida().toString(), "ID Estilo Vida") ||
            !idPacienteExisteEnBaseDatos(estiloVida.getIdPaciente(), "Paciente", "ID Paciente") ||
            !esHoraValida(estiloVida.getHoraDespertar(), "Hora Despertar") ||
            !esHoraValida(estiloVida.getHoraDormir(), "Hora Dormir") ||
            !esHoraValida(estiloVida.getHoraTrabajoEstudio(), "Hora Trabajo/Estudio") ||
            !esHoraValida(estiloVida.getHoraEntrenamiento(), "Hora Entrenamiento") ||
            !campoNoVacio(estiloVida.getTipoEjercicio(), "Tipo Ejercicio") ||
            !campoNoVacio(estiloVida.getIntensidad(), "Intensidad") ||
            !frecuenciaEjercicioValida(estiloVida.getFrecuenciaEjercicio(), "Frecuencia Ejercicio")) {
            return false;
        }
        return true;
    }
}

