package Entidades;

/**
 *
 * @author darkd
 */
import java.util.Date;

public class EntidadDatosInterpretacion {

    private Integer idDatosInterpretacion;  // ID de los datos de interpretación
    private Integer idPaciente;             // ID del paciente
    private Date fecha;                     // Fecha de los datos
    private double peso;                    // Peso del paciente
    private double porcentajeGrasaCorporal; // Porcentaje de grasa corporal
    private double masaMuscular;            // Masa muscular
    private double masaOsea;                // Masa ósea
    private double imc;                     // Índice de masa corporal (IMC)
    private double ingestaKilocalorias;     // Ingesta diaria de kilocalorías
    private Integer edadMetabolica;         // Edad metabólica
    private double porcentajeAguaCorporal;  // Porcentaje de agua corporal
    private double grasaVisceral;           // Grasa visceral
    private double pliegueTricipital;       // Pliegue tricipital
    private double pliegueBicipital;        // Pliegue bicipital
    private double pliegueSuprailiaco;      // Pliegue suprailiaco
    private double pliegueSubescapular;     // Pliegue subescapular

    public EntidadDatosInterpretacion(Integer idDatosInterpretacion, Integer idPaciente, Date fecha, double peso,
                                      double porcentajeGrasaCorporal, double masaMuscular, double masaOsea, double imc,
                                      double ingestaKilocalorias, Integer edadMetabolica, double porcentajeAguaCorporal,
                                      double grasaVisceral, double pliegueTricipital, double pliegueBicipital,
                                      double pliegueSuprailiaco, double pliegueSubescapular) {
        this.idDatosInterpretacion = idDatosInterpretacion;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.peso = peso;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.masaMuscular = masaMuscular;
        this.masaOsea = masaOsea;
        this.imc = imc;
        this.ingestaKilocalorias = ingestaKilocalorias;
        this.edadMetabolica = edadMetabolica;
        this.porcentajeAguaCorporal = porcentajeAguaCorporal;
        this.grasaVisceral = grasaVisceral;
        this.pliegueTricipital = pliegueTricipital;
        this.pliegueBicipital = pliegueBicipital;
        this.pliegueSuprailiaco = pliegueSuprailiaco;
        this.pliegueSubescapular = pliegueSubescapular;
    }

    // Getters y Setters
    public Integer getIdDatosInterpretacion() {
        return idDatosInterpretacion;
    }

    public void setIdDatosInterpretacion(Integer idDatosInterpretacion) {
        this.idDatosInterpretacion = idDatosInterpretacion;
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

    public double getPorcentajeGrasaCorporal() {
        return porcentajeGrasaCorporal;
    }

    public void setPorcentajeGrasaCorporal(double porcentajeGrasaCorporal) {
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
    }

    public double getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public double getMasaOsea() {
        return masaOsea;
    }

    public void setMasaOsea(double masaOsea) {
        this.masaOsea = masaOsea;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getIngestaKilocalorias() {
        return ingestaKilocalorias;
    }

    public void setIngestaKilocalorias(double ingestaKilocalorias) {
        this.ingestaKilocalorias = ingestaKilocalorias;
    }

    public Integer getEdadMetabolica() {
        return edadMetabolica;
    }

    public void setEdadMetabolica(Integer edadMetabolica) {
        this.edadMetabolica = edadMetabolica;
    }

    public double getPorcentajeAguaCorporal() {
        return porcentajeAguaCorporal;
    }

    public void setPorcentajeAguaCorporal(double porcentajeAguaCorporal) {
        this.porcentajeAguaCorporal = porcentajeAguaCorporal;
    }

    public double getGrasaVisceral() {
        return grasaVisceral;
    }

    public void setGrasaVisceral(double grasaVisceral) {
        this.grasaVisceral = grasaVisceral;
    }

    public double getPliegueTricipital() {
        return pliegueTricipital;
    }

    public void setPliegueTricipital(double pliegueTricipital) {
        this.pliegueTricipital = pliegueTricipital;
    }

    public double getPliegueBicipital() {
        return pliegueBicipital;
    }

    public void setPliegueBicipital(double pliegueBicipital) {
        this.pliegueBicipital = pliegueBicipital;
    }

    public double getPliegueSuprailiaco() {
        return pliegueSuprailiaco;
    }

    public void setPliegueSuprailiaco(double pliegueSuprailiaco) {
        this.pliegueSuprailiaco = pliegueSuprailiaco;
    }

    public double getPliegueSubescapular() {
        return pliegueSubescapular;
    }

    public void setPliegueSubescapular(double pliegueSubescapular) {
        this.pliegueSubescapular = pliegueSubescapular;
    }

    // Método toString para imprimir los datos de interpretación
    @Override
    public String toString() {
        return "Datos de interpretación de " + getIdPaciente() + " - Fecha: " + getFecha();
    }
}
