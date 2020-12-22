package david.augusto.luan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.dto.ClienteDTO;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente find(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cliente update(Cliente obj) {
		find(obj.getId());
		return repository.save(obj);
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

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
}
