$(function(){
    $(document).ready(function(){
        var bookCount = $('#count').val();
        var price = $('#bookPrice').text();
        var total_price = price * bookCount;

        var h4 = document.createElement("h4");
        h4.setAttribute("id","h4_price");
        h4.innerHTML = total_price;
        $('#total').append(h4);
    }),
    $("#count").change(function(){
        var bookCount = $('#count').val();
        var price = $('#bookPrice').text();
        var total_price = price * bookCount;

        $('#h4_price').text(total_price);
    })
})
