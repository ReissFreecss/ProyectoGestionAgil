package Controladores;

/**
 *
 * @author darkd
 */
import Entidades.EntidadDatosInterpretacion;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControladorDatosInterpretacion {

    // Método para obtener todos los registros de la tabla Datos_Interpretacion
    public static ArrayList<EntidadDatosInterpretacion> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDatosInterpretacion> resultado = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Datos_Interpretacion";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDatosInterpretacion obj = new EntidadDatosInterpretacion(
                        rs.getInt("id_datos_interpretacion"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("porcentaje_grasa_corporal"),
                        rs.getDouble("masa_muscular"),
                        rs.getDouble("masa_osea"),
                        rs.getDouble("imc"),
                        rs.getDouble("ingesta_kilocalorias"),
                        rs.getInt("edad_metabolica"),
                        rs.getDouble("porcentaje_agua_corporal"),
                        rs.getDouble("grasa_visceral"),
                        rs.getDouble("pliegue_tricipital"),
                        rs.getDouble("pliegue_bicipital"),
                        rs.getDouble("pliegue_suprailiaco"),
                        rs.getDouble("pliegue_subescapular")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo registro en Datos_Interpretacion
    public static void Alta(EntidadDatosInterpretacion obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlAlta = "INSERT INTO Datos_Interpretacion (id_paciente, fecha, peso, porcentaje_grasa_corporal, masa_muscular, masa_osea, imc, ingesta_kilocalorias, edad_metabolica, porcentaje_agua_corporal, grasa_visceral, pliegue_tricipital, pliegue_bicipital, pliegue_suprailiaco, pliegue_subescapular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setDate(2, (Date) obj.getFecha());
            ps.setDouble(3, obj.getPeso());
            ps.setDouble(4, obj.getPorcentajeGrasaCorporal());
            ps.setDouble(5, obj.getMasaMuscular());
            ps.setDouble(6, obj.getMasaOsea());
            ps.setDouble(7, obj.getImc());
            ps.setDouble(8, obj.getIngestaKilocalorias());
            ps.setInt(9, obj.getEdadMetabolica());
            ps.setDouble(10, obj.getPorcentajeAguaCorporal());
            ps.setDouble(11, obj.getGrasaVisceral());
            ps.setDouble(12, obj.getPliegueTricipital());
            ps.setDouble(13, obj.getPliegueBicipital());
            ps.setDouble(14, obj.getPliegueSuprailiaco());
            ps.setDouble(15, obj.getPliegueSubescapular());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un registro en Datos_Interpretacion
    public static void Actualizar(EntidadDatosInterpretacion obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlActualizar = "UPDATE Datos_Interpretacion SET id_paciente = ?, fecha = ?, peso = ?, porcentaje_grasa_corporal = ?, masa_muscular = ?, masa_osea = ?, imc = ?, ingesta_kilocalorias = ?, edad_metabolica = ?, porcentaje_agua_corporal = ?, grasa_visceral = ?, pliegue_tricipital = ?, pliegue_bicipital = ?, pliegue_suprailiaco = ?, pliegue_subescapular = ? WHERE id_datos_interpretacion = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setDate(2, (Date) obj.getFecha());
            ps.setDouble(3, obj.getPeso());
            ps.setDouble(4, obj.getPorcentajeGrasaCorporal());
            ps.setDouble(5, obj.getMasaMuscular());
            ps.setDouble(6, obj.getMasaOsea());
            ps.setDouble(7, obj.getImc());
            ps.setDouble(8, obj.getIngestaKilocalorias());
            ps.setInt(9, obj.getEdadMetabolica());
            ps.setDouble(10, obj.getPorcentajeAguaCorporal());
            ps.setDouble(11, obj.getGrasaVisceral());
            ps.setDouble(12, obj.getPliegueTricipital());
            ps.setDouble(13, obj.getPliegueBicipital());
            ps.setDouble(14, obj.getPliegueSuprailiaco());
            ps.setDouble(15, obj.getPliegueSubescapular());
            ps.setInt(16, obj.getIdDatosInterpretacion());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un registro de Datos_Interpretacion
    public static void Eliminar(EntidadDatosInterpretacion obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlBorrar = "DELETE FROM Datos_Interpretacion WHERE id_datos_interpretacion = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdDatosInterpretacion());
            ps.executeUpdate();
        }
    }

    // Método para obtener registros de Datos_Interpretacion por ID de paciente
    public static ArrayList<EntidadDatosInterpretacion> PedirDatosPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadDatosInterpretacion> datos = new ArrayList<>();

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Datos_Interpretacion WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadDatosInterpretacion dato = new EntidadDatosInterpretacion(
                        rs.getInt("id_datos_interpretacion"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("porcentaje_grasa_corporal"),
                        rs.getDouble("masa_muscular"),
                        rs.getDouble("masa_osea"),
                        rs.getDouble("imc"),
                        rs.getDouble("ingesta_kilocalorias"),
                        rs.getInt("edad_metabolica"),
                        rs.getDouble("porcentaje_agua_corporal"),
                        rs.getDouble("grasa_visceral"),
                        rs.getDouble("pliegue_tricipital"),
                        rs.getDouble("pliegue_bicipital"),
                        rs.getDouble("pliegue_suprailiaco"),
                        rs.getDouble("pliegue_subescapular")
                );
                datos.add(dato);
            }
        }
        return datos;
    }

    // Método para obtener un registro por su ID
    public static EntidadDatosInterpretacion PedirDatoPorId(int idDatosInterpretacion) throws IllegalAccessError, SQLException, IOException {
        EntidadDatosInterpretacion dato = null;

        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        String sqlSquery = "SELECT * FROM Datos_Interpretacion WHERE id_datos_interpretacion = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idDatosInterpretacion);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dato = new EntidadDatosInterpretacion(
                        rs.getInt("id_datos_interpretacion"),
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha"),
                        rs.getDouble("peso"),
                        rs.getDouble("porcentaje_grasa_corporal"),
                        rs.getDouble("masa_muscular"),
                        rs.getDouble("masa_osea"),
                        rs.getDouble("imc"),
                        rs.getDouble("ingesta_kilocalorias"),
                        rs.getInt("edad_metabolica"),
                        rs.getDouble("porcentaje_agua_corporal"),
                        rs.getDouble("grasa_visceral"),
                        rs.getDouble("pliegue_tricipital"),
                        rs.getDouble("pliegue_bicipital"),
                        rs.getDouble("pliegue_suprailiaco"),
                        rs.getDouble("pliegue_subescapular")
                );
            }
        }
        return dato;
    }
    // Método para verificar si existe un antecedente médico por su ID
    public static boolean existeAntecedentePorId(int idAntecedente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Datos_Interpretacion WHERE id_datos_interpretacion = ?";
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