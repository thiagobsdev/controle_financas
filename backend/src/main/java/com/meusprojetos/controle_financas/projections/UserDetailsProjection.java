package com.meusprojetos.controle_financas.projections;

public interface UserDetailsProjection {
	
	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();

}
