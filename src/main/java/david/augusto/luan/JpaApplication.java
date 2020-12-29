package david.augusto.luan;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import david.augusto.luan.domain.Categoria;
import david.augusto.luan.domain.Cidade;
import david.augusto.luan.domain.Cliente;
import david.augusto.luan.domain.Endereco;
import david.augusto.luan.domain.Estado;
import david.augusto.luan.domain.ItemPedido;
import david.augusto.luan.domain.Pagamento;
import david.augusto.luan.domain.PagamentoBoleto;
import david.augusto.luan.domain.PagamentoComCartao;
import david.augusto.luan.domain.Pedido;
import david.augusto.luan.domain.Produto;
import david.augusto.luan.domain.enums.EstadoPagamento;
import david.augusto.luan.domain.enums.TipoCliente;
import david.augusto.luan.repositories.CategoriaRepository;
import david.augusto.luan.repositories.CidadeRepository;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.repositories.EnderecoRepository;
import david.augusto.luan.repositories.EstadoRepository;
import david.augusto.luan.repositories.ItemPedidoRepository;
import david.augusto.luan.repositories.PagamentoRepository;
import david.augusto.luan.repositories.PedidoRepository;
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

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// categorias
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Eletrônico");
		Categoria c4 = new Categoria(null, "Jardinagem");
		Categoria c5 = new Categoria(null, "Decoração");
		Categoria c6 = new Categoria(null, "Cama, mesa e banho");
		Categoria c7 = new Categoria(null, "Perfumaria");

		// produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV True Color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Shampoo", 90.00);
		Produto p11 = new Produto(null, "Pendente", 180.00);

		// adicionando produtos as categorias
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2, p4));
		c3.getProdutos().addAll(Arrays.asList(p7, p3, p1, p2));
		c4.getProdutos().addAll(Arrays.asList(p8));
		c5.getProdutos().addAll(Arrays.asList(p11, p9));
		c6.getProdutos().addAll(Arrays.asList(p5, p6));
		c7.getProdutos().addAll(Arrays.asList(p10));

		// adicionando a categoria aos produtos
		p1.getCategorias().addAll(Arrays.asList(c1,c3));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c6));
		p6.getCategorias().addAll(Arrays.asList(c6));
		p7.getCategorias().addAll(Arrays.asList(c3));
		p8.getCategorias().addAll(Arrays.asList(c4));
		p9.getCategorias().addAll(Arrays.asList(c5));
		p10.getCategorias().addAll(Arrays.asList(c7));
		p11.getCategorias().addAll(Arrays.asList(c5));

		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Pernambuco");
		Cidade cid1 = new Cidade(null, "Campina Grande", est1);
		Cidade cid2 = new Cidade(null, "Joao Pessoa", est1);
		Cidade cid3 = new Cidade(null, "Recife", est2);

		// adicionando as cidades aos seus respectivos estados
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));

		// salvando na camada de acesso a dados
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		// Instanciando objetos
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "4321234234", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("1241-2344", "1231-1234"));

		Endereco e1 = new Endereco(null, "Rua Floriano Peixoto", "300", "Apto. 203", "Centro", "24-234-234", cli1,
				cid1);

		Endereco e2 = new Endereco(null, "Rua José do Precipício", "400", "Casa", "Ramadinha", "21-456-098", cli1,
				cid2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		// Salvando os objetos no DB
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, smf.parse("30/09/2020 05:30"), cli1, e1);
		Pedido ped2 = new Pedido(null, smf.parse("10/10/2020 16:20"), cli1, e2);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);

		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, smf.parse("30/12/2020 00:00"), null);
		ped2.setPagamento(pag2);

		// associando os pedidos ao cliente
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

		// ItemPedido
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 0.0, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
