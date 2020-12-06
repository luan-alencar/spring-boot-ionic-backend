package david.augusto.luan.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "REST rodando!";
	}
}
