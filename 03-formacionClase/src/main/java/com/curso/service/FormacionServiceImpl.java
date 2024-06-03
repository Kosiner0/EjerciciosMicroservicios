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
public class FormacionServiceImpl implements FormacionService {
	@Autowired
    RestTemplate template;
	
	private String url="http://localhost:8080/cursos";
	@Override
	public List<Formacion> listaCursosExistentes() {	
		
		List<CursoDto> cursos= Arrays.asList(template.getForObject(url, CursoDto[].class));
		List<Formacion> formaciones = new ArrayList<>();
		for (CursoDto curso:cursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getNombre());
			formacion.setAsignaturas((curso.getDuracion()>=50)?10:5);
			formacion.setPrecio(curso.getPrecio());
			formaciones.add(formacion);
		}
		
		return formaciones;
	}

	@Override
	public void altaCurso(Formacion formacion) {
	/*	Si no tuviera que controlas si exist el curso con ese nombre valdría esto:
		CursoDto curso = new CursoDto();
		//curso.setCodCurso(0);
		curso.setNombre(formacion.getCurso());
		curso.setDuracion(formacion.getAsignaturas()*10);
		curso.setPrecio(formacion.getPrecio());
		
		template.postForLocation(url, curso);
*/
		
		List<CursoDto> cursos= Arrays.asList(template.getForObject(url, CursoDto[].class));
		CursoDto cursoInsertar = new CursoDto(formacion.getCurso(), formacion.getAsignaturas()*10, formacion.getPrecio());
		boolean existeCurso = false;
		
		for (CursoDto curso:cursos) {
			if (curso.getNombre().equalsIgnoreCase(cursoInsertar.getNombre())) {
				existeCurso = true;
			}
		}
		if (!existeCurso) {
			template.postForLocation(url, cursoInsertar);
		}
	}

}
