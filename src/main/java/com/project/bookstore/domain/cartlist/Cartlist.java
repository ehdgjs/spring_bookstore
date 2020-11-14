package com.project.bookstore.domain.cartlist;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.cart.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
public class Cartlist implements Serializable {

    @EmbeddedId
    private MultiId multiId;

    private Long bookCount;

    @MapsId("cartUid")
    @ManyToOne
    @JoinColumn(name = "CART_UID")
    private Cart cart;

    @MapsId("bookUid")
    @ManyToOne
    @JoinColumn(name = "BOOK_UID")
    private Book book;


    @Builder
    public Cartlist(MultiId multiId, Long bookCount, Cart cart,Book book){
        this.multiId = multiId;
        this.bookCount = bookCount;
        this.book = book;
        this.cart = cart;
    }
}
