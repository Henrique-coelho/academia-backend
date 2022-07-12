package basePackage.models.enums;

public enum VinculoEnum {
    CLIENTE("cliente"),
    SECRETARIO("secretario"),
    PROFESSOR("professor"),
    MEDICO("medico");

    public String vinculo;

    VinculoEnum(String vinculo){
        this.vinculo = vinculo;
    }
}
