package basePackage.repositories;

import basePackage.entities.Treino;
import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository extends CrudRepository<Treino,Long> {
}
