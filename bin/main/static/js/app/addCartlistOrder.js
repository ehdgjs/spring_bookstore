let countSet = () => {
    let countByUrl = new URLSearchParams(location.search).getAll("count[]");
    countByUrl.forEach((item, index) => {
        countSetForUrl(item, index)
    });
}

let countSetForUrl = (count,index) => {
    let countInHtml = document.getElementsByClassName("count");
    countInHtml[index].innerHTML = count;
}

let totalPriceSet = () => {
    let totalPrice = document.getElementsByClassName("totalPrice");    
    let table = document.getElementById("table");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        let price = item.children[2].innerHTML*1;
        let count = item.children[3].innerHTML*1;
        let sum = price * count;
        totalPrice[index].innerHTML = sum;
    })
}

let init = () => {
    countSet();
    totalPriceSet();
}

init()