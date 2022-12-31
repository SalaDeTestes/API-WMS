package com.wms.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.api.controller.dto.UsuarioDto;
import com.wms.api.form.UsuarioForm;
import com.wms.api.models.Usuario;
import com.wms.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	@Transactional
	public List<UsuarioDto> lista(
			String nome) {/* String nomeCurso é o parametro passado dentro da URL, cria um filtro */

		if (nome == null) {
			List<Usuario> usuario = usuarioRepository.findAll();
			return UsuarioDto.converter(usuario);

		} else {

			List<Usuario> usuario = usuarioRepository
					.findByNome(nome);/*
										 * Metodo criado detro de topicoRepository para busca somente um atributo de uma
										 * entidade(nesse caso especifico busca o nome dentro de uma entidade que se
										 * relaciona com topico findByCursoNome Curso= entidade Nome = atributo de
										 * curso)
										 */
			return UsuarioDto.converter(usuario);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {

		Usuario usuario = form.formulario();
		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable Long id) {
		Optional<Usuario> pessoas = usuarioRepository.findById(id);
		if (pessoas.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(pessoas.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioForm form) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {

			usuarioRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
