package basePackage.controllers;

import basePackage.entities.Pessoa;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.LoginDTO;
import basePackage.models.enums.VinculoEnum;
import basePackage.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @CrossOrigin
    @PostMapping("/createOrUpdate")
    public ResponseEntity<String> createUpdate(@RequestBody Pessoa pessoa){
        var returnValue = pessoaService.saveCliente(pessoa);
        if (returnValue != null) {
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
    @CrossOrigin
    @GetMapping("/userByCPF")
    public Pessoa getUserByCPF(@RequestBody CpfDTO cpfDTO) {
        return pessoaService.getPessoaByCPF(cpfDTO);
    }

    @CrossOrigin
    @GetMapping("/userById")
    public Pessoa getUser(@PathVariable String id) {
        Optional<Pessoa> pessoa = pessoaService.getPessoa(id);
        if(pessoa.isPresent()){
            return pessoa.get();
        }
        return null;
    }

    @CrossOrigin
    @GetMapping("/getAuthorization")
    public boolean isAuthorized(@PathVariable String id){
        Optional<Pessoa> pessoa = pessoaService.getPessoa(id);
        if(pessoa.isPresent()){
            VinculoEnum vinculo = pessoa.get().getVinculo();
            if(vinculo == VinculoEnum.MEDICO || vinculo == VinculoEnum.PROFESSOR || vinculo == VinculoEnum.SECRETARIO){
                return true;
            }
        }
        return false;
    }
}
