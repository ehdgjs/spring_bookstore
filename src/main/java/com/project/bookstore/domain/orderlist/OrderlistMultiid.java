package com.project.bookstore.domain.orderlist;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.order.Orders;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class OrderlistMultiid implements Serializable {

    private Long ordersUid;

    private Long bookUid;
}
