package com.ipartek.formacion.springmvc.configuraciones;

import javax.persistence.*;
import javax.persistence.metamodel.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.data.rest.webmvc.config.*;
import org.springframework.stereotype.*;

@Component
public class SpringDataRestConfiguration {
	@Autowired
	private EntityManager entityManager;

	@Bean
	RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(
				entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new)));
	}
}
