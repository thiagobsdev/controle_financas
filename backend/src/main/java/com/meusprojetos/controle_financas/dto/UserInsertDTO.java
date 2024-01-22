package com.meusprojetos.controle_financas.dto;

import java.util.List;
import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Role;
import com.meusprojetos.controle_financas.entities.User;

public class UserInsertDTO extends UserDTO {
	
	private String password;
	
	public UserInsertDTO() {
		super();
	}

	public UserInsertDTO(Long id, String name, String email, String password, List<String> roles, String password2) {
		super(id, name, email, password, roles);
		password = password2;
	}
	
	public UserInsertDTO( User entity) {
		this.setId(entity.getId());
		this.setName(entity.getName());
		this.setEmail(entity.getEmail());
		for(Role obj : entity.getRoles() ) {
			RoleDTO newRoleDTO = new RoleDTO(obj);	
			this.getRoles().add(newRoleDTO.getAuthority());
		}
		this.setPassword(entity.getPassword());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInsertDTO other = (UserInsertDTO) obj;
		return Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserInsertDTO [password=" + password + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getId()=" + getId() + ", getRoles()=" + getRoles() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	

}
