package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursoDao extends JpaRepository<Curso, Integer> {
	/*
	@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
	List<Curso> buscarPorPrecio(int minPrecio, int maxPrecio);

	@Query(value="SELECT * FROM cursos WHERE precio BETWEEN ?1 AND ?2",  nativeQuery=true)
	List<Curso> buscarRangoPrecio(int minPrecio, int maxPrecio);
	*/	
	List<Curso> findByPrecioBetween(int minPrecio, int maxPrecio);
}
