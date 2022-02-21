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

// colecciones();

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

// objetos();

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

// prototipos();

function prototipos() {
    function Persona(nombre, apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    Persona.prototype.nombreCompleto = function () {
        return this.nombre + " " + this.apellidos;
    };

    const javier = new Persona('Javier', 'Lete');

    console.log(javier);

    console.log(javier.nombreCompleto());
}

// clases();

function clases() {
    class Persona {
        constructor(nombre, apellidos) {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        nombreCompleto() {
            return this.nombre + " " + this.apellidos;
        }
    }

    const javier = new Persona('Javier', 'Lete');

    console.log(javier);

    console.log(javier.nombreCompleto());
}

// operadores();

function operadores() {
    // +, -, *, /

    console.log(5 % 3); // Resto de la división entera

    console.log(5 + 3);

    console.log('5' + '3');

    console.log(5 + '3');

    console.log('5' + 3);

    // >, <, >=, <=

    console.log(5 == 5);
    console.log(5 != 5);

    console.log(5 == '5');
    console.log(5 != '5');

    // Estrictamente igual y distinto

    console.log(5 === '5');
    console.log(5 !== '5');

    const x = 5;

    console.log(1 + x + 10);

    console.log(1 <= x && x <= 10);

    const dato = prompt('Dime algo');

    console.log(dato || 'No me has dicho nada');

    console.log(!!0, !!1, !!'', !!'asdfasd', !!null, !!undefined, !!NaN);

    // ? :

    const cierto = confirm('¿Es cierto?');

    console.log(cierto ? 'Es cierto' : 'NO es cierto');

    const a = 5, b = 7;

    console.log(a > b ? a : b);
}

// alternativas();

function alternativas() {
    const confirmado = confirm('¿Confirmas?');

    if (confirmado) {
        console.log('CONFIRMADO');
    } else {
        console.log('NO confirmado');
    }

    const mes = +prompt('Dime un mes');
    let dias;

    switch (mes) {
        case 2:
            dias = 28;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            dias = 30;
            break;
        default:
            dias = 31;
    }

    console.log(mes, dias);
}

//repetitivas();

function repetitivas() {
    let c = 1;
    while (c <= 10) {
        console.log(c);
        ++c;
    }

    do {
        console.log(--c);
    } while (c > 1);

    for(let i = 1; i <= 5; i++) {
        console.log(i);
    }
}

repetitivasColecciones();

function repetitivasColecciones() {
    const arr = [ 1, 5, 8, 4, 3, 7, 9 ];
    arr.hola = 'hello';
    arr[20] = 'Otro valor';

    for(let i = 0; i < arr.length; i++) {
        console.log(i, arr[i]);
    }

    for(let clave in arr) {
        console.log(clave, arr[clave]);
    }

    for(let dato of arr) {
        console.log(dato);
    }
}