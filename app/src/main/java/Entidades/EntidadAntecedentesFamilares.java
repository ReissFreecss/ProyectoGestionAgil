package Entidades;

public class EntidadAntecedentesFamilares {
    private Integer idAntecedenteFamiliar;
    private Integer idPaciente;
    private String parentezco;
    private String enfermedadDiagnosticada;
    private String alergiasMedicamentos;

    // Constructor con todos los campos
    public EntidadAntecedentesFamilares(Integer idAntecedenteFamiliar, Integer idPaciente, String parentezco, String enfermedadDiagnosticada, String alergiasMedicamentos) {
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
        this.idPaciente = idPaciente;
        this.parentezco = parentezco != null ? parentezco : "Ninguna";
        this.enfermedadDiagnosticada = enfermedadDiagnosticada != null ? enfermedadDiagnosticada : "Ninguna";
        this.alergiasMedicamentos = alergiasMedicamentos != null ? alergiasMedicamentos : "Ninguna";
    }
    
    // Constructor sin ID (para cuando se está creando un nuevo antecedente familiar)
    public EntidadAntecedentesFamilares(Integer idPaciente, String parentezco, String enfermedadDiagnosticada, String alergiasMedicamentos) {
        this(null, idPaciente, parentezco, enfermedadDiagnosticada, alergiasMedicamentos);
    }

    // Getters y Setters
    public Integer getIdAntecedenteFamiliar() {
        return idAntecedenteFamiliar;
    }

    public void setIdAntecedenteFamiliar(Integer idAntecedenteFamiliar) {
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco != null ? parentezco : "Ninguna";
    }

    public String getEnfermedadDiagnosticada() {
        return enfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada) {
        this.enfermedadDiagnosticada = enfermedadDiagnosticada != null ? enfermedadDiagnosticada : "Ninguna";
    }

    public String getAlergiasMedicamentos() {
        return alergiasMedicamentos;
    }

    public void setAlergiasMedicamentos(String alergiasMedicamentos) {
        this.alergiasMedicamentos = alergiasMedicamentos != null ? alergiasMedicamentos : "Ninguna";
    }

    // Método para representar el objeto como String (opcional, útil para depuración)
    @Override
    public String toString() {
        return "EntidadAntecedentesFamiliares{" +
                "idAntecedenteFamiliar=" + idAntecedenteFamiliar +
                ", idPaciente=" + idPaciente +
                ", parentezco='" + parentezco + '\'' +
                ", enfermedadDiagnosticada='" + enfermedadDiagnosticada + '\'' +
                ", alergiasMedicamentos='" + alergiasMedicamentos + '\'' +
                '}';
    }
}

