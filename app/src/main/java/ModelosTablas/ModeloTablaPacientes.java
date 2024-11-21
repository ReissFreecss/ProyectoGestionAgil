package ModelosTablas;

import Entidades.EntidadPaciente;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.ArrayList;

public class ModeloTablaPacientes extends AbstractTableModel {

    // Lista de pacientes que serán mostrados en la tabla
    private ArrayList<EntidadPaciente> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {"ID", "Nombre Completo", "Edad", "Sexo", "Ocupación", "Motivo Consulta", "Fecha Consulta", "Teléfono"};

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {Integer.class, String.class, Integer.class, String.class, String.class, String.class, Date.class, String.class};

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadPaciente> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadPaciente> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de pacientes
    public ModeloTablaPacientes(ArrayList<EntidadPaciente> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de pacientes
    public ModeloTablaPacientes() {
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
        EntidadPaciente paciente = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> {
                return paciente.getIdPaciente();
            }
            case 1 -> {
                return paciente.getNombreCompleto();
            }
            case 2 -> {
                return paciente.getEdad();
            }
            case 3 -> {
                return paciente.getSexo();
            }
            case 4 -> {
                return paciente.getOcupacion();
            }
            case 5 -> {
                return paciente.getMotivoConsulta();
            }
            case 6 -> {
                return paciente.getFechaConsulta();
            }
            case 7 -> {
                return paciente.getTelefono();
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
    
    // Método para obtener un paciente según la fila seleccionada
    public EntidadPaciente getPaciente(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            return datos.get(rowIndex);
        }
        return null; // Retorna null si el índice no es válido
    }
}
