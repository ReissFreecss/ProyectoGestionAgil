/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadDietaEspecial;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaDietaEspecial extends AbstractTableModel {
    // Lista de dietas especiales que serán mostradas en la tabla
    private ArrayList<EntidadDietaEspecial> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Dieta Especial", "ID Paciente", "Dieta Especial", 
        "Tipo de Dieta", "Tiempo de Dieta Especial", 
        "Razón de Dieta Especial", "Resultado de Dieta Especial", 
        "Apego a Dieta"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        String.class, String.class, 
        String.class, String.class, String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadDietaEspecial> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadDietaEspecial> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de dietas especiales
    public ModeloTablaDietaEspecial(ArrayList<EntidadDietaEspecial> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de dietas especiales
    public ModeloTablaDietaEspecial() {
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
        EntidadDietaEspecial dieta = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return dieta.getIdDietaEspecial(); }
            case 1 -> { return dieta.getIdPaciente(); }
            case 2 -> { return dieta.getDietaEspecial(); }
            case 3 -> { return dieta.getTipoDieta(); }
            case 4 -> { return dieta.getTiempoDietaEspecial(); }
            case 5 -> { return dieta.getRazonDietaEspecial(); }
            case 6 -> { return dieta.getResultadoDietaEspecial(); }
            case 7 -> { return dieta.getApegoDieta(); }
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