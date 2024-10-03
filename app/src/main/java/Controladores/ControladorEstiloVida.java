package Controladores;

import Entidades.EntidadEstiloVida;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEstiloVida {

    // Método para obtener todos los registros de estilo de vida de la base de datos
    public static ArrayList<EntidadEstiloVida> PedirTodos() throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadEstiloVida> resultado = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener todos los registros de la tabla Estilo_Vida
        String sqlSquery = "SELECT * FROM Estilo_Vida";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntidadEstiloVida obj = new EntidadEstiloVida(
                        rs.getInt("id_estilo_vida"),
                        rs.getInt("id_paciente"),
                        rs.getString("hora_despertar"),
                        rs.getString("hora_dormir"),
                        rs.getString("hora_trabajo_estudio"),
                        rs.getString("hora_entrenamiento"),
                        rs.getString("tipo_ejercicio"),
                        rs.getString("intensidad"),
                        rs.getInt("frecuencia_ejercicio")
                );
                resultado.add(obj);
            }
        }
        return resultado;
    }

    // Método para insertar un nuevo registro de estilo de vida en la base de datos
    public static void Alta(EntidadEstiloVida obj) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para insertar un nuevo estilo de vida
        String sqlAlta = "INSERT INTO Estilo_Vida (id_paciente, hora_despertar, hora_dormir, hora_trabajo_estudio, hora_entrenamiento, tipo_ejercicio, intensidad, frecuencia_ejercicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlAlta)) {
            ps.setInt(1, obj.getIdPaciente());
            ps.setString(2, obj.getHoraDespertar());
            ps.setString(3, obj.getHoraDormir());
            ps.setString(4, obj.getHoraTrabajoEstudio());
            ps.setString(5, obj.getHoraEntrenamiento());
            ps.setString(6, obj.getTipoEjercicio());
            ps.setString(7, obj.getIntensidad());
            ps.setInt(8, obj.getFrecuenciaEjercicio());

            ps.executeUpdate();
        }
    }

    // Método para actualizar un registro de estilo de vida en la base de datos
    public static void Actualizar(EntidadEstiloVida estiloVida) throws IllegalAccessError, SQLException, IOException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para actualizar un registro de estilo de vida
        String sqlActualizar = "UPDATE Estilo_Vida SET id_paciente = ?, hora_despertar = ?, hora_dormir = ?, hora_trabajo_estudio = ?, hora_entrenamiento = ?, tipo_ejercicio = ?, intensidad = ?, frecuencia_ejercicio = ? WHERE id_estilo_vida = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlActualizar)) {
            ps.setInt(1, estiloVida.getIdPaciente());
            ps.setString(2, estiloVida.getHoraDespertar());
            ps.setString(3, estiloVida.getHoraDormir());
            ps.setString(4, estiloVida.getHoraTrabajoEstudio());
            ps.setString(5, estiloVida.getHoraEntrenamiento());
            ps.setString(6, estiloVida.getTipoEjercicio());
            ps.setString(7, estiloVida.getIntensidad());
            ps.setInt(8, estiloVida.getFrecuenciaEjercicio());
            ps.setInt(9, estiloVida.getIdEstiloVida());

            ps.executeUpdate();
        }
    }

    // Método para eliminar un registro de estilo de vida de la base de datos
    public static void Eliminar(EntidadEstiloVida obj) throws IllegalAccessError, SQLException {
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para eliminar un registro de estilo de vida por su id
        String sqlBorrar = "DELETE FROM Estilo_Vida WHERE id_estilo_vida = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlBorrar)) {
            ps.setInt(1, obj.getIdEstiloVida()); // Usar índice 1 y obtener el ID del estilo de vida
            ps.executeUpdate();
        }
    }

    // Método para obtener los registros de estilo de vida por ID de paciente
    public static ArrayList<EntidadEstiloVida> PedirEstiloVidaPorIdPaciente(int idPaciente) throws IllegalAccessError, SQLException, IOException {
        ArrayList<EntidadEstiloVida> estilosVida = new ArrayList<>();

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener los registros de estilo de vida por ID de paciente
        String sqlSquery = "SELECT * FROM Estilo_Vida WHERE id_paciente = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del paciente en la consulta SQL
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            // Itera sobre los resultados y los agrega a la lista
            while (rs.next()) {
                EntidadEstiloVida estiloVida = new EntidadEstiloVida(
                        rs.getInt("id_estilo_vida"),
                        rs.getInt("id_paciente"),
                        rs.getString("hora_despertar"),
                        rs.getString("hora_dormir"),
                        rs.getString("hora_trabajo_estudio"),
                        rs.getString("hora_entrenamiento"),
                        rs.getString("tipo_ejercicio"),
                        rs.getString("intensidad"),
                        rs.getInt("frecuencia_ejercicio")
                );
                estilosVida.add(estiloVida);
            }
        }
        return estilosVida; // Retorna una lista de registros de estilo de vida o una lista vacía
    }
    public static EntidadEstiloVida PedirEstiloVidaPorId(int idAntecedente) throws IllegalAccessError, SQLException, IOException {
        EntidadEstiloVida antecedente = null;

        // Verifica si la conexión a la base de datos es nula
        if (ControladorBDSQL.conexion == null) {
            throw new IllegalArgumentException("Error: Conexion es null");
        }

        // Consulta SQL para obtener el antecedente médico por ID de antecedente
        String sqlSquery = "SELECT * FROM Estilo_Vida WHERE id_estilo_vida = ?";

        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sqlSquery)) {
            // Asigna el valor del ID del antecedente médico en la consulta SQL
            ps.setInt(1, idAntecedente);

            ResultSet rs = ps.executeQuery();

            // Si se encuentra el antecedente, lo asigna al objeto antecedente
            if (rs.next()) {
                antecedente = new EntidadEstiloVida(
                        rs.getInt("id_estilo_vida"),
                        rs.getInt("id_paciente"),
                        rs.getString("hora_despertar"),
                        rs.getString("hora_dormir"),
                        rs.getString("hora_trabajo_estudio"),
                        rs.getString("hora_entrenamiento"),
                        rs.getString("tipo_ejercicio"),
                        rs.getString("intensidad"),
                        rs.getInt("frecuencia_ejercicio")
                );
            }
        }
        return antecedente; // Retorna el antecedente médico o null si no se encuentra
    }

    // Método para verificar si existe un registro de estilo de vida por su ID
    public static boolean existeEstiloVidaPorId(int idEstiloVida) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Estilo_Vida WHERE id_estilo_vida = ?";
        try (PreparedStatement ps = ControladorBDSQL.conexion.prepareStatement(sql)) {
            ps.setInt(1, idEstiloVida);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Devuelve true si existe al menos un registro con ese ID
            }
        }
        return false;
    }
}

