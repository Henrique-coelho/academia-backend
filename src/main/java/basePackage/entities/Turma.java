package basePackage.entities;

import basePackage.models.enums.VinculoEnum;
import basePackage.models.enums.DiaSemanaEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Modalidade modalidade;

    private DiaSemanaEnum diaSemana;

    private String horario;

    @OneToMany
    private List<Pessoa> alunos;
}
