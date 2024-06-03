package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursoController {

	@Autowired
	CursosService service;
	
	@PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Curso> alta(@RequestBody Curso curso){
		return service.alta(curso);
	}
	
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Curso> eliminar(@PathVariable("codCurso") int codCurso){
		return service.eliminacion(codCurso);
	}
	
	/*
	 * El PatchMapping es para actualizar cuando no se pasa el Objeto entero, como en el caso de debajo, aunque el Put tambien lo actualiza
	 * @PatchMapping(value="cursos/{codCurso}/{duracion}", produces=MediaType.APPLICATION_JSON_VALUE)
	 */
	@PutMapping(value="cursos/{codCurso}/{duracion}")
	void actualizarDuracion(@PathVariable("codCurso") int codCurso, @PathVariable("duracion") int duracion) {
		service.actualizarDuracion(codCurso, duracion);
	}
	
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	Optional<Curso> buscarCurso(@PathVariable int codCurso){
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value="cursos/{minPrecio}/{maxPrecio}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Curso> findByPrecioBetween(@PathVariable("minPrecio") double minPrecio, @PathVariable("maxPrecio") double maxPrecio){
		return service.findByPrecioBetween(minPrecio, maxPrecio);
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Curso> cursos() {
		return service.cursos();
	}
	
}
