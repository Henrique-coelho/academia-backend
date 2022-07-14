package basePackage.services.impl;

import basePackage.entities.Modalidade;
import basePackage.repositories.ModalidadeRopository;
import basePackage.services.ModalidadeService;

public class ModalidadeServiceImpl implements ModalidadeService {
    private ModalidadeRopository modalidadeRopository;

    @Override
    public Iterable<Modalidade> getAllModalidades() {
        return modalidadeRopository.findAll();
    }
}
