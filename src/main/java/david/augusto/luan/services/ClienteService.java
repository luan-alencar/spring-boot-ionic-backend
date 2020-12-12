package david.augusto.luan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
