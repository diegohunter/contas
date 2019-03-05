package andrade.dev.contas.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import andrade.dev.contas.model.Conta;
import andrade.dev.contas.repository.ContasRepository;
import andrade.dev.contas.services.base.AbsCrudService;
import andrade.dev.contas.services.interfaces.ContasService;

@Service
public class ContasServiceImpl extends AbsCrudService<Conta, Integer> implements ContasService {

	private ContasRepository contaRepository;

	public ContasRepository getContaRepository() {
		return contaRepository;
	}

	public void setContaRepository(ContasRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	
	public ContasServiceImpl(ContasRepository contaRepository) {
		super();
		this.setContaRepository(contaRepository);
		super.setRepository(contaRepository);
	}

	@Override
	public List<Conta> findByDescricao(String descricao) {
		
		if(this.getContaRepository() != null) {
			
			return this.getContaRepository().findByDescricao(descricao);
		}
		
		return null;
	}
	
	
}
