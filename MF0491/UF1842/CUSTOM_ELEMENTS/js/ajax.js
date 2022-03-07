'use strict';

var url = 'http://localhost:3000/usuarios/';

var $formulario;

$(function () {
    $formulario = $('#formulario');

    $formulario.on('submit', aceptar);

    $('#dni').on('change', cambioDni);

    activarModal();

    listar().then(function () {
        $('table').DataTable({
            language: {
                url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-ES.json'
            }
        });
    });
});

function cambioDni() {
    var dni = $('#dni')[0];
    if (dniValido(dni.value)) {
        dni.setCustomValidity('');
    } else {
        dni.setCustomValidity('El DNI no es correcto');
    }
}

function aceptar(e) {
    e.preventDefault();

    $formulario.addClass('was-validated');

    if (!$formulario[0].checkValidity()) {
        return;
    }

    var metodo;

    var usuario = { email: email.value, password: password.value, dni: dni.value };

    var id = $('#id').val();

    if (id) {
        usuario.id = id;
        metodo = 'PUT';
    } else {
        metodo = 'POST';
    }

    console.log(usuario);

    $.ajax({
        url: url + id,
        method: metodo,
        data: usuario
    }).then(function (datos, estado, objeto) {
        console.log(datos, estado, objeto);

        $('#id, #email, #password, #dni').val('');
        $formulario.removeClass('was-validated');

        listar();
    });
}

function listar() {
    return $.getJSON(url, function (usuarios) {
        console.log(usuarios);

        $('#listado tbody').empty();

        $(usuarios).each(function () {
            $('<tr>' +
                '<th>' + this.id + '</th>' +
                '<td>' + this.email + '</td>' +
                '<td>' + this.dni + '</td>' +
                '<td>' +
                '    <a class="btn btn-primary" href="javascript:editar(' + this.id + ')">Editar</a>' +
                '    <a class="btn btn-danger" data-id="' + this.id + '" data-bs-toggle="modal" data-bs-target="#estasSeguro" href="javascript:borrar(' + this.id + ')">Borrar</a>' +
                '</td>' +
                '</tr>').appendTo('#listado tbody');
        });
    });
}

function editar(idSeleccionado) {
    console.log(idSeleccionado);

    $.getJSON(url + idSeleccionado, function (usuario) {
        $('#id').val(usuario.id);
        $('#email').val(usuario.email);
        $('#password').val(usuario.password);
        $('#dni').val(usuario.dni);
    });
}

function borrar(id) {
    console.log(id);

    $.ajax({
        url: url + id,
        method: 'DELETE'
    }).then(function (datos, estado, objeto) {
        console.log(datos, estado, objeto);

        var modal = bootstrap.Modal.getInstance(estasSeguro);

        modal.hide();

        listar();
    });
}

function activarModal() {
    $('#estasSeguro').on('show.bs.modal', function (event) {
        console.log(event);
        // Button that triggered the modal
        var boton = event.relatedTarget;
        // Extract info from data-bs-* attributes
        var id = boton.dataset.id; // boton.getAttribute('data-id');
        // Update the modal's content.
        $('#estasSeguro .modal-body').text('¿Estás seguro de que quieres borrar el id ' + id + '?');

        $('#modal-aceptar').attr('href', boton.href);
    });
}

function dniValido(dni) {
    const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';

    if (!/^[XYZ\d]\d{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/.test(dni)) {
        return false;
    }

    var numero = +dni.substring(0, 8).replace('X', '0').replace('Y', '1').replace('Z', '2');
    var letra = dni[8];

    return letras[numero % 23] == letra;
}
