package andrade.dev.contas.model;

import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_id")
	private Integer id;
	
	@Column(name = "con_descricao")
	private String descricao;
	
	@Column(name = "con_valor")
	private BigDecimal valor;

	@JsonIgnore
	@OneToMany(mappedBy = "conta", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonBackReference
	private Set<TransacaoFinanceira> transacoesFinanceiras;
	
	public Conta() {
		
		this.transacoesFinanceiras = new HashSet<TransacaoFinanceira>();
	}
	
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

	public Set<TransacaoFinanceira> getTransacoesFinanceiras() {
		return transacoesFinanceiras;
	}

	public void setTransacoesFinanceiras(Set<TransacaoFinanceira> transacoesFinanceiras) {
		this.transacoesFinanceiras = transacoesFinanceiras;
	}
	
	
	
	
}
