package basePackage.repositories;

import basePackage.entities.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Long> {
}
