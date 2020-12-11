package david.augusto.luan.domain;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Date dataPagamento;

	public PagamentoBoleto(Date dataVencimento, Date dataPagamento) {
		this.dataVencimento = new Date();
		this.dataPagamento = new Date();
	}

}
