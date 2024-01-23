package com.meusprojetos.controle_financas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meusprojetos.controle_financas.dto.CategoriaDTO;
import com.meusprojetos.controle_financas.entities.Categoria;
import com.meusprojetos.controle_financas.repositories.CategoriaRepository;
import com.meusprojetos.controle_financas.services.exceptions.DataBaseExceptions;
import com.meusprojetos.controle_financas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;


	@Transactional(readOnly = true)
	public Page<CategoriaDTO> findAll(String descricao, Pageable pageable) {
		Page<Categoria> result = repository.searchByName(descricao, pageable);
		System.out.println(result);
		return result.map(x -> new CategoriaDTO(x));
	}

	

	@Transactional(readOnly = true)
	public CategoriaDTO findById(Long id) {
		Categoria lancamento = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		CategoriaDTO dto = new CategoriaDTO(lancamento);
		return dto;

	}
	
	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO dto) {

		try {

			Categoria categoria = repository.getReferenceById(id);
			copyDTOToEntity(dto, categoria);
			return new CategoriaDTO(repository.save(categoria));

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado ao atualizar");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseExceptions("Falha de integridade referencial");
		}

	}

	@Transactional
	public CategoriaDTO insert(CategoriaDTO dto) {
		
		Categoria categoria = new Categoria();
		

		copyDTOToEntity( dto, categoria);
		return new CategoriaDTO(repository.save(categoria));
	}

	

	private void copyDTOToEntity(CategoriaDTO dto, Categoria lancamento) {
		lancamento.setNomeCategoria(dto.getNomeCategoria());
		
	}

}