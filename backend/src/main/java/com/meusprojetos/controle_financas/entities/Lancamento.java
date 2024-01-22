package com.meusprojetos.controle_financas.entities;



import java.math.BigDecimal;
import java.util.Objects;

import com.meusprojetos.controle_financas.entities.enums.StatusLancamento;
import com.meusprojetos.controle_financas.entities.enums.TipoLancamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private Integer ano;
	private Integer mes;
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="tipo")
	@Enumerated(value = EnumType.STRING )
	private TipoLancamento tipoLancamento;
	
	@Column(name="status")
	@Enumerated(value = EnumType.STRING )
	private StatusLancamento statusLancamento;
	
	
	public Lancamento() {
	}


	public Lancamento(Long id, String descricao, Integer ano, Integer mes, BigDecimal valor, User user,
			TipoLancamento tipoLancamento, StatusLancamento statusLancamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.user = user;
		this.tipoLancamento = tipoLancamento;
		this.statusLancamento = statusLancamento;
	}


	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
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


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}


	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}


	public StatusLancamento getStatusLancamento() {
		return statusLancamento;
	}


	public void setStatusLancamento(StatusLancamento statusLancamento) {
		this.statusLancamento = statusLancamento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", mes=" + mes + ", valor="
				+ valor + ", user=" + user + ", tipoLancamento=" + tipoLancamento + ", statusLancamento="
				+ statusLancamento + ", getId()=" + getId() + ", getDescricao()=" + getDescricao() + ", getAno()="
				+ getAno() + ", getMes()=" + getMes() + ", getValor()=" + getValor() + ", getClient()=" + getUser()
				+ ", getTipoLancamento()=" + getTipoLancamento() + ", getStatusLancamento()=" + getStatusLancamento()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
