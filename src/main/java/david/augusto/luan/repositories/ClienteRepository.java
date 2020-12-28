package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import david.augusto.luan.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	// essa operação não necessita ser envolvida com uma transação de db
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
}
