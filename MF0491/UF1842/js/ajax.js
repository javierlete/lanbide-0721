'use strict';

const url = 'http://localhost:3000/usuarios/';
let listado, id, email, password, dni, formulario, estasSeguro;

document.addEventListener('DOMContentLoaded', async function () {
    estasSeguro = document.getElementById('estasSeguro');

    listado = document.querySelector('#listado tbody');

    formulario = document.getElementById('formulario');

    id = document.getElementById('id');
    email = document.getElementById('email');
    password = document.getElementById('password');
    dni = document.getElementById('dni');

    formulario.addEventListener('submit', aceptar);

    dni.addEventListener('change', cambioDni);

    activarModal();

    listar();
});

function cambioDni() {
    if(dniValido(dni.value)) {
        dni.setCustomValidity('');
    } else {
        dni.setCustomValidity('El DNI no es correcto');
    }
}

async function aceptar(e) {
    e.preventDefault();
    
    formulario.classList.add('was-validated');

    if(!formulario.checkValidity()) {
        return;
    }
    
    let metodo;

    const usuario = { email: email.value, password: password.value, dni: dni.value };

    if (id.value) {
        usuario.id = id.value;
        metodo = 'PUT';
    } else {
        metodo = 'POST';
    }

    console.log(usuario);

    const respuesta = await fetch(url + id.value, {
        method: metodo,
        body: JSON.stringify(usuario),
        headers: {
            'Content-Type': 'application/json'
        }
    });

    console.log(respuesta);

    id.value = email.value = password.value = dni.value = '';
    formulario.classList.remove('was-validated');

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
            <td>${usuario.dni}</td>
            <td> 
                <a class="btn btn-primary" href="javascript:editar(${usuario.id})">Editar</a>
                <a class="btn btn-danger" data-id="${usuario.id}" data-bs-toggle="modal" data-bs-target="#estasSeguro" href="javascript:borrar(${usuario.id})">Borrar</a>
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
    dni.value = usuario.dni;
}

async function borrar(id) {
    console.log(id);

    // if(!confirm(`??Est??s seguro de que quieres borrar el registro id=${id}?`)) {
    //     return;
    // }   

    const respuesta = await fetch(url + id, { method: 'DELETE' });

    console.log(respuesta);

    const modal = bootstrap.Modal.getInstance(estasSeguro);

    modal.hide();

    listar();
}
function activarModal() {
    estasSeguro.addEventListener('show.bs.modal', function (event) {
        console.log(event);
        // Button that triggered the modal
        const boton = event.relatedTarget;
        // Extract info from data-bs-* attributes
        const id = boton.dataset.id; // boton.getAttribute('data-id');
        // Update the modal's content.
        const cuerpo = estasSeguro.querySelector('.modal-body');

        cuerpo.innerText = `??Est??s seguro de que quieres borrar el id ${id}?`;

        const aceptar = estasSeguro.querySelector('#modal-aceptar');
        aceptar.href = boton.href;
    });
}

function dniValido(dni) {
    const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';

    if(!/^[XYZ\d]\d{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/.test(dni)) {
        return false;
    }

    const numero = +dni.substring(0, 8).replace('X', '0').replace('Y','1').replace('Z','2');
    const letra = dni[8];

    return letras[numero % 23] === letra;
}