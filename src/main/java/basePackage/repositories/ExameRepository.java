package basePackage.repositories;

import basePackage.entities.Exame;
import org.springframework.data.repository.CrudRepository;

public interface ExameRepository extends CrudRepository<Exame, Long> {
}
