package basePackage.dao;

import basePackage.entities.Exame;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ExameDAO {
    private final EntityManagerFactory emf;

    public ExameDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Exame> findExamsByCPF(String cpf){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM Exame e WHERE e.aluno.cpf = :cpf");
        query.setParameter("cpf", cpf);

        return query.getResultList();
    }
}
