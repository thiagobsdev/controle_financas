package com.meusprojetos.controle_financas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meusprojetos.controle_financas.entities.Role;
import com.meusprojetos.controle_financas.projections.RoleDetailsProjection;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	
	@Query(nativeQuery = true, value = """
			SELECT TB_ROLE.ID AS id, TB_ROLE.AUTHORITY as Authority
			FROM TB_ROLE
			WHERE TB_ROLE.AUTHORITY IN (:authority)
		""")
List<RoleDetailsProjection> searchRolesByListAuthority(List<String> authority);
	
	@Modifying
	@Query(nativeQuery = true, value = """
			INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (:userID, :roleID)
		""")
void insertByRoleAndUser(Long userID, Long roleID );
	
	
	

}
