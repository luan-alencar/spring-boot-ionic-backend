package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import david.augusto.luan.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
