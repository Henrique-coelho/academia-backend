package basePackage.services.impl;

import basePackage.dao.ExameDAO;
import basePackage.entities.Exame;
import basePackage.models.dto.CpfDTO;
import basePackage.repositories.ExameRepository;
import basePackage.services.ExameService;

import java.util.List;

public class ExameServiceImpl implements ExameService {
    private ExameRepository exameRepository;
    private ExameDAO exameDAO;
    @Override
    public boolean checkExame(CpfDTO cpfDTO) {
        List<Exame> exames = getExames(cpfDTO);
        if(!exames.isEmpty()){
            return exames.get(0).isAutorizado();
        }
        return false;
    }

    @Override
    public List<Exame> getExames(CpfDTO cpfDTO) {
        return exameDAO.findExamsByCPF(cpfDTO.getCpf());
    }
}