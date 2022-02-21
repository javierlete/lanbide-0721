// window.onload = function () {
document.addEventListener('DOMContentLoaded', function () {
    const h1 = document.getElementsByTagName('h1')[0];

    h1.innerText = 'Cambiado desde JavaScript';
 
    const form = document.forms[0];

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        const nombre = document.getElementById('nombre');
        const resultado = document.getElementById('respuesta');
        
        resultado.innerText = 'Hola ' + nombre.value;
    });

    const botones = document.querySelectorAll('#botonera button');

    for(let boton of botones) {
        boton.addEventListener('click', function() {
            console.log(this.innerText);
        });
    }
});
