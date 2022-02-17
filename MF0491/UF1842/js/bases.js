// alert('Mensaje');
// confirm('Confirmar o cancelar');
// prompt('¿Cómo te llamas?');

'use strict';

// variablesYAlertas();

function variablesYAlertas() {

    //console.log(siono, nombre);

    const siono = confirm('¿Estás de acuerdo?');
    console.log(siono, typeof siono);

    let nombre;
    console.log(nombre, typeof nombre);

    nombre = prompt('¿Cómo te llamas?');
    console.log(nombre, typeof nombre);

}

// arrays();

function arrays() {
    const arr = Array(7, 5, 8);

    console.log(arr[0]);

    console.log(arr[3]);

    arr[1] = 123;

    console.log(arr.length);

    // Empieza el cachondeo

    arr[3] = 90;

    arr[10] = 43;

    arr[7] = 'asdfasdf';

    arr[8] = new Date();

    arr['hola'] = 'Qué tal';
    arr.yepa = 'Lalaralalaaaaaaaa';

    console.log(arr['hola']);
    console.log(arr.hola);

    arr.push('Nuevo');

    console.log(arr);
}

// arrayTradicional();

function arrayTradicional() {
    const arr1 = Array(5);

    arr1[0] = 'Uno';
    arr1[1] = 'Dos';
    arr1[2] = 'Tres';
    arr1[3] = 'Cuatro';
    arr1[4] = 'Cinco';

    console.log(arr1[3]);

    arr1[2] = 'CAMBIADO';

    console.log(arr1);
}

// arrayBidimensional();

function arrayBidimensional() {
    const tablero = Array(3);

    tablero[0] = Array(3);
    tablero[1] = Array(3);
    tablero[2] = Array(3);

    tablero[0][0] = 'T';
    tablero[0][1] = 'C';
    tablero[1][0] = 'P';
    tablero[1][1] = 'P';

    console.log(tablero);
}

// notacionJsonArray();

function notacionJsonArray() {
    const arr = ['Uno', 'Dos', 'Tres', 'Cuatro', 'Cinco'];
    console.log(arr);

    const tablero = [
        ['T', 'C', null],
        ['P', 'P']
    ];

    tablero[2] = Array(3).fill(null);

    console.log(tablero);
}

colecciones();

function colecciones() {
    const col = [];

    col.push('Primero');
    col.push('Segundo');
    col.push('Tercero');
    col.push('Cuarto');
    col.push('Quinto');

    console.log(col);

    console.log(col.pop());

    console.log(col);

    console.log(col.shift());

    console.log(col);
}

// diccionario();

function diccionario() {
    const dic = [];

    dic.casa = 'Home';
    dic['perro'] = 'Dog';
    dic.coche = 'Car';

    console.log(dic);

    console.log(dic.perro);
}

objetos();

function objetos() {
    const persona = Object();

    persona.nombre = 'Javier';
    persona.apellido = 'Lete';
    persona['dni'] = '12123123A';

    console.log(persona);

    const otra = {
        nombre: 'Pepe',
        apellidos: 'Pérez',
        dni: '12123123B'
    };

    otra.hola = 'Vale';

    console.log(otra);
}