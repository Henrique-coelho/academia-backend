package basePackage.services.impl;

import basePackage.entities.Modalidade;
import basePackage.repositories.ModalidadeRopository;
import basePackage.services.ModalidadeService;
import org.springframework.stereotype.Service;

@Service
public class ModalidadeServiceImpl implements ModalidadeService {
    private ModalidadeRopository modalidadeRopository;

    @Override
    public Iterable<Modalidade> getAllModalidades() {
        return modalidadeRopository.findAll();
    }
}
