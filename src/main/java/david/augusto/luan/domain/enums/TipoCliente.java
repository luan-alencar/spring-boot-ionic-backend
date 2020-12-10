package david.augusto.luan.domain.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {

	PESSOAFISICA(1L, "Pessoa Física"), PESSOAJURIDICA(2L, "Pessoa Jurídica");

	private Long id;
	private String descricao;

	private TipoCliente(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	// Este método eu posso rodar mesmo sem ter o objeto instânciado
	public static TipoCliente toEnum(Long id) {
		if (id == null) {
			return null;
		}
		for (TipoCliente t : TipoCliente.values()) {
			if (id.equals(t.getId())) {
				return t;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
