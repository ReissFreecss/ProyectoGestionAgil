package Validatores;

import Controladores.ControlladorPaciente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ValidadorPacientes {

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

    // Valida si una fecha no es nula
    public static boolean fechaNoNula(java.util.Date fecha, String nombreCampo) {
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha para: " + nombreCampo, "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Valida si el ID de un paciente existe en la base de datos
    public static boolean idPacienteExisteEnBaseDatos(int id, String nombreCampo) {
        try {
            boolean existe = ControlladorPaciente.existePacientePorId(id);
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

    // Valida que la edad sea mayor que cero
    public static boolean esMayorQueCero(int numero, String nombreCampo) {
        if (numero <= 0) {
            JOptionPane.showMessageDialog(null, "El valor del campo " + nombreCampo + " debe ser mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}


