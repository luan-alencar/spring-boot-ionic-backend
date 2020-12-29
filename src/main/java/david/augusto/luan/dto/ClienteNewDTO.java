package david.augusto.luan.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import david.augusto.luan.services.validation.ClienteInsert;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ClienteInsert
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// @NotEmpty só se aplica em String's

	@NotEmpty(message = "Preechimento obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preechimento obrigatório!")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preechimento obrigatório!")
	private String cpfOuCnpj;
	private Long tipo;

	@NotEmpty(message = "Preechimento obrigatório!")
	private String logradouro;

	@NotEmpty(message = "Preechimento obrigatório!")
	private String numero;

	private String complemento;

	private String bairro;

	@NotEmpty(message = "Preechimento obrigatório!")
	private String cep;

	@NotEmpty(message = "Preechimento obrigatório!")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Long cidadeId;
}
