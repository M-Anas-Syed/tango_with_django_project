$(document).ready(function() {

    $('#about-btn').click(function() {
        alert('You clicked the button using JQuery!');
    });
});

$(document).ready(function(){
    $('p').hover( function() {

        $(this).css('color', 'orange');
    },
    function() {
        $(this).css('color', 'black');
})});

$(document).ready(function(){
    $('#about-btn').click(function() {
        msgStr = $('#msg').html();
        msgStr = msgStr + ' ooo, fancy!';

        $('#msg').html(msgStr);
})});