package Entidades;

/**
 *
 * @author darkd
 */
public class EntidadDietaEspecial {

    private Integer idDietaEspecial; // ID de la dieta especial
    private Integer idPaciente; // ID del paciente
    private String dietaEspecial; // Indica si sigue una dieta especial (Sí/No)
    private String tipoDieta; // Tipo de dieta especial
    private String tiempoDietaEspecial; // Duración de la dieta especial
    private String razonDietaEspecial; // Razón para seguir la dieta especial
    private String resultadoDietaEspecial; // Resultados obtenidos de la dieta especial
    private String apegoDieta; // Grado de apego a la dieta

    public EntidadDietaEspecial(Integer idDietaEspecial, Integer idPaciente, String dietaEspecial, String tipoDieta,
                                String tiempoDietaEspecial, String razonDietaEspecial, String resultadoDietaEspecial,
                                String apegoDieta) {
        this.idDietaEspecial = idDietaEspecial;
        this.idPaciente = idPaciente;
        this.dietaEspecial = dietaEspecial;
        this.tipoDieta = tipoDieta;
        this.tiempoDietaEspecial = tiempoDietaEspecial;
        this.razonDietaEspecial = razonDietaEspecial;
        this.resultadoDietaEspecial = resultadoDietaEspecial;
        this.apegoDieta = apegoDieta;
    }

    // Getters y Setters
    public Integer getIdDietaEspecial() {
        return idDietaEspecial;
    }

    public void setIdDietaEspecial(Integer idDietaEspecial) {
        this.idDietaEspecial = idDietaEspecial;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDietaEspecial() {
        return dietaEspecial;
    }

    public void setDietaEspecial(String dietaEspecial) {
        this.dietaEspecial = dietaEspecial;
    }

    public String getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(String tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public String getTiempoDietaEspecial() {
        return tiempoDietaEspecial;
    }

    public void setTiempoDietaEspecial(String tiempoDietaEspecial) {
        this.tiempoDietaEspecial = tiempoDietaEspecial;
    }

    public String getRazonDietaEspecial() {
        return razonDietaEspecial;
    }

    public void setRazonDietaEspecial(String razonDietaEspecial) {
        this.razonDietaEspecial = razonDietaEspecial;
    }

    public String getResultadoDietaEspecial() {
        return resultadoDietaEspecial;
    }

    public void setResultadoDietaEspecial(String resultadoDietaEspecial) {
        this.resultadoDietaEspecial = resultadoDietaEspecial;
    }

    public String getApegoDieta() {
        return apegoDieta;
    }

    public void setApegoDieta(String apegoDieta) {
        this.apegoDieta = apegoDieta;
    }

    // Método toString para imprimir la información de la dieta especial
    @Override
    public String toString() {
        return "Dieta Especial de " + getIdPaciente() + ": " + getTipoDieta();
    }
}

