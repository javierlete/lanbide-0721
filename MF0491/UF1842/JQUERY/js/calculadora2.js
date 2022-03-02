var op1, op2, op;

$(function () {
    $('.numero').on('click', function () {
        $('#display').val($('#display').val() + $(this).text());
    });

    $('.operacion').on('click', function () {
        op1 = +$('#display').val();
        $('#display').val('');
        op = $(this).text();

        console.log(op1, op);
    });

    $('.igual').on('click', function () {
        op2 = +$('#display').val();

        console.log(op1, op, op2);

        $('#display').val(eval(op1 + op + op2));
    })
});
