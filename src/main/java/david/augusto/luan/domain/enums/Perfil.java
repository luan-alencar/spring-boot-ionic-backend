package david.augusto.luan.domain.enums;

import lombok.Getter;

@Getter
public enum Perfil {

	ADMIN(1L, "ROLE_ADMIN"), CLIENTE(2L, "ROLE_CLIENTE");

	private Long id;
	private String descricao;

	private Perfil(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	// Este método eu posso rodar mesmo sem ter o objeto instânciado
	public static Perfil toEnum(Long id) {
		if (id == null) {
			return null;
		}

		for (Perfil e : Perfil.values()) {
			if (id.equals(e.getId())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
