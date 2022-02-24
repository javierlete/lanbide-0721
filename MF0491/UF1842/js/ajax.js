'use strict';

const url = 'http://localhost:3000/usuarios/';
let listado, id, email, password, formulario;

document.addEventListener('DOMContentLoaded', async function () {
    listado = document.querySelector('#listado tbody');

    formulario = document.getElementById('formulario');

    id = document.getElementById('id');
    email = document.getElementById('email');
    password = document.getElementById('password');

    formulario.addEventListener('submit', aceptar);

    listar();
});

async function aceptar(e) {
    e.preventDefault();

    const method = id.value ? 'PUT' : 'POST';

    const usuario = { email: email.value, password: password.value };

    if (id.value) {
        usuario.id = id.value;
    }

    console.log(usuario);

    const respuesta = await fetch(url + id.value, {
        method: method,
        body: JSON.stringify(usuario),
        headers: {
            'Content-Type': 'application/json'
        }
    });

    console.log(respuesta);

    id.value = '';
    email.value = '';
    password.value = '';

    listar();
}

async function listar() {
    const respuesta = await fetch(url);
    const usuarios = await respuesta.json();

    console.log(usuarios);

    listado.innerHTML = '';

    let tr;

    usuarios.forEach(function (usuario) {
        tr = document.createElement('tr');
        tr.innerHTML = `
            <th>${usuario.id}</th>
            <td>${usuario.email}</td>
            <td> 
                <a class="btn btn-primary" href="javascript:editar(${usuario.id})">Editar</a>
                <a class="btn btn-danger" href="javascript:borrar(${usuario.id})">Borrar</a>
            </td>`;
        listado.appendChild(tr);
    });
}

async function editar(idSeleccionado) {
    console.log(idSeleccionado);

    const respuesta = await fetch(url + idSeleccionado);
    const usuario = await respuesta.json();

    id.value = usuario.id;
    email.value = usuario.email;
    password.value = usuario.password;
}

async function borrar(id) {
    console.log(id);

    const respuesta = await fetch(url + id, { method: 'DELETE' });

    console.log(respuesta);

    listar();
}