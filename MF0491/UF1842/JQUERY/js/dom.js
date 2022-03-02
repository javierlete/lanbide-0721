$(function () {
    $('h1').html('Cambiado desde JavaScript');

    $('form').on('submit', function(e) {
        e.preventDefault();

        $('#respuesta').html('Hola ' + $('#nombre').val());
    });

    $('#botonera button').each(function() {
        $(this).on('click', function() {
            console.log($(this).html());
        })
    });
});
