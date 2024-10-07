package Controladores;

/**
 *
 * @author darkd
 */
import Entidades.EntidadIndicadoresDieteticos;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControladorIndicadoresDieteticos {

    // Método para obtener todos los indicadores dietéticos de la base de datos
    public static ArrayList<EntidadIndicadoresDieteticos> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadIndicadoresDieteticos> resultado = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Indicadores_Dieteticos";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadIndicadoresDieteticos obj = new EntidadIndicadoresDieteticos(
                    rs.getInt("id_indicadores_dieteticos"),
                    rs.getInt("id_paciente"),
                    rs.getString("preparador_alimentos"),
                    rs.getString("hora_apetito"),
                    rs.getString("alimentos_preferidos"),
                    rs.getString("alimentos_no_preferidos"),
                    rs.getString("suplemento"),
                    rs.getString("dosis_suplemento"),
                    rs.getDouble("agua_consumida"),
                    rs.getDouble("refresco_consumido"),
                    rs.getDouble("leche_consumida"),
                    rs.getString("medicamentos_bajar_peso")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo indicador dietético en la base de datos
    public static void Alta(EntidadIndicadoresDieteticos obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlAlta = "INSERT INTO Indicadores_Dieteticos (id_paciente, preparador_alimentos, hora_apetito, alimentos_preferidos, alimentos_no_preferidos, suplemento, dosis_suplemento, agua_consumida, refresco_consumido, leche_consumida, medicamentos_bajar_peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getPreparadorAlimentos());
            ps.setString(3, obj.getHoraApetito());
            ps.setString(4, obj.getAlimentosPreferidos());
            ps.setString(5, obj.getAlimentosNoPreferidos());
            ps.setString(6, obj.getSuplemento());
            ps.setString(7, obj.getDosisSuplemento());
            ps.setDouble(8, obj.getAguaConsumida());
            ps.setDouble(9, obj.getRefrescoConsumido());
            ps.setDouble(10, obj.getLecheConsumida());
            ps.setString(11, obj.getMedicamentosBajarPeso());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un indicador dietético en la base de datos
    public static void Actualizar(EntidadIndicadoresDieteticos indicador) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlActualizar = "UPDATE Indicadores_Dieteticos SET id_paciente = ?, preparador_alimentos = ?, hora_apetito = ?, alimentos_preferidos = ?, alimentos_no_preferidos = ?, suplemento = ?, dosis_suplemento = ?, agua_consumida = ?, refresco_consumido = ?, leche_consumida = ?, medicamentos_bajar_peso = ? WHERE id_indicadores_dieteticos = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, indicador.getIdPaciente());
            ps.setString(2, indicador.getPreparadorAlimentos());
            ps.setString(3, indicador.getHoraApetito());
            ps.setString(4, indicador.getAlimentosPreferidos());
            ps.setString(5, indicador.getAlimentosNoPreferidos());
            ps.setString(6, indicador.getSuplemento());
            ps.setString(7, indicador.getDosisSuplemento());
            ps.setDouble(8, indicador.getAguaConsumida());
            ps.setDouble(9, indicador.getRefrescoConsumido());
            ps.setDouble(10, indicador.getLecheConsumida());
            ps.setString(11, indicador.getMedicamentosBajarPeso());
            ps.setInt(12, indicador.getIdIndicadoresDieteticos());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un indicador dietético de la base de datos
    public static void Eliminar(EntidadIndicadoresDieteticos obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlBorrar = "DELETE FROM Indicadores_Dieteticos WHERE id_indicadores_dieteticos = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdIndicadoresDieteticos());
            ps.executeUpdate();
        }
    }

    // Método para obtener los indicadores dietéticos de un paciente por su ID
    public static ArrayList<EntidadIndicadoresDieteticos> PedirPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadIndicadoresDieteticos> indicadores = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Indicadores_Dieteticos WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadIndicadoresDieteticos indicador = new EntidadIndicadoresDieteticos(
                    rs.getInt("id_indicadores_dieteticos"),
                    rs.getInt("id_paciente"),
                    rs.getString("preparador_alimentos"),
                    rs.getString("hora_apetito"),
                    rs.getString("alimentos_preferidos"),
                    rs.getString("alimentos_no_preferidos"),
                    rs.getString("suplemento"),
                    rs.getString("dosis_suplemento"),
                    rs.getDouble("agua_consumida"),
                    rs.getDouble("refresco_consumido"),
                    rs.getDouble("leche_consumida"),
                    rs.getString("medicamentos_bajar_peso")
                );
                indicadores.add(indicador);
            }
        }
        return indicadores;
    }
}