package basePackage.controllers;

import basePackage.entities.Modalidade;
import basePackage.entities.Plano;
import basePackage.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {
    @Autowired
    private PlanoService planoService;

    @CrossOrigin
    @PostMapping("/getFromModalidade")
    public Iterable<Plano> getAllPlanos(@RequestBody Modalidade modalidade){
        return planoService.getAllPlanos(modalidade);
    }
}
