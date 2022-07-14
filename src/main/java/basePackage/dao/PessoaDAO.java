package basePackage.dao;

import basePackage.entities.Pessoa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Repository
public class PessoaDAO {

    private final EntityManagerFactory emf;

    public PessoaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Pessoa> findAllUserByCredentials(String email, String senha){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM Pessoa c WHERE c.email=:email and c.senha=:senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        return query.getResultList();
    }

}

