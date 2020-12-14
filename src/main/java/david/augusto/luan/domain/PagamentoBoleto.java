package david.augusto.luan.domain;

import java.util.Date;

import javax.persistence.Entity;

import david.augusto.luan.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PagamentoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataPagamento;
	private Date dataVencimento;

	public PagamentoBoleto(Long id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

}
