package Entidades;

public class EntidadEstiloVida {

    private Integer idEstiloVida; // ID del estilo de vida
    private Integer idPaciente; // ID del paciente
    private String horaDespertar; // Hora de despertar
    private String horaDormir; // Hora de dormir
    private String horaTrabajoEstudio; // Hora de trabajo/estudio
    private String horaEntrenamiento; // Hora de entrenamiento
    private String tipoEjercicio; // Tipo de ejercicio
    private String intensidad; // Intensidad del ejercicio
    private Integer frecuenciaEjercicio; // Frecuencia del ejercicio

    // Constructor
    public EntidadEstiloVida(Integer idEstiloVida, Integer idPaciente, String horaDespertar, String horaDormir,
                             String horaTrabajoEstudio, String horaEntrenamiento, String tipoEjercicio,
                             String intensidad, Integer frecuenciaEjercicio) {
        this.idEstiloVida = idEstiloVida;
        this.idPaciente = idPaciente;
        this.horaDespertar = horaDespertar;
        this.horaDormir = horaDormir;
        this.horaTrabajoEstudio = horaTrabajoEstudio;
        this.horaEntrenamiento = horaEntrenamiento;
        this.tipoEjercicio = tipoEjercicio;
        this.intensidad = intensidad;
        this.frecuenciaEjercicio = frecuenciaEjercicio;
    }

    // Getters y Setters
    public Integer getIdEstiloVida() {
        return idEstiloVida;
    }

    public void setIdEstiloVida(Integer idEstiloVida) {
        this.idEstiloVida = idEstiloVida;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getHoraDespertar() {
        return horaDespertar;
    }

    public void setHoraDespertar(String horaDespertar) {
        this.horaDespertar = horaDespertar;
    }

    public String getHoraDormir() {
        return horaDormir;
    }

    public void setHoraDormir(String horaDormir) {
        this.horaDormir = horaDormir;
    }

    public String getHoraTrabajoEstudio() {
        return horaTrabajoEstudio;
    }

    public void setHoraTrabajoEstudio(String horaTrabajoEstudio) {
        this.horaTrabajoEstudio = horaTrabajoEstudio;
    }

    public String getHoraEntrenamiento() {
        return horaEntrenamiento;
    }

    public void setHoraEntrenamiento(String horaEntrenamiento) {
        this.horaEntrenamiento = horaEntrenamiento;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public Integer getFrecuenciaEjercicio() {
        return frecuenciaEjercicio;
    }

    public void setFrecuenciaEjercicio(Integer frecuenciaEjercicio) {
        this.frecuenciaEjercicio = frecuenciaEjercicio;
    }

    // Método toString para imprimir los datos de estilo de vida
    @Override
    public String toString() {
        return "Estilo de vida de paciente " + getIdPaciente() + ": Ejercicio " + getTipoEjercicio() +
               " con intensidad " + getIntensidad() + ", frecuencia " + getFrecuenciaEjercicio() + " veces por semana.";
    }
}

