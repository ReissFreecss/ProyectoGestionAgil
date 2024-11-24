/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entidades.EntidadPaciente;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author darkd
 */
public class ControladorPaciente {

    // Método para obtener todos los Caracteristica de la base de datos
    public static ArrayList<EntidadPaciente> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadPaciente> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Caracteristica
        String sqlSquery = "SELECT * FROM pacientes";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadPaciente obj = new EntidadPaciente(
                        rs.getInt("id_paciente"),
                        rs.getString("nombre_completo"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("ocupacion"),
                        rs.getString("motivo_consulta"),
                        rs.getString("diagnostico"),
                        rs.getDate("fecha_consulta"),
                        rs.getString("telefono")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo paciente en la base de datos
    public static void Alta(EntidadPaciente obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo paciente (sin incluir el idPaciente, que se genera automáticamente)
        String sqlAlta = "INSERT INTO pacientes (nombre_completo, edad, sexo, ocupacion, motivo_consulta, diagnostico, fecha_consulta, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            // No incluimos el idPaciente porque es autogenerado
            ps.setString(1, obj.getNombreCompleto());
            ps.setInt(2, obj.getEdad());
            ps.setString(3, obj.getSexo());
            ps.setString(4, obj.getOcupacion());
            ps.setString(5, obj.getMotivoConsulta());
            ps.setString(6, obj.getDiagnostico());
            ps.setDate(7, new java.sql.Date(obj.getFechaConsulta().getTime())); // Conversión de java.util.Date a java.sql.Date
            ps.setString(8, obj.getTelefono());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un Caracteristica en la base de datos
    public static void Actualizar(EntidadPaciente paciente) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un Caracteristica
        String sqlActualizar = "UPDATE pacientes SET nombre_completo = ?, edad = ?, sexo = ?, ocupacion = ?, motivo_consulta = ?, diagnostico = ?, fecha_consulta = ?, telefono = ? WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setString(1, paciente.getNombreCompleto());
            ps.setInt(2, paciente.getEdad());
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getOcupacion());
            ps.setString(5, paciente.getMotivoConsulta());
            ps.setString(6, paciente.getDiagnostico());
            ps.setDate(7, new java.sql.Date(paciente.getFechaConsulta().getTime()));
            ps.setString(8, paciente.getTelefono());
            ps.setInt(9, paciente.getIdPaciente());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un Paciente de la base de datos
    public static void Eliminar(EntidadPaciente obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un paciente por su id
        String sqlBorrar = "DELETE FROM pacientes WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            // Pasa el idPaciente del objeto 'obj' al PreparedStatement
            ps.setInt(1, obj.getIdPaciente());  // Usar índice 1 y obtener el ID del paciente
            ps.executeUpdate();
        }
    }

    // Método para obtener un paciente por ID de la base de datos
    public static EntidadPaciente PedirPorId(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        EntidadPaciente paciente = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el paciente por ID
        String sqlSquery = "SELECT * FROM pacientes WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID en la consulta SQL
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el paciente, lo asigna al objeto paciente
            if (rs.next()) {
                paciente = new EntidadPaciente(
                        rs.getInt("id_paciente"),
                        rs.getString("nombre_completo"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("ocupacion"),
                        rs.getString("motivo_consulta"),
                        rs.getString("diagnostico"),
                        rs.getDate("fecha_consulta"),
                        rs.getString("telefono")
                );
            }
        }
        return paciente; // Retorna el paciente o null si no se encuentra
    }
    // Método para obtener pacientes por nombre de la base de datos

    public static ArrayList<EntidadPaciente> PedirPorNombre(String nombre) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadPaciente> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para buscar pacientes por nombre (usando LIKE para coincidencias parciales)
        String sqlSquery = "SELECT * FROM pacientes WHERE nombre_completo LIKE ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Agrega el nombre como parámetro de búsqueda con % para coincidencias parciales
            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadPaciente obj = new EntidadPaciente(
                        rs.getInt("id_paciente"),
                        rs.getString("nombre_completo"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("ocupacion"),
                        rs.getString("motivo_consulta"),
                        rs.getString("diagnostico"),
                        rs.getDate("fecha_consulta"),
                        rs.getString("telefono")
                );
                resultado.add(obj);
            }
        }

        return resultado; // Retorna una lista de pacientes con nombres que coinciden
    }
    // Método para verificar si existe un paciente por ID

    public static boolean existePacientePorId(int idPaciente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Pacientes WHERE id_paciente = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un paciente con ese ID
            }
        }
        return false;
    }

}
