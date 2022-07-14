package basePackage.services;

import basePackage.entities.Exame;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.MedidasDTO;

import java.util.List;

public interface ExameService {
    boolean checkExame(CpfDTO cpfDTO);

    List<Exame> getExames(CpfDTO cpfDTO);

    double getIMC(MedidasDTO medidasDTO);

    Exame saveExame(Exame exame);
}
