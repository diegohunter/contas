package andrade.dev.contas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import andrade.dev.contas.model.RelatorioDonativo;
import andrade.dev.contas.repository.queries.RelatorioDonativoQueries;

public interface RelatorioDonativoRepository extends PagingAndSortingRepository<RelatorioDonativo, Integer> {
	
	
	@Query(
			value = RelatorioDonativoQueries.QUERY_PESQUISAR,
			countProjection = "rel"
			)
	public Page<RelatorioDonativo> pesquisar(Integer ano, Integer mes, Pageable pageable);

}
