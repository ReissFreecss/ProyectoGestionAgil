package Controladores;

import java.util.ArrayList;
import Entidades.EntidadAntecedentesFamilares;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorAntecedentesFamiliares {

    // Método para obtener todos los antecedentes familiares de la base de datos
    public static ArrayList<EntidadAntecedentesFamilares> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadAntecedentesFamilares> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Antecedentes_Familiares
        String sqlSquery = "SELECT * FROM Antecedentes_Familiares";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadAntecedentesFamilares obj = new EntidadAntecedentesFamilares(
                        rs.getInt("id_antecedente_familiar"),
                        rs.getInt("id_paciente"),
                        rs.getString("parentezco"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("alergias_medicamentos")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo antecedente familiar en la base de datos
    public static void Alta(EntidadAntecedentesFamilares obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo antecedente familiar
        String sqlAlta = "INSERT INTO Antecedentes_Familiares (id_paciente, parentezco, enfermedad_diagnosticada, alergias_medicamentos) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getParentezco());
            ps.setString(3, obj.getEnfermedadDiagnosticada());
            ps.setString(4, obj.getAlergiasMedicamentos());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un antecedente familiar en la base de datos
    public static void Actualizar(EntidadAntecedentesFamilares antecedente) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un antecedente familiar
        String sqlActualizar = "UPDATE Antecedentes_Familiares SET id_paciente = ?, parentezco = ?, enfermedad_diagnosticada = ?, alergias_medicamentos = ? WHERE id_antecedente_familiar = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, antecedente.getIdPaciente());
            ps.setString(2, antecedente.getParentezco());
            ps.setString(3, antecedente.getEnfermedadDiagnosticada());
            ps.setString(4, antecedente.getAlergiasMedicamentos());
            ps.setInt(5, antecedente.getIdAntecedenteFamiliar());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un antecedente familiar de la base de datos
    public static void Eliminar(EntidadAntecedentesFamilares obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un antecedente familiar por su id
        String sqlBorrar = "DELETE FROM Antecedentes_Familiares WHERE id_antecedente_familiar = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdAntecedenteFamiliar());
            ps.executeUpdate();
        }
    }

    // Método para obtener antecedentes familiares por ID de paciente
    public static ArrayList<EntidadAntecedentesFamilares> PedirAntecedentesPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadAntecedentesFamilares> antecedentes = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener antecedentes familiares por ID de paciente
        String sqlSquery = "SELECT * FROM Antecedentes_Familiares WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadAntecedentesFamilares antecedente = new EntidadAntecedentesFamilares(
                        rs.getInt("id_antecedente_familiar"),
                        rs.getInt("id_paciente"),
                        rs.getString("parentezco"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("alergias_medicamentos")
                );
                antecedentes.add(antecedente);
            }
        }
        return antecedentes;
    }

    // Método para obtener un antecedente familiar por su ID
    public static EntidadAntecedentesFamilares PedirAntecedentePorId(int idAntecedenteFamiliar) throws IllegalAccessError, SQLException, IOException {
        EntidadAntecedentesFamilares antecedente = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el antecedente familiar por ID
        String sqlSquery = "SELECT * FROM Antecedentes_Familiares WHERE id_antecedente_familiar = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ps.setInt(1, idAntecedenteFamiliar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                antecedente = new EntidadAntecedentesFamilares(
                        rs.getInt("id_antecedente_familiar"),
                        rs.getInt("id_paciente"),
                        rs.getString("parentezco"),
                        rs.getString("enfermedad_diagnosticada"),
                        rs.getString("alergias_medicamentos")
                );
            }
        }
        return antecedente;
    }

    // Método para verificar si existe un antecedente familiar por su ID
    public static boolean existeAntecedentePorId(int idAntecedenteFamiliar) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Antecedentes_Familiares WHERE id_antecedente_familiar = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idAntecedenteFamiliar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un antecedente con ese ID
            }
        }
        return false;
    }
}

