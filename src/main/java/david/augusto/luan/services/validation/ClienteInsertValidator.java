package david.augusto.luan.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import david.augusto.luan.domain.enums.TipoCliente;
import david.augusto.luan.dto.ClienteNewDTO;
import david.augusto.luan.resources.exceptions.FieldMessage;
import david.augusto.luan.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

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
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
