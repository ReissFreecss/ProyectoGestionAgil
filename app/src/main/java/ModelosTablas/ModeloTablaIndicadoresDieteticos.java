/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadIndicadoresDieteticos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaIndicadoresDieteticos extends AbstractTableModel {
    // Lista de indicadores dietéticos que serán mostrados en la tabla
    private ArrayList<EntidadIndicadoresDieteticos> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Indicadores Dietéticos", "ID Paciente", "Preparador de Alimentos", 
        "Hora de Apetito", "Alimentos Preferidos", 
        "Alimentos No Preferidos", "Suplemento", 
        "Dosis Suplemento", "Agua Consumida", 
        "Refresco Consumido", "Leche Consumida", 
        "Medicamentos para Bajar Peso"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        String.class, String.class, 
        String.class, String.class, 
        String.class, Double.class, 
        Double.class, Double.class, 
        String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadIndicadoresDieteticos> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadIndicadoresDieteticos> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de indicadores dietéticos
    public ModeloTablaIndicadoresDieteticos(ArrayList<EntidadIndicadoresDieteticos> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de indicadores dietéticos
    public ModeloTablaIndicadoresDieteticos() {
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
        EntidadIndicadoresDieteticos indicador = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return indicador.getIdIndicadoresDieteticos(); }
            case 1 -> { return indicador.getIdPaciente(); }
            case 2 -> { return indicador.getPreparadorAlimentos(); }
            case 3 -> { return indicador.getHoraApetito(); }
            case 4 -> { return indicador.getAlimentosPreferidos(); }
            case 5 -> { return indicador.getAlimentosNoPreferidos(); }
            case 6 -> { return indicador.getSuplemento(); }
            case 7 -> { return indicador.getDosisSuplemento(); }
            case 8 -> { return indicador.getAguaConsumida(); }
            case 9 -> { return indicador.getRefrescoConsumido(); }
            case 10 -> { return indicador.getLecheConsumida(); }
            case 11 -> { return indicador.getMedicamentosBajarPeso(); }
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
}