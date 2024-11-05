/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.EntidadSeguimiento;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author darkd
 */
public class ControladorSeguimiento {

    // Método para obtener todos los registros de seguimiento de la base de datos
    public static ArrayList<EntidadSeguimiento> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadSeguimiento> resultado = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Seguimiento";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadSeguimiento obj = new EntidadSeguimiento(
                        rs.getInt("id_seguimiento"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getString("apego_plan"),
                        rs.getString("alimentos_fuera_plan"),
                        rs.getString("paso_hambre"),
                        rs.getInt("dias_entrenamiento"),
                        rs.getString("mejoro_ejercicio"),
                        rs.getString("jugos_refrescos_alcohol"),
                        rs.getString("litros_agua"),
                        rs.getString("malestares_gastricos"),
                        rs.getString("horas_sueno"),
                        rs.getString("problema_solucion"),
                        rs.getString("extras_observaciones")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo registro de seguimiento en la base de datos
    public static void Alta(EntidadSeguimiento obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlAlta = "INSERT INTO Seguimiento (id_paciente, fecha, apego_plan, alimentos_fuera_plan, paso_hambre, dias_entrenamiento, mejoro_ejercicio, jugos_refrescos_alcohol, litros_agua, malestares_gastricos, horas_sueno, problema_solucion, extras_observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setDate(2, obj.getFecha());
            ps.setString(3, obj.getApegoPlan());
            ps.setString(4, obj.getAlimentosFueraPlan());
            ps.setString(5, obj.getPasoHambre());
            ps.setInt(6, obj.getDiasEntrenamiento());
            ps.setString(7, obj.getMejoroEjercicio());
            ps.setString(8, obj.getJugosRefrescosAlcohol());
            ps.setString(9, obj.getLitrosAgua());
            ps.setString(10, obj.getMalestaresGastricos());
            ps.setString(11, obj.getHorasSueno());
            ps.setString(12, obj.getProblemaSolucion());
            ps.setString(13, obj.getExtrasObservaciones());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un registro de seguimiento en la base de datos
    public static void Actualizar(EntidadSeguimiento seguimiento) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlActualizar = "UPDATE Seguimiento SET id_paciente = ?, fecha = ?, apego_plan = ?, alimentos_fuera_plan = ?, paso_hambre = ?, dias_entrenamiento = ?, mejoro_ejercicio = ?, jugos_refrescos_alcohol = ?, litros_agua = ?, malestares_gastricos = ?, horas_sueno = ?, problema_solucion = ?, extras_observaciones = ? WHERE id_seguimiento = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, seguimiento.getIdPaciente());
            ps.setDate(2, seguimiento.getFecha());
            ps.setString(3, seguimiento.getApegoPlan());
            ps.setString(4, seguimiento.getAlimentosFueraPlan());
            ps.setString(5, seguimiento.getPasoHambre());
            ps.setInt(6, seguimiento.getDiasEntrenamiento());
            ps.setString(7, seguimiento.getMejoroEjercicio());
            ps.setString(8, seguimiento.getJugosRefrescosAlcohol());
            ps.setString(9, seguimiento.getLitrosAgua());
            ps.setString(10, seguimiento.getMalestaresGastricos());
            ps.setString(11, seguimiento.getHorasSueno());
            ps.setString(12, seguimiento.getProblemaSolucion());
            ps.setString(13, seguimiento.getExtrasObservaciones());
            ps.setInt(14, seguimiento.getIdSeguimiento());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un registro de seguimiento de la base de datos
    public static void Eliminar(EntidadSeguimiento obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlBorrar = "DELETE FROM Seguimiento WHERE id_seguimiento = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdSeguimiento());
            ps.executeUpdate();
        }
    }

    // Método para obtener registros de seguimiento por ID de paciente
    public static ArrayList<EntidadSeguimiento> PedirSeguimientoPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadSeguimiento> seguimiento = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Seguimiento WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadSeguimiento obj = new EntidadSeguimiento(
                        rs.getInt("id_seguimiento"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getString("apego_plan"),
                        rs.getString("alimentos_fuera_plan"),
                        rs.getString("paso_hambre"),
                        rs.getInt("dias_entrenamiento"),
                        rs.getString("mejoro_ejercicio"),
                        rs.getString("jugos_refrescos_alcohol"),
                        rs.getString("litros_agua"),
                        rs.getString("malestares_gastricos"),
                        rs.getString("horas_sueno"),
                        rs.getString("problema_solucion"),
                        rs.getString("extras_observaciones")
                );
                seguimiento.add(obj);
            }
        }
        return seguimiento;
    }

    // Método para verificar si existe un registro de seguimiento por su ID
    public static boolean existeSeguimientoPorId(int idSeguimiento) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Seguimiento WHERE id_seguimiento = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idSeguimiento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // Método para verificar si existe un antecedente médico por su ID
    public static boolean existeAntecedentePorId(int idAntecedente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Seguimiento WHERE id_seguimiento = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idAntecedente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un antecedente con ese ID
            }
        }
        return false;
    }

    public static EntidadSeguimiento PedirSeguimientoPorId(int idSeguimiento) throws IllegalAccessError, SQLException, IOException {
        EntidadSeguimiento seguimiento = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el seguimiento por ID
        String sqlQuery = "SELECT * FROM Seguimiento WHERE id_seguimiento = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlQuery)) {
            // Asigna el valor del ID del seguimiento en la consulta SQL
            ps.setInt(1, idSeguimiento);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el seguimiento, lo asigna al objeto seguimiento
            if (rs.next()) {
                seguimiento = new EntidadSeguimiento(
                        rs.getInt("id_seguimiento"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getString("apego_plan"),
                        rs.getString("alimentos_fuera_plan"),
                        rs.getString("paso_hambre"),
                        rs.getInt("dias_entrenamiento"),
                        rs.getString("mejoro_ejercicio"),
                        rs.getString("jugos_refrescos_alcohol"),
                        rs.getString("litros_agua"),
                        rs.getString("malestares_gastricos"),
                        rs.getString("horas_sueno"),
                        rs.getString("problema_solucion"),
                        rs.getString("extras_observaciones")
                );
            }
        }
        return seguimiento; // Retorna el seguimiento o null si no se encuentra
    }
}
