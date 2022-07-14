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

    public Pessoa findAllUserByCredentials(String email, String senha){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.email=:email and p.senha=:senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        return (Pessoa) query.getSingleResult();
    }

    public List<Pessoa> findUserByCPF(String cpf){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.cpf=:cpf");
        query.setParameter("cpf", cpf);

        return query.getResultList();
    }
}

