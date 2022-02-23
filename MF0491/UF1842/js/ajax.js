document.addEventListener('DOMContentLoaded', async function () {
    const respuesta = await fetch('json/usuarios.json');
    const usuarios = await respuesta.json();

    console.log(usuarios);

    const listado = document.getElementById('listado');

    let li;

    usuarios.forEach(function (usuario) {
        li = document.createElement('li');
        li.innerText = `${usuario.id}, ${usuario.email}`;
        listado.appendChild(li);
    });
});