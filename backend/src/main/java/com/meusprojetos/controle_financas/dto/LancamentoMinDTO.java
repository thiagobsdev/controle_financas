package com.meusprojetos.controle_financas.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Lancamento;
import com.meusprojetos.controle_financas.entities.enums.StatusLancamento;
import com.meusprojetos.controle_financas.entities.enums.TipoLancamento;
import com.meusprojetos.controle_financas.projections.LancamentoDetailsProjection;

public class LancamentoMinDTO {

	private Long id;
	private String descricao;
	private Integer ano;
	private Integer mes;
	private BigDecimal valor;
	private TipoLancamento tipoLancamento;
	private StatusLancamento statusLancamento;
	private List<CategoriaDTO> categorias = new ArrayList<>();
	
	
	public LancamentoMinDTO() {
	}


	public LancamentoMinDTO(Long id, String descricao, Integer ano, Integer mes, BigDecimal valor
			,TipoLancamento tipoLancamento, StatusLancamento statusLancamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.tipoLancamento = tipoLancamento;
		this.statusLancamento = statusLancamento;
	}
	
	public LancamentoMinDTO(Long id, String descricao, Integer ano, Integer mes, BigDecimal valor
			,TipoLancamento tipoLancamento, StatusLancamento statusLancamento, List<CategoriaDTO> categorias) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.tipoLancamento = tipoLancamento;
		this.statusLancamento = statusLancamento;
		this.categorias = categorias;
	}
	
	public LancamentoMinDTO(Lancamento entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		ano = entity.getAno();
		mes = entity.getMes();
		valor = entity.getValor();
		tipoLancamento = entity.getTipoLancamento();
		statusLancamento = entity.getStatusLancamento();
		entity.getCategorias().forEach(x -> categorias.add(new CategoriaDTO(x)));
		
	}


	public LancamentoMinDTO(LancamentoDetailsProjection projection) {
		id = projection.getId();
		descricao = projection.getDescricao();
		ano = projection.getAno();
		mes = projection.getMes();
		valor = projection.getValor();
		tipoLancamento = projection.getTipoLancamento();
		statusLancamento = projection.getStatusLancamento();
		projection.getCategoriaDTO().forEach(x -> categorias.add(new CategoriaDTO(x)));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	
	

	public List<CategoriaDTO> getCategoriasDTO() {
		return categorias;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ano, categorias, descricao, id, mes, statusLancamento, tipoLancamento, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoMinDTO other = (LancamentoMinDTO) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(categorias, other.categorias)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(mes, other.mes) && statusLancamento == other.statusLancamento
				&& tipoLancamento == other.tipoLancamento && Objects.equals(valor, other.valor);
	}


	@Override
	public String toString() {
		return "LancamentoMinDTO [id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", mes=" + mes + ", valor="
				+ valor + ", tipoLancamento=" + tipoLancamento + ", statusLancamento=" + statusLancamento
				+ ", categorias=" + categorias + "]";
	}


	






	
	
	
	
	

}
