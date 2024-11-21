package Reportes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReporteService {

    /*/ Declaración de una variable de conexión estática
    public static Connection conexion = null;

    // Método para inicializar la conexión a la base de datos
    public static void InicializarConexion(File archivobd) throws SQLException {
        conexion = DriverManager.getConnection("jdbc:sqlite:" + archivobd.getPath());
    }

    public ReporteData obtenerDatosReporte(int idPaciente) throws Exception {
        ReporteData data = new ReporteData();

        // Consulta de datos de interpretación
        String queryInterpretacion = "SELECT peso, imc, masa_muscular, porcentaje_grasa_corporal FROM Datos_Interpretacion WHERE id_paciente = ? ORDER BY fecha DESC LIMIT 1";
        try (PreparedStatement stmt = conexion.prepareStatement(queryInterpretacion)) {
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data.setPeso(rs.getDouble("peso"));
                data.setImc(rs.getDouble("imc"));
                data.setMasaMuscular(rs.getDouble("masa_muscular"));
                data.setPorcentajeGrasaCorporal(rs.getDouble("porcentaje_grasa_corporal"));
            }
        }

        // Consulta de indicadores antropométricos
        String queryAntropometricos = "SELECT circunferencia_cintura FROM Indicadores_Antropometricos WHERE id_paciente = ? ORDER BY fecha DESC LIMIT 1";
        try (PreparedStatement stmt = conexion.prepareStatement(queryAntropometricos)) {
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data.setCircunferenciaCintura(rs.getDouble("circunferencia_cintura"));
            }
        }

        // Consulta de datos del paciente y antecedentes
        String queryPaciente = "SELECT nombre_completo, edad, fecha_consulta, motivo_consulta FROM Pacientes WHERE id_paciente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(queryPaciente)) {
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data.setNombreCompleto(rs.getString("nombre_completo"));
                data.setEdad(rs.getInt("edad"));
                data.setFechaConsulta(rs.getDate("fecha_consulta"));
                data.setMotivoConsulta(rs.getString("motivo_consulta"));
            }
        }

        // Consulta de dieta
        String queryDieta = "SELECT horario, ingredientes, suplemento FROM Dietas WHERE id_paciente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(queryDieta)) {
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                data.addDietaItem(rs.getString("horario"), rs.getString("ingredientes"), rs.getString("suplemento"));
            }
        }
        return data;
    }*/
}
