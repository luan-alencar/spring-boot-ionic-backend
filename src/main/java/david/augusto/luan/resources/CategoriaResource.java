package david.augusto.luan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import david.augusto.luan.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> list() {

		Categoria c1 = new Categoria(1L, "Higiene");
		Categoria c2 = new Categoria(2L, "Petiscos");

		List<Categoria> categorias = new ArrayList<>();
		categorias.add(c1);
		categorias.add(c2);
		
		return categorias;
	}
}
