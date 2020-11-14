var main = {
    init : function () {
        var _this = this;
        $('#btn-signup').on('click', function () {
            _this.save();
        });
        $('#btn-login').on('click', function(){
            _this.login();
        });
        $('#btn-logout').on('click', function(){
            _this.logout();
        })
        $('#btn-cardadd').on('click', function(){
            _this.cardadd();
        })
        $('#btn-shipadd').on('click', function(){
            _this.shipadd();
        })
        $(document).on("click","#btn-Addcard", function(){
            _this.Addcard();
        })
        $(document).on("click","#btn-Addship", function(){
            _this.Addship();
        })
        $('#btn-booksSave').on("click", function(){
            _this.booksSave();
        })
        $('#btn-booksUpdate').on("click", function(){
            _this.booksUpdate();
        })
        $('#btn-addCart').on("click", function(){
            _this.addCart();
        })

    },
    save : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/signup',
            dataType: 'JSON',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다.');
            window.location.href = "/users/login"
        }).fail(function (error) {
            if(data.id == ""){
                alert("정보를 입력해주세요.");
            }else{
                alert("이미 존재하는 아이디입니다.")
            }
        });
    },
    login : function(){
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/login',
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            window.location.href = '/';
        }).fail(function(error){
            console.log(data);
            alert('아이디나 비밀번호가 틀렸습니다.');
        })
    },
    logout : function(){
        $.ajax({
            type: 'POST',
            url: '/users/logout',
        }).done(function(){
            window.location.href = '/';
        })
    },
    cardadd : function(){
        var div = document.getElementById("container-card");
        var form = document.createElement("form");
        var inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","id");
        inputid.setAttribute("placeholder","카드번호를 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","datetime");
        inputid.setAttribute("placeholder","유효기간을 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","type");
        inputid.setAttribute("placeholder","은행명을 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);
        div.appendChild(form);

        inputid = document.createElement("input");
        inputid.setAttribute("type","button");
        inputid.setAttribute("id","btn-Addcard");
        inputid.setAttribute("class", "btn btn-secondary col-lg-12");
        inputid.setAttribute("value", "추가하기")
        div.appendChild(inputid);

    },
    shipadd : function(){
        var div = document.getElementById("container-addr");
        var form = document.createElement("form");
        var inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","shipping_num");
        inputid.setAttribute("placeholder","우편번호를 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","basic_addr");
        inputid.setAttribute("placeholder","기본주소를 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);

        inputid = document.createElement("input");
        inputid.setAttribute("type","text");
        inputid.setAttribute("id","detail_addr");
        inputid.setAttribute("placeholder","세부주소를 입력해주세요");
        inputid.setAttribute("class", "form-control");
        form.appendChild(inputid);
        div.appendChild(form);

        inputid = document.createElement("input");
        inputid.setAttribute("type","button");
        inputid.setAttribute("id","btn-Addship");
        inputid.setAttribute("class", "btn btn-secondary col-lg-12");
        inputid.setAttribute("value", "추가하기")
        div.appendChild(inputid);

    },
    Addcard : function(){
        var data = {
            id: $('#id').val(),
            datetime: $('#datetime').val(),
            type: $('#type').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/addCard',
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            window.location.href = '/users/mypage';
        }).fail(function(error){
            console.log(data);
            alert(error);
        })
    },
    Addship : function(){
            var data = {
                basic_addr: $('#basic_addr').val(),
                detail_addr: $('#detail_addr').val(),
                shipping_num: $('#shipping_num').val()
            };

            $.ajax({
                type: 'POST',
                url: '/users/addAddr',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href = '/users/mypage';
            }).fail(function(error){
                console.log(data);
                alert(error);
            })
        },
    booksSave : function(){
            var data = {
                bookName: $('#book_name').val(),
                bookAuthor: $('#book_author').val(),
                bookPublish: $('#book_publish').val(),
                bookPrice: $('#book_price').val(),
                bookCount: $('#book_count').val(),
                bookDetail: $('#book_detail').val()
            };

            $.ajax({
                type: 'POST',
                url: '/books/saveBooks',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href='/'
            }).fail(function(error){
                console.log("222222222222222222");
                console.log(error);
            })
        },
    booksUpdate : function(){
            var data = {
                bookName: $('#book_name').val(),
                bookAuthor: $('#book_author').val(),
                bookPublish: $('#book_publish').val(),
                bookPrice: $('#book_price').val(),
                bookCount: $('#book_count').val(),
                bookDetail: $('#book_detail').val()
            };

            var uid = new URLSearchParams(location.search).get("uid");

            $.ajax({
                type: 'POST',
                url: '/books/updateBooks/'+uid,
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                window.location.href='/'
            }).fail(function(error){
                console.log(error);
            })
    },
    addCart : function(){
        var data = {
            bookCount : $('#count').val()
        };

        var uid = new URLSearchParams(location.search).get("uid");

        $.ajax({
            type: 'POST',
            url: '/cart/addCartlist/'+uid,
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert("장바구니에 추가되었습니다.")
            window.location.href='/'
        }).fail(function(error){
            console.log(error);
        })
    }

};

main.init();