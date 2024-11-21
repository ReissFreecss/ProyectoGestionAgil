/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadIndicadoresAntropometricos;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaIndicadoresAntropometricos extends AbstractTableModel {

    // Lista de indicadores antropométricos que serán mostrados en la tabla
    private ArrayList<EntidadIndicadoresAntropometricos> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Indicador", "ID Paciente", "Fecha",
        "Peso", "Estatura",
        "Circunferencia Brazo", "Circunferencia Cintura",
        "Circunferencia Cadera", "Circunferencia Muslo"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, Date.class,
        Double.class, Double.class,
        Double.class, Double.class,
        Double.class, Double.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadIndicadoresAntropometricos> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadIndicadoresAntropometricos> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de indicadores antropométricos
    public ModeloTablaIndicadoresAntropometricos(ArrayList<EntidadIndicadoresAntropometricos> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de indicadores antropométricos
    public ModeloTablaIndicadoresAntropometricos() {
        this.datos = new ArrayList<>();
    }

    // Método que devuelve el número de filas de la tabla
    @Override
    public int getRowCount() {
        return datos.size();
    }

    // Método que devuelve el número de columnas de la tabla
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    // Método que devuelve el valor de una celda específica en la tabla
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EntidadIndicadoresAntropometricos indicador = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> {
                return indicador.getIdIndicador();
            }
            case 1 -> {
                return indicador.getIdPaciente();
            }
            case 2 -> {
                return indicador.getFecha();
            }
            case 3 -> {
                return indicador.getPeso();
            }
            case 4 -> {
                return indicador.getEstatura();
            }
            case 5 -> {
                return indicador.getCircunferenciaBrazo();
            }
            case 6 -> {
                return indicador.getCircunferenciaCintura();
            }
            case 7 -> {
                return indicador.getCircunferenciaCadera();
            }
            case 8 -> {
                return indicador.getCircunferenciaMuslo();
            }
        }
        return null;
    }

    // Método que devuelve el nombre de una columna específica
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    // Método que devuelve la clase de los datos en una columna específica
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }
    // Método para obtener un indicador antropométrico según la fila seleccionada

    public EntidadIndicadoresAntropometricos getIndicadorAntropometrico(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            return datos.get(rowIndex);
        }
        return null; // Retorna null si el índice no es válido
    }
}
