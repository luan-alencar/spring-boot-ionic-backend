package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import david.augusto.luan.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
