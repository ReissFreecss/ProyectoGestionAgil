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
public class EntidadSeguimiento {

    private Integer idSeguimiento; // ID del seguimiento
    private Integer idPaciente; // ID del paciente
    private Date fecha; // Fecha del seguimiento
    private String apegoPlan; // Apego al plan
    private String alimentosFueraPlan; // Alimentos fuera del plan
    private String pasoHambre; // Indicador si pasó hambre
    private Integer diasEntrenamiento; // Días de entrenamiento
    private String mejoroEjercicio; // Indicador si mejoró en el ejercicio
    private String jugosRefrescosAlcohol; // Consumo de jugos, refrescos o alcohol
    private String litrosAgua; // Cantidad de agua en litros
    private String malestaresGastricos; // Malestares gástricos
    private String horasSueno; // Horas de sueño
    private String problemaSolucion; // Problemas y soluciones
    private String extrasObservaciones; // Observaciones adicionales

    public EntidadSeguimiento(Integer idSeguimiento, Integer idPaciente, Date fecha, String apegoPlan,
            String alimentosFueraPlan, String pasoHambre, Integer diasEntrenamiento, String mejoroEjercicio,
            String jugosRefrescosAlcohol, String litrosAgua, String malestaresGastricos, String horasSueno,
            String problemaSolucion, String extrasObservaciones) {
        this.idSeguimiento = idSeguimiento;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.apegoPlan = apegoPlan;
        this.alimentosFueraPlan = alimentosFueraPlan;
        this.pasoHambre = pasoHambre;
        this.diasEntrenamiento = diasEntrenamiento;
        this.mejoroEjercicio = mejoroEjercicio;
        this.jugosRefrescosAlcohol = jugosRefrescosAlcohol;
        this.litrosAgua = litrosAgua;
        this.malestaresGastricos = malestaresGastricos;
        this.horasSueno = horasSueno;
        this.problemaSolucion = problemaSolucion;
        this.extrasObservaciones = extrasObservaciones;
    }

    // Getters y Setters
    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
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

    public String getApegoPlan() {
        return apegoPlan;
    }

    public void setApegoPlan(String apegoPlan) {
        this.apegoPlan = apegoPlan;
    }

    public String getAlimentosFueraPlan() {
        return alimentosFueraPlan;
    }

    public void setAlimentosFueraPlan(String alimentosFueraPlan) {
        this.alimentosFueraPlan = alimentosFueraPlan;
    }

    public String getPasoHambre() {
        return pasoHambre;
    }

    public void setPasoHambre(String pasoHambre) {
        this.pasoHambre = pasoHambre;
    }

    public Integer getDiasEntrenamiento() {
        return diasEntrenamiento;
    }

    public void setDiasEntrenamiento(Integer diasEntrenamiento) {
        this.diasEntrenamiento = diasEntrenamiento;
    }

    public String getMejoroEjercicio() {
        return mejoroEjercicio;
    }

    public void setMejoroEjercicio(String mejoroEjercicio) {
        this.mejoroEjercicio = mejoroEjercicio;
    }

    public String getJugosRefrescosAlcohol() {
        return jugosRefrescosAlcohol;
    }

    public void setJugosRefrescosAlcohol(String jugosRefrescosAlcohol) {
        this.jugosRefrescosAlcohol = jugosRefrescosAlcohol;
    }

    public String getLitrosAgua() {
        return litrosAgua;
    }

    public void setLitrosAgua(String litrosAgua) {
        this.litrosAgua = litrosAgua;
    }

    public String getMalestaresGastricos() {
        return malestaresGastricos;
    }

    public void setMalestaresGastricos(String malestaresGastricos) {
        this.malestaresGastricos = malestaresGastricos;
    }

    public String getHorasSueno() {
        return horasSueno;
    }

    public void setHorasSueno(String horasSueno) {
        this.horasSueno = horasSueno;
    }

    public String getProblemaSolucion() {
        return problemaSolucion;
    }

    public void setProblemaSolucion(String problemaSolucion) {
        this.problemaSolucion = problemaSolucion;
    }

    public String getExtrasObservaciones() {
        return extrasObservaciones;
    }

    public void setExtrasObservaciones(String extrasObservaciones) {
        this.extrasObservaciones = extrasObservaciones;
    }

    // Método toString para imprimir el seguimiento
    @Override
    public String toString() {
        return "Seguimiento de " + getIdPaciente() + " en fecha " + getFecha() + ": Apego al plan - " + getApegoPlan();
    }
}
