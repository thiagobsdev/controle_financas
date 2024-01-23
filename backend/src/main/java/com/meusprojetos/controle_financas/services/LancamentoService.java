package com.meusprojetos.controle_financas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meusprojetos.controle_financas.dto.LancamentoDTO;
import com.meusprojetos.controle_financas.dto.LancamentoMinDTO;
import com.meusprojetos.controle_financas.dto.UserDTO;
import com.meusprojetos.controle_financas.entities.Categoria;
import com.meusprojetos.controle_financas.entities.Lancamento;
import com.meusprojetos.controle_financas.entities.User;
import com.meusprojetos.controle_financas.projections.LancamentoDetailsProjection;
import com.meusprojetos.controle_financas.repositories.LancamentoRepository;
import com.meusprojetos.controle_financas.services.exceptions.DataBaseExceptions;
import com.meusprojetos.controle_financas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public Page<LancamentoDTO> findAll(String descricao, Pageable pageable) {
		Page<Lancamento> result = repository.searchByDescricao(descricao, pageable);
		System.out.println(result);
		return result.map(x -> new LancamentoDTO(x));
	}

	@Transactional(readOnly = true)
	public Page<LancamentoDTO> findAllByUser(String descricao, Pageable pageable) {
		UserDTO userDTO = userService.getMe();
		Page<Lancamento> result = repository.searchByUser(descricao, pageable, userDTO.getId());
		return result.map(x -> new LancamentoDTO(x));
	}

	public List<LancamentoDTO> findAllByUserAndId(Long id) {
		UserDTO userDTO = userService.getMe();
		List<LancamentoDetailsProjection> result = repository.findAllByUserAndId(id, userDTO.getId());
		return result.stream().map(x -> new LancamentoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public LancamentoDTO findById(Long id) {
		Lancamento lancamento = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		LancamentoDTO dto = new LancamentoDTO(lancamento);
		return dto;

	}
	
	@Transactional
	public LancamentoDTO update(Long id, LancamentoMinDTO dto) {

		try {

			Lancamento lancamento = repository.searchLancamentoById(id);
			copyDTOToEntity(dto, lancamento);
			return new LancamentoDTO(repository.save(lancamento));

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
	public LancamentoDTO insert(LancamentoMinDTO dto) {
		
		System.out.println(dto);

		LancamentoDTO newLancamentoDTO = new LancamentoDTO(dto);
		UserDTO newUserDTO = userService.getMe();
		newLancamentoDTO.setUser(newUserDTO);
		User user = new User();
		Lancamento lancamento = new Lancamento();
		lancamento.setUser(user);

		copyDTOToEntity(newLancamentoDTO, lancamento, newUserDTO);
		return new LancamentoDTO(repository.save(lancamento));
	}

	private void copyDTOToEntity(LancamentoMinDTO updateLancamentoDTO, Lancamento lancamento) {
		lancamento.setAno(updateLancamentoDTO.getAno());
		lancamento.setDescricao(updateLancamentoDTO.getDescricao());
		lancamento.setMes(updateLancamentoDTO.getMes());
		lancamento.setValor(updateLancamentoDTO.getValor());
		lancamento.setStatusLancamento(updateLancamentoDTO.getStatusLancamento());
		lancamento.setTipoLancamento(updateLancamentoDTO.getTipoLancamento());

	}

	private void copyDTOToEntity(LancamentoDTO dto, Lancamento lancamento, UserDTO userDTO) {
		lancamento.setAno(dto.getAno());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setMes(dto.getMes());
		lancamento.setValor(dto.getValor());
		lancamento.setStatusLancamento(dto.getStatusLancamento());
		lancamento.setTipoLancamento(dto.getTipoLancamento());
		lancamento.getUser().setId(userDTO.getId());
		lancamento.getUser().setEmail(userDTO.getEmail());
		lancamento.getUser().setName(userDTO.getName());
		
		lancamento.getCategorias().clear();
		
		dto.getCategoriaDTO().forEach(x -> lancamento.getCategorias().add(new Categoria(x)));
	}

}