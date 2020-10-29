package com.project.bookstore.domain.cartlist;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.cart.Cart;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class MultiId implements Serializable {

    private Long cartUid;

    private Long bookUid;
}
