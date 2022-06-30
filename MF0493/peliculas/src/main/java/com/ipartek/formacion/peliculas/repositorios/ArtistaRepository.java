package com.ipartek.formacion.peliculas.repositorios;

import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

import com.ipartek.formacion.peliculas.entidades.*;

@RepositoryRestResource(collectionResourceRel = "artistas", path = "artistas")
public interface ArtistaRepository extends PagingAndSortingRepository<Artista, Long> {

}
