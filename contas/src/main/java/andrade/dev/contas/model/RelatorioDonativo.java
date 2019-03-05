package andrade.dev.contas.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "relatorio_donativo")
public class RelatorioDonativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "red_id")
	private Integer id;
	
	@Column(name = "red_data_criacao")
	private Date dataCriacao;
	
	@Column(name = "red_observacoes")
	private String observacao;
	
	@Column(name = "red_ano")
	private Integer ano;
	
	@Column(name = "red_mes")
	private Integer mes;
	
	@OneToMany(mappedBy = "relatorioDonativo", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonBackReference
	private Set<TransacaoFinanceira> transacaoFinanceira;
	
	public RelatorioDonativo() {
	
		this.transacaoFinanceira = new HashSet<TransacaoFinanceira>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Set<TransacaoFinanceira> getTransacaoFinanceira() {
		return transacaoFinanceira;
	}

	public void setTransacaoFinanceira(Set<TransacaoFinanceira> transacaoFinanceira) {
		this.transacaoFinanceira = transacaoFinanceira;
	}
	
	public void adicionarTransacaoFinanceira(TransacaoFinanceira transacao) {
		
		if(transacao != null) {
			
			RelatorioDonativo relAtual = transacao.getRelatorioDonativo();
			
			if(!this.equals(relAtual)) {
				
				transacao.setRelatorioDonativo(this);
			}
			
			if(!this.transacaoFinanceira.contains(transacao)) {
				
				this.transacaoFinanceira.add(transacao);
			}
		}
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
		RelatorioDonativo other = (RelatorioDonativo) obj;
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
