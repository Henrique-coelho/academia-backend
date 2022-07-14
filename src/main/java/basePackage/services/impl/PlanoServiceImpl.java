package basePackage.services.impl;

import basePackage.dao.PlanoDAO;
import basePackage.entities.Modalidade;
import basePackage.entities.Plano;
import basePackage.repositories.PlanoRepository;
import basePackage.services.PlanoService;

public class PlanoServiceImpl implements PlanoService {
    private PlanoRepository planoRepository;
    private PlanoDAO planoDAO;

    @Override
    public Iterable<Plano> getAllPlanos(Modalidade modalidade) {
        String nomeModalidade = modalidade.getNome().toString();
        return planoDAO.findAllPlans(nomeModalidade);
    }
}
