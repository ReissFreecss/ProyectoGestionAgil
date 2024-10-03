package Controladores;

import Entidades.EntidadAntecedentesMedicos;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorAntecedentesMedicos {

    // Método para obtener todos los antecedentes médicos de la base de datos
    public static ArrayList<EntidadAntecedentesMedicos> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadAntecedentesMedicos> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Antecedentes_Medicos
        String sqlSquery = "SELECT * FROM Antecedentes_Medicos";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadAntecedentesMedicos obj = new EntidadAntecedentesMedicos(
                        rs.getInt("id_antecedente"),
                        rs.getInt("id_paciente"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("medicamentos"),
                        rs.getDate("inicio_medicacion"),
                        rs.getDate("ultima_desparasitacion"),
                        rs.getDate("ultima_realizacion_laboratorios"),
                        rs.getString("alergia_intolerancia_alimentos")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo antecedente médico en la base de datos
    public static void Alta(EntidadAntecedentesMedicos obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo antecedente médico
        String sqlAlta = "INSERT INTO Antecedentes_Medicos (id_paciente, enfermedad_diagnosticada, medicamentos, inicio_medicacion, ultima_desparasitacion, ultima_realizacion_laboratorios, alergia_intolerancia_alimentos) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getEnfermedadDiagnosticada());
            ps.setString(3, obj.getMedicamentos());
            ps.setDate(4, obj.getInicioMedicación());
            ps.setDate(5, obj.getUltimaDesparasitacion());
            ps.setDate(6, obj.getUltimaRealizacionLaboratorios());
            ps.setString(7, obj.getAlergiaIntoleranciaAlimentos());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un antecedente médico en la base de datos
    public static void Actualizar(EntidadAntecedentesMedicos antecedente) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un antecedente médico
        String sqlActualizar = "UPDATE Antecedentes_Medicos SET id_paciente = ?, enfermedad_diagnosticada = ?, medicamentos = ?, inicio_medicacion = ?, ultima_desparasitacion = ?, ultima_realizacion_laboratorios = ?, alergia_intolerancia_alimentos = ? WHERE id_antecedente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, antecedente.getIdPaciente());
            ps.setString(2, antecedente.getEnfermedadDiagnosticada());
            ps.setString(3, antecedente.getMedicamentos());
            ps.setDate(4, antecedente.getInicioMedicación());
            ps.setDate(5, antecedente.getUltimaDesparasitacion());
            ps.setDate(6, antecedente.getUltimaRealizacionLaboratorios());
            ps.setString(7, antecedente.getAlergiaIntoleranciaAlimentos());
            ps.setInt(8, antecedente.getIdAntecedente());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un antecedente médico de la base de datos
    public static void Eliminar(EntidadAntecedentesMedicos obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un antecedente médico por su id
        String sqlBorrar = "DELETE FROM Antecedentes_Medicos WHERE id_antecedente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdAntecedente()); // Usar índice 1 y obtener el ID del antecedente médico
            ps.executeUpdate();
        }
    }

    public static ArrayList<EntidadAntecedentesMedicos> PedirAntecedentesPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadAntecedentesMedicos> antecedentes = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener antecedentes médicos por ID de paciente
        String sqlSquery = "SELECT * FROM antecedentes_medicos WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del paciente en la consulta SQL
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadAntecedentesMedicos antecedente = new EntidadAntecedentesMedicos(
                        rs.getInt("id_antecedente"),
                        rs.getInt("id_paciente"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("medicamentos"),
                        rs.getDate("inicio_medicacion"),
                        rs.getDate("ultima_desparasitacion"),
                        rs.getDate("ultima_realizacion_laboratorios"),
                        rs.getString("alergia_intolerancia_alimentos")
                );
                antecedentes.add(antecedente);
            }
        }
        return antecedentes; // Retorna una lista de antecedentes médicos o una lista vacía
    }

    public static EntidadAntecedentesMedicos PedirAntecedentePorId(int idAntecedente) throws IllegalAccessError, SQLException, IOException {
        EntidadAntecedentesMedicos antecedente = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el antecedente médico por ID de antecedente
        String sqlSquery = "SELECT * FROM antecedentes_medicos WHERE id_antecedente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del antecedente médico en la consulta SQL
            ps.setInt(1, idAntecedente);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el antecedente, lo asigna al objeto antecedente
            if (rs.next()) {
                antecedente = new EntidadAntecedentesMedicos(
                        rs.getInt("id_antecedente"),
                        rs.getInt("id_paciente"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("medicamentos"),
                        rs.getDate("inicio_medicacion"),
                        rs.getDate("ultima_desparasitacion"),
                        rs.getDate("ultima_realizacion_laboratorios"),
                        rs.getString("alergia_intolerancia_alimentos")
                );
            }
        }
        return antecedente; // Retorna el antecedente médico o null si no se encuentra
    }
    
    // Método para verificar si existe un antecedente médico por su ID
    public static boolean existeAntecedentePorId(int idAntecedente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Antecedentes_Medicos WHERE id_antecedente = ?";
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
