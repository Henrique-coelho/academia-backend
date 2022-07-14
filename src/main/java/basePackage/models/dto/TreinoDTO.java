package basePackage.models.dto;

import basePackage.entities.Pessoa;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class TreinoDTO {
    private Pessoa aluno;
    private Pessoa professor;
    private String descricao;
}
