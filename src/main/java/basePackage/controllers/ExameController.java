package basePackage.controllers;

import basePackage.models.dto.CpfDTO;
import basePackage.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exame")
public class ExameController {
    @Autowired
    private ExameService exameService;

    @CrossOrigin
    @GetMapping("/getAuthorizationFromCPF")
    public boolean wasExamAuthorized(CpfDTO cpfDTO){
        return exameService.checkExame(cpfDTO);
    }
}
