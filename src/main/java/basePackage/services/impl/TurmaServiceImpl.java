package basePackage.services.impl;

import basePackage.entities.Pessoa;
import basePackage.entities.Turma;
import basePackage.repositories.TurmaRepository;
import basePackage.services.TurmaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {

    private TurmaRepository turmaRepository;

    @Override
    public Turma saveTurma(Turma turma){
        return turmaRepository.save(turma);
    }
    @Override
    public Iterable<Pessoa> getAllAlunos(String id) {
        Optional<Turma> turma = getTurmaById(id);
        if(turma.isPresent()){
            return (Iterable<Pessoa>) turma.get().getPessoas();
        }
        return null;
    }
    @Override
    public int getEnrolledCount(Turma turma) {
        return (int) turma.getPessoas().stream().count();
    }

    @Override
    public int getEnrollLimit(Turma turma){
        return turma.getModalidade().getLimiteAlunos();
    }

    @Override
    public Optional<Turma> getTurmaById(String id){
        return turmaRepository.findById(Long.getLong(id));
    }
}
