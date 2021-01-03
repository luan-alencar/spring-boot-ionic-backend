package david.augusto.luan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import david.augusto.luan.domain.enums.Perfil;
import david.augusto.luan.domain.enums.TipoCliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Long> perfis = new HashSet<Long>();

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) // se eu apagar um Cliente todos seus Endereços tb serão
	private List<Endereco> enderecos;

	@ElementCollection
	@CollectionTable(name = "TELEFONES")
	private Set<String> telefones;

	public Cliente(Long id, String nome, String email, String cpfOuCnpf, TipoCliente tipo, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpf;
		this.tipo = (tipo == null) ? null : tipo.getId();
		this.senha = senha;
		this.pedidos = new ArrayList<Pedido>();
		this.enderecos = new ArrayList<Endereco>();
		this.telefones = new HashSet<String>();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getId();
	}

	// retorna os perfis do Cliente
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(n -> Perfil.toEnum(id)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getId());
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
