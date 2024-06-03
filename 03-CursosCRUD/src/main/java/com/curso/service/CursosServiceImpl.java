package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursoDao dao;
	
	@Override
	public List<Curso> alta(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminacion(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarDuracion(int codCurso, int duracion) {
		Curso curso = dao.findById(codCurso).orElse(null);
		if(curso != null) {
			curso.setDuracion(duracion);
		}
		dao.save(curso);

	}

	@Override
	public Optional<Curso> buscarCurso(int codCurso) {
		return dao.findById(codCurso);
	}

	@Override
	public List<Curso> findByPrecioBetween(double minPrecio, double maxPrecio) {
		return dao.findByPrecioBetween(minPrecio, maxPrecio);
	}

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

}
