package david.augusto.luan.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.domain.enums.TipoCliente;
import david.augusto.luan.dto.ClienteNewDTO;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.resources.exceptions.FieldMessage;
import david.augusto.luan.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repository;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		// inclua os testes aqui, inserindo erros na lista
		List<FieldMessage> list = new ArrayList<>();

		// Pessoas Físicas
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getId()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido!"));
		}

		// Pessoas Jurídicas
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getId()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido!"));
		}

		// Email
		Cliente aux = repository.findByEmail(objDto.getEmail());
		
		// se o aux for diferente de nulo ele encontrou um regidtro no db que tinha esse
		// email do objDto, ou seja, ele já existe
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existe!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
