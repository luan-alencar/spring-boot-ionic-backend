package david.augusto.luan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import david.augusto.luan.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
