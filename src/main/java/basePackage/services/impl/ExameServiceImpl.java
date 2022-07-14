package basePackage.services.impl;

import basePackage.dao.ExameDAO;
import basePackage.entities.Exame;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.MedidasDTO;
import basePackage.repositories.ExameRepository;
import basePackage.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameServiceImpl implements ExameService {
    @Autowired
    private ExameRepository exameRepository;
    @Autowired
    private ExameDAO exameDAO;
    @Override
    public Boolean checkExame(String cpf) {
        List<Exame> exames = getExames(cpf);
        if(!exames.isEmpty()){
            return exames.get(0).getAutorizado();
        }
        return false;
    }

    @Override
    public List<Exame> getExames(String cpf) {
        return exameDAO.findExamsByCPF(cpf);
    }

    @Override
    public Double getIMC(MedidasDTO medidasDTO) {
        return medidasDTO.getPeso()/(Math.pow(medidasDTO.getAltura(),2));
    }

    @Override
    public Exame saveExame(Exame exame) {
        return exameRepository.save(exame);
    }
}
