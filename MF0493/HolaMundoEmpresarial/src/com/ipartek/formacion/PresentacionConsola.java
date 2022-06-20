package com.ipartek.formacion;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class PresentacionConsola implements CommandLineRunner {

	@Autowired
	private SalidaConsola sc;
	
	@Autowired
	private ObtencionMensaje om;

	public static void main(String[] args) {
		SpringApplication.run(PresentacionConsola.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sc.mostrar(om.getMensaje());
	}
}

