package david.augusto.luan.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * Como é uma classe de associação ela não terá um id própio quem identifica ela
	 * são os dois obj associados a ela: - pedidos - itens
	 */

	// id com atributo composto
	@JsonIgnore // isso não vai ser sereliarizado
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public double getSubTotal() {
		return (preco - desconto) * quantidade;
	}

	// Esses getter's servem para ter acesso direto ao pedido e produto fora da
	// minha classe ItemPedido
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setPedido(Pedido p) {
		id.setPedido(p);
	}

	public void setProduto(Produto p) {
		id.setProduto(p);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(getProduto().getNome());
		build.append(", Qte: ");
		build.append(getQuantidade());
		build.append(", Preço unitário: ");
		build.append(getPreco());
		build.append(", Subtotal: ");
		build.append(getSubTotal());
		build.append("\n");
		return build.toString();
	}
}
