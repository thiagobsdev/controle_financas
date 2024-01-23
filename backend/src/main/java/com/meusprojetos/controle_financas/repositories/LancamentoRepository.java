package com.meusprojetos.controle_financas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meusprojetos.controle_financas.entities.Lancamento;
import com.meusprojetos.controle_financas.projections.LancamentoDetailsProjection;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	@Query(nativeQuery = true, value = """
			SELECT *
			FROM TB_LANCAMENTO
			WHERE UPPER(TB_LANCAMENTO.DESCRICAO) LIKE UPPER(CONCAT('%', :descricao, '%'))
			""")
	Page<Lancamento> searchByDescricao(String descricao, Pageable page);

	@Query(nativeQuery = true, value = """
			SELECT *
			FROM TB_LANCAMENTO
			WHERE
			TB_LANCAMENTO.USER_ID=:userId
			AND
			UPPER(TB_LANCAMENTO.DESCRICAO) LIKE UPPER(CONCAT('%', :descricao, '%'))

			""")
	Page<Lancamento> searchByUser(String descricao, Pageable pageable, Long userId);

	@Query(nativeQuery = true, value = """
			SELECT *
			FROM TB_LANCAMENTO
			WHERE
			TB_LANCAMENTO.USER_ID=:userId
			AND
			TB_LANCAMENTO.ID=:id

			""")
	List<LancamentoDetailsProjection> findAllByUserAndId(Long id, Long userId);

	@Query(nativeQuery = true, value = """
			SELECT *
			FROM TB_LANCAMENTO
			WHERE
			TB_LANCAMENTO.ID=:id
			""")
	Lancamento searchLancamentoById(Long id);

}
