/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author darkd
 */
public class EntidadIndicadoresAntropometricos {

    private Integer idIndicador; // ID del indicador antropométrico
    private Integer idPaciente;  // ID del paciente
    private Date fecha;          // Fecha de registro de los indicadores
    private double peso;         // Peso del paciente
    private double estatura;     // Estatura del paciente
    private double circunferenciaBrazo;    // Circunferencia del brazo
    private double circunferenciaCintura;  // Circunferencia de la cintura
    private double circunferenciaCadera;   // Circunferencia de la cadera
    private double circunferenciaMuslo;    // Circunferencia del muslo

    public EntidadIndicadoresAntropometricos(Integer idIndicador, Integer idPaciente, Date fecha, double peso,
                                             double estatura, double circunferenciaBrazo,
                                             double circunferenciaCintura, double circunferenciaCadera,
                                             double circunferenciaMuslo) {
        this.idIndicador = idIndicador;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.peso = peso;
        this.estatura = estatura;
        this.circunferenciaBrazo = circunferenciaBrazo;
        this.circunferenciaCintura = circunferenciaCintura;
        this.circunferenciaCadera = circunferenciaCadera;
        this.circunferenciaMuslo = circunferenciaMuslo;
    }

    // Getters y Setters
    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getCircunferenciaBrazo() {
        return circunferenciaBrazo;
    }

    public void setCircunferenciaBrazo(double circunferenciaBrazo) {
        this.circunferenciaBrazo = circunferenciaBrazo;
    }

    public double getCircunferenciaCintura() {
        return circunferenciaCintura;
    }

    public void setCircunferenciaCintura(double circunferenciaCintura) {
        this.circunferenciaCintura = circunferenciaCintura;
    }

    public double getCircunferenciaCadera() {
        return circunferenciaCadera;
    }

    public void setCircunferenciaCadera(double circunferenciaCadera) {
        this.circunferenciaCadera = circunferenciaCadera;
    }

    public double getCircunferenciaMuslo() {
        return circunferenciaMuslo;
    }

    public void setCircunferenciaMuslo(double circunferenciaMuslo) {
        this.circunferenciaMuslo = circunferenciaMuslo;
    }

    // Método toString para imprimir los indicadores antropométricos
    @Override
    public String toString() {
        return "Indicadores antropométricos de " + getIdPaciente() + " - Fecha: " + getFecha();
    }
}