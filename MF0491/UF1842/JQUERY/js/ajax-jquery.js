$(function () {
    $.ajax({
        url: 'ajax-jquery.txt',
        success: function (texto) {
            console.log('Ajax');
            console.log(texto);
        },
        fail: function (error) {
            console.error('Houston, tenemos un problema');
            console.error(error);
            console.log(error.responseText);
        }
    });
});
