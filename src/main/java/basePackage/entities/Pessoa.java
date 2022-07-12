package basePackage.entities;

import basePackage.models.enums.VinculoEnum;
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

    String nome;

    String cpf;

    Date dataNascimento;

    VinculoEnum vinculo;

    String numCartao;

    String donoCartao;
}
