package basePackage.entities;

import basePackage.models.enums.PeriodoEnum;
import basePackage.models.enums.VinculoEnum;
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
@Table(name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Modalidade modalidade;

    private int dias;

    private PeriodoEnum periodo;

    private double valor;

}
