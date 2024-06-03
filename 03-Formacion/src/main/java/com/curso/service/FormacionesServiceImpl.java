package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoDto;
import com.curso.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost/cursos";
	
	@Override
	public List<Formacion> formaciones() {
		
		List<CursoDto> cursos = Arrays.asList(template.getForObject(url, CursoDto[].class));
		List<Formacion> formaciones = new ArrayList<>();
		
		for(CursoDto c : cursos) {
			Formacion formacion = new Formacion();
			
			formacion.setCurso(c.getNombre());
			formacion.setAsignaturas((c.getDuracion() >= 50) ? 10 : 5);
			formacion.setPrecio(c.getPrecio());
			
			formaciones.add(formacion);
			
		}
		
		return formaciones;
	}

	@Override
	public void altaCurso(Formacion formacion) {
	/*
	 * Si no hubiera que validar si el nombre del curso existe, esta codigo valdria:
		CursoDto curso = new CursoDto();
		
		//curso.setCodCurso(0);
		curso.setNombre(formacion.getCurso());
		curso.setDuracion(formacion.getAsignaturas() * 10);
		curso.setPrecio(formacion.getPrecio());
		
		template.postForLocation(url, curso);
	*/
		
		List<CursoDto> cursos = Arrays.asList(template.getForObject(url, CursoDto[].class));
		CursoDto cursoInsertar = new CursoDto(formacion.getCurso(), formacion.getAsignaturas() * 10, formacion.getPrecio());
		
		boolean existeCurso = false;
		
		for(CursoDto c : cursos) {
			if(c.getNombre().equalsIgnoreCase(cursoInsertar.getNombre())) {
				existeCurso = true;
			}
		}
		
		if(!existeCurso) {
			template.postForLocation(url, cursoInsertar);
		}
		
	}

}
