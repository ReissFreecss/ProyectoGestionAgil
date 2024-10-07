/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.EntidadDietaEspecial;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author darkd
 */
public class ControladorDietaEspecial {

    // Método para obtener todas las dietas especiales de la base de datos
    public static ArrayList<EntidadDietaEspecial> PedirTodas() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDietaEspecial> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Dieta_Especial
        String sqlSquery = "SELECT * FROM Dieta_Especial";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDietaEspecial obj = new EntidadDietaEspecial(
                        rs.getInt("id_dieta_especial"),
                        rs.getInt("id_paciente"),
                        rs.getString("dieta_especial"),
                        rs.getString("tipo_dieta"),
                        rs.getString("tiempo_dieta_especial"),
                        rs.getString("razon_dieta_especial"),
                        rs.getString("resultado_dieta_especial"),
                        rs.getString("apego_dieta")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar una nueva dieta especial en la base de datos
    public static void Alta(EntidadDietaEspecial obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar una nueva dieta especial
        String sqlAlta = "INSERT INTO Dieta_Especial (id_paciente, dieta_especial, tipo_dieta, tiempo_dieta_especial, razon_dieta_especial, resultado_dieta_especial, apego_dieta) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getDietaEspecial());
            ps.setString(3, obj.getTipoDieta());
            ps.setString(4, obj.getTiempoDietaEspecial());
            ps.setString(5, obj.getRazonDietaEspecial());
            ps.setString(6, obj.getResultadoDietaEspecial());
            ps.setString(7, obj.getApegoDieta());

            ps.executeUpdate();
        }
    }

    // Método para actualizar una dieta especial en la base de datos
    public static void Actualizar(EntidadDietaEspecial dieta) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar una dieta especial
        String sqlActualizar = "UPDATE Dieta_Especial SET id_paciente = ?, dieta_especial = ?, tipo_dieta = ?, tiempo_dieta_especial = ?, razon_dieta_especial = ?, resultado_dieta_especial = ?, apego_dieta = ? WHERE id_dieta_especial = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, dieta.getIdPaciente());
            ps.setString(2, dieta.getDietaEspecial());
            ps.setString(3, dieta.getTipoDieta());
            ps.setString(4, dieta.getTiempoDietaEspecial());
            ps.setString(5, dieta.getRazonDietaEspecial());
            ps.setString(6, dieta.getResultadoDietaEspecial());
            ps.setString(7, dieta.getApegoDieta());
            ps.setInt(8, dieta.getIdDietaEspecial());

            ps.executeUpdate();
        }
    }

    // Método para eliminar una dieta especial de la base de datos
    public static void Eliminar(EntidadDietaEspecial obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar una dieta especial por su id
        String sqlBorrar = "DELETE FROM Dieta_Especial WHERE id_dieta_especial = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdDietaEspecial());
            ps.executeUpdate();
        }
    }

    // Método para obtener dietas especiales por el ID de paciente
    public static ArrayList<EntidadDietaEspecial> PedirDietasPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDietaEspecial> dietas = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener dietas especiales por ID de paciente
        String sqlSquery = "SELECT * FROM Dieta_Especial WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDietaEspecial dieta = new EntidadDietaEspecial(
                        rs.getInt("id_dieta_especial"),
                        rs.getInt("id_paciente"),
                        rs.getString("dieta_especial"),
                        rs.getString("tipo_dieta"),
                        rs.getString("tiempo_dieta_especial"),
                        rs.getString("razon_dieta_especial"),
                        rs.getString("resultado_dieta_especial"),
                        rs.getString("apego_dieta")
                );
                dietas.add(dieta);
            }
        }
        return dietas;
    }

    // Método para obtener una dieta especial por ID
    public static EntidadDietaEspecial PedirDietaPorId(int idDietaEspecial) throws IllegalAccessError, SQLException, IOException {
        EntidadDietaEspecial dieta = null;

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener una dieta especial por ID
        String sqlSquery = "SELECT * FROM Dieta_Especial WHERE id_dieta_especial = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idDietaEspecial);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new EntidadDietaEspecial(
                        rs.getInt("id_dieta_especial"),
                        rs.getInt("id_paciente"),
                        rs.getString("dieta_especial"),
                        rs.getString("tipo_dieta"),
                        rs.getString("tiempo_dieta_especial"),
                        rs.getString("razon_dieta_especial"),
                        rs.getString("resultado_dieta_especial"),
                        rs.getString("apego_dieta")
                );
            }
        }
        return dieta;
    }
    
    // Método para verificar si existe una dieta especial por su ID
    public static boolean existeDietaPorId(int idDietaEspecial) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Dieta_Especial WHERE id_dieta_especial = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idDietaEspecial);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}