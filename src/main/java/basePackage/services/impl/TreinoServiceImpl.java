package basePackage.services.impl;

import basePackage.entities.Treino;
import basePackage.repositories.TreinoRepository;
import basePackage.services.TreinoService;

public class TreinoServiceImpl implements TreinoService {
    private TreinoRepository treinoRepository;

    @Override
    public Treino saveTreino(Treino treino){
        return treinoRepository.save(treino);
    }

    @Override
    public boolean deleteTreino(String id) {
        var exists = treinoRepository.existsById(Long.getLong(id));
        if(exists){
            treinoRepository.deleteById(Long.getLong(id));
            return true;
        }
        return false;
    }
}
