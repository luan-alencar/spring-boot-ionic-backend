package david.augusto.luan.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationErrorException extends StandartError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> list = new ArrayList<>();

	public ValidationErrorException(Integer value, String message, Long currentTimeMillis) {
		super(value, message, currentTimeMillis);
	}

	public List<FieldMessage> getErros() {
		return list;
	}
	
	public void addError(String fieldName, String msg) {
		list.add(new FieldMessage(fieldName, msg));
	}
}
