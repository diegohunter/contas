package andrade.dev.contas.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import andrade.dev.contas.model.RelatorioDonativo;
import andrade.dev.contas.services.base.PagingAndSortingService;

public interface RelatorioDonativoService extends PagingAndSortingService<RelatorioDonativo, Integer> {

	public void testarSalvamentoRelatorio();
	public Page<RelatorioDonativo> pesquisar(Integer ano, Integer mes, Pageable pageable);
}
