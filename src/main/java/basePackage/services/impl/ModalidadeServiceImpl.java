package basePackage.services.impl;

import basePackage.entities.Modalidade;
import basePackage.repositories.ModalidadeRepository;
import basePackage.services.ModalidadeService;
import org.springframework.stereotype.Service;

@Service
public class ModalidadeServiceImpl implements ModalidadeService {
    private ModalidadeRepository modalidadeRepository;

    @Override
    public Iterable<Modalidade> getAllModalidades() {
        return modalidadeRepository.findAll();
    }

    @Override
    public Modalidade getModalidade(String id) {
        return modalidadeRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
