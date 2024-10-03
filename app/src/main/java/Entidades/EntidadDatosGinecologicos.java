package Entidades;

import java.sql.Date;

public class EntidadDatosGinecologicos {

    private Integer idGinecologico;
    private Integer idPaciente;
    private String embarazoActual;
    private String sdg; // Semanas de gestación
    private String referidoPorPaciente;
    private Date fum; // Fecha de última menstruación
    private String anticonceptivosOrales;
    private String dosisAnticonceptivo;
    private Integer numEmbarazos;

    // Constructor vacío
    public EntidadDatosGinecologicos() {
    }

    // Constructor con parámetros
    public EntidadDatosGinecologicos(Integer idGinecologico, Integer idPaciente, String embarazoActual, String sdg,
            String referidoPorPaciente, Date fum, String anticonceptivosOrales, String dosisAnticonceptivo, Integer numEmbarazos) {
        this.idGinecologico = idGinecologico;
        this.idPaciente = idPaciente;
        this.embarazoActual = embarazoActual;
        this.sdg = sdg;
        this.referidoPorPaciente = referidoPorPaciente;
        this.fum = fum;
        this.anticonceptivosOrales = anticonceptivosOrales;
        this.dosisAnticonceptivo = dosisAnticonceptivo;
        this.numEmbarazos = numEmbarazos;
    }

    // Getters y Setters
    public Integer getIdGinecologico() {
        return idGinecologico;
    }

    public void setIdGinecologico(Integer idGinecologico) {
        this.idGinecologico = idGinecologico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEmbarazoActual() {
        return embarazoActual;
    }

    public void setEmbarazoActual(String embarazoActual) {
        this.embarazoActual = embarazoActual;
    }

    public String getSdg() {
        return sdg;
    }

    public void setSdg(String sdg) {
        this.sdg = sdg;
    }

    public String getReferidoPorPaciente() {
        return referidoPorPaciente;
    }

    public void setReferidoPorPaciente(String referidoPorPaciente) {
        this.referidoPorPaciente = referidoPorPaciente;
    }

    public Date getFum() {
        return fum;
    }

    public void setFum(Date fum) {
        this.fum = fum;
    }

    public String getAnticonceptivosOrales() {
        return anticonceptivosOrales;
    }

    public void setAnticonceptivosOrales(String anticonceptivosOrales) {
        this.anticonceptivosOrales = anticonceptivosOrales;
    }

    public String getDosisAnticonceptivo() {
        return dosisAnticonceptivo;
    }

    public void setDosisAnticonceptivo(String dosisAnticonceptivo) {
        this.dosisAnticonceptivo = dosisAnticonceptivo;
    }

    public Integer getNumEmbarazos() {
        return numEmbarazos;
    }

    public void setNumEmbarazos(Integer numEmbarazos) {
        this.numEmbarazos = numEmbarazos;
    }

    @Override
    public String toString() {
        return "EntidadDatosGinecologicos{"
                + "idGinecologico=" + idGinecologico
                + ", idPaciente=" + idPaciente
                + ", embarazoActual='" + embarazoActual + '\''
                + ", sdg='" + sdg + '\''
                + ", referidoPorPaciente='" + referidoPorPaciente + '\''
                + ", fum=" + fum
                + ", anticonceptivosOrales='" + anticonceptivosOrales + '\''
                + ", dosisAnticonceptivo='" + dosisAnticonceptivo + '\''
                + ", numEmbarazos=" + numEmbarazos
                + '}';
    }
}
