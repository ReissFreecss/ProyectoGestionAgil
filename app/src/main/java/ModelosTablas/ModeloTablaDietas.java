/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadDietas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaDietas extends AbstractTableModel {

    // Lista de dietas que serán mostradas en la tabla
    private ArrayList<EntidadDietas> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Dieta", "ID Paciente", "Comida",
        "Horario", "Porciones",
        "Ingredientes", "Suplemento",
        "Dosis Suplemento"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class,
        String.class, String.class,
        String.class, String.class,
        String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadDietas> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadDietas> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de dietas
    public ModeloTablaDietas(ArrayList<EntidadDietas> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de dietas
    public ModeloTablaDietas() {
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
        EntidadDietas dieta = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> {
                return dieta.getIdDieta();
            }
            case 1 -> {
                return dieta.getIdPaciente();
            }
            case 2 -> {
                return dieta.getComida();
            }
            case 3 -> {
                return dieta.getHorario();
            }
            case 4 -> {
                return dieta.getPorciones();
            }
            case 5 -> {
                return dieta.getIngredientes();
            }
            case 6 -> {
                return dieta.getSuplemento();
            }
            case 7 -> {
                return dieta.getDosisSuplemento();
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

    // Método para obtener una dieta según la fila seleccionada
    public EntidadDietas getDieta(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            return datos.get(rowIndex);
        }
        return null; // Retorna null si el índice no es válido
    }
}
