package david.augusto.luan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import david.augusto.luan.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
