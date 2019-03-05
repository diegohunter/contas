package andrade.dev.contas.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import andrade.dev.contas.model.Conta;
import andrade.dev.contas.model.RelatorioDonativo;
import andrade.dev.contas.model.TransacaoFinanceira;
import andrade.dev.contas.repository.RelatorioDonativoRepository;
import andrade.dev.contas.services.base.AbsPagingAndSortingService;
import andrade.dev.contas.services.interfaces.ContasService;
import andrade.dev.contas.services.interfaces.RelatorioDonativoService;


@Service
public class RelatorioDonativoServiceImpl extends AbsPagingAndSortingService<RelatorioDonativo, Integer> implements RelatorioDonativoService {

	@Autowired
	private ContasService contaService;
	private RelatorioDonativoRepository relFinanRepo;
	
	public RelatorioDonativoServiceImpl(RelatorioDonativoRepository relFinanRepo) {
		
		super();
		this.relFinanRepo = relFinanRepo;
		super.setRepository(relFinanRepo);
	}
	
	@Override
	@Transactional
	public void testarSalvamentoRelatorio() {
		
		
		Optional<Conta> conta1 = this.contaService.findById(1);
		Optional<Conta> conta2 = this.contaService.findById(2);
		Optional<Conta> conta3 = this.contaService.findById(3);
		
		RelatorioDonativo relatorio1 = new RelatorioDonativo();
		relatorio1.setAno(2019);
		relatorio1.setDataCriacao(new Date());
		relatorio1.setMes(3);
		relatorio1.setObservacao("Testando Observação");
		
		// Transacao Financeira 1
		TransacaoFinanceira txFinanceira = new TransacaoFinanceira();
		txFinanceira.setData(new Date());
		txFinanceira.setDescricao("Donativos para Caixa de Donativos");
		txFinanceira.setEntrada(true);
		txFinanceira.setOrdem(1);
		txFinanceira.setOrdemTransacao(1);
		txFinanceira.setValor(new BigDecimal(300.66));
		
		conta1.ifPresent((conta) -> {
			
			txFinanceira.setConta(conta);
		});
		

		// Transacao Financeira 2
		TransacaoFinanceira txFinanceira2 = new TransacaoFinanceira();
		txFinanceira2.setData(new Date());
		txFinanceira2.setDescricao("Donativos para Obra Mundial");
		txFinanceira2.setEntrada(true);
		txFinanceira2.setOrdem(2);
		txFinanceira2.setOrdemTransacao(2);
		txFinanceira2.setValor(new BigDecimal(155.32));
		
		conta1.ifPresent((conta) -> {
			
			txFinanceira2.setConta(conta);
		});
		

		// Transacao Financeira 3
		TransacaoFinanceira txFinanceira3 = new TransacaoFinanceira();
		txFinanceira3.setData(new Date());
		txFinanceira3.setDescricao("Arranjo de Ônibus");
		txFinanceira3.setEntrada(true);
		txFinanceira3.setOrdem(1);
		txFinanceira3.setOrdemTransacao(1);
		txFinanceira3.setValor(new BigDecimal(550.04));
		
		conta1.ifPresent((conta) -> {
			
			txFinanceira3.setConta(conta);
		});
		
		relatorio1.adicionarTransacaoFinanceira(txFinanceira);
		relatorio1.adicionarTransacaoFinanceira(txFinanceira2);
		relatorio1.adicionarTransacaoFinanceira(txFinanceira3);
		
		this.save(relatorio1);
	}

	@Override
	public Page<RelatorioDonativo> pesquisar(Integer ano, Integer mes, Pageable pageable) {
		
		return this.relFinanRepo.pesquisar(ano, mes, pageable);
	}

}
