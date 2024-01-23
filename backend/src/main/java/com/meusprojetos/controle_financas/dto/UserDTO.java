package com.meusprojetos.controle_financas.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.meusprojetos.controle_financas.entities.Role;
import com.meusprojetos.controle_financas.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	private Long id;
	
	@NotBlank(message = "O nome não pode estar vazio")
	@Size(min = 3, max = 80, message = "O Nome deve ter entre 03 e 80 caracteres")
	private String name;
	
	@NotNull(message = "Campo requerido")
	@Email
	private String email;
	
	private List<String> roles = new ArrayList<>();

	
	public UserDTO() {
	}
	
	public UserDTO(Long id, String name, String email, String password, List<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roles = roles;
	}
	
	public UserDTO(UserMinDTO userMinDTO) {
		super();
		this.id = userMinDTO.getId();
		this.name = userMinDTO.getName();
		this.email = userMinDTO.getEmail();
	}



	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		for(Role obj : entity.getRoles() ) {
			RoleDTO newRoleDTO = new RoleDTO(obj);
			roles.add(newRoleDTO.getAuthority());
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<String> getRoles() {
		return roles;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(roles, other.roles);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", roles=" + roles + "]";
	}

	
	

	
	

	

	
	

}
