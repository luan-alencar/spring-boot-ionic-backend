package david.augusto.luan;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import david.augusto.luan.domain.Categoria;
import david.augusto.luan.domain.Cidade;
import david.augusto.luan.domain.Estado;
import david.augusto.luan.domain.Produto;
import david.augusto.luan.repositories.CategoriaRepository;
import david.augusto.luan.repositories.CidadeRepository;
import david.augusto.luan.repositories.EstadoRepository;
import david.augusto.luan.repositories.ProdutoRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// categorias
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");

		// produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		// adicionando produtos a categora 1
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		// adicionando produtos a categora 2
		c2.getProdutos().addAll(Arrays.asList(p2));

		// adicionando a categoria aos produtos
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));

		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Pernambuco");
		Cidade cid1 = new Cidade(null, "Campina Grande", est1);
		Cidade cid2 = new Cidade(null, "Joao Pessoa", est1);
		Cidade cid3 = new Cidade(null, "Recife", est2);

		// adicionando as cidades aos seus respectivos estados
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));

		// salvando na camada de acesso a dados
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
	}
}
