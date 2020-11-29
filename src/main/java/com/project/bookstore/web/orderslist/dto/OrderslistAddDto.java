package com.project.bookstore.web.orderslist.dto;

import com.project.bookstore.domain.book.Book;
import com.project.bookstore.domain.order.Orders;
import com.project.bookstore.domain.orderlist.Orderlist;
import com.project.bookstore.domain.orderlist.OrderlistMultiid;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderslistAddDto {
        private OrderlistMultiid orderlistMultiid;

        private Long  count;

        private Orders orders;

        private Book book;

        public Orderlist toEntity(){
            return Orderlist.builder()
            .orderlistMultiid(orderlistMultiid)
            .count(count)
            .orders(orders)
            .book(book)
            .build();
        }
}
