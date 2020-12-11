package david.augusto.luan.domain.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

	PENDENTE(1L, "Pedido Pendente"), QUITADO(2L, "Pedido Quitado"), CANCELADO(3L, "Pedido Cancelado");

	private Long id;
	private String descricao;

	private EstadoPagamento(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	// Este método eu posso rodar mesmo sem ter o objeto instânciado
	public static EstadoPagamento toEnum(Long id) {
		if (id == null) {
			return null;
		}
		for (EstadoPagamento e : EstadoPagamento.values()) {
			if (id.equals(e.getId())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
