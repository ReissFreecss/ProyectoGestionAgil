package Controladores;

import Entidades.EntidadComidas;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author darkd
 */
public class ControladorComidas {

    // Método para obtener todas las comidas de la base de datos
    public static ArrayList<EntidadComidas> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadComidas> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Comidas
        String sqlSquery = "SELECT * FROM Comidas";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadComidas obj = new EntidadComidas(
                        rs.getInt("id_comidas"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("platillo"),
                        rs.getString("ingredientes"),
                        rs.getString("cantidad"),
                        rs.getString("come_calle"),
                        rs.getInt("frecuencia_comida_calle")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar una nueva comida en la base de datos
    public static void Alta(EntidadComidas obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar una nueva comida
        String sqlAlta = "INSERT INTO Comidas (id_paciente, comida, horario, platillo, ingredientes, cantidad, come_calle, frecuencia_comida_calle) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getComida());
            ps.setString(3, obj.getHorario());
            ps.setString(4, obj.getPlatillo());
            ps.setString(5, obj.getIngredientes());
            ps.setString(6, obj.getCantidad());
            ps.setString(7, obj.getComeCalle());
            ps.setInt(8, obj.getFrecuenciaComidaCalle());

            ps.executeUpdate();
        }
    }

    // Método para actualizar una comida en la base de datos
    public static void Actualizar(EntidadComidas comida) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar una comida
        String sqlActualizar = "UPDATE Comidas SET id_paciente = ?, comida = ?, horario = ?, platillo = ?, ingredientes = ?, cantidad = ?, come_calle = ?, frecuencia_comida_calle = ? WHERE id_comidas = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, comida.getIdPaciente());
            ps.setString(2, comida.getComida());
            ps.setString(3, comida.getHorario());
            ps.setString(4, comida.getPlatillo());
            ps.setString(5, comida.getIngredientes());
            ps.setString(6, comida.getCantidad());
            ps.setString(7, comida.getComeCalle());
            ps.setInt(8, comida.getFrecuenciaComidaCalle());
            ps.setInt(9, comida.getIdComidas());

            ps.executeUpdate();
        }
    }

    // Método para eliminar una comida de la base de datos
    public static void Eliminar(EntidadComidas obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar una comida por su id
        String sqlBorrar = "DELETE FROM Comidas WHERE id_comidas = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdComidas()); // Usar índice 1 y obtener el ID de la comida
            ps.executeUpdate();
        }
    }

    public static ArrayList<EntidadComidas> PedirComidasPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadComidas> comidas = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener comidas por ID de paciente
        String sqlSquery = "SELECT * FROM Comidas WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del paciente en la consulta SQL
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadComidas comida = new EntidadComidas(
                        rs.getInt("id_comidas"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("platillo"),
                        rs.getString("ingredientes"),
                        rs.getString("cantidad"),
                        rs.getString("come_calle"),
                        rs.getInt("frecuencia_comida_calle")
                );
                comidas.add(comida);
            }
        }
        return comidas; // Retorna una lista de comidas o una lista vacía
    }

    public static EntidadComidas PedirComidaPorId(int idComida) throws IllegalAccessError, SQLException, IOException {
        EntidadComidas comida = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener la comida por ID
        String sqlSquery = "SELECT * FROM Comidas WHERE id_comidas = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID de la comida en la consulta SQL
            ps.setInt(1, idComida);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra la comida, la asigna al objeto comida
            if (rs.next()) {
                comida = new EntidadComidas(
                        rs.getInt("id_comidas"),
                        rs.getInt("id_paciente"),
                        rs.getString("comida"),
                        rs.getString("horario"),
                        rs.getString("platillo"),
                        rs.getString("ingredientes"),
                        rs.getString("cantidad"),
                        rs.getString("come_calle"),
                        rs.getInt("frecuencia_comida_calle")
                );
            }
        }
        return comida; // Retorna la comida o null si no se encuentra
    }

    // Método para verificar si existe una comida por su ID
    public static boolean existeComidaPorId(int idComida) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Comidas WHERE id_comidas = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idComida);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos una comida con ese ID
            }
        }
        return false;
    }
}