package ModelosTablas;
import Entidades.EntidadAntecedentesFamilares;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
public class ModeloTablaAntecedentesFamiliares extends AbstractTableModel {
    // Lista de antecedentes familiares que serán mostrados en la tabla
    private ArrayList<EntidadAntecedentesFamilares> datos;

    // Nombres de las columnas de la tabla
    String columnas[] = {
        "ID Antecedente Familiar", "ID Paciente", "Familiar", 
        "Enfermedad Hereditaria", "Edad de Diagnóstico"
    };

    // Tipos de datos de cada columna
    Class<?> colClasses[] = {
        Integer.class, Integer.class, String.class, 
        String.class, Integer.class
    };

    // Método para obtener los datos, inicializa la lista si es null
    public ArrayList<EntidadAntecedentesFamilares> getDatos() {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        return datos;
    }

    // Método para establecer los datos y notificar cambios en la tabla
    public void setDatos(ArrayList<EntidadAntecedentesFamilares> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }

    // Constructor que recibe una lista de antecedentes familiares
    public ModeloTablaAntecedentesFamiliares(ArrayList<EntidadAntecedentesFamilares> datos) {
        this.datos = datos;
    }

    // Constructor por defecto que inicializa una lista vacía de antecedentes familiares
    public ModeloTablaAntecedentesFamiliares() {
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
        EntidadAntecedentesFamilares antecedenteFamiliar = datos.get(rowIndex);

        // Devuelve el valor correspondiente a cada columna
        switch (columnIndex) {
            case 0 -> { return antecedenteFamiliar.getIdAntecedenteFamiliar(); }
            case 1 -> { return antecedenteFamiliar.getIdPaciente(); }
            case 2 -> { return antecedenteFamiliar.getParentezco(); }
            case 3 -> { return antecedenteFamiliar.getEnfermedadDiagnosticada(); }
            case 4 -> { return antecedenteFamiliar.getAlergiasMedicamentos(); }
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

