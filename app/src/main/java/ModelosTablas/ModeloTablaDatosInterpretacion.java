/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadDatosInterpretacion;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author darkd
 */
public class ModeloTablaDatosInterpretacion extends AbstractTableModel {
    // Lista de datos de interpretación que serán mostrados en la tabla
    private ArrayList<EntidadDatosInterpretacion> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Datos Interpretación", "ID Paciente", "Fecha", 
        "Peso", "Porcentaje Grasa Corporal", 
        "Masa Muscular", "Masa Ósea", 
        "IMC", "Ingesta Kilocalorías", 
        "Edad Metabólica", "Porcentaje Agua Corporal", 
        "Grasa Visceral", "Pliegue Tricipital", 
        "Pliegue Bicipital", "Pliegue Suprailiaco", 
        "Pliegue Subescapular"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, Date.class, 
        Double.class, Double.class, 
        Double.class, Double.class, 
        Double.class, Double.class, 
        Integer.class, Double.class, 
        Double.class, Double.class, 
        Double.class, Double.class, 
        Double.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadDatosInterpretacion> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadDatosInterpretacion> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de datos de interpretación
    public ModeloTablaDatosInterpretacion(ArrayList<EntidadDatosInterpretacion> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de datos de interpretación
    public ModeloTablaDatosInterpretacion() {
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
        EntidadDatosInterpretacion interpretacion = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return interpretacion.getIdDatosInterpretacion(); }
            case 1 -> { return interpretacion.getIdPaciente(); }
            case 2 -> { return interpretacion.getFecha(); }
            case 3 -> { return interpretacion.getPeso(); }
            case 4 -> { return interpretacion.getPorcentajeGrasaCorporal(); }
            case 5 -> { return interpretacion.getMasaMuscular(); }
            case 6 -> { return interpretacion.getMasaOsea(); }
            case 7 -> { return interpretacion.getImc(); }
            case 8 -> { return interpretacion.getIngestaKilocalorias(); }
            case 9 -> { return interpretacion.getEdadMetabolica(); }
            case 10 -> { return interpretacion.getPorcentajeAguaCorporal(); }
            case 11 -> { return interpretacion.getGrasaVisceral(); }
            case 12 -> { return interpretacion.getPliegueTricipital(); }
            case 13 -> { return interpretacion.getPliegueBicipital(); }
            case 14 -> { return interpretacion.getPliegueSuprailiaco(); }
            case 15 -> { return interpretacion.getPliegueSubescapular(); }
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

