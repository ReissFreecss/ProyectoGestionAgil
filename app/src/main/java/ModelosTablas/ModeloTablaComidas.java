/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadComidas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaComidas extends AbstractTableModel {
    // Lista de comidas que serán mostradas en la tabla
    private ArrayList<EntidadComidas> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Comidas", "ID Paciente", "Comida", 
        "Horario", "Platillo", 
        "Ingredientes", "Cantidad", 
        "Come en la calle", "Frecuencia comida calle"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        String.class, String.class, 
        String.class, String.class, 
        String.class, Integer.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadComidas> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadComidas> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de comidas
    public ModeloTablaComidas(ArrayList<EntidadComidas> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de comidas
    public ModeloTablaComidas() {
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
        EntidadComidas comida = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return comida.getIdComidas(); }
            case 1 -> { return comida.getIdPaciente(); }
            case 2 -> { return comida.getComida(); }
            case 3 -> { return comida.getHorario(); }
            case 4 -> { return comida.getPlatillo(); }
            case 5 -> { return comida.getIngredientes(); }
            case 6 -> { return comida.getCantidad(); }
            case 7 -> { return comida.getComeCalle(); }
            case 8 -> { return comida.getFrecuenciaComidaCalle(); }
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