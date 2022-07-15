package basePackage.controllers;

import basePackage.entities.Modalidade;
import basePackage.entities.Plano;
import basePackage.services.ModalidadeService;
import basePackage.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {
    @Autowired
    private PlanoService planoService;

    @Autowired
    private ModalidadeService modalidadeService;

    @CrossOrigin
    @GetMapping("/getFromModalidade/{id}")
    public Iterable<Plano> getAllPlanos(@PathVariable("id") String id){
        Modalidade modalidade = modalidadeService.getModalidade(id);
        return planoService.getAllPlanos(modalidade);
    }
}
