const URL = 'http://localhost:8080/api/productos/';
let resultados;

window.addEventListener('DOMContentLoaded', function() {
	resultados = document.querySelector('#resultados tbody');
	
	document.querySelector('#obtener-todos').addEventListener('submit', obtenerTodos);
	document.querySelector('#obtener-por-id').addEventListener('submit', obtenerPorId);
	document.querySelector('#insertar').addEventListener('submit', insertar);
	document.querySelector('#modificar').addEventListener('submit', modificar);
	document.querySelector('#borrar').addEventListener('submit', borrar);
});

async function obtenerTodos(e) {
	e.preventDefault();
	
	const peticion = await fetch(URL);
	const objeto = await peticion.json();
	
	const productos = objeto._embedded.productos;
	console.log(productos);
	
	resultados.innerHTML = '';

	let producto;
	let elemento;
	for(producto of productos) {
		elemento = document.createElement('tr');
		
		elemento.innerHTML = 
		`
		<th>${producto.id}</th>
		<td>${producto.nombre}</td>
		<td>${producto.precio}</td>
		`;
		
		resultados.appendChild(elemento);
	};
}

async function obtenerPorId(e) {
	e.preventDefault();
	
	const id = document.getElementById('obtener-id').value;
	
	const peticion = await fetch(URL + id);
	const objeto = await peticion.json();
	
	const producto = objeto;
	
	resultados.innerHTML = '';

	resultados.innerText = producto.id + ":" + producto.nombre + ": " + producto.precio;
}

async function insertar(e) {
	e.preventDefault();
	
	const nombre = document.getElementById('insertar-nombre').value;
	const precio = document.getElementById('insertar-precio').value;
	
	const nuevo = { nombre, precio };
	
	const peticion = await fetch(URL, {
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
	
	obtenerTodos(e);
}

async function modificar(e) {
	e.preventDefault();
	
	const id = document.getElementById('modificar-id').value;
	const nombre = document.getElementById('modificar-nombre').value;
	const precio = document.getElementById('modificar-precio').value;
	
	const nuevo = { id, nombre, precio };
	
	const peticion = await fetch(URL + id, {
		method: 'PUT',
		body: JSON.stringify(nuevo),
		headers: {
      		'Content-Type': 'application/json'
  		}
	});
	
	const objeto = await peticion.json();
	
	const producto = objeto;
	
	resultados.innerHTML = '';

	resultados.innerText = producto.id + ": " + producto.nombre + " -> " + producto.precio;
	
	obtenerTodos(e);
}

async function borrar(e) {
	e.preventDefault();
	
	const id = document.getElementById('borrar-id').value;
	
	await fetch(URL + id, {method: 'DELETE'});
	
	obtenerTodos(e);
}