package david.augusto.luan.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.dto.ClienteDTO;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.resources.exceptions.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ClienteRepository repository;

	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@SuppressWarnings("unused")
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		// qnd eu faço uma requisição ela haverá varios atributos e esses atributos são
		// localizados em um Map

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		// Email
		Cliente aux = repository.findByEmail(objDto.getEmail());

		// Se isso acontecer significa que tentei atualizar o CLiente contendo o email
		// que já tinha um outro CLiente do db
		if (aux != null && aux.getId().equals(uriId)) {
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
