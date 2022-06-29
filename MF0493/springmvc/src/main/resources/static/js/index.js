const URL = 'http://192.168.0.50:8080/api/productos/';
let tbody;
let resultados, formulario;

window.addEventListener('DOMContentLoaded', function() {
	resultados = document.getElementById('resultados');
	formulario = document.getElementById('formulario');
	
	rellenarTabla();
	
	tbody = document.querySelector('#resultados tbody');
	
	document.querySelector('#obtener-todos').addEventListener('click', obtenerTodos);
	document.querySelector('#obtener-por-id').addEventListener('click', obtenerPorId);
	document.querySelector('#insertar').addEventListener('click', insertar);
	document.querySelector('#modificar').addEventListener('click', modificar);
	document.querySelector('#borrar').addEventListener('click', borrar);
});

function ocultarResultadosMostrarFormulario() {
	resultados.style.display = 'none';
	formulario.style.display = 'block';
}
function mostrarResultadosOcultarFormulario() {
	resultados.style.display = 'block';
	formulario.style.display = 'none';
}

async function obtenerTodos(e) {
	e.preventDefault();
	
	rellenarTabla();
}

async function rellenarTabla() {
	const peticion = await fetch(URL);
	const objeto = await peticion.json();
	
	const productos = objeto._embedded.productos;
	console.log(productos);
	
	tbody.innerHTML = '';

	let producto;
	let elemento;
	for(producto of productos) {
		elemento = document.createElement('tr');
		
		elemento.innerHTML = 
		`
		<th>${producto.id}</th>
		<td>${producto.nombre}</td>
		<td>${producto.precio}</td>
		<td>
			<a class="btn btn-primary" href="javascript:colocarEnFormulario(${producto.id})">Editar</a>
			<a class="btn btn-danger" href="javascript:eliminar(${producto.id})">Borrar</a>
		</td>
		`;
		
		tbody.appendChild(elemento);
	};
	
	mostrarResultadosOcultarFormulario();
}

function obtenerPorId(e) {
	e.preventDefault();
	
	const id = document.getElementById('id').value;
	
	colocarEnFormulario(id);
}

async function colocarEnFormulario(id) {
	const peticion = await fetch(URL + id);
	const objeto = await peticion.json();
	
	const producto = objeto;
	
	document.getElementById('id').value = producto.id;
	document.getElementById('nombre').value = producto.nombre;
	document.getElementById('precio').value = producto.precio;
	
	ocultarResultadosMostrarFormulario();
}

async function insertar(e) {
	e.preventDefault();
	
	const nombre = document.getElementById('nombre').value;
	const precio = document.getElementById('precio').value;
	
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
	
	tbody.innerHTML = '';

	tbody.innerText = producto.id + ": " + producto.nombre + " -> " + producto.precio;
	
	rellenarTabla();
}

async function modificar(e) {
	e.preventDefault();
	
	const id = document.getElementById('id').value;
	const nombre = document.getElementById('nombre').value;
	const precio = document.getElementById('precio').value;
	
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
	
	tbody.innerHTML = '';

	tbody.innerText = producto.id + ": " + producto.nombre + " -> " + producto.precio;
	
	rellenarTabla();
}

async function borrar(e) {
	e.preventDefault();
	
	const id = document.getElementById('id').value;
	
	eliminar(id);
}

async function eliminar(id) {
	await fetch(URL + id, {method: 'DELETE'});
	
	rellenarTabla();
}

function limpiarFormulario() {
	document.getElementById('id').value = '';
	document.getElementById('nombre').value = '';
	document.getElementById('precio').value = '';
	
	ocultarResultadosMostrarFormulario();
}