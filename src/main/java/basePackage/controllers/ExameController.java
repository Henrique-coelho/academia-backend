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

@RestController
@RequestMapping("/api/exame")
public class ExameController {
    @Autowired
    private ExameService exameService;

    @CrossOrigin
    @PostMapping("/getAuthorizationFromCPF")
    public Boolean wasExamAuthorized(@RequestBody CpfDTO cpfDTO){
        return exameService.checkExame(cpfDTO);
    }
    @CrossOrigin
    @PostMapping("/imc")
    public Double getIMC(@RequestBody MedidasDTO medidasDTO){
        return exameService.getIMC(medidasDTO);
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
}
