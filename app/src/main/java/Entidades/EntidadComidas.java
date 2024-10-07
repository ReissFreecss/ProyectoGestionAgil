package Entidades;

public class EntidadComidas {

    private Integer idComidas; // ID de la comida
    private Integer idPaciente; // ID del paciente
    private String comida; // Tipo de comida (Desayuno, Comida, Cena, etc.)
    private String horario; // Horario de la comida
    private String platillo; // Platillo consumido
    private String ingredientes; // Ingredientes del platillo
    private String cantidad; // Cantidad del platillo
    private String comeCalle; // Indica si come en la calle (Sí/No)
    private Integer frecuenciaComidaCalle; // Frecuencia con la que come en la calle

    public EntidadComidas(Integer idComidas, Integer idPaciente, String comida, String horario, String platillo, 
                          String ingredientes, String cantidad, String comeCalle, Integer frecuenciaComidaCalle) {
        this.idComidas = idComidas;
        this.idPaciente = idPaciente;
        this.comida = comida;
        this.horario = horario;
        this.platillo = platillo;
        this.ingredientes = ingredientes;
        this.cantidad = cantidad;
        this.comeCalle = comeCalle;
        this.frecuenciaComidaCalle = frecuenciaComidaCalle;
    }

    // Getters y Setters
    public Integer getIdComidas() {
        return idComidas;
    }

    public void setIdComidas(Integer idComidas) {
        this.idComidas = idComidas;
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

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getComeCalle() {
        return comeCalle;
    }

    public void setComeCalle(String comeCalle) {
        this.comeCalle = comeCalle;
    }

    public Integer getFrecuenciaComidaCalle() {
        return frecuenciaComidaCalle;
    }

    public void setFrecuenciaComidaCalle(Integer frecuenciaComidaCalle) {
        this.frecuenciaComidaCalle = frecuenciaComidaCalle;
    }

    // Método toString para imprimir los datos de las comidas
    @Override
    public String toString() {
        return "Comida de " + getIdPaciente() + ": " + getComida() + ", Platillo: " + getPlatillo();
    }
}
