package david.augusto.luan.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import david.augusto.luan.domain.PagamentoBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoBoleto pagto, Date instanceDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanceDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
