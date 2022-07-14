package basePackage.models.enums;

public enum ModalidadeEnum {
    SPINNING("spinning"),
    CROSSFIT("crossfit"),
    RITMO("ritmo"),
    NATACAO("natacao"),
    MUSCULACAO("musculacao");

    public String modalidade;

    ModalidadeEnum(String modalidade){
        this.modalidade = modalidade;
    }
}
