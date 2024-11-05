/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadSeguimiento;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablaSeguimiento extends AbstractTableModel {
    // Lista de seguimientos que serán mostrados en la tabla
    private ArrayList<EntidadSeguimiento> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Seguimiento", "ID Paciente", "Fecha", 
        "Apego Plan", "Alimentos Fuera de Plan", 
        "Paso Hambre", "Días Entrenamiento", 
        "Mejoró Ejercicio", "Jugos/Refrescos/Alcohol", 
        "Litros Agua", "Malestares Gástricos", 
        "Horas Sueño", "Problema Solución", "Extras/Observaciones"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, Date.class, 
        String.class, String.class, 
        String.class, Integer.class, 
        String.class, String.class, 
        String.class, String.class, 
        String.class, String.class, String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadSeguimiento> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadSeguimiento> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de seguimientos
    public ModeloTablaSeguimiento(ArrayList<EntidadSeguimiento> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de seguimientos
    public ModeloTablaSeguimiento() {
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
        EntidadSeguimiento seguimiento = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return seguimiento.getIdSeguimiento(); }
            case 1 -> { return seguimiento.getIdPaciente(); }
            case 2 -> { return seguimiento.getFecha(); }
            case 3 -> { return seguimiento.getApegoPlan(); }
            case 4 -> { return seguimiento.getAlimentosFueraPlan(); }
            case 5 -> { return seguimiento.getPasoHambre(); }
            case 6 -> { return seguimiento.getDiasEntrenamiento(); }
            case 7 -> { return seguimiento.getMejoroEjercicio(); }
            case 8 -> { return seguimiento.getJugosRefrescosAlcohol(); }
            case 9 -> { return seguimiento.getLitrosAgua(); }
            case 10 -> { return seguimiento.getMalestaresGastricos(); }
            case 11 -> { return seguimiento.getHorasSueno(); }
            case 12 -> { return seguimiento.getProblemaSolucion(); }
            case 13 -> { return seguimiento.getExtrasObservaciones(); }
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

