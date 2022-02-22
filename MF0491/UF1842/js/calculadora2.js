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
            op = this.innerText;

            console.log(op1, op);
        });
    }

    igual.addEventListener('click', function() {
        op2 = +display.value;

        console.log(op1, op, op2);

        switch(op) {
            case '+':
                display.value = op1 + op2;
                break;
            
            case '-':
                display.value = op1 - op2;
                break;
            
            case '*':
                display.value = op1 * op2;
                break;
            
            case '/':
                display.value = op1 / op2;
                break;
            
        }
    })
});
