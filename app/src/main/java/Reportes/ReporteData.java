package Reportes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ReporteData {

    // Tabla paciente:
    private String nombreCompleto;
    private Integer edad;
    private java.sql.Date fechaConsulta;
    private String motivoConsulta;
    
    // Tabla datos interpretacion:
    private double peso;
    private double imc;
    private double masaMuscular;
    private double porcentajeGrasaCorporal;
    
    // Tabla datos antropometricos:
    private double estatura;
    private double circunferenciaCintura;
    
    // Tabla antecedentes medicos:
    private String enfermedadDiagnosticada;
    private String alergiaIntoleranciaAlimentos;
    
    //Tabla dietas:
    private String comida;
    private String horario;            
    private String porciones;          
    private String ingredientes;       
    private String suplemento;         
    private String dosisSuplemento;

    public ReporteData(String nombreCompleto, Integer edad, java.sql.Date fechaConsulta, String motivoConsulta, double peso, double imc, double masaMuscular, double porcentajeGrasaCorporal, double estatura, double circunferenciaCintura, String enfermedadDiagnosticada, String alergiaIntoleranciaAlimentos, String comida, String horario, String porciones, String ingredientes, String suplemento, String dosisSuplemento) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.fechaConsulta = fechaConsulta;
        this.motivoConsulta = motivoConsulta;
        this.peso = peso;
        this.imc = imc;
        this.masaMuscular = masaMuscular;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.estatura = estatura;
        this.circunferenciaCintura = circunferenciaCintura;
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
        this.alergiaIntoleranciaAlimentos = alergiaIntoleranciaAlimentos;
        this.comida = comida;
        this.horario = horario;
        this.porciones = porciones;
        this.ingredientes = ingredientes;
        this.suplemento = suplemento;
        this.dosisSuplemento = dosisSuplemento;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public double getPorcentajeGrasaCorporal() {
        return porcentajeGrasaCorporal;
    }

    public void setPorcentajeGrasaCorporal(double porcentajeGrasaCorporal) {
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
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

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPorciones() {
        return porciones;
    }

    public void setPorciones(String porciones) {
        this.porciones = porciones;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(String suplemento) {
        this.suplemento = suplemento;
    }

    public String getDosisSuplemento() {
        return dosisSuplemento;
    }

    public void setDosisSuplemento(String dosisSuplemento) {
        this.dosisSuplemento = dosisSuplemento;
    }
        

}
