package com.meusprojetos.controle_financas.dto;

import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Categoria;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

	private Long id;
	
	@NotBlank
	private String nomeCategoria;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(Long id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}
	
	public CategoriaDTO(Categoria entity) {
		id = entity.getId();
		nomeCategoria = entity.getNomeCategoria();
	}

	public CategoriaDTO(CategoriaDTO categoriaDTO) {
		id = categoriaDTO.getId();
		nomeCategoria = categoriaDTO.getNomeCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomeCategoria, other.nomeCategoria);
	}

	@Override
	public String toString() {
		return "CategoriaDTO [id=" + id + ", nomeCategoria=" + nomeCategoria + "]";
	}
	
	
	
	
}



