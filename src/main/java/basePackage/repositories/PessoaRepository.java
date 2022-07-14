package basePackage.repositories;

import basePackage.entities.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends CrudRepository<Pessoa,Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.email=:email and p.senha=:senha")
    Pessoa findAllUserByCredentials(@Param("email") String email, @Param("senha") String senha);
}
