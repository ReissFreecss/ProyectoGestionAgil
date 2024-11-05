/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorBDSQL {

    // Declaración de una variable de conexión estática
    public static Connection conexion = null;

    // Método para inicializar la conexión a la base de datos
    public static void InicializarConexion(File archivobd) throws SQLException {
        conexion = DriverManager.getConnection("jdbc:sqlite:" + archivobd.getPath());
    }

    // Método para crear la base de datos a partir de un archivo SQL
    public static void crearBD() {
        InputStream is = null;
        try {
            // Intenta obtener el archivo SQL como un flujo de entrada
            is = ControladorBDSQL.class.getClassLoader().getResourceAsStream("BD/BaseDatos_Pacientes.sql");
        } catch (Exception e) {
            // Imprime un mensaje de error si ocurre una excepción
            System.err.println(e.getMessage());
        }
        if (is != null) {
            String sql = "";
            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(streamReader)) {

                String line;

                // Lee cada línea del archivo SQL y las concatena en una cadena
                while ((line = reader.readLine()) != null) {
                    sql += line + System.lineSeparator();
                }
                System.out.println("--------------------------Intentando ejecutar statement para crear tablas--------------------------");
                System.out.println(sql);

                // Crea un statement para ejecutar la consulta SQL
                Statement statement = conexion.createStatement();
                statement.setQueryTimeout(30);

                // Ejecuta la consulta SQL para crear las tablas
                statement.executeUpdate(sql);

            } catch (Exception ex) {
                // Imprime un mensaje de error si ocurre una excepción
                System.err.println(ex.getMessage());
            }
        } else {
            // Imprime un mensaje si el flujo de entrada es nulo
            System.out.println("is fue null");
        }
    }
}
