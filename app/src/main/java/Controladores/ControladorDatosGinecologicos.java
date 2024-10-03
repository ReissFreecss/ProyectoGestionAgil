package Controladores;

import Controladores.ControladorBDSQL;
import Entidades.EntidadDatosGinecologicos;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControladorDatosGinecologicos {

    // Método para obtener todos los datos ginecológicos de la base de datos
    public static ArrayList<EntidadDatosGinecologicos> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDatosGinecologicos> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Datos_Ginecologicos
        String sqlSquery = "SELECT * FROM Datos_Ginecologicos";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDatosGinecologicos obj = new EntidadDatosGinecologicos(
                        rs.getInt("id_ginecologico"),
                        rs.getInt("id_paciente"),
                        rs.getString("embarazo_actual"),
                        rs.getString("sdg"),
                        rs.getString("referido_por_paciente"),
                        rs.getDate("fum"),
                        rs.getString("anticonceptivos_orales"),
                        rs.getString("dosis_anticonceptivo"),
                        rs.getInt("num_embarazos")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo dato ginecológico en la base de datos
    public static void Alta(EntidadDatosGinecologicos obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo dato ginecológico
        String sqlAlta = "INSERT INTO Datos_Ginecologicos (id_paciente, embarazo_actual, sdg, referido_por_paciente, fum, anticonceptivos_orales, dosis_anticonceptivo, num_embarazos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getEmbarazoActual());
            ps.setString(3, obj.getSdg());
            ps.setString(4, obj.getReferidoPorPaciente());
            ps.setDate(5, obj.getFum());
            ps.setString(6, obj.getAnticonceptivosOrales());
            ps.setString(7, obj.getDosisAnticonceptivo());
            ps.setInt(8, obj.getNumEmbarazos());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un dato ginecológico en la base de datos
    public static void Actualizar(EntidadDatosGinecologicos dato) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un dato ginecológico
        String sqlActualizar = "UPDATE Datos_Ginecologicos SET id_paciente = ?, embarazo_actual = ?, sdg = ?, referido_por_paciente = ?, fum = ?, anticonceptivos_orales = ?, dosis_anticonceptivo = ?, num_embarazos = ? WHERE id_ginecologico = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, dato.getIdPaciente());
            ps.setString(2, dato.getEmbarazoActual());
            ps.setString(3, dato.getSdg());
            ps.setString(4, dato.getReferidoPorPaciente());
            ps.setDate(5, dato.getFum());
            ps.setString(6, dato.getAnticonceptivosOrales());
            ps.setString(7, dato.getDosisAnticonceptivo());
            ps.setInt(8, dato.getNumEmbarazos());
            ps.setInt(9, dato.getIdGinecologico());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un dato ginecológico de la base de datos
    public static void Eliminar(EntidadDatosGinecologicos obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un dato ginecológico por su id
        String sqlBorrar = "DELETE FROM Datos_Ginecologicos WHERE id_ginecologico = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdGinecologico()); // Usar índice 1 y obtener el ID del dato ginecológico
            ps.executeUpdate();
        }
    }

    public static ArrayList<EntidadDatosGinecologicos> PedirDatosPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDatosGinecologicos> datos = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener datos ginecológicos por ID de paciente
        String sqlSquery = "SELECT * FROM Datos_Ginecologicos WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del paciente en la consulta SQL
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadDatosGinecologicos dato = new EntidadDatosGinecologicos(
                        rs.getInt("id_ginecologico"),
                        rs.getInt("id_paciente"),
                        rs.getString("embarazo_actual"),
                        rs.getString("sdg"),
                        rs.getString("referido_por_paciente"),
                        rs.getDate("fum"),
                        rs.getString("anticonceptivos_orales"),
                        rs.getString("dosis_anticonceptivo"),
                        rs.getInt("num_embarazos")
                );
                datos.add(dato);
            }
        }
        return datos; // Retorna una lista de datos ginecológicos o una lista vacía
    }

    public static EntidadDatosGinecologicos PedirDatoPorId(int idGinecologico) throws IllegalAccessError, SQLException, IOException {
        EntidadDatosGinecologicos dato = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el dato ginecológico por ID de dato ginecológico
        String sqlSquery = "SELECT * FROM Datos_Ginecologicos WHERE id_ginecologico = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del dato ginecológico en la consulta SQL
            ps.setInt(1, idGinecologico);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el dato, lo asigna al objeto dato
            if (rs.next()) {
                dato = new EntidadDatosGinecologicos(
                        rs.getInt("id_ginecologico"),
                        rs.getInt("id_paciente"),
                        rs.getString("embarazo_actual"),
                        rs.getString("sdg"),
                        rs.getString("referido_por_paciente"),
                        rs.getDate("fum"),
                        rs.getString("anticonceptivos_orales"),
                        rs.getString("dosis_anticonceptivo"),
                        rs.getInt("num_embarazos")
                );
            }
        }
        return dato; // Retorna el dato ginecológico o null si no se encuentra
    }
    
    // Método para verificar si existe un dato ginecológico por su ID
    public static boolean existeDatoPorId(int idGinecologico) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Datos_Ginecologicos WHERE id_ginecologico = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idGinecologico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un dato con ese ID
            }
        }
        return false; // Retorna false si no existe
    }
}
