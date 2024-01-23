package com.meusprojetos.controle_financas.projections;

import java.math.BigDecimal;
import java.util.List;

import com.meusprojetos.controle_financas.dto.CategoriaDTO;
import com.meusprojetos.controle_financas.dto.UserMinDTO;
import com.meusprojetos.controle_financas.entities.enums.StatusLancamento;
import com.meusprojetos.controle_financas.entities.enums.TipoLancamento;

public interface LancamentoDetailsProjection {

	Long getId();

	String getDescricao();
	Integer getAno();
	Integer getMes();
	BigDecimal getValor();
	UserMinDTO getUser();
	
	TipoLancamento getTipoLancamento();
	StatusLancamento getStatusLancamento();
	
	List<CategoriaDTO> getCategoriaDTO();

}
