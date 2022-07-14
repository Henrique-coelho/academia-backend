package basePackage.controllers;

import basePackage.entities.Pessoa;
import basePackage.models.dto.LoginDTO;
import basePackage.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> createUpdate(@RequestBody Pessoa pessoa){
        var retorno = pessoaService.saveCliente(pessoa);
        if (retorno != null) {
            return ResponseEntity.ok("Usuário criado com sucesso!");
        } else {
            return new ResponseEntity<>("Erro ao criar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public List<Pessoa> getCredentials(@RequestBody LoginDTO loginDTO) {
        return pessoaService.validateLogin(loginDTO);
    }
}
