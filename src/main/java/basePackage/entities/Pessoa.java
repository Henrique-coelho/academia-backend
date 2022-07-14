package basePackage.entities;

import basePackage.models.enums.VinculoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    private VinculoEnum vinculo;

    private String numCartao;

    private String donoCartao;
}
