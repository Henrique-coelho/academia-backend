package basePackage.models.enums;

public enum DiaSemanaEnum {
    DOMINGO("domingo"),
    SEGUNDA("segunda"),
    TERÇA("terça"),
    QUARTA("quarta"),
    QUINTA("quinta"),
    SEXTA("sexta"),
    SABADO("sabado");

    public String dia;

    DiaSemanaEnum(String dia){
        this.dia = dia;
    }
}
