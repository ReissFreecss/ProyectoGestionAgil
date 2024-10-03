package ModelosTablas;

import Entidades.EntidadDatosGinecologicos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablaDatosGinecologicos extends AbstractTableModel {
    // Lista de datos ginecológicos que serán mostrados en la tabla
    private ArrayList<EntidadDatosGinecologicos> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Ginecológico", "ID Paciente", "Embarazo Actual", 
        "SDG", "Referido por Paciente", 
        "FUM", "Anticonceptivos Orales", 
        "Dosis Anticonceptivo", "Número de Embarazos"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        String.class, String.class, 
        Date.class, String.class, 
        String.class, String.class, Integer.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadDatosGinecologicos> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadDatosGinecologicos> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de datos ginecológicos
    public ModeloTablaDatosGinecologicos(ArrayList<EntidadDatosGinecologicos> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de datos ginecológicos
    public ModeloTablaDatosGinecologicos() {
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
        EntidadDatosGinecologicos dato = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return dato.getIdGinecologico(); }
            case 1 -> { return dato.getIdPaciente(); }
            case 2 -> { return dato.getEmbarazoActual(); }
            case 3 -> { return dato.getSdg(); }
            case 4 -> { return dato.getReferidoPorPaciente(); }
            case 5 -> { return dato.getFum(); }
            case 6 -> { return dato.getAnticonceptivosOrales(); }
            case 7 -> { return dato.getDosisAnticonceptivo(); }
            case 8 -> { return dato.getNumEmbarazos(); }
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

