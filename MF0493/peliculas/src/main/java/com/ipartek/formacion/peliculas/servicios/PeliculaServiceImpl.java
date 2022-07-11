package com.ipartek.formacion.peliculas.servicios;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ipartek.formacion.peliculas.entidades.*;
import com.ipartek.formacion.peliculas.repositorios.*;

import lombok.extern.java.*;

@Log
@Service
public class PeliculaServiceImpl implements PeliculaService {
	@Autowired
	private PeliculaRepository repo;
	
	@Override
	public Iterable<Pelicula> listado() {
		log.info("Se han pedido todas las películas");
		return repo.findAll();
	}

	@Override
	public Pelicula obtenerPorId(Long id) {
		log.info("Se ha pedido la película " + id);
		return repo.findById(id).orElse(null);
	}

	@Override
	public Pelicula insertar(Pelicula pelicula) {
		log.info("Se va a insertar la película " + pelicula);
		pelicula.setId(null);
		return repo.save(pelicula);
	}

	@Override
	public Pelicula modificar(Pelicula pelicula) {
		log.info("Se va a modificar la película " + pelicula);
		log.info("con los géneros:" + pelicula.getGeneros());
		
		return repo.save(pelicula);
	}

	@Override
	public void borrar(Long id) {
		log.info("Se va a borrar la película " + id);
		repo.deleteById(id);
	}
}
