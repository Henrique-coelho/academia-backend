package basePackage.services;

import basePackage.entities.Treino;

public interface TreinoService {
    Treino saveTreino(Treino treino);
    boolean deleteTreino(String id);
}
