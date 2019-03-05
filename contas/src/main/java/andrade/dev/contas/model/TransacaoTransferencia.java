package andrade.dev.contas.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transacao_transferencia")
public class TransacaoTransferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trt_id")
	private Integer id;
	
	@Column(name = "trt_data")
	private Date data;
	
	@Column(name = "trt_valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "trf_id_origem")
	private TransacaoFinanceira transacaoFinanceiraOrigem;
	

	@ManyToOne
	@JoinColumn(name = "trf_id_destino")
	private TransacaoFinanceira transacaoFinanceiraDestino;
	
	@ManyToOne
	@JoinColumn(name = "con_id_origem")
	private Conta contaOrigem;
	
	@ManyToOne
	@JoinColumn(name = "con_id_destino")
	private Conta contaDestino;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TransacaoFinanceira getTransacaoFinanceiraOrigem() {
		return transacaoFinanceiraOrigem;
	}

	public void setTransacaoFinanceiraOrigem(TransacaoFinanceira transacaoFinanceiraOrigem) {
		this.transacaoFinanceiraOrigem = transacaoFinanceiraOrigem;
	}

	public TransacaoFinanceira getTransacaoFinanceiraDestino() {
		return transacaoFinanceiraDestino;
	}

	public void setTransacaoFinanceiraDestino(TransacaoFinanceira transacaoFinanceiraDestino) {
		this.transacaoFinanceiraDestino = transacaoFinanceiraDestino;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	
	

}
