package com.project.bookstore.domain.orderlist;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.order.Orders;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class OrderlistMultiid implements Serializable {

    private Long ordersUid;

    private Long bookUid;
}
