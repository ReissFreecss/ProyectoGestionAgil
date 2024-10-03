/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosTablas;

import Entidades.EntidadEstiloVida;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaEstiloVida extends AbstractTableModel {
    // Lista de estilos de vida que serán mostrados en la tabla
    private ArrayList<EntidadEstiloVida> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Estilo Vida", "ID Paciente", "Hora Despertar", 
        "Hora Dormir", "Hora Trabajo/Estudio", "Hora Entrenamiento", 
        "Tipo Ejercicio", "Intensidad", "Frecuencia Ejercicio"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        Integer.class, String.class, String.class, 
        String.class, String.class, Integer.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadEstiloVida> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadEstiloVida> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de estilos de vida
    public ModeloTablaEstiloVida(ArrayList<EntidadEstiloVida> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de estilos de vida
    public ModeloTablaEstiloVida() {
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
        EntidadEstiloVida estiloVida = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return estiloVida.getIdEstiloVida(); }
            case 1 -> { return estiloVida.getIdPaciente(); }
            case 2 -> { return estiloVida.getHoraDespertar(); }
            case 3 -> { return estiloVida.getHoraDormir(); }
            case 4 -> { return estiloVida.getHoraTrabajoEstudio(); }
            case 5 -> { return estiloVida.getHoraEntrenamiento(); }
            case 6 -> { return estiloVida.getTipoEjercicio(); }
            case 7 -> { return estiloVida.getIntensidad(); }
            case 8 -> { return estiloVida.getFrecuenciaEjercicio(); }
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

