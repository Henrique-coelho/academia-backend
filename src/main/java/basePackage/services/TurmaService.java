package basePackage.services;

import basePackage.entities.Pessoa;
import basePackage.entities.Turma;

import java.util.Optional;

public interface TurmaService {
    Turma saveTurma(Turma turma);
    Iterable<Pessoa> getAllAlunos(String id);
    int getEnrolledCount(Turma turma);

    int getEnrollLimit(Turma turma);
    Optional<Turma> getTurmaById(String id);
}
