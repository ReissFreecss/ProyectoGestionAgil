/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author darkd
 */
public class EntidadDietas {

    private Integer idDieta;           // ID de la dieta
    private Integer idPaciente;        // ID del paciente
    private String comida;             // Tipo de comida (Desayuno, Comida, Cena, etc.)
    private String horario;            // Horario de la comida
    private String porciones;          // Cantidad de porciones
    private String ingredientes;       // Ingredientes de la comida
    private String suplemento;         // Suplemento alimenticio, si lo hay
    private String dosisSuplemento;    // Dosis del suplemento alimenticio

    public EntidadDietas(Integer idDieta, Integer idPaciente, String comida, String horario, String porciones,
                         String ingredientes, String suplemento, String dosisSuplemento) {
        this.idDieta = idDieta;
        this.idPaciente = idPaciente;
        this.comida = comida;
        this.horario = horario;
        this.porciones = porciones;
        this.ingredientes = ingredientes;
        this.suplemento = suplemento;
        this.dosisSuplemento = dosisSuplemento;
    }

    // Getters y Setters
    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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

    // Método toString para imprimir los detalles de la dieta
    @Override
    public String toString() {
        return "Dieta de " + getComida() + " a las " + getHorario() + " - Paciente: " + getIdPaciente();
    }
}