package basePackage.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double peso;

    private Double altura;

    private Boolean autorizado;

    @ManyToOne
    private Pessoa aluno;

    @ManyToOne
    private Pessoa medico;

    private String descricao;
}
