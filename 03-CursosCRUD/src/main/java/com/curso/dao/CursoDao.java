package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursoDao extends JpaRepository<Curso, Integer> {

	/*
		@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
		List<Curso> buscarPorPrecio(double minPrecio, double maxPrecio);
	*/
	
	List<Curso> findByPrecioBetween(double minPrecio, double maxPrecio);
}
