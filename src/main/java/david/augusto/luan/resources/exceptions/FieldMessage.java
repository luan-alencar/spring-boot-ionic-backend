package david.augusto.luan.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;
	
}
