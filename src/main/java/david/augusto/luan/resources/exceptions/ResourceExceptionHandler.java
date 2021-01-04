package david.augusto.luan.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import david.augusto.luan.services.exceptions.AuthorizationException;
import david.augusto.luan.services.exceptions.DataIntegrityViolationException;
import david.augusto.luan.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandartError> dataIntegrityViolation(DataIntegrityViolationException e,
			HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationErrorException err = new ValidationErrorException(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandartError> objectNotFound(AuthorizationException e, HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
}
