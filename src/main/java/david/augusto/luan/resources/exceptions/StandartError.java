package david.augusto.luan.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String ms;
	private Long timeStamp;
}
