package com.ipartek.formacion.uf1845.dal;

import static org.junit.jupiter.api.Assertions.*;

import java.math.*;

import org.junit.jupiter.api.*;

import com.ipartek.formacion.uf1845.modelos.*;

public class DaoLibrosMemoriaTest {

	private static final int MAX_REGISTROS = 10;
	
	private static final DaoLibros dao = DaoLibrosMemoria.getInstancia();

	@BeforeEach
	public void setUp() {
		for (long i = 1; i <= MAX_REGISTROS; i++) {
			DaoLibrosMemoria.libros.put(i, new Libro(i, "Libro" + i, "Autor" + i, "ISBN" + i, new BigDecimal(i)));
		}
	}

	@AfterEach
	public void tearDown() {
		DaoLibrosMemoria.libros.clear();
	}

	@Test
	public void testGetInstancia() {
		assertNotNull(dao);

		DaoLibros dao2 = DaoLibrosMemoria.getInstancia();

		assertTrue(dao == dao2);
	}

	@Test
	public void testObtenerTodos() {
		Iterable<Libro> libros = dao.obtenerTodos();

		int i = 0;

		for (Libro libro : libros) {
			i++;

			assertEquals(new Libro((long) i, "Libro" + i, "Autor" + i, "ISBN" + i, new BigDecimal(i)), libro);
		}

		assertEquals(MAX_REGISTROS, i);
	}

	@Test
	public void testObtenerPorId() {
		Libro libro = dao.obtenerPorId(5L);

		assertEquals(new Libro(5L, "Libro5", "Autor5", "ISBN5", new BigDecimal(5)), libro);

		assertNull(dao.obtenerPorId(200L));
	}

	@Test
	public void testInsertar() {
		Libro libro = dao.insertar(new Libro(null, "LibroX", "AutorX", "ISBNX", BigDecimal.ZERO));

		assertNotNull(libro.getId());

		assertEquals(MAX_REGISTROS + 1, libro.getId());
		
		DaoLibrosMemoria.libros.clear();
		
		dao.insertar(libro);
		
		assertEquals(1L, libro.getId());
	}

	@Test
	public void testModificar() {
		Libro libro = new Libro(2L, "LibroX", "AutorX", "ISBNX", BigDecimal.ZERO);
		dao.modificar(libro);

		assertEquals(libro, dao.obtenerPorId(2L));
	}

	@Test
	public void testBorrar() {
		dao.borrar(3L);
		
		assertNull(dao.obtenerPorId(3L));
	}

}
