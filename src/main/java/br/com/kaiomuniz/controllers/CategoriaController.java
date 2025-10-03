package br.com.kaiomuniz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kaiomuniz.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	@GetMapping
	public ResponseEntity<?> get() {
		try {

			var categoriaRepository = new CategoriaRepository();
			var lista = categoriaRepository.findAll();

			return ResponseEntity.ok()
					.body(lista);
		} catch (Exception e) {
			return ResponseEntity.internalServerError()

					.body(e.getMessage());
		}
	}
}
