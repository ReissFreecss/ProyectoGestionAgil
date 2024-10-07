/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author darkd
 */
import Entidades.EntidadDietas;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControladorDietas {

    // Método para obtener todos los registros de la tabla Dietas
    public static ArrayList<EntidadDietas> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDietas> resultado = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Dietas";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDietas obj = new EntidadDietas(
                        rs.getInt("id_dieta"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("porciones"),
                        rs.getString("ingredientes"),
                        rs.getString("suplemento"),
                        rs.getString("dosis_suplemento")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo registro en Dietas
    public static void Alta(EntidadDietas obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlAlta = "INSERT INTO Dietas (id_paciente, comida, horario, porciones, ingredientes, suplemento, dosis_suplemento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getComida());
            ps.setString(3, obj.getHorario());
            ps.setString(4, obj.getPorciones());
            ps.setString(5, obj.getIngredientes());
            ps.setString(6, obj.getSuplemento());
            ps.setString(7, obj.getDosisSuplemento());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un registro en Dietas
    public static void Actualizar(EntidadDietas obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlActualizar = "UPDATE Dietas SET id_paciente = ?, comida = ?, horario = ?, porciones = ?, ingredientes = ?, suplemento = ?, dosis_suplemento = ? WHERE id_dieta = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getComida());
            ps.setString(3, obj.getHorario());
            ps.setString(4, obj.getPorciones());
            ps.setString(5, obj.getIngredientes());
            ps.setString(6, obj.getSuplemento());
            ps.setString(7, obj.getDosisSuplemento());
            ps.setInt(8, obj.getIdDieta());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un registro de Dietas
    public static void Eliminar(EntidadDietas obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlBorrar = "DELETE FROM Dietas WHERE id_dieta = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdDieta());
            ps.executeUpdate();
        }
    }

    // Método para obtener registros de Dietas por ID de paciente
    public static ArrayList<EntidadDietas> PedirDietasPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDietas> dietas = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Dietas WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDietas dieta = new EntidadDietas(
                        rs.getInt("id_dieta"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("porciones"),
                        rs.getString("ingredientes"),
                        rs.getString("suplemento"),
                        rs.getString("dosis_suplemento")
                );
                dietas.add(dieta);
            }
        }
        return dietas;
    }

    // Método para obtener un registro por su ID
    public static EntidadDietas PedirDietaPorId(int idDieta) throws IllegalAccessError, SQLException, IOException {
        EntidadDietas dieta = null;

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Dietas WHERE id_dieta = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idDieta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new EntidadDietas(
                        rs.getInt("id_dieta"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("porciones"),
                        rs.getString("ingredientes"),
                        rs.getString("suplemento"),
                        rs.getString("dosis_suplemento")
                );
            }
        }
        return dieta;
    }
}

