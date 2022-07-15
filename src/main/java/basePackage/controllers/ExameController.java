package basePackage.controllers;

import basePackage.entities.Exame;
import basePackage.entities.Pessoa;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.MedidasDTO;
import basePackage.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exame")
public class ExameController {
    @Autowired
    private ExameService exameService;

    @CrossOrigin
    @GetMapping("/getAuthorizationFromCPF/{cpf}")
    public Boolean wasExamAuthorized(@PathVariable("cpf") String cpf){
        return exameService.checkExame(cpf);
    }

    @CrossOrigin
    @PostMapping("/imc")
    public Double getIMC(@RequestBody MedidasDTO medidasDTO){
        return exameService.getIMC(medidasDTO);
    }

    @CrossOrigin
    @PostMapping("/getAuthorizationFromCPF/{cpf}")
    public List<Exame> getExamesFromCPF(@PathVariable("cpf") String cpf){
        return exameService.getExames(cpf);
    }

    @CrossOrigin
    @PostMapping("/createOrUpdate")
    public ResponseEntity<String> createUpdate(@RequestBody Exame exame){
        var returnValue = exameService.saveExame(exame);
        if (returnValue != null) {
            return ResponseEntity.ok("Resultados do exame cadastrados com sucesso!");
        } else {
            return new ResponseEntity<>("Erro ao cadastrar exame", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @GetMapping("/ExameByCPF/{cpf}")
    public ResponseEntity<List<Exame>> getExame(@PathVariable("cpf") String cpf){
        List<Exame> exames = exameService.getExames(cpf);
        return ResponseEntity.ok(exames);
    }
}
