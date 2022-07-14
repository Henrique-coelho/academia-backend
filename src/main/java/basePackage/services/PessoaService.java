package basePackage.services;

import basePackage.entities.Pessoa;
import basePackage.models.dto.LoginDTO;

import java.util.List;

public interface PessoaService {
    Pessoa saveCliente(Pessoa pessoa);
    List<Pessoa> validateLogin(LoginDTO loginDTO);
}
