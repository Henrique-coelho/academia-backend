package basePackage.controllers;

import basePackage.entities.Pessoa;
import basePackage.entities.Turma;
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

    @CrossOrigin
    @GetMapping("/getAllAlunos")
    public Iterable<Pessoa> getAllClientes(@PathVariable String id){
        return turmaService.getAllAlunos(id);
    }

    @CrossOrigin
    @PostMapping("/addAluno")
    public ResponseEntity<String> addAluno(@RequestBody Pessoa aluno,@RequestBody Turma turma){
        if(turmaService.getEnrolledCount(turma) <= turmaService.getEnrollLimit(turma)){
            List<Pessoa> alunos = turma.getAlunos();
            alunos.add(aluno);
            turma.setAlunos(alunos);
            var returnValue = turmaService.saveTurma(turma);
            if(returnValue != null){
                return ResponseEntity.ok("Aluno matriculado com sucesso!");
            }
            return new ResponseEntity<>("Erro ao adicionar aluno", HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("Limite da turma ultrapassado", HttpStatus.BAD_REQUEST);
    }
}
