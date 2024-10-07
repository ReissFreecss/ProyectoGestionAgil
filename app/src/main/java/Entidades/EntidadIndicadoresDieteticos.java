/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author darkd
 */
public class EntidadIndicadoresDieteticos {

    private Integer idIndicadoresDieteticos; // ID de los indicadores dietéticos
    private Integer idPaciente; // ID del paciente
    private String preparadorAlimentos; // Quién prepara los alimentos
    private String horaApetito; // Hora en la que tiene apetito
    private String alimentosPreferidos; // Alimentos preferidos
    private String alimentosNoPreferidos; // Alimentos no preferidos
    private String suplemento; // Suplemento que toma
    private String dosisSuplemento; // Dosis del suplemento
    private Double aguaConsumida; // Cantidad de agua consumida
    private Double refrescoConsumido; // Cantidad de refresco consumido
    private Double lecheConsumida; // Cantidad de leche consumida
    private String medicamentosBajarPeso; // Medicamentos para bajar de peso

    public EntidadIndicadoresDieteticos(Integer idIndicadoresDieteticos, Integer idPaciente, String preparadorAlimentos,
                                        String horaApetito, String alimentosPreferidos, String alimentosNoPreferidos,
                                        String suplemento, String dosisSuplemento, Double aguaConsumida, 
                                        Double refrescoConsumido, Double lecheConsumida, String medicamentosBajarPeso) {
        this.idIndicadoresDieteticos = idIndicadoresDieteticos;
        this.idPaciente = idPaciente;
        this.preparadorAlimentos = preparadorAlimentos;
        this.horaApetito = horaApetito;
        this.alimentosPreferidos = alimentosPreferidos;
        this.alimentosNoPreferidos = alimentosNoPreferidos;
        this.suplemento = suplemento;
        this.dosisSuplemento = dosisSuplemento;
        this.aguaConsumida = aguaConsumida;
        this.refrescoConsumido = refrescoConsumido;
        this.lecheConsumida = lecheConsumida;
        this.medicamentosBajarPeso = medicamentosBajarPeso;
    }

    // Getters y Setters
    public Integer getIdIndicadoresDieteticos() {
        return idIndicadoresDieteticos;
    }

    public void setIdIndicadoresDieteticos(Integer idIndicadoresDieteticos) {
        this.idIndicadoresDieteticos = idIndicadoresDieteticos;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPreparadorAlimentos() {
        return preparadorAlimentos;
    }

    public void setPreparadorAlimentos(String preparadorAlimentos) {
        this.preparadorAlimentos = preparadorAlimentos;
    }

    public String getHoraApetito() {
        return horaApetito;
    }

    public void setHoraApetito(String horaApetito) {
        this.horaApetito = horaApetito;
    }

    public String getAlimentosPreferidos() {
        return alimentosPreferidos;
    }

    public void setAlimentosPreferidos(String alimentosPreferidos) {
        this.alimentosPreferidos = alimentosPreferidos;
    }

    public String getAlimentosNoPreferidos() {
        return alimentosNoPreferidos;
    }

    public void setAlimentosNoPreferidos(String alimentosNoPreferidos) {
        this.alimentosNoPreferidos = alimentosNoPreferidos;
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

    public Double getAguaConsumida() {
        return aguaConsumida;
    }

    public void setAguaConsumida(Double aguaConsumida) {
        this.aguaConsumida = aguaConsumida;
    }

    public Double getRefrescoConsumido() {
        return refrescoConsumido;
    }

    public void setRefrescoConsumido(Double refrescoConsumido) {
        this.refrescoConsumido = refrescoConsumido;
    }

    public Double getLecheConsumida() {
        return lecheConsumida;
    }

    public void setLecheConsumida(Double lecheConsumida) {
        this.lecheConsumida = lecheConsumida;
    }

    public String getMedicamentosBajarPeso() {
        return medicamentosBajarPeso;
    }

    public void setMedicamentosBajarPeso(String medicamentosBajarPeso) {
        this.medicamentosBajarPeso = medicamentosBajarPeso;
    }

    // Método toString para imprimir los indicadores dietéticos
    @Override
    public String toString() {
        return "Indicadores Dietéticos de " + getIdPaciente() + ": " + getPreparadorAlimentos();
    }
}

