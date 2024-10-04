package ModelosTablas;

import Entidades.EntidadConsumoSustancias;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablaConsumoSustancias extends AbstractTableModel {

    // Lista de registros de consumo de sustancias que serán mostrados en la tabla
    private ArrayList<EntidadConsumoSustancias> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Consumo", "ID Paciente", "Sustancia",
        "Tipo sustancia", "Frecuencia", "Cantidad"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class,
        String.class, Integer.class,
        String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadConsumoSustancias> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadConsumoSustancias> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de registros de consumo de sustancias
    public ModeloTablaConsumoSustancias(ArrayList<EntidadConsumoSustancias> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de registros de consumo
    public ModeloTablaConsumoSustancias() {
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
        EntidadConsumoSustancias consumo = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> {
                return consumo.getIdConsumoSustancia();
            }
            case 1 -> {
                return consumo.getIdPaciente();
            }
            case 2 -> {
                return consumo.getSustancia();
            }
            case 3 -> {
                return consumo.getTipo();
            }
            case 4 -> {
                return consumo.getFrecuencia();
            }
            case 5 -> {
                return consumo.getCantidad();
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
}
