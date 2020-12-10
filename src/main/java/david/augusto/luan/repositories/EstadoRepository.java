package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import david.augusto.luan.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
