package basePackage.controllers;

import basePackage.entities.Pessoa;
import basePackage.entities.Turma;
import basePackage.models.dto.AddAlunoDTO;
import basePackage.services.PessoaService;
import basePackage.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private PessoaService pessoaService;

    @CrossOrigin
    @GetMapping("/getAllAlunos/{id}")
    public Iterable<Pessoa> getAllClientes(@PathVariable("id") String id){
        return turmaService.getAllAlunos(id);
    }

    @CrossOrigin
    @PostMapping("/addAluno")
    public ResponseEntity<String> addAluno(@RequestBody AddAlunoDTO addAlunoDTO){
        Turma turma = turmaService.getTurmaById(addAlunoDTO.getAlunoId()).orElse(null);
        Pessoa aluno = pessoaService.getPessoaById(addAlunoDTO.getTurmaId()).orElse(null);
        if(turma==null){
            return new ResponseEntity<>("Turma inexistente", HttpStatus.BAD_REQUEST);
        }
        if(aluno==null){
            return new ResponseEntity<>("Aluno inexistente", HttpStatus.BAD_REQUEST);
        }
        if(turmaService.getEnrolledCount(turma) <= turmaService.getEnrollLimit(turma)){
            List<Pessoa> alunos = turma.getPessoas();
            alunos.add(aluno);
            turma.setPessoas(alunos);
            var returnValue = turmaService.saveTurma(turma);
            if(returnValue != null){
                return ResponseEntity.ok("Aluno matriculado com sucesso!");
            }
            return new ResponseEntity<>("Erro ao adicionar aluno", HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("Limite da turma ultrapassado", HttpStatus.BAD_REQUEST);
    }
}
