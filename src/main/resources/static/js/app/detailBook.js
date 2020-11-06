var bookCount = document.getElementById('count').value;
var price = document.getElementById('bookPrice').innerText;
var total_price = price * bookCount;
var div = document.getElementById('total');

var h4 = document.createElement("h4");
h4.innerHTML=total_price;
div.appendChild(h4);