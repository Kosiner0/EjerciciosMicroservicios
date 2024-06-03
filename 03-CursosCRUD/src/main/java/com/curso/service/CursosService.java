package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> alta(Curso curso);
	List<Curso> eliminacion(int codCurso);
	void actualizarDuracion(int codCurso, int duracion);
	Optional<Curso> buscarCurso(int codCurso);
	List<Curso> findByPrecioBetween(double minPrecio, double maxPrecio);
	
	List<Curso> cursos();
}
