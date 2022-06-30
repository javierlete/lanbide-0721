package com.ipartek.formacion.peliculas.repositorios;

import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

import com.ipartek.formacion.peliculas.entidades.*;

@RepositoryRestResource(collectionResourceRel = "papeles", path = "papeles")
public interface PapelRepository extends PagingAndSortingRepository<Papel, Long> {

}
