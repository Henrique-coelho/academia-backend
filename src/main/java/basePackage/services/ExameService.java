package basePackage.services;

import basePackage.entities.Exame;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.MedidasDTO;

import java.util.List;

public interface ExameService {
    Boolean checkExame(CpfDTO cpfDTO);

    List<Exame> getExames(CpfDTO cpfDTO);

    Double getIMC(MedidasDTO medidasDTO);

    Exame saveExame(Exame exame);
}
