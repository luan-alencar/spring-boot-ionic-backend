package david.augusto.luan.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 80, message = "O tamanho deve conter entre 5 a 80 caracteres!")
	private String nome;

	public CategoriaDTO(Categoria category) {
		id = category.getId();
		nome = category.getNome();
	}
}
