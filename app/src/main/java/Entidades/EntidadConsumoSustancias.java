/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class EntidadConsumoSustancias {

    private Integer idConsumoSustancia; // ID del consumo de sustancia
    private Integer idPaciente; // ID del paciente
    private String sustancia; // Sustancia consumida
    private String tipo; // Tipo de sustancia
    private Integer frecuencia; // Frecuencia de consumo
    private String cantidad; // Cantidad consumida

    public EntidadConsumoSustancias(Integer idConsumoSustancia, Integer idPaciente, String sustancia,
                                      String tipo, Integer frecuencia, String cantidad) {
        this.idConsumoSustancia = idConsumoSustancia;
        this.idPaciente = idPaciente;
        this.sustancia = sustancia;
        this.tipo = tipo;
        this.frecuencia = frecuencia;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Integer getIdConsumoSustancia() {
        return idConsumoSustancia;
    }

    public void setIdConsumoSustancia(Integer idConsumoSustancia) {
        this.idConsumoSustancia = idConsumoSustancia;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getSustancia() {
        return sustancia;
    }

    public void setSustancia(String sustancia) {
        this.sustancia = sustancia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString para imprimir el consumo de sustancias
    @Override
    public String toString() {
        return "Consumo de " + getSustancia() + " por el paciente " + getIdPaciente() + ": " + getFrecuencia() + " veces a la semana.";
    }
}

