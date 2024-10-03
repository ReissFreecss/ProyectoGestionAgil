package Entidades;

import java.sql.Date;

public class EntidadAntecedentesMedicos {

    private Integer idAntecedente; // ID del antecedente médico
    private Integer idPaciente; // ID del paciente
    private String enfermedadDiagnosticada; // Enfermedad diagnosticada
    private String medicamentos; // Medicamentos que toma
    private Date inicioMedicación; // Fecha de inicio de medicación
    private Date ultimaDesparasitacion; // Fecha de última desparacitación
    private Date ultimaRealizacionLaboratorios; // Fecha de última realización de laboratorios
    private String alergiaIntoleranciaAlimentos; // Alergias o intolerancias alimentarias

    public EntidadAntecedentesMedicos(Integer idAntecedente, Integer idPaciente, String enfermedadDiagnosticada,
            String medicamentos, Date inicioMedicación, Date ultimaDesparasitacion,
            Date ultimaRealizacionLaboratorios, String alergiaIntoleranciaAlimentos) {
        this.idAntecedente = idAntecedente;
        this.idPaciente = idPaciente;
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
        this.medicamentos = medicamentos;
        this.inicioMedicación = inicioMedicación;
        this.ultimaDesparasitacion = ultimaDesparasitacion;
        this.ultimaRealizacionLaboratorios = ultimaRealizacionLaboratorios;
        this.alergiaIntoleranciaAlimentos = alergiaIntoleranciaAlimentos;
    }

    // Getters y Setters
    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnfermedadDiagnosticada() {
        return enfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada) {
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Date getInicioMedicación() {
        return inicioMedicación;
    }

    public void setInicioMedicación(Date inicioMedicación) {
        this.inicioMedicación = inicioMedicación;
    }

    public Date getUltimaDesparasitacion() {
        return ultimaDesparasitacion;
    }

    public void setUltimaDesparasitacion(Date ultimaDesparasitacion) {
        this.ultimaDesparasitacion = ultimaDesparasitacion;
    }

    public Date getUltimaRealizacionLaboratorios() {
        return ultimaRealizacionLaboratorios;
    }

    public void setUltimaRealizacionLaboratorios(Date ultimaRealizacionLaboratorios) {
        this.ultimaRealizacionLaboratorios = ultimaRealizacionLaboratorios;
    }

    public String getAlergiaIntoleranciaAlimentos() {
        return alergiaIntoleranciaAlimentos;
    }

    public void setAlergiaIntoleranciaAlimentos(String alergiaIntoleranciaAlimentos) {
        this.alergiaIntoleranciaAlimentos = alergiaIntoleranciaAlimentos;
    }

    // Método toString para imprimir los antecedentes médicos
    @Override
    public String toString() {
        return "Antecedentes de " + getIdPaciente() + ": " + getEnfermedadDiagnosticada();
    }
}
