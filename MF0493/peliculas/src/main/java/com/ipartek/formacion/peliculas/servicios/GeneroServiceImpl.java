package com.ipartek.formacion.peliculas.servicios;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ipartek.formacion.peliculas.entidades.*;
import com.ipartek.formacion.peliculas.repositorios.*;

@Service
public class GeneroServiceImpl implements GeneroService {
	@Autowired
	private GeneroRepository repo;
	
	@Override
	public Iterable<Genero> obtenerGeneros() {
		return repo.findAll();
	}
	
}
