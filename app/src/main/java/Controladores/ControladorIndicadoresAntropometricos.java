/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author darkd
 */
import Entidades.EntidadIndicadoresAntropometricos;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControladorIndicadoresAntropometricos {

    // Método para obtener todos los indicadores antropométricos de la base de datos
    public static ArrayList<EntidadIndicadoresAntropometricos> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadIndicadoresAntropometricos> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Indicadores_Antropometricos
        String sqlSquery = "SELECT * FROM Indicadores_Antropometricos";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadIndicadoresAntropometricos obj = new EntidadIndicadoresAntropometricos(
                        rs.getInt("id_indicador"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("estatura"),
                        rs.getDouble("circunferencia_brazo"),
                        rs.getDouble("circunferencia_cintura"),
                        rs.getDouble("circunferencia_cadera"),
                        rs.getDouble("circunferencia_muslo")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo indicador antropométrico en la base de datos
    public static void Alta(EntidadIndicadoresAntropometricos obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo indicador antropométrico
        String sqlAlta = "INSERT INTO Indicadores_Antropometricos (id_paciente, fecha, peso, estatura, circunferencia_brazo, circunferencia_cintura, circunferencia_cadera, circunferencia_muslo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setDate(2, obj.getFecha());
            ps.setDouble(3, obj.getPeso());
            ps.setDouble(4, obj.getEstatura());
            ps.setDouble(5, obj.getCircunferenciaBrazo());
            ps.setDouble(6, obj.getCircunferenciaCintura());
            ps.setDouble(7, obj.getCircunferenciaCadera());
            ps.setDouble(8, obj.getCircunferenciaMuslo());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un indicador antropométrico en la base de datos
    public static void Actualizar(EntidadIndicadoresAntropometricos obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un indicador antropométrico
        String sqlActualizar = "UPDATE Indicadores_Antropometricos SET id_paciente = ?, fecha = ?, peso = ?, estatura = ?, circunferencia_brazo = ?, circunferencia_cintura = ?, circunferencia_cadera = ?, circunferencia_muslo = ? WHERE id_indicador = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setDate(2, obj.getFecha());
            ps.setDouble(3, obj.getPeso());
            ps.setDouble(4, obj.getEstatura());
            ps.setDouble(5, obj.getCircunferenciaBrazo());
            ps.setDouble(6, obj.getCircunferenciaCintura());
            ps.setDouble(7, obj.getCircunferenciaCadera());
            ps.setDouble(8, obj.getCircunferenciaMuslo());
            ps.setInt(9, obj.getIdIndicador());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un indicador antropométrico de la base de datos
    public static void Eliminar(EntidadIndicadoresAntropometricos obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un indicador antropométrico por su ID
        String sqlBorrar = "DELETE FROM Indicadores_Antropometricos WHERE id_indicador = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdIndicador());
            ps.executeUpdate();
        }
    }

    // Método para obtener indicadores antropométricos por ID de paciente
    public static ArrayList<EntidadIndicadoresAntropometricos> PedirIndicadoresPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadIndicadoresAntropometricos> indicadores = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener los indicadores por ID de paciente
        String sqlSquery = "SELECT * FROM Indicadores_Antropometricos WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadIndicadoresAntropometricos indicador = new EntidadIndicadoresAntropometricos(
                        rs.getInt("id_indicador"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("estatura"),
                        rs.getDouble("circunferencia_brazo"),
                        rs.getDouble("circunferencia_cintura"),
                        rs.getDouble("circunferencia_cadera"),
                        rs.getDouble("circunferencia_muslo")
                );
                indicadores.add(indicador);
            }
        }
        return indicadores;
    }

    // Método para obtener un indicador antropométrico por su ID
    public static EntidadIndicadoresAntropometricos PedirIndicadorPorId(int idIndicador) throws IllegalAccessError, SQLException, IOException {
        EntidadIndicadoresAntropometricos indicador = null;

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el indicador por su ID
        String sqlSquery = "SELECT * FROM Indicadores_Antropometricos WHERE id_indicador = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idIndicador);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                indicador = new EntidadIndicadoresAntropometricos(
                        rs.getInt("id_indicador"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("estatura"),
                        rs.getDouble("circunferencia_brazo"),
                        rs.getDouble("circunferencia_cintura"),
                        rs.getDouble("circunferencia_cadera"),
                        rs.getDouble("circunferencia_muslo")
                );
            }
        }
        return indicador;
    }

    // Método para verificar si existe un indicador antropométrico por su ID
    public static boolean existeIndicadorPorId(int idIndicador) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Indicadores_Antropometricos WHERE id_indicador = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idIndicador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un indicador con ese ID
            }
        }
        return false;
    }
    // Método para verificar si existe un antecedente médico por su ID
    public static boolean existeAntecedentePorId(int idAntecedente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Indicadores_Antropometricos WHERE id_indicador = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idAntecedente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un antecedente con ese ID
            }
        }
        return false;
    }
}