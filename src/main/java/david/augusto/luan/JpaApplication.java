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

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
