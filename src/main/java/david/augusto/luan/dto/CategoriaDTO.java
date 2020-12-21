package david.augusto.luan.dto;

import java.io.Serializable;

import david.augusto.luan.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  Esta classe vai ser um obj para definir os dados que quero trafegar 
 *  qnd fizer operações básicas de Categoria
 */

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}
}
