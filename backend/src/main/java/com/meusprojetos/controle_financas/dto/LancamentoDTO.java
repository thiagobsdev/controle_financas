package com.meusprojetos.controle_financas.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meusprojetos.controle_financas.entities.Categoria;
import com.meusprojetos.controle_financas.entities.Lancamento;
import com.meusprojetos.controle_financas.entities.enums.StatusLancamento;
import com.meusprojetos.controle_financas.entities.enums.TipoLancamento;
import com.meusprojetos.controle_financas.projections.LancamentoDetailsProjection;

public class LancamentoDTO {

	private Long id;
	private String descricao;
	private Integer ano;
	private Integer mes;
	private BigDecimal valor;
	private UserMinDTO userMinDTO = new UserMinDTO();
	private TipoLancamento tipoLancamento;
	private StatusLancamento statusLancamento;
	@JsonProperty(value = "categorias")
	private List<CategoriaDTO> categoriaDTO = new ArrayList<>();
	
	
	public LancamentoDTO() {
	}


	public LancamentoDTO(Long id, String descricao, Integer ano, Integer mes, BigDecimal valor, UserMinDTO userMinDTO,
			TipoLancamento tipoLancamento, StatusLancamento statusLancamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.userMinDTO = userMinDTO;
		this.tipoLancamento = tipoLancamento;
		this.statusLancamento = statusLancamento;
	}
	
	public LancamentoDTO(Lancamento entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		ano = entity.getAno();
		mes = entity.getMes();
		valor = entity.getValor();
		userMinDTO = new UserMinDTO(entity.getUser());
		tipoLancamento = entity.getTipoLancamento();
		statusLancamento = entity.getStatusLancamento();
		
		for(Categoria categoria: entity.getCategorias() ) {
			CategoriaDTO entityCategoriaDTO = new CategoriaDTO(categoria);
			categoriaDTO.add(entityCategoriaDTO);
		}
		
		
	}


	public LancamentoDTO(LancamentoDetailsProjection projection) {
		id = projection.getId();
		descricao = projection.getDescricao();
		ano = projection.getAno();
		mes = projection.getMes();
		valor = projection.getValor();
		userMinDTO = new UserMinDTO(projection.getUser());
		tipoLancamento = projection.getTipoLancamento();
		statusLancamento = projection.getStatusLancamento();
		for(CategoriaDTO projectCategoriaDTO : projection.getCategoriaDTO() ) {
			CategoriaDTO entityCategoriaDTO = new CategoriaDTO(projectCategoriaDTO);
			categoriaDTO.add(entityCategoriaDTO);
		}
	}
	
	public LancamentoDTO(LancamentoMinDTO lancamentoMinDTO) {
		id = lancamentoMinDTO.getId();
		descricao = lancamentoMinDTO.getDescricao();
		ano = lancamentoMinDTO.getAno();
		mes = lancamentoMinDTO.getMes();
		valor = lancamentoMinDTO.getValor();
		tipoLancamento = lancamentoMinDTO.getTipoLancamento();
		statusLancamento = lancamentoMinDTO.getStatusLancamento();
		for(CategoriaDTO catDTO: lancamentoMinDTO.getCategoriasDTO() ) {
			categoriaDTO.add(catDTO);
		}
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


	public UserMinDTO getUser() {
		return userMinDTO;
	}


	public void setUser(UserMinDTO userMinDTO) {
		this.userMinDTO = userMinDTO;
	}
	
	public void  setUser(UserDTO newUserDTO) {
		userMinDTO.setId(newUserDTO.getId());
		userMinDTO.setName(newUserDTO.getName());
		userMinDTO.setEmail(newUserDTO.getEmail());
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
	

	public List<CategoriaDTO> getCategoriaDTO() {
		return categoriaDTO;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ano, categoriaDTO, descricao, id, mes, statusLancamento, tipoLancamento, userMinDTO, valor);
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
		return Objects.equals(ano, other.ano) && Objects.equals(categoriaDTO, other.categoriaDTO)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(mes, other.mes) && statusLancamento == other.statusLancamento
				&& tipoLancamento == other.tipoLancamento && Objects.equals(userMinDTO, other.userMinDTO)
				&& Objects.equals(valor, other.valor);
	}


	@Override
	public String toString() {
		return "LancamentoDTO [id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", mes=" + mes + ", valor="
				+ valor + ", userMinDTO=" + userMinDTO + ", tipoLancamento=" + tipoLancamento + ", statusLancamento="
				+ statusLancamento + ", categoriaDTO=" + categoriaDTO + "]";
	}


	


	

	




	
	
	
	
	

}
