document.addEventListener('DOMContentLoaded', async function () {
    //ES2017
    console.log('Antes');
    
    const respuesta = await fetch('/ajax-xhr.txt');
    console.log('respuesta', respuesta);
    
    const texto = await respuesta.text();
    console.log('texto', texto);
    
    alert(texto);
    
    console.log('Después');
});

// document.addEventListener('DOMContentLoaded', function () {
//     console.log('Antes'); //1
    
//     // ES2015
//     fetch('/ajax-xhr.txt')
//         .then(respuesta => {
//             console.log('respuesta', respuesta); //3
//             return respuesta.text();
//         })
//         .then(texto => {
//             console.log('texto', texto); //4
//             return alert(texto);
//         });
    
//     console.log('Después'); //2
// });