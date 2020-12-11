package david.augusto.luan.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import david.augusto.luan.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long estado;

	public Pagamento(Long id, EstadoPagamento estado) {
		this.id = id;
		this.estado = estado.getId();
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstadoPagamento(EstadoPagamento estado) {
		this.estado = estado.getId();
	}
}
