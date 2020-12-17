package david.augusto.luan.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable // diz que a classe é um subtipo
public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * Classe auxiliar para representar o identificador do ItemPedido
	 */

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
}
