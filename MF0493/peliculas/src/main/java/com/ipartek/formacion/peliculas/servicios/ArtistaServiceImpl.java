package com.ipartek.formacion.peliculas.servicios;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ipartek.formacion.peliculas.entidades.*;
import com.ipartek.formacion.peliculas.repositorios.*;

@Service
public class ArtistaServiceImpl implements ArtistaService {
	@Autowired
	private ArtistaRepository repo;
	
	@Override
	public Iterable<Artista> obtenerArtistas() {
		return repo.findAll();
	}
	
}
