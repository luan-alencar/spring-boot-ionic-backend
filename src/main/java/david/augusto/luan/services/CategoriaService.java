package david.augusto.luan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import david.augusto.luan.domain.Categoria;
import david.augusto.luan.repositories.CategoriaRepository;
import david.augusto.luan.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
