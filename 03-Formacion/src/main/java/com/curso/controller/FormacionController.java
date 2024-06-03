package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

@RestController
public class FormacionController {

	@Autowired
	FormacionesService service;
	
	@GetMapping(value="formacion", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Formacion> formaciones() {
		return service.formaciones();
	}
	
	@PostMapping(value="formacion/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	void altaCurso(@RequestBody Formacion formacion) {
		service.altaCurso(formacion);
	}
	
	
}
