let op1, op2, op;

document.addEventListener('DOMContentLoaded', function () {
    const numeros = document.getElementsByClassName('numero');
    const operaciones = document.getElementsByClassName('operacion');
    const igual = document.querySelector('.igual');
    const display = document.getElementById('display');

    console.log(numeros, operaciones, igual, display);

    for (let numero of numeros) {
        numero.addEventListener('click', function () {
            display.value += this.innerText;
        });
    }

    for (let operacion of operaciones) {
        operacion.addEventListener('click', function() {
            op1 = +display.value;
            display.value = '';
            
            switch(this.innerText) {
                case '+':
                    op = sumar;
                    break;
                
                case '-':
                    op = restar;
                    break;
                
                case '*':
                    op = multiplicar;
                    break;
                
                case '/':
                    op = dividir;
                    break;
                default:
                    op = 'NO RECONOCIDA';
            }

            console.log(op1, op);
        });
    }

    igual.addEventListener('click', function() {
        op2 = +display.value;

        console.log(op1, op, op2);

        display.value = op(op1, op2);
    })
});

function sumar(a, b) {
    return a + b;
}

function restar(a, b) {
    return a - b;
}

var multiplicar = function(a, b) {
    return a * b;
}

var dividir = (a, b) => a / b;
