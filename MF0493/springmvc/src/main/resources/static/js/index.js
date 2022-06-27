let resultados;

window.addEventListener('DOMContentLoaded', function() {
	resultados = document.getElementById('resultados');
	
	document.querySelector('#obtener-todos').addEventListener('submit', obtenerTodos);
	document.querySelector('#obtener-por-id').addEventListener('submit', obtenerPorId);
	document.querySelector('#insertar').addEventListener('submit', insertar);
});

async function obtenerTodos(e) {
	e.preventDefault();
	
	const peticion = await fetch('http://localhost:8080/api/productos');
	const objeto = await peticion.json();
	
	const productos = objeto._embedded.productos;
	console.log(productos);
	
	resultados.innerHTML = '';

	let producto;
	let elemento;
	for(producto of productos) {
		elemento = document.createElement('p');
		
		elemento.innerText = producto.nombre + ": " + producto.precio;
		
		resultados.appendChild(elemento);
	};
}

async function obtenerPorId(e) {
	e.preventDefault();
	
	const id = document.getElementById('id').value;
	
	const peticion = await fetch('http://localhost:8080/api/productos/' + id);
	const objeto = await peticion.json();
	
	const producto = objeto;
	
	resultados.innerHTML = '';

	resultados.innerText = producto.nombre + ": " + producto.precio;
}

async function insertar(e) {
	e.preventDefault();
	
	const nombre = document.getElementById('nombre').value;
	const precio = document.getElementById('precio').value;
	
	const nuevo = { nombre, precio };
	
	const peticion = await fetch('http://localhost:8080/api/productos', {
		method: 'POST',
		body: JSON.stringify(nuevo),
		headers: {
      		'Content-Type': 'application/json'
  		}
	});
	
	const objeto = await peticion.json();
	
	const producto = objeto;
	
	resultados.innerHTML = '';

	resultados.innerText = producto.id + ": " + producto.nombre + " -> " + producto.precio;
}