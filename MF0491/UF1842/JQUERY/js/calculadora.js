$(function () {
    $('#calculadora').on('submit', function (e) {
        e.preventDefault();

        // Convertimos los datos
        var x = +$('#a').val();
        var y = +$('#b').val();

        // Según la operación...
        switch ($('#op').val()) {
            case '+':
                $('#resultado').html(x + y);
                break;
            case '-':
                $('#resultado').html(x - y);
                break;
            case '*':
                $('#resultado').html(x * y);
                break;
            case '/':
                $('#resultado').html(x / y);
                break;
            default:
                $('#resultado').html('No dispongo de esa operación');
        }
    });
});
