package david.augusto.luan.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import david.augusto.luan.domain.Categoria;
import david.augusto.luan.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categories,
			Pageable pageRequest);
}
