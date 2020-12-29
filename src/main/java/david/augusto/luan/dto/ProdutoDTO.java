package david.augusto.luan.dto;

import java.io.Serializable;

import david.augusto.luan.domain.Produto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Double preco;

	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
	}
}
