package basePackage.services.impl;

import basePackage.entities.Treino;
import basePackage.repositories.TreinoRepository;
import basePackage.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinoServiceImpl implements TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;

    @Override
    public Treino saveTreino(Treino treino){
        return treinoRepository.save(treino);
    }

    @Override
    public boolean deleteTreino(String id) {
        var exists = treinoRepository.existsById(Long.parseLong(id));
        if(exists){
            treinoRepository.deleteById(Long.parseLong(id));
            return true;
        }
        return false;
    }
}
