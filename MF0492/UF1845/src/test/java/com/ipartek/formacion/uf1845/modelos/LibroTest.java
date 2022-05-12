package com.ipartek.formacion.uf1845.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.math.*;
import java.util.*;

import org.junit.jupiter.api.*;

public class LibroTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void equals() {
		Libro libro1 = new Libro(1L, "Título1", "Autor1", "ISBN1", new BigDecimal("1234"));
		Libro libro2 = new Libro(1L, "Título1", "Autor1", "ISBN1", new BigDecimal("1234"));
		Libro libro3 = new Libro(1L, "Título1", "Autor1", "ISBN1", new BigDecimal("234"));
		
		assertTrue(libro1.equals(libro1));
		assertFalse(libro1.equals(null));
		assertFalse(libro1.equals(new Date()));
		assertTrue(libro1.equals(libro2));
		assertFalse(libro1.equals(libro3));
	}
	
	@Test
	public void constructorString() {
		Libro libro = new Libro("1", "Título1", "Autor1", "ISBN1", "1234");
//		Libro libroRes = new Libro(1L, "Título1", "Autor1", "ISBN1", new BigDecimal("1234"));
		
//		assertEquals(libroRes, libro);
		assertEquals(1L, libro.getId());
		assertEquals("Título1", libro.getTitulo());
		assertEquals("Autor1", libro.getAutor());
		assertEquals("ISBN1", libro.getIsbn());
		assertEquals(new BigDecimal("1234"), libro.getPrecio());
		
	}
	
	@Test
	public void testSetIdString() {
		// fail("Not yet implemented");
		// assertTrue(true);
		
		Libro libro = new Libro();
		
		libro.setId("1");
		
		assertEquals(1L, libro.getId());
		
		libro = new Libro();
		
		libro.setId("  ");
		
		assertNull(libro.getId());
		
		libro = new Libro();
		
		libro.setId("alskdjflkasdf");
		
		assertTrue(libro.getErrores().containsKey("id"));
	}

}
