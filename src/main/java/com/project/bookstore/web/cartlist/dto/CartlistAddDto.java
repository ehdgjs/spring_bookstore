package com.project.bookstore.web.cartlist.dto;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.cart.Cart;
import com.project.bookstore.domain.cartlist.Cartlist;
import com.project.bookstore.domain.cartlist.MultiId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartlistAddDto {
    private MultiId multiId;
    private Long bookCount;
    private Cart cart;
    private Book book;

    public Cartlist toEntity(){
        return Cartlist.builder()
                .multiId(multiId)
                .bookCount(bookCount)
                .book(book)
                .cart(cart)
                .build();
    }
}
