package david.augusto.luan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import david.augusto.luan.domain.Cidade;
import david.augusto.luan.domain.Cliente;
import david.augusto.luan.domain.Endereco;
import david.augusto.luan.domain.enums.TipoCliente;
import david.augusto.luan.dto.ClienteNewDTO;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.repositories.EnderecoRepository;
import david.augusto.luan.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Cliente find(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	@Transactional // garante que tanto o cliente quanto os endereços estejam na mesma transação
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		// apos atualizar salva o novo obj
		return repository.save(newObj);
	}

	// vai no db e seta o nome e email ao novo obj
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getNome());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possua produtos!");
		}
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	/*
	 * @params : direction(este parametro se refere a diração de ordenação que pode
	 * ser ASC ou DESC
	 */
	public Page<Cliente> findPage(Integer page, Integer linesPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		// Cliente
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpf(),
				TipoCliente.toEnum(objDto.getTipo()));

		// Cidade
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);

		// Endereco
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);

		cli.getEnderecos().add(end);
		cli.getTelefone().add(objDto.getTelefone1());

		// como estes telefones não sao obrigatórios, caso não seja nulo adicione-os
		if (objDto.getTelefone2() != null) {
			cli.getTelefone().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefone().add(objDto.getTelefone3());
		}
		return cli;
	}
}
