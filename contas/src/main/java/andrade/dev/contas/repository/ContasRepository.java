 package andrade.dev.contas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import andrade.dev.contas.model.Conta;

@Repository
public interface ContasRepository extends CrudRepository<Conta, Integer> {

	List<Conta> findByDescricao(String descricao);
}
