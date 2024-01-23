package com.meusprojetos.controle_financas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meusprojetos.controle_financas.dto.LancamentoDTO;
import com.meusprojetos.controle_financas.dto.LancamentoMinDTO;
import com.meusprojetos.controle_financas.services.LancamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoController {

	@Autowired
	LancamentoService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<Page<LancamentoDTO>> findAll(
			@RequestParam(name = "descricao", defaultValue = "") String descricao, Pageable pageable) {
		Page<LancamentoDTO> dto = service.findAll(descricao, pageable);
		return ResponseEntity.ok(dto);

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping
	public ResponseEntity<Page<LancamentoDTO>> findAllByUser(
			@RequestParam(name = "descricao", defaultValue = "") String descricao, Pageable pageable) {
		Page<LancamentoDTO> dto = service.findAllByUser(descricao, pageable);
		return ResponseEntity.ok(dto);

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<LancamentoDTO> findByID(@PathVariable Long id) {
		LancamentoDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping("/user/{id}")
	public ResponseEntity<List<LancamentoDTO>> findAllByUserAndId(@PathVariable Long id) {
		List<LancamentoDTO> dto = service.findAllByUserAndId(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/new")
	public ResponseEntity<LancamentoDTO> insert(@Valid @RequestBody LancamentoMinDTO dto) {

		LancamentoDTO newDto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();

		return ResponseEntity.created(uri).body(newDto);

	}

	@PutMapping("/{id}")
	public ResponseEntity<LancamentoDTO> update(@PathVariable Long id, @Valid @RequestBody LancamentoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
