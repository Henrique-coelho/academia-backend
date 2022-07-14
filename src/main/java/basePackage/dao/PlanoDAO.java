package basePackage.dao;

import basePackage.entities.Modalidade;
import basePackage.entities.Pessoa;
import basePackage.entities.Plano;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PlanoDAO {
    private final EntityManagerFactory emf;

    public PlanoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Plano> findAllPlans(String modalidade){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Plano p, Modalidade m WHERE p.modalidade==m and m.nome==:modalidade");
        query.setParameter("modalidade", modalidade);

        return query.getResultList();
    }
}
