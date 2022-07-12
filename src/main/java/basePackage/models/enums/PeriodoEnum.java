package basePackage.models.enums;

public enum PeriodoEnum {
    MENSAL("mensal"),
    SEMESTRAL("semestral"),
    ANUAL("anual");

    public String periodo;

    PeriodoEnum(String periodo){
        this.periodo = periodo;
    }
}
