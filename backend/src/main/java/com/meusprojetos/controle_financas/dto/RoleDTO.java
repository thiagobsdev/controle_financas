package com.meusprojetos.controle_financas.dto;

import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Role;

import jakarta.validation.constraints.NotBlank;


public class RoleDTO   {
	
	private Long id;
	
	@NotBlank(message = "O perfil não pode estar vazio")
	private  String authority;
	
	public RoleDTO() {
	}
	
	public RoleDTO(Long id, String authority) {

		this.id = id;
		this.authority = authority;
	}
	
	public RoleDTO (Role entity) {
		id = entity.getId();
		authority = entity.getAuthority();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleDTO other = (RoleDTO) obj;
		return Objects.equals(authority, other.authority);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", authority=" + authority + "]";
	}
	
	

}