package com.meusprojetos.controle_financas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meusprojetos.controle_financas.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT *
			FROM TB_CATEGORIA
			WHERE UPPER(TB_CATEGORIA.NOME_CATEGORIA) LIKE UPPER(CONCAT('%', :descricao, '%'))
			""")
	Page<Categoria> searchByName(String descricao, Pageable pageable);

	

	

}
