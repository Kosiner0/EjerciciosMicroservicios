package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionService {
	List<Formacion> listaCursosExistentes();    // yo le llamaria formaciones()
	void altaCurso(Formacion formacion);
}
