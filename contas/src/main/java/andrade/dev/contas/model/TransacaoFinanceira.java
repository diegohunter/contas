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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "transacao_financeira")
public class TransacaoFinanceira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trf_id")
	private Integer id;
	
	@Column(name = "trf_descricao")	
	private String descricao;
	
	@Column(name = "trf_valor")
	private BigDecimal valor;
	
	@Column(name = "trf_data")
	private Date data;
	
	@Column(name = "trf_codigo_referencia")
	private String codigoReferencia;
	
	@Column(name = "trf_ordem_transacao")
	private Integer ordemTransacao;
	
	@Column(name = "red_ordem")
	private Integer ordem;
	
	@Column(name = "trf_entrada")
	private Boolean entrada;
	
	@Column(name = "trf_transferencia")
	private Boolean transferencia;
	
	@ManyToOne
	@JoinColumn(name = "red_id")
	@JsonManagedReference
	private RelatorioDonativo relatorioDonativo;
	
	@ManyToOne
	@JoinColumn(name = "con_id")
	@JsonManagedReference
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public Integer getOrdemTransacao() {
		return ordemTransacao;
	}

	public void setOrdemTransacao(Integer ordemTransacao) {
		this.ordemTransacao = ordemTransacao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Boolean getEntrada() {
		return entrada;
	}

	public void setEntrada(Boolean entrada) {
		this.entrada = entrada;
	}

	public Boolean getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Boolean transferencia) {
		this.transferencia = transferencia;
	}

	public RelatorioDonativo getRelatorioDonativo() {
		return relatorioDonativo;
	}

	public void setRelatorioDonativo(RelatorioDonativo relatorioDonativo) {
		this.relatorioDonativo = relatorioDonativo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

	@Override
	public int hashCode() {
  		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoFinanceira other = (TransacaoFinanceira) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if(id == null && other.id == null)
			return false;
		return true;
	}

}
