package Reportes;

import Entidades.EntidadDietas;
import Entidades.EntidadDatosInterpretacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteData {

    // Tabla paciente:
    private String nombreCompleto;
    private Integer edad;
    private java.sql.Date fechaConsulta;
    private String motivoConsulta;
    private String diagnostico;

    // Tabla datos antropometricos:
    private double estatura;
    private double circunferenciaCintura;

    // Tabla antecedentes medicos:
    private String enfermedadDiagnosticada;
    private String alergiaIntoleranciaAlimentos;

    //Tabla dietas con alimentos:
    private List<EntidadDietas> dietas;
    private List<EntidadDatosInterpretacion> datosInterpretacion;

    public ReporteData(String nombreCompleto, Integer edad, java.sql.Date fechaConsulta, String motivoConsulta, String diagnostico, double estatura, double circunferenciaCintura, String enfermedadDiagnosticada, String alergiaIntoleranciaAlimentos, List<EntidadDietas> dietas, List<EntidadDatosInterpretacion> datosInterpretacion) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.fechaConsulta = fechaConsulta;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.estatura = estatura;
        this.circunferenciaCintura = circunferenciaCintura;
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
        this.alergiaIntoleranciaAlimentos = alergiaIntoleranciaAlimentos;
        this.dietas = dietas;
        this.datosInterpretacion = datosInterpretacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public java.sql.Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(java.sql.Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
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

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getCircunferenciaCintura() {
        return circunferenciaCintura;
    }

    public void setCircunferenciaCintura(double circunferenciaCintura) {
        this.circunferenciaCintura = circunferenciaCintura;
    }

    public String getEnfermedadDiagnosticada() {
        return enfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada) {
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
    }

    public String getAlergiaIntoleranciaAlimentos() {
        return alergiaIntoleranciaAlimentos;
    }

    public void setAlergiaIntoleranciaAlimentos(String alergiaIntoleranciaAlimentos) {
        this.alergiaIntoleranciaAlimentos = alergiaIntoleranciaAlimentos;
    }

    public List<EntidadDietas> getDietas() {
        return dietas;
    }

    public void setDietas(List<EntidadDietas> dietas) {
        this.dietas = dietas;
    }

    public List<EntidadDatosInterpretacion> getDatosInterpretacion() {
        return datosInterpretacion;
    }

    public void setDatosInterpretacion(List<EntidadDatosInterpretacion> datosInterpretacion) {
        this.datosInterpretacion = datosInterpretacion;
    }

    
}
