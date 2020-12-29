package david.augusto.luan.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.services.validation.ClienteUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Preechimento obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preechimento obrigatório!")
	@Email(message = "Email inválido")
	private String email;

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
}
