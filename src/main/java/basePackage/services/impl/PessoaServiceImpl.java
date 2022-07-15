package basePackage.services.impl;

import basePackage.dao.PessoaDAO;
import basePackage.models.dto.CpfDTO;
import basePackage.models.dto.LoginDTO;
import basePackage.repositories.PessoaRepository;
import basePackage.services.PessoaService;
import basePackage.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaDAO pessoaDAO;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa saveCliente(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa getPessoaByCPF(String cpf) {
        List<Pessoa> queryResult = pessoaDAO.findUserByCPF(cpf);
        if(!queryResult.isEmpty()){
            return queryResult.get(0);
        }
        return null;
    }

    @Override
    public Optional<Pessoa> getPessoaById(String id){
        return pessoaRepository.findById(Long.parseLong(id));
    }

    @Override
    public Pessoa validateLogin(LoginDTO loginDTO){
        return pessoaRepository.findAllUserByCredentials(loginDTO.getEmail(), loginDTO.getSenha());
    }
}
