package Controladores;

import Entidades.EntidadConsumoSustancias;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorConsumoSustancias {

    // Método para obtener todos los registros de consumo de sustancias de la base de datos
    public static ArrayList<EntidadConsumoSustancias> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadConsumoSustancias> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Consumo_Sustancias
        String sqlSquery = "SELECT * FROM Consumo_Sustancias";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadConsumoSustancias obj = new EntidadConsumoSustancias(
                        rs.getInt("id_consumo_sustancia"),
                        rs.getInt("id_paciente"),
                        rs.getString("sustancia"),
                        rs.getString("tipo"),
                        rs.getInt("frecuencia"),
                        rs.getString("cantidad")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo registro de consumo de sustancias en la base de datos
    public static void Alta(EntidadConsumoSustancias obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo registro de consumo de sustancias
        String sqlAlta = "INSERT INTO Consumo_Sustancias (id_paciente, sustancia, tipo, frecuencia, cantidad) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getSustancia());
            ps.setString(3, obj.getTipo());
            ps.setInt(4, obj.getFrecuencia());
            ps.setString(5, obj.getCantidad());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un registro de consumo de sustancias en la base de datos
    public static void Actualizar(EntidadConsumoSustancias consumo) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un registro de consumo de sustancias
        String sqlActualizar = "UPDATE Consumo_Sustancias SET id_paciente = ?, sustancia = ?, tipo = ?, frecuencia = ?, cantidad = ? WHERE id_consumo_sustancia = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, consumo.getIdPaciente());
            ps.setString(2, consumo.getSustancia());
            ps.setString(3, consumo.getTipo());
            ps.setInt(4, consumo.getFrecuencia());
            ps.setString(5, consumo.getCantidad());
            ps.setInt(6, consumo.getIdConsumoSustancia());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un registro de consumo de sustancias de la base de datos
    public static void Eliminar(EntidadConsumoSustancias obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un registro de consumo de sustancias por su id
        String sqlBorrar = "DELETE FROM Consumo_Sustancias WHERE id_consumo_sustancia = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdConsumoSustancia());
            ps.executeUpdate();
        }
    }

    // Método para obtener registros de consumo de sustancias por ID de paciente
    public static ArrayList<EntidadConsumoSustancias> PedirConsumoPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadConsumoSustancias> consumos = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener consumos de sustancias por ID de paciente
        String sqlSquery = "SELECT * FROM Consumo_Sustancias WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadConsumoSustancias consumo = new EntidadConsumoSustancias(
                        rs.getInt("id_consumo_sustancia"),
                        rs.getInt("id_paciente"),
                        rs.getString("sustancia"),
                        rs.getString("tipo"),
                        rs.getInt("frecuencia"),
                        rs.getString("cantidad")
                );
                consumos.add(consumo);
            }
        }
        return consumos; // Retorna una lista de consumos o una lista vacía
    }

    // Método para obtener un registro de consumo de sustancias por ID
     public static EntidadConsumoSustancias PedirConsumoPorId(int idConsumo) throws IllegalAccessError, SQLException, IOException {
        EntidadConsumoSustancias consumo = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el registro de consumo de sustancias por ID
        String sqlSquery = "SELECT * FROM Consumo_Sustancias WHERE id_consumo_sustancia = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idConsumo);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el registro, lo asigna al objeto consumo
            if (rs.next()) {
                consumo = new EntidadConsumoSustancias(
                        rs.getInt("id_consumo_sustancia"),
                        rs.getInt("id_paciente"),
                        rs.getString("sustancia"),
                        rs.getString("tipo"),
                        rs.getInt("frecuencia"),
                        rs.getString("cantidad")
                );
            }
        }
        return consumo; // Retorna el registro de consumo o null si no se encuentra
    }

    // Método para verificar si existe un registro de consumo de sustancias por su ID
    public static boolean existeConsumoPorId(int idConsumo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Consumo_Sustancias WHERE id_consumo_sustancia = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idConsumo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un registro con ese ID
            }
        }
        return false;
    }
}