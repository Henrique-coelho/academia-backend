package basePackage.services;

import basePackage.entities.Pessoa;
import basePackage.models.dto.LoginDTO;

import java.util.Optional;

public interface PessoaService {
    Pessoa saveCliente(Pessoa pessoa);
    Pessoa getPessoaByCPF(String cpf);
    Optional<Pessoa> getPessoaById(String id);
    Pessoa validateLogin(LoginDTO loginDTO);
}
