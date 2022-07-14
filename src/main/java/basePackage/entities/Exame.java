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

    private double peso;

    private double altura;

    private boolean autorizado;

    @OneToOne
    private Pessoa aluno;

    @OneToOne
    private Pessoa medico;

    private String descricao;
}
