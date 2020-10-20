package com.project.bookstore.domain.cartlist;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class MultiId implements Serializable {

    @Column(name = "CART_UID")
    private Long cartUid;

    @Column(name = "BOOK_UID")
    private Long bookUid;
}
