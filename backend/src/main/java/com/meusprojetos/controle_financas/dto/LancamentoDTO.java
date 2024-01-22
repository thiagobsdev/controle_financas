package com.meusprojetos.controle_financas.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Lancamento;
import com.meusprojetos.controle_financas.entities.enums.StatusLancamento;
import com.meusprojetos.controle_financas.entities.enums.TipoLancamento;

public class LancamentoDTO {

	private Long id;
	private String descricao;
	private Integer ano;
	private Integer mes;
	private BigDecimal valor;
	private UserDTO userDTO;
	private TipoLancamento tipoLancamento;
	private StatusLancamento statusLancamento;
	
	
	public LancamentoDTO() {
	}


	public LancamentoDTO(Long id, String descricao, Integer ano, Integer mes, BigDecimal valor, UserDTO userDTO,
			TipoLancamento tipoLancamento, StatusLancamento statusLancamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.userDTO = userDTO;
		this.tipoLancamento = tipoLancamento;
		this.statusLancamento = statusLancamento;
	}
	
	public LancamentoDTO(Lancamento entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		ano = entity.getAno();
		mes = entity.getMes();
		valor = entity.getValor();
		userDTO = new UserDTO(entity.getUser());
		tipoLancamento = entity.getTipoLancamento();
		statusLancamento = entity.getStatusLancamento();
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


	public UserDTO getUser() {
		return userDTO;
	}


	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
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
		return Objects.hash(ano, descricao, id, mes, statusLancamento, tipoLancamento, userDTO, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoDTO other = (LancamentoDTO) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(mes, other.mes)
				&& statusLancamento == other.statusLancamento && tipoLancamento == other.tipoLancamento
				&& Objects.equals(userDTO, other.userDTO) && Objects.equals(valor, other.valor);
	}


	@Override
	public String toString() {
		return "LancamentoDTO [id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", mes=" + mes + ", valor="
				+ valor + ", user=" + userDTO + ", tipoLancamento=" + tipoLancamento + ", statusLancamento="
				+ statusLancamento + "]";
	}
	
	
	
	

}
