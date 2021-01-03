package david.augusto.luan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import david.augusto.luan.domain.enums.TipoCliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	// o db garante que não haverá repetição nesse campo
	@Column(unique = true)
	private String email;
	private String cpfOuCnpj;
	private Long tipo;
	@JsonIgnore
	private String senha;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) // se eu apagar um Cliente todos seus Endereços tb serão
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@ElementCollection
	@CollectionTable(name = "TELEFONES")
	private Set<String> telefone = new HashSet<String>();

	public Cliente(Long id, String nome, String email, String cpfOuCnpf, TipoCliente tipo, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpf;
		this.tipo = (tipo == null) ? null : tipo.getId();
		this.senha = senha;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
