package com.ipartek.formacion.uf1845.modelos;

import static org.junit.jupiter.api.Assertions.*;

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
