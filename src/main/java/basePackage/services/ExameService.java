package basePackage.services;

import basePackage.entities.Exame;
import basePackage.models.dto.CpfDTO;

import java.util.List;

public interface ExameService {
    boolean checkExame(CpfDTO cpfDTO);

    List<Exame> getExames(CpfDTO cpfDTO);
}
