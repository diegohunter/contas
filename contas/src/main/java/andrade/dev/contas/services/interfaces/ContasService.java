package andrade.dev.contas.services.interfaces;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import andrade.dev.contas.model.Conta;
import andrade.dev.contas.services.base.CrudService;

@NoRepositoryBean
public interface ContasService extends CrudService<Conta, Integer> {

	List<Conta> findByDescricao(String descricao);
}
