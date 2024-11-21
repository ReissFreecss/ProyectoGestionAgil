package ModelosTablas;

import Entidades.EntidadAntecedentesMedicos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ModeloTablaAntecedentesMedicos extends AbstractTableModel {

    // Lista de antecedentes médicos que serán mostrados en la tabla
    private ArrayList<EntidadAntecedentesMedicos> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Antecedente", "ID Paciente", "Enfermedad Diagnosticada",
        "Medicamentos", "Inicio Medicación",
        "Última Desparasitacion", "Última Realización Laboratorios",
        "Alergia/Intolerancia a Alimentos"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class,
        String.class, Date.class,
        Date.class, Date.class, String.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadAntecedentesMedicos> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadAntecedentesMedicos> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de antecedentes médicos
    public ModeloTablaAntecedentesMedicos(ArrayList<EntidadAntecedentesMedicos> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de antecedentes médicos
    public ModeloTablaAntecedentesMedicos() {
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
        EntidadAntecedentesMedicos antecedente = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> {
                return antecedente.getIdAntecedente();
            }
            case 1 -> {
                return antecedente.getIdPaciente();
            }
            case 2 -> {
                return antecedente.getEnfermedadDiagnosticada();
            }
            case 3 -> {
                return antecedente.getMedicamentos();
            }
            case 4 -> {
                return antecedente.getInicioMedicación();
            }
            case 5 -> {
                return antecedente.getUltimaDesparasitacion();
            }
            case 6 -> {
                return antecedente.getUltimaRealizacionLaboratorios();
            }
            case 7 -> {
                return antecedente.getAlergiaIntoleranciaAlimentos();
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
    // Método para obtener antecedentes médicos según la fila seleccionada

    public EntidadAntecedentesMedicos getAntecedenteMedico(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            return datos.get(rowIndex);
        }
        return null; // Retorna null si el índice no es válido
    }

}
