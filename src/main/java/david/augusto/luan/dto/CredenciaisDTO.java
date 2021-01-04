package david.augusto.luan.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
}
