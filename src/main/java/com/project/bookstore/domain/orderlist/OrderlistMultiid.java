package com.project.bookstore.domain.orderlist;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderlistMultiid implements Serializable {

    @Column(name = "ORDER_UID")
    private Long orderUid;

    @Column(name = "BOOK_UID")
    private Long bookUid;
}
