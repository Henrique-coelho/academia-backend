package basePackage.services;

import basePackage.entities.Modalidade;
import basePackage.entities.Plano;

public interface PlanoService {
    Iterable<Plano> getAllPlanos(Modalidade modalidade);
}
