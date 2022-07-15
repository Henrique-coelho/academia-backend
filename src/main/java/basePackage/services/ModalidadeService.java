package basePackage.services;

import basePackage.entities.Modalidade;
import basePackage.services.impl.ModalidadeServiceImpl;

public interface ModalidadeService {
    Iterable<Modalidade> getAllModalidades();

    Modalidade getModalidade(String id);
}
