package basePackage.controllers;

import basePackage.entities.Treino;
import basePackage.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/treino")
public class TreinoController {
    @Autowired
    private TreinoService treinoService;

    @CrossOrigin
    @PostMapping("/createOrUpdate")
    public ResponseEntity<String> createUpdate(@RequestBody Treino treino){
        var returnValue = treinoService.saveTreino(treino);
        if(returnValue != null){
            return ResponseEntity.ok("Treino criado com sucesso");
        }
        return new ResponseEntity<>("Erro ao cadastrar treino", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteTreino(@PathVariable("id") String id){
        var deletionSuccessful = treinoService.deleteTreino(id);
        if(deletionSuccessful){
            return ResponseEntity.ok("Treino removido");
        }
        return new ResponseEntity<>("Treino Inexistente no Sistema",HttpStatus.BAD_REQUEST);

    }
}
