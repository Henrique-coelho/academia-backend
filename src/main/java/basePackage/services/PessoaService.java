package basePackage.services;

import basePackage.entities.Pessoa;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.LoginDTO;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    Pessoa saveCliente(Pessoa pessoa);
    Pessoa getPessoaByCPF(CpfDTO cpfDTO);
    Optional<Pessoa> getPessoa(String id);
    List<Pessoa> validateLogin(LoginDTO loginDTO);
}
