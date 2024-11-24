package Entidades;

import java.sql.Date;

public class EntidadPaciente {

    private Integer idPaciente = null;
    private String nombreCompleto;
    private Integer edad;
    private String sexo;
    private String ocupacion;
    private String motivoConsulta;
    private String diagnostico;
    private Date fechaConsulta;
    private String telefono;

    public EntidadPaciente(Integer idPaciente, String nombreCompleto, int edad, String sexo, String ocupacion, String motivoConsulta, String diagnostico, Date fechaConsulta, String telefono) {
        this.idPaciente = idPaciente; // Permitir que sea null
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.fechaConsulta = fechaConsulta;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para imprimir los pacientes
    @Override
    public String toString() {
        return getNombreCompleto();
    }
}
